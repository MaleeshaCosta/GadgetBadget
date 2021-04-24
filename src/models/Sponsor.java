package models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Sponsor {

	private int sponsor_id;
	private String organization;
	private String product_code;
	private double fund;
	private String name;

	public Sponsor() {
	}

	public Sponsor(int sponsor_id) {
		this.sponsor_id = sponsor_id;
	}

	public Sponsor(int sponsor_id, String organization, String product_code, double fund, String name) {
		this.sponsor_id = sponsor_id;
		this.organization = organization;
		this.product_code = product_code;
		this.fund = fund;
		this.name = name;
	}

	public int getSponsor_id() {
		return sponsor_id;
	}

	public void setSponsor_id(int sponsor_id) {
		this.sponsor_id = sponsor_id;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public double getfund() {
		return fund;
	}

	public void setfund(double fund) {
		this.fund = fund;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}