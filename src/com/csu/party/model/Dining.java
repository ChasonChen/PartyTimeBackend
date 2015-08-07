package com.csu.party.model;

import java.util.ArrayList;
import java.util.List;

public class Dining {
	public String addition;
	public String atmosphere;
	public String cost;
	public String cpRating;
	public String cuisines;
	public String deepSrc;
	public String environmentRating;
	public String intro;
	public String openTime;
	public String openTimeGDF;
	public String orderingAppUrl;
	public String orderingWapUrl;
	public String orderingWebUrl;
	public List<Photo> photos;
	public String rating;
	public String recommend;
	public String serviceRating;
	public String tag;
	public String tasteRating;
	public Boolean isMealOrdering;

	public Dining() {
		this.photos = new ArrayList<Photo>();
	}
}
