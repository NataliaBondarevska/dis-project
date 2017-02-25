package dis_project.dis.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@XmlRootElement
public class Client {
	private String clientId = "id";
	private String clientName = "";
	private double clientBalance = 0;
	private Map<String, String> shares = null;
	private List<String> sharesKeys = null;
	private List<Integer> sharesValues = null;
	
	public List<String> getSharesKeys() {
		return sharesKeys;
	}

	public void setSharesKeys(List<String> sharesKeys) {
		this.sharesKeys = sharesKeys;
	}

	public List<Integer> getSharesValues() {
		return sharesValues;
	}

	public void setSharesValues(List<Integer> sharesValues) {
		this.sharesValues = sharesValues;
	}
	
	public Map<String, String> getShares() {
		return new HashMap<>(shares);
	}
	
	public void setShares(Map<String, String> shares) {
		this.shares = new HashMap<>(shares);
	}
	
	public Client() {}
	//
	public Client(String id, String name, double balance, Map<String, Integer> stocks) {
		clientId = id;
		clientName = name;
		clientBalance = balance;
	}
	
	public String getClientName() {
		return clientName;
	}
	
	public void setClientName(String clientName) {
		this.clientName = clientName;
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
	
}
