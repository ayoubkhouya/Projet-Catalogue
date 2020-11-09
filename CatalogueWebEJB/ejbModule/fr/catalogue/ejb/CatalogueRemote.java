package fr.catalogue.ejb;

import fr.catalogue.beans.Categorie;

import javax.ejb.Remote;

@Remote
public interface CatalogueRemote {
     Categorie getCategory(String name);
}