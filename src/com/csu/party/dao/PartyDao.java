package com.csu.party.dao;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.New;

import org.bson.types.ObjectId;

import com.csu.party.Constants;
import com.csu.party.model.Party;
import com.csu.party.util.ModelUtils;
import com.csu.party.util.MongoHelper;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class PartyDao {
	
	public static List<Party> getPartiesByMemberAccessToken(
			String accessToken,Integer offset,Integer size){
		List<Party> parties = new ArrayList<Party>();
		BasicDBObject query = new BasicDBObject();
		BasicDBObject queryInvitedMember = new BasicDBObject();
		queryInvitedMember.put(Constants.ACCOUNT_COUNTER_ACCOUNT_ACCESS_TOKEN, 
				accessToken);
		queryInvitedMember.put(Constants.ACCOUNT_COUNTER_IS_ACCEPT, false);
		query.put(Constants.PARTY_INVITED_MEMBERS, queryInvitedMember);
		List<DBObject> dbObjects=MongoHelper.find(Constants.TABLE_PARTY, 
				query, offset, size,Constants.PARTY_U_TIME,MongoHelper.DESC);
		for (DBObject dbObject : dbObjects) {
			parties.add(ModelUtils.dbObject2Party((BasicDBObject)dbObject));
		}
		return parties;
	}
	
	public static void updatePartyByID(Party party){
		BasicDBObject query = new BasicDBObject();
		query.put(Constants.PARTY_ID, new ObjectId(party.id));
		BasicDBObject update = (BasicDBObject) ModelUtils.party2DBObject(party);
		MongoHelper.update(Constants.TABLE_PARTY, query, update);
	}

	public static Party addParty(Party party) {
		MongoHelper.insert(Constants.TABLE_PARTY,
				ModelUtils.party2DBObject(party));
		return getInsertedParty(party);
	}

	private static Party getInsertedParty(Party party) {
		BasicDBObject query = new BasicDBObject();
		query.put(Constants.PARTY_C_TIME, party.cTime);
		query.put(Constants.PARTY_ACCESS_TOKEN, party.accessToken);
		BasicDBObject result = (BasicDBObject) MongoHelper.findOne(
				Constants.TABLE_PARTY, query);
		return ModelUtils.dbObject2Party(result);
	}

	public static Party getPartyByID(String id) {
		BasicDBObject query = new BasicDBObject();
		query.put(Constants.PARTY_ID, new ObjectId(id));
		BasicDBObject result = (BasicDBObject) MongoHelper.findOne(
				Constants.TABLE_PARTY, query);
		return ModelUtils.dbObject2Party(result);
	}

	public static void removeParty(String field, String value) {
		BasicDBObject query = new BasicDBObject();
		query.put(field, value);
		MongoHelper.remove(Constants.TABLE_PARTY, query);
	}

	public static List<Party> getPartiesByAccessToken(String accessToken,
			Integer offset, Integer size) {
		List<Party> parties = new ArrayList<Party>();
		BasicDBObject query = new BasicDBObject();
		query.put(Constants.PARTY_ACCESS_TOKEN, accessToken);
		List<DBObject> dbObjects=MongoHelper.find(Constants.TABLE_PARTY, 
				query, offset, size,Constants.PARTY_U_TIME,MongoHelper.DESC);
		for (DBObject dbObject : dbObjects) {
			parties.add(ModelUtils.dbObject2Party((BasicDBObject) dbObject));
		}
		return parties;
	}
}
