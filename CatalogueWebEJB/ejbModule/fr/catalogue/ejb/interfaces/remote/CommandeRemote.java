package fr.catalogue.ejb.interfaces.remote;

import fr.catalogue.beans.Commande;

import javax.ejb.Remote;

@Remote
public interface CommandeRemote {

    Commande enregistrerCommande(Commande commande);

}
