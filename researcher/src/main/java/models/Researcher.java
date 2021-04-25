package models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Researcher{

	private int researcher_id;
	private String name;
	private String company;
	private int product_id;
	private String product_name;
	private String product_description;
	private double product_price;

public Researcher(){
}

public Researcher(int researcher_id){
	this.researcher_id = researcher_id;
}
public Researcher(int researcher_id,String name,String company,int product_id,String product_name,String product_description,double product_price){
	this.researcher_id = researcher_id;
	this.name = name;
	this.company = company;
	this.product_id = product_id;
	this.product_name = product_name;
	this.product_description = product_description;
	this.product_price = product_price;
}

public int getResearcher_id(){
return researcher_id;
}

public void setResearcher_id(int researcher_id){
	this.researcher_id = researcher_id;
}

public String getName(){
return name;
}

public void setName(String name){
	this.name = name;
}

public String getCompany(){
return company;
}

public void setCompany(String company){
	this.company = company;
}

public int getProduct_id(){
return product_id;
}

public void setProduct_id(int product_id){
	this.product_id = product_id;
}

public String getProduct_name(){
return product_name;
}

public void setProduct_name(String product_name){
	this.product_name = product_name;
}

public String getProduct_description(){
return product_description;
}

public void setProduct_description(String product_description){
	this.product_description = product_description;
}

public double getProduct_price(){
return product_price;
}

public void setProduct_price(double product_price){
	this.product_price = product_price;
}

}