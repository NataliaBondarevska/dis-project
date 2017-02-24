package dis_project.dis.database;

import java.util.List;

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

public class ClientDB {
	private static DynamoDB dynamoDB;

	private static String tableName = "Clients";
	
	private static Table table;
	
	public ClientDB() {
		dynamoDB = new DynamoDB(new AmazonDynamoDBClient(
	            new ProfileCredentialsProvider()));
		
		table = dynamoDB.getTable(tableName);
	}
	
	/**
	 * Should put an item to db, follows the contract.
	 */
	public void putItem() {
		
	}

	/**
	 * Queries the db and returns all the items from it.
	 * @return
	 */
	public List<Item> getItems() {
		return null;
		
	}
	
	/**
	 * Updates information for this client by its id.
	 */
	public void updateItem(String clientId) {
		
	}
}

