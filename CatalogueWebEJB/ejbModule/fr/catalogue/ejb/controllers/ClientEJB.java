package fr.catalogue.ejb.controllers;

import fr.catalogue.beans.Client;
import fr.catalogue.ejb.interfaces.local.ClientLocal;
import fr.catalogue.ejb.interfaces.remote.ClientRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ClientEJB implements ClientLocal, ClientRemote {

    @PersistenceContext(unitName = "catalogueManager")
    EntityManager mh;

    @Override
    public List<Client> getClients() {
        Query query = mh.createQuery("SELECT c FROM Client c");
        List<Client> clients = query.getResultList();
        return clients;
    }

    @Override
    public Client getClient(int id) {
        Query query = mh.createQuery("SELECT c FROM Client c WHERE c.id=:id").setParameter("id", id);
        Client client = (Client) query.getSingleResult();
        return client;
    }

    @Override
    public Client enregisterClient(Client client) {
        try {
            mh.persist(client);
            return client;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Client getClient(String nom, String mail) {
        Query query = mh.createQuery("SELECT c FROM Client c WHERE c.nom=:nom AND c.email=:mail").setParameter("nom", nom).setParameter("mail", mail);
        Client client;
        try {
            client = (Client) query.getSingleResult();
        } catch (NoResultException e) {
            client = null;
        }
        return client;
    }
}
