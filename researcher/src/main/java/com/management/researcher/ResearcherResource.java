
package com.management.researcher;


import models.Researcher;
import controllers.ResearcherController;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("ResearcherResources")
public class ResearcherResource {

	@GET
	@Path("Researchers")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Researcher> getAllResearchers() throws Exception {
		return ResearcherController.getInstance().SearchAll();
	}

	@GET
	@Path("Researcher/{researcher_id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Researcher> getResearcher(@PathParam("researcher_id") int researcher_id) throws Exception {
		Researcher obj = new Researcher();
		obj.setResearcher_id(researcher_id);
		return ResearcherController.getInstance().Search(obj);
	}

	@POST
	@Path("Researcher")
	public String saveResearcher(Researcher obj) throws Exception {
		ResearcherController.getInstance().Save(obj);
		return "Researcher Saved";
	}

	@PUT
	@Path("Researcher")
	public String updateResearcher(Researcher obj) throws Exception {
		ResearcherController.getInstance().Update(obj);
		return "Researcher Updated";
	}

	@DELETE
	@Path("Researcher/{researcher_id}")
	public String deleteResearcher(@PathParam("researcher_id") int researcher_id) throws Exception {
		Researcher obj = new Researcher();
		obj.setResearcher_id(researcher_id);
		ResearcherController.getInstance().Delete(obj);
		return "Researcher Deleted";
	}
}