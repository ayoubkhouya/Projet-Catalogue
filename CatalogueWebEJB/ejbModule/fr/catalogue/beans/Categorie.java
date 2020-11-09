package fr.catalogue.beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "catalogue", name = "categories")
public class Categorie implements Serializable {

    private static final long serialVersionUID = 7215289928717677967L;

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String nom;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return nom;
    }

    public void setName(String nom) {
        this.nom = nom;
    }
}
