package fr.catalogue.servlets;

import fr.catalogue.beans.Categorie;
import fr.catalogue.beans.Produit;
import fr.catalogue.ejb.interfaces.remote.ProduitRemote;
import fr.catalogue.global.AppContext;
import fr.catalogue.interfaces.ProduitMethodes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/produits")
public class ProduitServlet extends HttpServlet implements ProduitMethodes {

    private static final long serialVersionUID = 8317143133560970103L;

    private ProduitRemote produitRemote;

    public ProduitServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Session
        HttpSession session = request.getSession(true);

        Map<String, String[]> mapParams = request.getParameterMap();

        if (mapParams.isEmpty()) {

        } if (mapParams.containsKey("id")) {

        } if (mapParams.containsKey("cat")) {
            List<Produit> produits = getProduitsByCategorie((Categorie) request.getAttribute("categorie"));
            session.setAttribute("produits", produits);
            request.getRequestDispatcher("/pages/produits.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public List<Produit> getProduits() {
        return null;
    }

    @Override
    public List<Produit> getProduitsByCategorie(Categorie categorie) {
        produitRemote = (ProduitRemote) AppContext.getRemote(ProduitRemote.class);
        return produitRemote.getProduitsByCategorie(categorie);
    }

    @Override
    public Produit getProduitById(int id) {
        return null;
    }

    @Override
    public Produit getProduitByName(String name) {
        return null;
    }
}
