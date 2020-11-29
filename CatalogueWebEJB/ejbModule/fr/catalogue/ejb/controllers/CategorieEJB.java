package fr.catalogue.ejb.controllers;


import fr.catalogue.beans.Categorie;
import fr.catalogue.ejb.interfaces.local.CategorieLocal;
import fr.catalogue.ejb.interfaces.remote.CategorieRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless(name = "CatalogueJNDI")
public class CategorieEJB implements CategorieLocal, CategorieRemote {


    @PersistenceContext(unitName = "catalogueManager")
    EntityManager mh;

    @Override
    public List<Categorie> getAllCategories() {
        Query query = mh.createQuery("SELECT c FROM Categorie c");
        List<Categorie> categories = query.getResultList();
        return categories;
    }

    @Override
    public Categorie getCategoryById(int id) {
        Query query = mh.createQuery("SELECT c FROM Categorie c WHERE c.id=:id").setParameter("id", id);
        return (Categorie) query.getSingleResult();
    }

    @Override
    public Categorie getCategoryByName(String name) {
        Query query = mh.createQuery("SELECT c FROM Categorie c WHERE c.nom=:name").setParameter("name", name);
        return (Categorie) query.getSingleResult();
    }


}
