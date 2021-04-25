
package controllers;


import models.Researcher;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ResearcherController{

	Connector con = Connector.getInstance();

	private ResearcherController(){
	}

	private static final ResearcherController obj = new ResearcherController();

	public static ResearcherController getInstance(){
		return obj;
	}

	public void Save(Researcher data) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO researcher(name,company,product_id,product_name,product_description,product_price) values ('" + data.getName()+ "','" + data.getCompany()+ "','" + data.getProduct_id()+ "','" + data.getProduct_name()+ "','" + data.getProduct_description()+ "','" + data.getProduct_price()+ "') " );
	}

	public void Update(Researcher data) throws Exception {
		con.getConnection();
		con.aud("UPDATE researcher SET name  = '" + data.getName()+ "',company  = '" + data.getCompany()+ "',product_id  = '" + data.getProduct_id()+ "',product_name  = '" + data.getProduct_name()+ "',product_description  = '" + data.getProduct_description()+ "',product_price  = '" + data.getProduct_price()+ "' WHERE researcher_id = '" + data.getResearcher_id()+ "'");
	}

	public void Delete(Researcher data) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM researcher WHERE researcher_id = '" + data.getResearcher_id()+ "'");
	}

	public List<Researcher> SearchAll() throws Exception {
		List<Researcher> objList = new ArrayList<Researcher>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM researcher");
		while(rset.next()){
			Researcher obj = new Researcher();
			obj.setResearcher_id(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setCompany(rset.getString(3));
			obj.setProduct_id(rset.getInt(4));
			obj.setProduct_name(rset.getString(5));
			obj.setProduct_description(rset.getString(6));
			obj.setProduct_price(rset.getDouble(7));
			objList.add(obj);
		}

	return objList;
	}

	public List<Researcher> Search(Researcher data) throws Exception {
		List<Researcher> objList = new ArrayList<Researcher>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM researcher WHERE researcher_id = '" + data.getResearcher_id()+ "'");
		while(rset.next()){
			Researcher obj = new Researcher();
			obj.setResearcher_id(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setCompany(rset.getString(3));
			obj.setProduct_id(rset.getInt(4));
			obj.setProduct_name(rset.getString(5));
			obj.setProduct_description(rset.getString(6));
			obj.setProduct_price(rset.getDouble(7));
			objList.add(obj);
		}

	return objList;
	}

}