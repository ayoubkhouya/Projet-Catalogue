package fr.catalogue.servlets;

import fr.catalogue.beans.Client;
import fr.catalogue.ejb.interfaces.remote.ClientRemote;
import fr.catalogue.global.AppContext;
import fr.catalogue.global.EnumEJB;
import fr.catalogue.interfaces.ClientMethodes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/client")
public class ClientServlet extends HttpServlet implements ClientMethodes {

    private static final long serialVersionUID = -1808494065352023432L;

    private ClientRemote clientRemote;

    public ClientServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = (String) req.getAttribute("name");
        String email = (String) req.getAttribute("email");
        String adresse = (String) req.getAttribute("adress");
        String telephone = (String) req.getAttribute("phone");
        if (registerClient(new Client(nom, email, adresse, telephone))) {
            resp.sendRedirect("/home");
        } else {
            System.out.println("Erreur While Registering");
        }
    }

    @Override
    public boolean registerClient(Client client) {
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
