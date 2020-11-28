package fr.catalogue.ejb.interfaces.remote;

import fr.catalogue.beans.Categorie;

import javax.ejb.Remote;
import java.util.List;


@Remote
public interface CategorieRemote {
    List<Categorie> getAllCategories();
    Categorie getCategoryById(int id);
    Categorie getCategoryByName(String name);
}
