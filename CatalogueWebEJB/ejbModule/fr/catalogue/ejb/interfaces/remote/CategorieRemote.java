package fr.catalogue.ejb.interfaces.remote;

import fr.catalogue.beans.Categorie;

import javax.ejb.Remote;
import java.util.List;


@Remote
public interface CategorieRemote {
    Categorie getOneCategory(String name);
    List<Categorie> getAllCategories();
}
