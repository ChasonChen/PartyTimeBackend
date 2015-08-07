package com.csu.party.util;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.csu.party.Constants;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class MongoHelper {
	private static DB db;
	public final static int DESC = -1;
	public final static int ASC = 1;

	static {
		try {
			if (null == db) {
				MongoCredential credential = MongoCredential
						.createCredential(Constants.USERNAME,
								Constants.DB_NAME,
								Constants.PASSWORD.toCharArray());
				ServerAddress sAddress = new ServerAddress(Constants.HOST,
						Constants.PORT);

//				MongoClient mongoClient = new MongoClient(Constants.HOST,
//						Constants.PORT);
				MongoClient mongoClient = new MongoClient(sAddress,Arrays.asList(credential));
	
				db = mongoClient.getDB(Constants.DB_NAME);
//				db.authenticateCommand(Constants.USERNAME, Constants.PASSWORD.toCharArray());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public static void insert(String collectionName, DBObject dbObject) {
		DBCollection dbCollection = db.getCollection(collectionName);
		dbCollection.insert(dbObject);
	}

	public static void update(String collectionName, DBObject query,
			DBObject update) {
		DBCollection dbCollection = db.getCollection(collectionName);
		dbCollection.update(query, update);
	}

	public static void remove(String collectionName, DBObject query) {
		DBCollection dbCollection = db.getCollection(collectionName);
		dbCollection.remove(query);
	}

	public static DBObject findOne(String collectionName, DBObject query) {
		DBCollection dbCollection = db.getCollection(collectionName);
		return dbCollection.findOne(query);
	}

	public static List<DBObject> find(String collectionName, DBObject query,
			Integer offset, Integer size,String sortBy,Integer ascOrDesc) {
		DBCollection dbCollection = db.getCollection(collectionName);
		List<DBObject> dbObjects = new ArrayList<DBObject>();
		DBCursor dbCursor;

		if (null != query) {
			dbCursor = dbCollection.find(query);
		} else {
			dbCursor = dbCollection.find();
		}

		if (null != offset && null != size) {
			dbCursor.skip(offset);
			dbCursor.batchSize(size);
		}

		if (null!=sortBy) {
			if (null!=ascOrDesc) {
				dbCursor.sort(new BasicDBObject(sortBy, ascOrDesc));
			}else {
				dbCursor.sort(new BasicDBObject(sortBy,ASC));
			}
		}
		
		while (dbCursor.hasNext()) {
			dbObjects.add(dbCursor.next());
		}
		return dbObjects;
	}

}
