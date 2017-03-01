package dis_project.dis.service;

import java.util.List;

import dis_project.dis.database.ClientDB;
import dis_project.dis.model.Client;

public class ClientService {
	private static ClientDB dbclient = new ClientDB();
	
	public String putClient(Client clientData) {
		return dbclient.putItem(clientData);
	}
	
	public List<Client> getClients() { 
		return dbclient.getItems();
	}
}
