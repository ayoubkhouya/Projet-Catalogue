package fr.catalogue.servlets;

import fr.catalogue.beans.Client;
import fr.catalogue.ejb.interfaces.remote.ClientRemote;
import fr.catalogue.global.AppContext;
import fr.catalogue.global.EnumEJB;
import fr.catalogue.interfaces.ClientMethodes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/client")
public class ClientServlet extends HttpServlet implements ClientMethodes {

    private static final long serialVersionUID = -1808494065352023432L;

    private ClientRemote clientRemote;

    public ClientServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> param = req.getParameterMap();

        if (param.containsKey("login")) {
            req.getRequestDispatcher("/pages/login.jsp").forward(req, resp);
        }

        if (param.containsKey("logout")) {
            req.getSession(true).setAttribute("client", null);
            resp.sendRedirect("/home");
        }

        if (param.containsKey("signin")) {
            req.getRequestDispatcher("/pages/register.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Session
        HttpSession session = req.getSession(true);
        Map<String, String[]> param = req.getParameterMap();
        String email;
        String nom;
        Client client;

        if (param.containsKey("login")) {
            nom = req.getParameter("name");
            email = req.getParameter("email");
            client = getClientByNameAndEmail(nom, email);
            if (client != null) {
                session.setAttribute("client", client);
                resp.sendRedirect("/home");
            } else {
                resp.sendRedirect("/client?signin");
            }
            //req.getRequestDispatcher("/home").forward(req, resp);
        } else {
            nom = req.getParameter("name");
            email = req.getParameter("email");
            String adresse = req.getParameter("adress");
            String telephone = req.getParameter("phone");
            client = (registerClient(new Client(nom, email, adresse, telephone)));
            if (client != null) {
                session.setAttribute("client", client);
                resp.sendRedirect("/home");
            } else {
                req.getRequestDispatcher("/pages/register.jsp").forward(req, resp);
            }
        }


    }

    @Override
    public Client registerClient(Client client) {
        clientRemote = (ClientRemote) AppContext.getRemote(ClientRemote.class, EnumEJB.CLIENTEJB.getEjbName());
        try {
            Client cl = clientRemote.enregisterClient(client);
            return cl;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Client getClient(Client client) {
        return null;
    }

    @Override
    public Client getClientById(int id) {
        return null;
    }

    @Override
    public Client getClientByNameAndEmail(String nom, String email) {
        clientRemote = (ClientRemote) AppContext.getRemote(ClientRemote.class, EnumEJB.CLIENTEJB.getEjbName());
        return clientRemote.getClient(nom, email);
    }
}
