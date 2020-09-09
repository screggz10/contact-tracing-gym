package scc.project.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import scc.project.SCCCheckIn;
import scc.project.dao.CheckInDAO;

@Path("/checkin")
public class CheckInResource {

	private CheckInDAO dao = new CheckInDAO();
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<SCCCheckIn> findAll() {
		System.out.println("findAll");
		return dao.findAll();
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public SCCCheckIn create(SCCCheckIn checkIn) {
		System.out.println("creating checkIn");
		return dao.addCheckIn(checkIn);
	}
	
}
