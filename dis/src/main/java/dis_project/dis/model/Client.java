package dis_project.dis.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Client {
	private int client_id = 0;

	private String clientName = "";
	private double balance = 0;
	private List<String> stocksName = null;
	private List<Integer> stocksQuantity = null;
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
	
	public List<String> getStocksName() {
		return stocksName;
	}
	
	public void setStocksName(List<String> stocksName) {
		this.stocksName = stocksName;
		
		if (this.stocksQuantity!=null) updateMap();
	}
	
	public List<Integer> getStocksQuantity() {
		return stocksQuantity;
	}
	
	public void setStocksQuantity(List<Integer> stocksQuantity) {
		this.stocksQuantity = stocksQuantity;
		if (this.stocksName != null) updateMap(); 
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
	
	private void updateMap() {
		this.stocks = new HashMap<>();
		for (int i = 0; i < stocksName.size(); i++) {
			stocks.put(stocksName.get(i), stocksQuantity.get(i));
		}
	}
}