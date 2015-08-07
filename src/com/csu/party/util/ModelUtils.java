package com.csu.party.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.enterprise.inject.New;

import org.bson.types.ObjectId;

import com.csu.party.Constants;
import com.csu.party.model.Account;
import com.csu.party.model.AccountCounter;
import com.csu.party.model.ActivityCounter;
import com.csu.party.model.Avatar;
import com.csu.party.model.LatLonPoint;
import com.csu.party.model.MState;
import com.csu.party.model.PMessage;
import com.csu.party.model.Party;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class ModelUtils {
	
	public static BasicDBObject pMessage2DBObject(PMessage m) {
		BasicDBObject dbObject = new BasicDBObject();
		dbObject.put(Constants.PMESSAGE_ID, null==m.id? null:new ObjectId(m.id));
		dbObject.put(Constants.PMESSAGE_PARTY_ID, m.partyID);
		dbObject.put(Constants.PMESSAGE_CONTENT, m.mContent);
		dbObject.put(Constants.PMESSAGE_PARTY, party2DBObject(m.party));
		dbObject.put(Constants.PMESSAGE_MSTATE, mStates2DBObjectList(m.mStates));
		dbObject.put(Constants.PMESSAGE_C_TIME, m.cTime);
		return dbObject;
	}
	
	public static PMessage dbObject2PMessage(BasicDBObject dbObject){
		PMessage pMessage = new PMessage();
		pMessage.id= dbObject.getString(Constants.PMESSAGE_ID);
		pMessage.partyID = dbObject.getString(Constants.PMESSAGE_PARTY_ID);
		pMessage.party = dbObject2Party(
				(BasicDBObject)dbObject.get(Constants.PMESSAGE_PARTY));
		pMessage.mContent = dbObject.getString(Constants.PMESSAGE_CONTENT);
		pMessage.mStates = dbObjectList2MStates(
				(BasicDBList)dbObject.get(Constants.PMESSAGE_MSTATE));
		pMessage.cTime = dbObject.getString(Constants.PMESSAGE_C_TIME);
		return pMessage;
	}
	
	public static BasicDBList mStates2DBObjectList(List<MState> mStates){
		BasicDBList dbList = new BasicDBList();
		for (MState state : mStates) {
			dbList.add(mState2DBObject(state));
		}
		return dbList;
	}
	
	public static List<MState> dbObjectList2MStates(BasicDBList dbList){
		List<MState> mStates = new ArrayList<MState>();
		for ( int i=0; i<dbList.size();i++) {
			mStates.add(dbObject2MState((BasicDBObject)dbList.get(i)));
		}
		return mStates;
	}
	
	public static BasicDBObject mState2DBObject(MState mState){
		BasicDBObject dbObject = new BasicDBObject();
		dbObject.put(Constants.MSTATE_ACCOUNT_TOKEN, mState.accountToken);
		dbObject.put(Constants.MSTATE_IS_READ, mState.isRead);
		return dbObject;
	}
	
	public static MState dbObject2MState(BasicDBObject dbObject){
		MState mState = new MState();
		mState.accountToken= dbObject.getString(Constants.MSTATE_ACCOUNT_TOKEN);
		mState.isRead = dbObject.getBoolean(Constants.MSTATE_IS_READ);
		return mState;
	}

	public static Party dbObject2Party(BasicDBObject dbObject){
		Party party = new Party();
		party.id = dbObject.getString(Constants.PARTY_ID);
		party.title = dbObject.getString(Constants.PARTY_TITLE);
		party.accessToken = dbObject.getString(Constants.PARTY_ACCESS_TOKEN);
		party.gatheringPlace = dbObject.getString(Constants.PARTY_GATHERING_PLACE);
		party.startTime = dbObject.getString(Constants.PARTY_START_TIME);
		party.activities = dbList2ActivityCounters(
				(BasicDBList)dbObject.get(Constants.PARTY_ACTIVITIES));
		party.invitedMembers = dbList2AccountCounterList(
				(BasicDBList)dbObject.get(Constants.PARTY_INVITED_MEMBERS));
		party.joinedMembers = dbList2AccountCounterList(
				(BasicDBList)dbObject.get(Constants.PARTY_JOINED_MEMBERS)); 
		party.notice = dbObject.getString(Constants.PARTY_NOTICE);
		party.upvotes = dbObject.getLong(Constants.PARTY_UPVOTES);
		party.cTime = dbObject.getString(Constants.PARTY_C_TIME);
		party.uTime = dbObject.getString(Constants.PARTY_U_TIME);
		party.isVotingEnd = dbObject.getBoolean(Constants.PARTY_IS_VOTING_END);
		party.isPartyShared = dbObject.getBoolean(Constants.PARTY_IS_SHARED);
		return party;
	}
	
	
	private static List<ActivityCounter> dbList2ActivityCounters(BasicDBList dbList){
		List<ActivityCounter> list = new ArrayList<ActivityCounter>();
		for (int i = 0; i < dbList.size(); i++) {
			list.add(dbObject2ActivityCounter((BasicDBObject)dbList.get(i)));
		}
		return list;
	}
	
	private static List<AccountCounter> dbList2AccountCounterList(BasicDBList dbList){
		List<AccountCounter> list = new ArrayList<AccountCounter>();
		for (int i=0; i<dbList.size();i++) {
			list.add(dbObject2AccountCounter((BasicDBObject)dbList.get(i)));
		}
		return list;
	}
	
	public static AccountCounter dbObject2AccountCounter(BasicDBObject dbObject){
		return new AccountCounter(
				dbObject.getString(
						Constants.ACCOUNT_COUNTER_ACCOUNT_ACCESS_TOKEN),
				dbObject.getBoolean(Constants.ACCOUNT_COUNTER_IS_ACCEPT));
	}
	
	public static ActivityCounter dbObject2ActivityCounter(BasicDBObject dbObject){
		return new ActivityCounter(
				dbObject.getString(Constants.ACTIVITY_COUNTER_ACTIVITY_ID),
				dbObject.getInt(Constants.ACTIVITY_COUNTER_VOTES),
				dbObject.getString(Constants.ACTIVITY_COUNTER_ACTIVITY_TITLE));
	}

	public static DBObject party2DBObject(Party party) {
		BasicDBObject dbInsert = new BasicDBObject();
		dbInsert.put(Constants.PARTY_ID, null==party.id? null:new ObjectId(party.id));
		dbInsert.put(Constants.PARTY_TITLE, party.title);
		dbInsert.put(Constants.ACCOUNT_ACCESS_TOKEN, party.accessToken);
		dbInsert.put(Constants.PARTY_GATHERING_PLACE, party.gatheringPlace);
		dbInsert.put(Constants.PARTY_START_TIME, party.startTime);
		dbInsert.put(Constants.PARTY_ACTIVITIES,
				listActivity2DBObject(party.activities));
		dbInsert.put(Constants.PARTY_INVITED_MEMBERS,
				listAccount2DBObject(party.invitedMembers));
		dbInsert.put(Constants.PARTY_JOINED_MEMBERS,
				listAccount2DBObject(party.joinedMembers));
		dbInsert.put(Constants.PARTY_NOTICE, party.notice);
		dbInsert.put(Constants.PARTY_UPVOTES, party.upvotes);
		dbInsert.put(Constants.PARTY_C_TIME, party.cTime);
		dbInsert.put(Constants.PARTY_U_TIME, party.uTime);
		dbInsert.put(Constants.PARTY_IS_VOTING_END, party.isVotingEnd);
		dbInsert.put(Constants.PARTY_IS_SHARED, party.isPartyShared);
		return dbInsert;
	}
	
	public static BasicDBList listActivity2DBObject(List<ActivityCounter> counters){
		BasicDBList dbList = new BasicDBList();
		for (ActivityCounter counter : counters) {
			dbList.add(activityCounter2DBObject(counter));
		}
		return dbList;
	}

	public static BasicDBList listAccount2DBObject(List<AccountCounter> counters) {
		BasicDBList dbList = new BasicDBList();
		for (AccountCounter counter : counters) {
			dbList.add(accountCounter2DBObject(counter));
		}
		return dbList;
	}

	public static DBObject accountCounter2DBObject(AccountCounter counter) {
		DBObject dbObject = new BasicDBObject();
		dbObject.put(Constants.ACCOUNT_COUNTER_ACCOUNT_ACCESS_TOKEN, counter.accessToken);
		dbObject.put(Constants.ACCOUNT_COUNTER_IS_ACCEPT, counter.isAccept);
		return dbObject;
	}

	public static DBObject activityCounter2DBObject(ActivityCounter counter) {
		DBObject dbObject = new BasicDBObject();
		dbObject.put(Constants.ACTIVITY_COUNTER_ACTIVITY_ID, counter.activityID);
		dbObject.put(Constants.ACTIVITY_COUNTER_VOTES, counter.votes);
		dbObject.put(Constants.ACTIVITY_COUNTER_ACTIVITY_TITLE, counter.activityTitle);
		return dbObject;
	}

	public static DBObject map2DBObject(Map<String, Object> activities) {
		BasicDBObject dbObject = new BasicDBObject();
		Set<Entry<String, Object>> eSet = activities.entrySet();
		Iterator<Entry<String, Object>> iterator = eSet.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Object> entry = iterator.next();
			dbObject.put(entry.getKey(), entry.getValue());
		}
		return dbObject;
	}

	public static DBObject account2DBObject(Account account) {
		BasicDBObject dbObject = new BasicDBObject();
		dbObject.put(Constants.ACCOUNT_ACCESS_TOKEN, account.accessToken);
		dbObject.put(Constants.ACCOUNT_NICKNAME, account.nickname);
		dbObject.put(Constants.ACCOUNT_NAME, account.name);
		dbObject.put(Constants.ACCOUNT_TEL, account.tel);
		dbObject.put(Constants.ACCOUNT_PASSWORD, account.password);
		dbObject.put(Constants.ACCOUNT_AVATAR, avatar2DBObject(account.avatar));
		dbObject.put(Constants.ACCOUNT_CITY, account.city);
		dbObject.put(Constants.ACCOUNT_PROVINCE, account.province);
		dbObject.put(Constants.ACCOUNT_GENDER, account.gender);
		dbObject.put(Constants.ACCOUNT_EMAIL, account.email);
		dbObject.put(Constants.ACCOUNT_SIGNATURE, account.signature);
		dbObject.put(Constants.ACCOUNT_CURRENT_POS, latLonPoint2DBObject(account.currentPos));
		dbObject.put(Constants.ACCOUNT_FRIENDS, friends2DBObject(account.friends));
		dbObject.put(Constants.ACCOUNT_BIRTHDAY, account.birthday);
		dbObject.put(Constants.ACCOUNT_C_TIME, account.cTime);
		dbObject.put(Constants.ACCOUNT_U_TIME, account.uTime);
		dbObject.put(Constants.ACCOUNT_LAST_LOGIN_TIME, account.lastLoginTime);
		dbObject.put(Constants.ACCOUNT_IS_CREATOR, account.isCreator);
		dbObject.put(Constants.ACCOUNT_IS_MEMBER, account.isMember);
		return dbObject;
	}
	
	public static BasicDBList friends2DBObject(List<String> friends) {
		BasicDBList dbList = new BasicDBList();
		for (String string : friends) {
			dbList.add(string);
		}
		return dbList;
	}
	
	public static List<String> dbList2friends(BasicDBList dbList){
		if (dbList!=null) {
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < dbList.size(); i++) {
				list.add(dbList.get(i).toString());
			}
			return list;
		}
		return null;
	}

	public static Account dbObject2Account(BasicDBObject dbObject) {
		Account account = new Account();
		account._id = dbObject.getString(Constants.ACCOUNT_ID);
		account.accessToken = dbObject
				.getString(Constants.ACCOUNT_ACCESS_TOKEN);
		account.nickname = dbObject.getString(Constants.ACCOUNT_NICKNAME);
		account.name = dbObject.getString(Constants.ACCOUNT_NAME);
		account.tel = dbObject.getString(Constants.ACCOUNT_TEL);
		account.password = dbObject.getString(Constants.ACCOUNT_PASSWORD);
		account.avatar = dbObject2Avatar((BasicDBObject) dbObject
				.get(Constants.ACCOUNT_AVATAR));
		account.city = dbObject.getString(Constants.ACCOUNT_CITY);
		account.province = dbObject.getString(Constants.ACCOUNT_PROVINCE);
		account.gender = dbObject.getString(Constants.ACCOUNT_GENDER);
		account.email = dbObject.getString(Constants.ACCOUNT_EMAIL);
		account.signature = dbObject.getString(Constants.ACCOUNT_SIGNATURE);
		account.currentPos = dbObject2LatLonPoint((BasicDBObject)
				dbObject.get(Constants.ACCOUNT_CURRENT_POS));
		account.friends = dbList2friends((BasicDBList)
				dbObject.get(Constants.ACCOUNT_FRIENDS));
		account.birthday = dbObject.getString(Constants.ACCOUNT_BIRTHDAY);
		account.cTime = dbObject.getString(Constants.ACCOUNT_C_TIME);
		account.uTime = dbObject.getString(Constants.ACCOUNT_U_TIME);
		account.lastLoginTime = dbObject
				.getString(Constants.ACCOUNT_LAST_LOGIN_TIME);
		account.isCreator = dbObject.getBoolean(Constants.ACCOUNT_IS_CREATOR);
		account.isMember = dbObject.getBoolean(Constants.ACCOUNT_IS_MEMBER);
		return account;
	}
	
	public static DBObject latLonPoint2DBObject(LatLonPoint latLonPoint) {
		DBObject dbObject = new BasicDBObject();
		if (latLonPoint!=null) {
			dbObject.put(Constants.LATLON_LAT, latLonPoint.Latitude);
			dbObject.put(Constants.LATLON_LON, latLonPoint.longitude);
		}
		return dbObject;
	}
	
	public static LatLonPoint dbObject2LatLonPoint(BasicDBObject dbObject) {
		if (null!= dbObject&&!dbObject.isEmpty()) {
			return new LatLonPoint(dbObject.getDouble(Constants.LATLON_LAT),
					dbObject.getDouble(Constants.LATLON_LON));
		}
		return null;
	}

	public static DBObject avatar2DBObject(Avatar avatar) {
		DBObject dbObject = new BasicDBObject();
		dbObject.put(Constants.AVATAR_TINY, avatar.tiny);
		dbObject.put(Constants.AVATAR_MID, avatar.mid);
		dbObject.put(Constants.AVATAR_LARGE, avatar.large);
		return dbObject;
	}

	public static Avatar dbObject2Avatar(BasicDBObject dbObject) {
		Avatar avatar = new Avatar();
		avatar.tiny = StringUtils.deleteBlank(
				dbObject.getString(Constants.AVATAR_TINY));
		avatar.mid = StringUtils.deleteBlank(
				dbObject.getString(Constants.AVATAR_MID));
		avatar.large = StringUtils.deleteBlank(
				dbObject.getString(Constants.AVATAR_LARGE));
		return avatar;
	}
}
