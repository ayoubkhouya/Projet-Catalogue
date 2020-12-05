package fr.catalogue.interfaces;

import fr.catalogue.beans.Client;

public interface ClientMethodes {

    Client registerClient(Client client);
    Client getClient(Client client);
    Client getClientById(int id);
    Client getClientByNameAndEmail(String nom, String email);

}
