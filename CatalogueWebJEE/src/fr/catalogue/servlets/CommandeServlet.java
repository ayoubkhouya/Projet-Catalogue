package fr.catalogue.servlets;

import fr.catalogue.beans.Client;
import fr.catalogue.beans.Commande;
import fr.catalogue.beans.Panier;
import fr.catalogue.ejb.interfaces.remote.CommandeRemote;
import fr.catalogue.global.AppContext;
import fr.catalogue.global.EnumEJB;
import fr.catalogue.interfaces.CommandeMethodes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;

@WebServlet("/commande")
public class CommandeServlet extends HttpServlet implements CommandeMethodes {

    private static final long serialVersionUID = 534547274455921165L;
    private CommandeRemote commandeRemote;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> param = req.getParameterMap();
        Commande commande;

        if (param.containsKey("payer")) {

            try {

                commande = (Commande) req.getSession().getAttribute("commande");
                commande.setNo_confirmation(AppContext.getRandomNoConfirmation());
                req.getSession().setAttribute("commande", commande);
                req.getSession().setAttribute("panier", null);
                enregistrerCommande(commande);
                req.getRequestDispatcher("/pages/confirmation.jsp").forward(req, resp);

            } catch (Exception e) {
                resp.sendRedirect("/home");
            }

        } if (param.isEmpty()) {
            resp.sendRedirect("/home");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> param = req.getParameterMap();
        Panier panier = null;
        Client client = null;
        Commande command;

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
                        // enregistrer la commande de client
                        command = new Commande();
                        command.setClient(client);
                        command.setProduits(panier.getProduits());
                        command.setDate_creation(Timestamp.valueOf(LocalDateTime.now()));
                        command.setMontant(panier.getMontant());
                        req.getSession().setAttribute("commande", command);
                        req.getRequestDispatcher("/pages/enregistrement.jsp").forward(req, resp);
                    }
                }

            } catch (Exception e) {
                req.getSession(true).setAttribute("client", client);
                req.getSession(true).setAttribute("panier", panier);
                resp.sendRedirect("/client?login");
            }
        }
        if (param.containsKey("payer")) {
            doGet(req, resp);
        }
    }


    @Override
    public Commande enregistrerCommande(Commande commande) {
        commandeRemote = (CommandeRemote) AppContext.getRemote(CommandeRemote.class, EnumEJB.COMMANDEEJB.getEjbName());
        try {
            Commande cmd = commandeRemote.enregistrerCommande(commande);
            return cmd;
        } catch (Exception e) {
            return null;
        }
    }
}
