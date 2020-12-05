package fr.catalogue.ejb.interfaces.remote;

import fr.catalogue.beans.Panier;
import fr.catalogue.beans.Produit;

import javax.ejb.Remote;

@Remote
public interface PanierRemote {
    boolean enregistrerPanier(Panier panier);
    public Produit getProduit(int id);
    Panier getPanier(int id);
}
