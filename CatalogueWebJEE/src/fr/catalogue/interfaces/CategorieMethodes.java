package fr.catalogue.interfaces;

import fr.catalogue.beans.Categorie;

import java.util.List;

public interface CategorieMethodes {

    List<Categorie> getCategories();
    Categorie getCategorieById(int id);
    Categorie getCategorieByName(String name);

}
