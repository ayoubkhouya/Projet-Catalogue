package fr.catalogue.servlets;

import fr.catalogue.beans.Client;
import fr.catalogue.ejb.controllers.ClientEJB;
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
        if (param.containsKey("logout")) {
            req.getSession(true).setAttribute("client", null);
            resp.sendRedirect("/home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = (String) req.getParameter("name");
        String email = (String) req.getParameter("email");
        String adresse = (String) req.getParameter("adress");
        String telephone = (String) req.getParameter("phone");
        Client client = (registerClient(new Client(nom, email, adresse, telephone)));
        if (client != null) {
            resp.sendRedirect("/home");
            // Session
            HttpSession session = req.getSession(true);
            session.setAttribute("client", client);
        } else {
            System.out.println("Error While Registering");
        }
    }

    @Override
    public Client registerClient(Client client) {
        clientRemote = (ClientRemote) AppContext.getRemote(ClientRemote.class, EnumEJB.CLIENTEJB.getEjbName());
        return clientRemote.enregisterClient(client);
    }

    @Override
    public Client getClient(Client client) {
        return null;
    }

    @Override
    public Client getClientById(int id) {
        return null;
    }
}
