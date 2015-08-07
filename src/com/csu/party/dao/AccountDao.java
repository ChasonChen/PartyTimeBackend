package com.csu.party.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.inject.New;

import com.csu.party.Constants;
import com.csu.party.model.Account;
import com.csu.party.util.ModelUtils;
import com.csu.party.util.MongoHelper;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class AccountDao {

	public static List<Account> getAllAccount(String accessToken,Integer offset, Integer size) {
		List<Account> accounts = new ArrayList<Account>();
		DBObject query = new BasicDBObject();
		BasicDBList dbList = new BasicDBList();
		dbList.add(accessToken);
		query.put(Constants.ACCOUNT_ACCESS_TOKEN, new BasicDBObject("$nin",dbList));
		List<DBObject> dbObjects=MongoHelper.find(Constants.TABLE_ACCOUNT, 
				query, offset, size,Constants.ACCOUNT_U_TIME,MongoHelper.DESC);
		for (DBObject object : dbObjects) {
			accounts.add(ModelUtils.dbObject2Account((BasicDBObject) object));
		}
		
		return accounts;
	}

	public static void add(Account account) {
		MongoHelper.insert(Constants.TABLE_ACCOUNT,
				ModelUtils.account2DBObject(account));
	}

	public static void updateAccount(BasicDBObject query, BasicDBObject update) {
		MongoHelper.update(Constants.TABLE_ACCOUNT, query, update);
	}

	public static Account getAccount(String field, String value) {
		BasicDBObject query = new BasicDBObject();
		query.put(field, value);
		BasicDBObject dbObject = (BasicDBObject) MongoHelper.findOne(
				Constants.TABLE_ACCOUNT, query);
		return dbObject == null ? null : ModelUtils.dbObject2Account(dbObject);
	}

	public static void removeAccount(String field, String value) {
		BasicDBObject query = new BasicDBObject();
		query.put(field, value);
		MongoHelper.remove(Constants.TABLE_ACCOUNT, query);
	}

	public static void updateQQLoginAccountInfo(Account account) {
		BasicDBObject query = new BasicDBObject();
		query.put(Constants.ACCOUNT_ACCESS_TOKEN, account.accessToken);
		BasicDBObject update = (BasicDBObject) ModelUtils
				.account2DBObject(account);
		MongoHelper.update(Constants.TABLE_ACCOUNT, query, update);
	}

	public static void update(Account account) {
		BasicDBObject query = new BasicDBObject();
		query.put(Constants.ACCOUNT_ACCESS_TOKEN, account.accessToken);
		BasicDBObject update = (BasicDBObject) ModelUtils
				.account2DBObject(account);
		MongoHelper.update(Constants.TABLE_ACCOUNT, query, update);
	}

}
