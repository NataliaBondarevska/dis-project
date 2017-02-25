package dis_project.dis.service;

import java.util.List;

import dis_project.dis.database.ClientDB;
import dis_project.dis.model.Client;

public class ClientService {
	private ClientDB dbclient = new ClientDB();
	
	/**
	 * Returns client by name. 
	 * @param name Name of the client precisely. 
	 * @return client.
	 */
	public Client getClient(String name) {
		List<Client> clients =  dbclient.getItems();
		
		for (Client c: clients) {
			if (c.getClientName().equals(name)) 
				return c;
		}
		return null;
	}
	
	public Client putClient(Client clientData) {
		dbclient.putItem(clientData);
		return clientData;
	}
	
	public List<Client> getClients() { 
		return dbclient.getItems();
	}
}
