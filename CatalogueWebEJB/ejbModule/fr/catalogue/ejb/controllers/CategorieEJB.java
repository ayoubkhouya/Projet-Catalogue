package fr.catalogue.ejb.controllers;


import fr.catalogue.beans.Categorie;
import fr.catalogue.ejb.interfaces.local.CatalogueLocal;
import fr.catalogue.ejb.interfaces.local.CategorieLocal;
import fr.catalogue.ejb.interfaces.remote.CatalogueRemote;
import fr.catalogue.ejb.interfaces.remote.CategorieRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "CatalogueJNDI")
public class CategorieEJB implements CategorieLocal, CategorieRemote {

    @PersistenceContext(unitName = "catalogueManager")
    EntityManager mh;

    public CategorieEJB() { }

    @Override
    public Categorie getCategory(String name) {
        Query query = mh.createQuery("SELECT c FROM Categorie c");
        Categorie singleResult = (Categorie) query.getSingleResult();
        return singleResult;
    }
}
