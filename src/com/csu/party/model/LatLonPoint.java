package com.csu.party.model;

public class LatLonPoint {
    public double Latitude;
    public double longitude;
    
	public LatLonPoint() {
		super();
	}

	public LatLonPoint(double latitude, double longitude) {
		super();
		Latitude = latitude;
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "LatLonPoint [Latitude=" + Latitude + ", longitude=" + longitude
				+ "]";
	}
    
	
}
