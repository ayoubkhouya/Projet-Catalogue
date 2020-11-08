package fr.catalogue.beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "catalogue", name = "categories")
public class CategorieBean implements Serializable {

    private static final long serialVersionUID = 7215289928717677967L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "nom")
    private String nom;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return nom;
    }

    public void setName(String nom) {
        this.nom = nom;
    }
}
