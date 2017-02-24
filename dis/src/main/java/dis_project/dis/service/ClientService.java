package dis_project.dis.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dis_project.dis.database.ClientDB;
import dis_project.dis.model.Client;

public class ClientService {
	private ClientDB dbclient = new ClientDB();
	
	public String getClient() {
		return null;
	}
	
	public void putClient(String clientData) {
		
	}
	
	public List<Client> getClients() {
		List<Client>  test = new ArrayList<>();
		Map<String, Integer> stocks = new HashMap<>();
		stocks.put("Google", 10);
		stocks.put("Amzn", 100);
		
		Client one = new Client("1", 10.0, stocks);
		
		test.add(one);
		return test;
	}
	
}
