package fr.catalogue.interfaces;

import fr.catalogue.beans.Client;

public interface ClientMethodes {

    boolean registerClient(Client client);
    Client getClient(Client client);
    Client getClientById(int id);

}
