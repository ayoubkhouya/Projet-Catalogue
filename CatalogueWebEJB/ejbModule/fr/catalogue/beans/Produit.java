package fr.catalogue.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(schema = "catalogue")
public class Produit implements Serializable {

    private static final long serialVersionUID = 6784550648794430181L;

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private float prix;

    @Column(nullable = false)
    private String description;

    @Column
    private Timestamp dernier_maj;

    @OneToOne
    private Categorie categorie;

    @OneToOne
    private Commande commande;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDernier_maj() {
        return dernier_maj;
    }

    public void setDernier_maj(Timestamp dernier_maj) {
        this.dernier_maj = dernier_maj;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }


    public Commande getCommandes() { return commande; }

    public void setCommandes(Commande commandes) { this.commande = commandes; }
}
