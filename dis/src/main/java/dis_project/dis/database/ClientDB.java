package dis_project.dis.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.DescribeTableRequest;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.amazonaws.services.dynamodbv2.util.TableUtils.TableNeverTransitionedToStateException;
import com.google.gson.Gson;

import dis_project.dis.model.Client;

public class ClientDB {
	private static AmazonDynamoDBClient amazonDynamoDBClient;
	
	private static DynamoDB dynamodb ;
	
	private static String tableName = "Clients";
	
	private long transaction = 0;
	private long client_id = 0;
	
	public ClientDB() {
		Region usWest2 = Region.getRegion(Regions.US_WEST_2);
		amazonDynamoDBClient =	new AmazonDynamoDBClient(new ProfileCredentialsProvider());
		amazonDynamoDBClient.setRegion(usWest2);
		dynamodb = new DynamoDB(amazonDynamoDBClient);
		
		createTable();
	}
	
	private void createTable() {
		 ArrayList<AttributeDefinition> attributeDefinitions = new ArrayList<AttributeDefinition>();
         attributeDefinitions.add(new AttributeDefinition()
             .withAttributeName("transaction")
             .withAttributeType("N"));

         ArrayList<KeySchemaElement> keySchema = new ArrayList<KeySchemaElement>();
         keySchema.add(new KeySchemaElement()
             .withAttributeName("transaction")
             .withKeyType(KeyType.HASH));
         
         CreateTableRequest request = new CreateTableRequest()
         .withTableName(tableName)
         .withKeySchema(keySchema)
         .withAttributeDefinitions(attributeDefinitions)
         .withProvisionedThroughput(new ProvisionedThroughput()
             .withReadCapacityUnits(5L)
             .withWriteCapacityUnits(6L));
         
         try {
        	 amazonDynamoDBClient.createTable(request);
        	 dynamodb.getTable(tableName).waitForActive();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Should put an item to db, follows the contract.
	 * Add a check. so that wont be possible to submit two clients with same client_id. 
	 */
	public String putItem(Client client) {
	    this.transaction = getTransaction();
		Item item = new Item()
			.withPrimaryKey("client_id",client.getClientId())
			.withString("name", client.getClientName())
			.withLong("transaction", transaction)
			.withDouble("balance", client.getBalance())
			.withMap("stocks", client.getStocks());
		
		dynamodb.getTable(tableName).putItem(item);
		return new Long(transaction).toString();
	}

	private Long getTransaction() {
		Item item_next = dynamodb.getTable(tableName).getItem("transaction", this.transaction);
		//this.transaction++;
		
		Long next_id = null;
		if (item_next != null) {
			next_id = new Long(item_next.get("transaction").toString());
		} else return new Long(0);
		
		this.transaction = next_id + 1;
		
		return next_id == null ? new Long(0) : next_id+1;
	}
	
	/**
	 * Queries the db and returns all the items from it.
	 * @return
	 */
	public List<Client> getItems() {
		return null;
	}
	
	/**
	 * Updates information for this client by its id.
	 */
	public void updateItem(String clientId) {
		
	}
}

