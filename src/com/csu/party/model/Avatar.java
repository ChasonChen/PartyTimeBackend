package com.csu.party.model;

public class Avatar {
    public String tiny;
    public String mid;
    public String large;
    
	@Override
	public String toString() {
		return "Avatar [tiny=" + tiny + ", mid=" + mid + ", large=" + large
				+ "]";
	}

	public String getTiny() {
		return tiny;
	}

	public void setTiny(String tiny) {
		this.tiny = tiny;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getLarge() {
		return large;
	}

	public void setLarge(String large) {
		this.large = large;
	}
    
    
}
