package com.csu.party.model;

public class ActivityCounter {
	public String activityID;
	public String activityTitle;
	public Integer votes;

	public ActivityCounter() {
		super();
	}

	public String getActivityID() {
		return activityID;
	}

	public void setActivityID(String activityID) {
		this.activityID = activityID;
	}

	public String getActivityTitle() {
		return activityTitle;
	}

	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	public ActivityCounter(String activityID, Integer votes,
			String activityTitle) {
		super();
		this.activityID = activityID;
		this.votes = votes;
		this.activityTitle = activityTitle;
	}
}
