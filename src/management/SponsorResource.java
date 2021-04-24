package com.rest.management;

import models.Sponsor;
import controllers.SponsorController;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("SponsorResources")
public class SponsorResource {

	@GET
	@Path("Sponsors")
	@Produces({MediaType.APPLICATION_JSON })
	public List<Sponsor> getAllSponsors() throws Exception {
		return SponsorController.getInstance().SearchAll();
	}

	@GET
	@Path("Sponsor/{sponsor_id}")
	@Produces({MediaType.APPLICATION_JSON })
	public List<Sponsor> getSponsor(@PathParam("sponsor_id") int sponsor_id) throws Exception {
		Sponsor obj = new Sponsor();
		obj.setSponsor_id(sponsor_id);
		return SponsorController.getInstance().Search(obj);
	}

	@POST
	@Path("Sponsor")
	public String saveSponsor(Sponsor obj) throws Exception {
		SponsorController.getInstance().Save(obj);
		return "Sponsor Saved";
	}

	@PUT
	@Path("Sponsor")
	public String updateSponsor(Sponsor obj) throws Exception {
		SponsorController.getInstance().Update(obj);
		return "Sponsor Updated";
	}

	@DELETE
	@Path("Sponsor/{sponsor_id}")
	public String deleteSponsor(@PathParam("sponsor_id") int sponsor_id) throws Exception {
		Sponsor obj = new Sponsor();
		obj.setSponsor_id(sponsor_id);
		SponsorController.getInstance().Delete(obj);
		return "Sponsor Deleted";
	}
}