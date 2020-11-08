package fr.catalogue.ejb;

import javax.ejb.Remote;

@Remote
public interface CatalogueRemote {
     String getCategory(String name);
}