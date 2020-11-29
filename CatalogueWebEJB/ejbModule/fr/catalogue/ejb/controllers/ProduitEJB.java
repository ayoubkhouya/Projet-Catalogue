package fr.catalogue.ejb.controllers;

import fr.catalogue.beans.Categorie;
import fr.catalogue.beans.Produit;
import fr.catalogue.ejb.interfaces.local.ProduitLocal;
import fr.catalogue.ejb.interfaces.remote.ProduitRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless(mappedName = "CatalogueJNDI")
public class ProduitEJB implements ProduitRemote, ProduitLocal {

    @PersistenceContext(unitName = "catalogueManager")
    EntityManager mh;

    @Override
    public List<Produit> getProduits() {
        Query query = mh.createQuery("SELECT p FROM Produit p");
        List<Produit> produits = query.getResultList();
        return produits;
    }

    @Override
    public List<Produit> getProduitsByCategorie(Categorie categorie) {
        Query query = mh.createQuery("SELECT p FROM Produit p WHERE p.categorie=:categorie").setParameter("categorie", categorie);
        List<Produit> produits = query.getResultList();
        return produits;
    }

    @Override
    public Produit getProduitById(int id) {
        Query query = mh.createQuery("SELECT p FROM Produit p WHERE p.id=:id").setParameter("id", id);
        Produit produit = (Produit) query.getSingleResult();
        return produit;
    }

    @Override
    public Produit getProduitByName(String name) {
        Query query = mh.createQuery("SELECT p FROM Produit p WHERE p.nom=:nom").setParameter("nom", name);
        Produit produit = (Produit) query.getSingleResult();
        return produit;
    }

    @Override
    public List<Produit> getProduitsByCategorieId(int id) {
        Query query = mh.createQuery("SELECT p FROM Produit p WHERE p.categorie.id=:id").setParameter("id", id);
        List<Produit> produits = query.getResultList();
        System.out.println(query.getFirstResult());
        return produits;
    }
}
