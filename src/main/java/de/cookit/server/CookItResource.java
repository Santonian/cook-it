package de.cookit.server;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

import de.cookit.entity.Ingredient;

@Path("/cookit")
@Produces(MediaType.APPLICATION_JSON)
public class CookItResource  {

	private Datastore datastore;
	
	public CookItResource(final MongoClient mongoClient) {
		datastore = new Morphia().createDatastore(mongoClient, "cookit");
	}
	
	@GET
	@Path("ping")
	public String ping(){
		return "ok";
	}
    
    @POST
	@Path("storeIngredient")
    @Consumes(MediaType.APPLICATION_JSON)
	public Response storeIngredient(Ingredient ingredient){
    	datastore.save(ingredient);
    	
    	return Response.created(URI.create(ingredient.getId())).entity(ingredient).build();
	}
}
