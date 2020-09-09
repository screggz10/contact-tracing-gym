package scc.project.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import scc.project.SCCUser;
import scc.project.dao.UserDAO;

@Path("/user")
public class UserResource {
	
	private UserDAO dao = new UserDAO();
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<SCCUser> findAll(){
		System.out.println("findAll");
		return dao.findAll();
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public SCCUser create(SCCUser user) {
		System.out.println("creating user");
		System.out.println("new user");
		return dao.create(user);

	}
	
	@GET
	@Path("/query")
	@Produces({ MediaType.APPLICATION_JSON })
	public SCCUser findByUsername(@QueryParam("username") String username, @QueryParam("password") String password) {
		System.out.println("findByUsername: " + username + password);
		return dao.findByUsername(username);
	}
	
}
