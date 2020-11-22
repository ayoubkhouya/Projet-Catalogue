package fr.catalogue.ejb.interfaces.remote;

import javax.ejb.Remote;
import fr.catalogue.beans.Produit;
import java.util.ArrayList;

@Remote
public interface ProduitRemote {
    Produit getProduit(int id);
    ArrayList<Produit> getProduits();
}
