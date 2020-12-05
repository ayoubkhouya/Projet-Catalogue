package fr.catalogue.ejb.controllers;

import fr.catalogue.beans.Panier;
import fr.catalogue.beans.Produit;
import fr.catalogue.ejb.interfaces.remote.PanierRemote;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



@Stateless
public class PanierEJB implements PanierRemote {

    @PersistenceContext(unitName = "catalogueManager")
    EntityManager mh;

    public Panier getPanier(int id) {
        Query query = mh.createQuery("SELECT p FROM Panier p WHERE p.id=:id").setParameter("id", id);
        Panier panier = (Panier) query.getSingleResult();
        return panier;
    }

    @Override
    public boolean enregistrerPanier(Panier panier) {
        try {
            mh.persist(panier);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Produit getProduit(int id) {
        Query query = mh.createQuery("SELECT p FROM Produit p WHERE p.id=:id").setParameter("id", id);
        return (Produit) query.getSingleResult();
    }
}
