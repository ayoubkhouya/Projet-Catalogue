package fr.catalogue.interfaces;

import fr.catalogue.beans.Categorie;
import fr.catalogue.beans.Produit;

import java.util.List;

public interface ProduitMethodes {

    List<Produit> getProduits();
    List<Produit> getProduitsByCategorie(Categorie categorie);
    List<Produit> getProduitsByCategorieId(int id);
    Produit getProduitById(int id);
    Produit getProduitByName(String name);

}
