package fr.catalogue.ejb.interfaces.remote;

import fr.catalogue.beans.Client;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ClientRemote {
    List<Client> getClients();
    Client getClient(int id);
    Client enregisterClient(Client client);
    Client getClient(String nom, String mail);
}
