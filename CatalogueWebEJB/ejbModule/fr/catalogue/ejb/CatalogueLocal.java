package fr.catalogue.ejb;
import fr.catalogue.beans.Categorie;

import javax.ejb.Local;

@Local
public interface CatalogueLocal {
    Categorie getCategory(String name);
}
