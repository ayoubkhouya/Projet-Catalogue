package fr.catalogue.servlets;

import fr.catalogue.beans.Client;
import fr.catalogue.beans.Commande;
import fr.catalogue.beans.Panier;
import fr.catalogue.interfaces.CommandeMethodes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/commande")
public class CommandeServlet extends HttpServlet implements CommandeMethodes {

    private static final long serialVersionUID = 534547274455921165L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> param = req.getParameterMap();
        Panier panier = null;
        Client client = null;

        if (param.containsKey("passer")) {
            try {
                panier = (Panier) req.getSession().getAttribute("panier");
                client = (Client) req.getSession().getAttribute("client");

                if (client == null) {
                    resp.sendRedirect("/client?login");
                } else {
                    if (panier == null) {
                        resp.sendRedirect("/categories");
                    } if (panier.getProduits().isEmpty())  {
                        resp.sendRedirect("/categories");
                    } else {
                        req.getRequestDispatcher("/pages/enregistrement.jsp").forward(req, resp);
                    }
                }

            } catch (Exception e) {
                req.getSession(true).setAttribute("client", client);
                req.getSession(true).setAttribute("panier", panier);
                resp.sendRedirect("/client?login");
            }
        }
    }


    @Override
    public Commande enregistrerCommande() {
        return null;
    }
}
