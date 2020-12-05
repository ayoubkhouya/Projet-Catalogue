package fr.catalogue.servlets;

import fr.catalogue.beans.Panier;
import fr.catalogue.beans.Produit;
import fr.catalogue.ejb.controllers.PanierEJB;
import fr.catalogue.global.AppContext;
import fr.catalogue.global.EnumEJB;
import fr.catalogue.interfaces.PanierMethodes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/panier")
public class PanierServlet extends HttpServlet implements PanierMethodes {

    private static final long serialVersionUID = -2543996090073074652L;

    private PanierEJB panierRemote;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Session
        HttpSession session = req.getSession(true);

        Map<String, String[]> mapParams = req.getParameterMap();
        Panier panier = (Panier) session.getAttribute("panier");

        if (mapParams.containsKey("add")) {
            if (panier != null) {
                panier.getProduits().add(addProduitToPanier(Integer.parseInt(mapParams.get("add")[0])));
            } else {
                panier = new Panier();
                panier.getProduits().add(addProduitToPanier(Integer.parseInt(mapParams.get("add")[0])));
            }
        } if (mapParams.containsKey("remove")) {
            if (panier != null) {
                panier.getProduits().remove(getProduitFromPanier(Integer.parseInt(mapParams.get("remove")[0])));
            }
        }

    }

    @Override
    public Panier getPanier(int id) {
        panierRemote = (PanierEJB) AppContext.getRemote(PanierEJB.class, EnumEJB.PANIER.getEjbName());
        return panierRemote.getPanier(id);
    }

    @Override
    public Produit addProduitToPanier(int id) {
        panierRemote = (PanierEJB) AppContext.getRemote(PanierEJB.class, EnumEJB.PANIER.getEjbName());
        return panierRemote.getProduit(id);
    }

    @Override
    public Produit getProduitFromPanier(int id) {
        panierRemote = (PanierEJB) AppContext.getRemote(PanierEJB.class, EnumEJB.PANIER.getEjbName());
        return panierRemote.getProduit(id);
    }


}
