package fr.catalogue.ejb;


import fr.catalogue.beans.CategorieBean;

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
    public CategorieBean getCategory(String name) {
        Query query = mh.createQuery("SELECT c FROM CategorieBean c");
        CategorieBean categorieBean = (CategorieBean) query.getSingleResult();
        return categorieBean;
    }
}
