package fr.catalogue.ejb;
import javax.ejb.Local;

@Local
public interface CatalogueLocal {
    String getCategory(String name);
}
