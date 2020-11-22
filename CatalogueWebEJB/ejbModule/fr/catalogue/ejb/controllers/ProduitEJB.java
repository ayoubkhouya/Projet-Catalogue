package fr.catalogue.ejb.controllers;

import fr.catalogue.beans.Produit;
import fr.catalogue.ejb.interfaces.local.ProduitLocal;
import fr.catalogue.ejb.interfaces.remote.ProduitRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;

@Stateless(name = "CatalogueJNDI")
public class ProduitEJB implements ProduitRemote, ProduitLocal {
    @PersistenceContext(unitName = "catalogueManager")
    EntityManager em;

    public ProduitEJB() { }

    @Override
    // Get single result
    public Produit getProduit(int id) {
        Query query = em.createQuery("SELECT p FROM Produit p WHERE p.id = :id").setParameter("id", id);
        return (Produit) query.getSingleResult();
    }

    // Get all results
    public ArrayList<Produit> getProduits() {
        Query query = em.createQuery("SELECT p FROM Produit p");
        return (ArrayList<Produit>) query.getResultList();
    }
}
