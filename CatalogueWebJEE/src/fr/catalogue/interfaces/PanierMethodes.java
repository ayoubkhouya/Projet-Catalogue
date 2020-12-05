package fr.catalogue.interfaces;

import fr.catalogue.beans.Panier;
import fr.catalogue.beans.Produit;

public interface PanierMethodes {

    Panier getPanier(int id);

    Produit addProduitToPanier(int id);

    Produit getProduitFromPanier(int id);
}
