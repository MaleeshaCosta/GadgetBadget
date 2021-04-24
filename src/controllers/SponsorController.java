package controllers;

import models.Sponsor;
import connector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SponsorController {

	Connector con = Connector.getInstance();

	private SponsorController() {
	}

	private static final SponsorController obj = new SponsorController();

	public static SponsorController getInstance() {
		return obj;
	}

	public void Save(Sponsor data) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO sponsor(organization,product_code,fund,name) values ('" + data.getOrganization() + "','"
				+ data.getProduct_code() + "','" + data.getfund() + "','" + data.getName() + "') ");
	}

	public void Update(Sponsor data) throws Exception {
		con.getConnection();
		con.aud("UPDATE sponsor SET organization  = '" + data.getOrganization() + "',product_code  = '"
				+ data.getProduct_code() + "',fund  = '" + data.getfund() + "',name  = '" + data.getName()
				+ "' WHERE sponsor_id = '" + data.getSponsor_id() + "'");
	}

	public void Delete(Sponsor data) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM sponsor WHERE sponsor_id = '" + data.getSponsor_id() + "'");
	}

	public List<Sponsor> SearchAll() throws Exception {
		List<Sponsor> objList = new ArrayList<Sponsor>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM sponsor");
		while (rset.next()) {
			Sponsor obj = new Sponsor();
			obj.setSponsor_id(rset.getInt(1));
			obj.setOrganization(rset.getString(2));
			obj.setProduct_code(rset.getString(3));
			obj.setfund(rset.getDouble(4));
			obj.setName(rset.getString(5));
			objList.add(obj);
		}

		return objList;
	}

	public List<Sponsor> Search(Sponsor data) throws Exception {
		List<Sponsor> objList = new ArrayList<Sponsor>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM sponsor WHERE sponsor_id = '" + data.getSponsor_id() + "'");
		while (rset.next()) {
			Sponsor obj = new Sponsor();
			obj.setSponsor_id(rset.getInt(1));
			obj.setOrganization(rset.getString(2));
			obj.setProduct_code(rset.getString(3));
			obj.setfund(rset.getDouble(4));
			obj.setName(rset.getString(5));
			objList.add(obj);
		}

		return objList;
	}

}