package dis_project.dis.resources;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dis_project.dis.model.Client;
import dis_project.dis.service.ClientService;

@Path("/clients")
public class ClientResource {
	//
	private ClientService service = new ClientService();
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> getClients() {
		return service.getClients();
	}
	
	 @GET
	 @Path("/test")
	 @Produces(MediaType.TEXT_PLAIN)
	 public String getIt() {
		 return "Got it!";
	 }
	    
	 /**
     * By posting this request we initiate the whole process. 
     *   - initiate connection with the DB: authenticate, create table if it doesnt exists, create a unique id for the client
     *   and submit an item to the db(client_id + his_info + transcation_number). Also we post a request to the second team service, 
     *   that should contain all the information from the DB(?), for this we need to trigger the even on their side.  
     * @param client_id uuid of the client, should be in a string format.
     * @param shares in a format {"Share1" : 10, "Share2" : 20}
     * @param init_balance initial balance of the client. 
     */
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String startClient(String client) {
    	Gson g = new Gson();
    	Client clientJson = g.fromJson(client, Client.class);
    	return this.service.putClient(clientJson);
    }
    
    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> postUpdate(String clients) {
    	Gson g = new Gson();
    	Type listType = new TypeToken<ArrayList<Client>>(){}.getType();
    	List<Client> clientsJson = g.fromJson(clients, listType);
    	return clientsJson;
    }
    
    /**
     * Second team use this api to send us information with the updates, they should probably post to some queue(SQS). 
     * Format for the return message is same as in previous method.
     * @param client_id uuid of the client or they sent the information about the whole clients.
     */
    @POST
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public void updateClient() {
    	
    }
    
    @GET
    @Path("/read")
    @Produces(MediaType.APPLICATION_JSON)
    public String readClient() {
    	return "hello from readClient";
    }
    
    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteClient() {
    	
    }
    /**
     * Think about what kind of the report we need and query the DB to get the result.
     * @param client_id
     */
    @GET
    @Path("/report")
    @Produces(MediaType.APPLICATION_JSON)
    public String getReport() {
    	return "hello from getReport";
    }
	
}