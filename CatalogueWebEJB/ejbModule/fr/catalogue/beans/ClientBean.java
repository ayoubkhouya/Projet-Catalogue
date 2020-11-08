package fr.catalogue.beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "catalogue", name = "client")
public class ClientBean implements Serializable {

    private static final long serialVersionUID = 570269912778275353L;

    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private String nom;

    @Column
    private String email;

    @Column
    private String telephone;

    @Column
    private String adresse;

    public long getId() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
