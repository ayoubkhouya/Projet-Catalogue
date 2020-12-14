package fr.catalogue.ejb.controllers;

import fr.catalogue.beans.Commande;
import fr.catalogue.ejb.interfaces.local.CommandeLocal;
import fr.catalogue.ejb.interfaces.remote.CommandeRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CommandeEJB implements CommandeLocal, CommandeRemote {

    @PersistenceContext(unitName = "catalogueManager")
    EntityManager mh;


    @Override
    public Commande enregistrerCommande(Commande commande) {
        try {
            mh.persist(commande);
            return commande;
        } catch (Exception e) {
            return null;
        }
    }
}
