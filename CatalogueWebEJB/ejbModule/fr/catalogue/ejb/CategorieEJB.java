package fr.catalogue.ejb;


import fr.catalogue.beans.Categorie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "CatalogueJNDI")
public class CategorieEJB implements CatalogueLocal, CatalogueRemote {

    @PersistenceContext(unitName = "catalogueManager")
    EntityManager mh;

    public CategorieEJB() { }

    @Override
    public Categorie getCategory(String name) {
        Query query = mh.createQuery("SELECT c FROM Categorie c");
        Categorie categorieBean = (Categorie) query.getSingleResult();
        return categorieBean;
    }
}
