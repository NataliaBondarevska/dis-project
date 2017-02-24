package dis_project.dis.model;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Client {
	private String clientId = "id";
	private double clientBalance = 0;
	private Map<String, Integer> stocks = null;
	
	public Client() {}
	
	public Client(String id, double balance, Map<String, Integer> stocks) {
		clientId = id;
		clientBalance = balance;
		stocks = new HashMap<>(stocks);
	}
	
	public String getClientId() {
		return clientId;
	}
	
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	public double getClientBalance() {
		return clientBalance;
	}
	
	public void setClientBalance(double clientBalance) {
		this.clientBalance = clientBalance;
	}
	
	public Map<String, Integer> getStocks() {
		return stocks;
	}
	
	public void setStocks(Map<String, Integer> stocks) {
		this.stocks = stocks;
	}
}
