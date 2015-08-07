package com.csu.party.util;

import java.util.List;

import com.csu.party.model.LatLonPoint;

public class SpatialAnalysisUtils {

	public static LatLonPoint getPos(List<LatLonPoint> points) {
		LatLonPoint pos = null;
		if (points.size()==2) {
			pos=getLineCenter(points.get(0), points.get(1));
		}else if (points.size()==3) {
			pos = gravityCenter(points.get(0), points.get(1), points.get(2));
		}
		return pos;
	}
	
	public static LatLonPoint getLineCenter(LatLonPoint a, LatLonPoint b) {
		return new LatLonPoint((a.Latitude+b.Latitude)/2,
				(a.longitude+b.longitude)/2);
	}
	
	public static LatLonPoint gravityCenter(LatLonPoint a, LatLonPoint b, LatLonPoint c){
		LatLonPoint center = new LatLonPoint();
		center.Latitude = (a.Latitude+b.Latitude+c.Latitude)/3;
		center.longitude = (a.longitude+b.longitude+c.longitude)/3;
		return center;
	};

	public static LatLonPoint sircumCenter(LatLonPoint a, LatLonPoint b, LatLonPoint c) {
		LatLonPoint result = new LatLonPoint();
		double a1 = b.Latitude - a.Latitude;
		double b1 = b.longitude - a.longitude;
		double c1 = (Math.pow(a1, 2) + Math.pow(b1, 2)) / 2;
		
		double a2 = c.Latitude - a.Latitude;
		double b2 = c.longitude - a.longitude;
		double c2 = (Math.pow(a2, 2) + Math.pow(b2, 2)) / 2;
		
		double d = a1 * b2 - a2 * b1;
		result.Latitude = a.Latitude + (c1 * b2 - c2 * b1) / d;
		result.longitude = a.longitude + (a1 * c2 - a2 * c1) / d;

		return result;
	}

	public static double distance(LatLonPoint start, LatLonPoint end) {
		return Math.sqrt(Math.pow((start.Latitude - end.Latitude), 2)
				+ Math.pow((start.longitude - end.longitude), 2));
	}

}
