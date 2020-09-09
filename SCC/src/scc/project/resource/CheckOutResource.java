package scc.project.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import scc.project.SCCCheckOut;
import scc.project.dao.CheckOutDAO;

@Path("/checkout")
public class CheckOutResource {
	private CheckOutDAO dao = new CheckOutDAO();
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<SCCCheckOut> findAll() {
		System.out.println("findAll");
		return dao.findAll();
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public SCCCheckOut create(SCCCheckOut checkOut) {
		System.out.println("creating checkOut");
		return dao.addCheckOut(checkOut);
	}
}
