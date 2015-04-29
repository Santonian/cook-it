package de.cookit.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cookit")
@Produces(MediaType.APPLICATION_JSON)
public class CookItResource  {

	@GET
	@Path("ping")
	public String ping(){
		return "ok";
	}
}
