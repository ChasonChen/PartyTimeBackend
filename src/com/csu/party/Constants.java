package com.csu.party;

public class Constants {
	public final static String SIMPLE_DATE_FORMAT = "yyyy-MM-dd-HH-mm-ss";
	/**/
	public final static String DB_NAME = "partytimedb";
	public final static String HOST = "127.0.0.1";
	public final static int PORT = 27017;
	public final static String USERNAME = "root";
	public final static String PASSWORD = "123456";
	/*
	public final static String DB_NAME = "vPPKjVgGjsmPWPhcwHCD";
	public final static String HOST = "mongo.duapp.com";
	public final static int PORT = 8908;
	public final static String USERNAME = "ndZp9UW6Sj29ETlVdHXNNW7u";
	public final static String PASSWORD = "xBP5uosb8vf1hCaMWVl3uNQEzA9fovV5";*/
	
	public final static String TABLE_PMESSAGE = "pt_pmessage";
	
	public final static String PMESSAGE_ID ="_id";
	public final static String PMESSAGE_PARTY_ID ="partyID";
	public final static String PMESSAGE_PARTY ="party";
	public final static String PMESSAGE_CONTENT ="content";
	public final static String PMESSAGE_MSTATE ="mState";
	public final static String PMESSAGE_C_TIME ="cTime";
	
	public final static String MSTATE_ACCOUNT_TOKEN ="accountToken";
	public final static String MSTATE_IS_READ ="isRead";
	
	public final static String TABLE_ACCOUNT ="pt_account"; 
	
	public final static String ACCOUNT_ID ="_id";
	public final static String ACCOUNT_ACCESS_TOKEN = "accessToken";
	public final static String ACCOUNT_NICKNAME = "nickname";
	public final static String ACCOUNT_NAME = "name";
	public final static String ACCOUNT_TEL = "tel";
	public final static String ACCOUNT_PASSWORD = "password";
	public final static String ACCOUNT_AVATAR = "avatar";
	public final static String ACCOUNT_CITY = "city";
	public final static String ACCOUNT_PROVINCE = "province";
	public final static String ACCOUNT_GENDER = "gender";
	public final static String ACCOUNT_EMAIL = "email";
	public final static String ACCOUNT_SIGNATURE = "signature";
	public final static String ACCOUNT_CURRENT_POS = "currentPos";
	public final static String ACCOUNT_FRIENDS = "friends";
	public final static String ACCOUNT_BIRTHDAY = "birthday";
	public final static String ACCOUNT_C_TIME = "cTime";
	public final static String ACCOUNT_U_TIME = "uTime";
	public final static String ACCOUNT_LAST_LOGIN_TIME = "lastLoginTime";
	public final static String ACCOUNT_IS_CREATOR = "isCreator";
	public final static String ACCOUNT_IS_MEMBER = "isMember";
	
	public final static String AVATAR_TINY = "tiny";
	public final static String AVATAR_MID = "mid";
	public final static String AVATAR_LARGE = "large";

	public final static String TABLE_PARTY = "pt_party";
	
	public final static String PARTY_ID ="_id";
	public final static String PARTY_TITLE ="title";
	public final static String PARTY_ACCESS_TOKEN ="accessToken";
	public final static String PARTY_CREATOR ="creator";
	public final static String PARTY_GATHERING_PLACE ="gatheringPlace";
	public final static String PARTY_START_TIME ="startTime";
	public final static String PARTY_ACTIVITIES ="activities";
	public final static String PARTY_INVITED_MEMBERS ="invitedMembers";
	public final static String PARTY_JOINED_MEMBERS ="joinedMembers";
	public final static String PARTY_NOTICE ="notice";
	public final static String PARTY_UPVOTES ="upvotes";
	public final static String PARTY_C_TIME ="cTime";
	public final static String PARTY_U_TIME ="uTime";
	public final static String PARTY_IS_VOTING_END ="isVotingEnd";
	public final static String PARTY_IS_SHARED ="isShared";
	
	public final static String ACCOUNT_COUNTER_ACCOUNT_ACCESS_TOKEN = "accessToken";
	public final static String ACCOUNT_COUNTER_IS_ACCEPT = "isAccept";
	
	public final static String ACTIVITY_COUNTER_ACTIVITY_ID = "activityID";
	public final static String ACTIVITY_COUNTER_VOTES = "votes";
	public final static String ACTIVITY_COUNTER_ACTIVITY_TITLE = "activityTitle";
	
	public final static String LATLON_LAT = "latitude";
	public final static String LATLON_LON = "longitude";
	
	public final static String ACCOUNT_COUNTER = "accessToken";
	public final static String ACCOUNT_IS_ACCEPT = "isAccept";

}
