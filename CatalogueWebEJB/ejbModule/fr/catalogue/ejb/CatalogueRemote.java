package fr.catalogue.ejb;

import fr.catalogue.beans.CategorieBean;

import javax.ejb.Remote;

@Remote
public interface CatalogueRemote {
     CategorieBean getCategory(String name);
}