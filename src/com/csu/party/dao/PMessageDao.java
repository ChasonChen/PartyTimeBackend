package com.csu.party.dao;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.New;

import com.csu.party.Constants;
import com.csu.party.model.PMessage;
import com.csu.party.util.ModelUtils;
import com.csu.party.util.MongoHelper;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class PMessageDao {
	
	public static void addMessage(PMessage message) {
		MongoHelper.insert(Constants.TABLE_PMESSAGE, 
				ModelUtils.pMessage2DBObject(message));
	}

	public static List<PMessage> getPMessagesByAccessToken(String accessToken,
			Integer offset,Integer size){
		List<PMessage> pMessages = new ArrayList<PMessage>();
		BasicDBObject query2 = new BasicDBObject();
		query2.put(Constants.MSTATE_ACCOUNT_TOKEN, accessToken);
		query2.put(Constants.MSTATE_IS_READ, false);
		BasicDBObject query = new BasicDBObject(Constants.PMESSAGE_MSTATE,
				query2);
		List<DBObject> dbObjects=MongoHelper.find(Constants.TABLE_PMESSAGE, 
				query, offset, size,Constants.PMESSAGE_C_TIME,MongoHelper.DESC);
		for (DBObject db : dbObjects) {
			pMessages.add(ModelUtils.dbObject2PMessage((BasicDBObject) db));
		}
		return pMessages;
	}
}
