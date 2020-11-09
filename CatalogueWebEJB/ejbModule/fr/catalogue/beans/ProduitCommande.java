package fr.catalogue.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(schema = "catalogue", name = "produit_commande")
public class ProduitCommande implements Serializable {

    private static final long serialVersionUID = 4802556426613669717L;

    @Id
    private int commande_client_id;

    @Column(nullable = false)
    private int quantite;


    public int getCommande_client_id() {
        return commande_client_id;
    }

    public void setCommande_client_id(int commande_client_id) {
        this.commande_client_id = commande_client_id;
    }
}
