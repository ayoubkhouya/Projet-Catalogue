package fr.catalogue.ejb.interfaces.remote;

import fr.catalogue.beans.Categorie;
import fr.catalogue.beans.Produit;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ProduitRemote {
    List<Produit> getProduits();
    List<Produit> getProduitsByCategorie(Categorie categorie);
    Produit getProduitById(int id);
    Produit getProduitByName(String name);
}
