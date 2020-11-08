package fr.catalogue.ejb;
import fr.catalogue.beans.CategorieBean;

import javax.ejb.Local;

@Local
public interface CatalogueLocal {
    CategorieBean getCategory(String name);
}
