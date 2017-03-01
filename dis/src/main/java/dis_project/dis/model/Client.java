package dis_project.dis.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Client {
	private int client_id = 0;

	private String clientName = "";
	private double balance = 0;
	private Map<String, Integer> stocks ;
	
	public Client() {}
	//
	public Client(int clientID, String name, double balance, List<String> stocksName, List<Integer> stocksQuantity) {
		this.client_id = clientID;
		this.clientName = name;
		this.balance = balance;
		this.stocks = new HashMap<>();
	}
	
	public int getClientId() {
		return client_id;
	}
	public void setClientId(int client_id) {
		this.client_id = client_id;
	}
	public void setStocks(Map<String, Integer> stocks) {
		this.stocks = stocks;
	}
	
	public Map<String, Integer> getStocks() {
		return stocks;
	}
	
	public String getClientName() {
		return clientName;
	}
	
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double clientBalance) {
		this.balance = clientBalance;
	}
}