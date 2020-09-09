package scc.project.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import scc.project.HealthCheck;
import scc.project.dao.HealthCheckDAO;

@Path("/healthcheck")
public class HealthCheckResource {
	
	private HealthCheckDAO dao = new HealthCheckDAO();
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<HealthCheck> findAll() {
		System.out.println("findAll");
		return dao.findAll();
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public HealthCheck create(HealthCheck check) {
		System.out.println("creating checkIn");
		return dao.create(check);
	}
}
