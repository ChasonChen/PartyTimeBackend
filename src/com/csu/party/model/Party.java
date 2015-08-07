package com.csu.party.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Party {
	public String id;
	public String title;
	public String accessToken;
	public String gatheringPlace;
	public String startTime;
	public List<ActivityCounter> activities;
	public List<AccountCounter> invitedMembers;
	public List<AccountCounter> joinedMembers;
	public String notice;
	public long upvotes;

	public String cTime;
	public String uTime;

	public boolean isVotingEnd;
	public boolean isPartyShared;

	public Party() {
		this.activities = new ArrayList<ActivityCounter>();
		this.invitedMembers = new ArrayList<AccountCounter>();
		this.joinedMembers = new ArrayList<AccountCounter>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getGatheringPlace() {
		return gatheringPlace;
	}

	public void setGatheringPlace(String gatheringPlace) {
		this.gatheringPlace = gatheringPlace;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public List<ActivityCounter> getActivities() {
		return activities;
	}

	public void setActivities(List<ActivityCounter> activities) {
		this.activities = activities;
	}

	public List<AccountCounter> getInvitedMembers() {
		return invitedMembers;
	}

	public void setInvitedMembers(List<AccountCounter> invitedMembers) {
		this.invitedMembers = invitedMembers;
	}

	public List<AccountCounter> getJoinedMembers() {
		return joinedMembers;
	}

	public void setJoinedMembers(List<AccountCounter> joinedMembers) {
		this.joinedMembers = joinedMembers;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public long getUpvotes() {
		return upvotes;
	}

	public void setUpvotes(long upvotes) {
		this.upvotes = upvotes;
	}

	public String getcTime() {
		return cTime;
	}

	public void setcTime(String cTime) {
		this.cTime = cTime;
	}

	public String getuTime() {
		return uTime;
	}

	public void setuTime(String uTime) {
		this.uTime = uTime;
	}

	public boolean isVotingEnd() {
		return isVotingEnd;
	}

	public void setVotingEnd(boolean isVotingEnd) {
		this.isVotingEnd = isVotingEnd;
	}

	public boolean isPartyShared() {
		return isPartyShared;
	}

	public void setPartyShared(boolean isPartyShared) {
		this.isPartyShared = isPartyShared;
	}

	@Override
	public String toString() {
		return "Party [id=" + id + ", title=" + title + ", accessToken="
				+ accessToken + ", gatheringPlace=" + gatheringPlace
				+ ", startTime=" + startTime + ", activities=" + activities
				+ ", invitedMembers=" + invitedMembers + ", joinedMembers="
				+ joinedMembers + ", notice=" + notice + ", upvotes=" + upvotes
				+ ", cTime=" + cTime + ", uTime=" + uTime + ", isVotingEnd="
				+ isVotingEnd + ", isPartyShared=" + isPartyShared + "]";
	}

}
