package com.rs.fer.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddressForm extends ActionForm {

	private int id;
	private String streetname;
	private String town;
	private String city;
	private String state;
	private String zip;
	private String country;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreetname() {
		return streetname;
	}

	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (streetname == null || streetname.length() < 1) {
			errors.add("streetname", new ActionMessage("error.streetname.required"));
		}
		if (town == null || town.length() < 1) {
			errors.add("town", new ActionMessage("error.town.required"));
		}
		if (city == null || city.length() < 1) {
			errors.add("city", new ActionMessage("error.city.required"));
		}
		if (state == null || state.length() < 1) {
			errors.add("state", new ActionMessage("error.state.required"));
		}
		if (country == null || country.length() < 1) {
			errors.add("country", new ActionMessage("error.country.required"));
		}
		if (zip == null || zip.length() < 1) {
			errors.add("zip", new ActionMessage("error.zip.required"));
		}
		return errors;
	}
}