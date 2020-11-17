package fr.catalogue.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(schema = "catalogue", name = "produit_commande")
public class ProduitCommande implements Serializable {

    private static final long serialVersionUID = 4802556426613669717L;

    @Id
    @OneToOne
    private Client client;

    @OneToOne
    private Produit produit;

    @Column(nullable = false)
    private int quantite;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Produit getProduits() {
        return produit;
    }

    public void setProduits(Produit produits) {
        this.produit = produits;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
