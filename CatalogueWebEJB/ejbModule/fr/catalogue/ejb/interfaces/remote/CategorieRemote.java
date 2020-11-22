package fr.catalogue.ejb.interfaces.remote;

import fr.catalogue.beans.Categorie;

import javax.ejb.Remote;

@Remote
public interface CategorieRemote {
    Categorie getCategory(String name);
}
