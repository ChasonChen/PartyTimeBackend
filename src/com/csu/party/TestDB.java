package com.csu.party;

import java.util.List;

import org.junit.Test;

import com.csu.party.dao.PMessageDao;
import com.csu.party.dao.PartyDao;
import com.csu.party.model.Account;
import com.csu.party.model.PMessage;
import com.csu.party.model.Party;

public class TestDB {

	@Test
	public void test() {
		/*Account account = getAccount();
		AccountDao.add(account);*/

//		String accessToken = "CAAE17404A3CFA39C0041B6A49A1CA9E";
//		String partyID = "5540c5246ce00bab7ff19670";
//		List<Party> party = PartyDao.getPartiesByAccessToken(accessToken, null, null);
//		List<PMessage> pMessages=PMessageDao.getPMessagesByAccessToken(accessToken, null, null);
//		List<Party> parties=PartyDao.getPartiesByMemberAccessToken(accessToken, null, null);
//		System.out.println(parties.size());
//		AccountDao.removeAccount(Constants.ACCOUNT_TEL,"13397606862");
//		PartyDao.removeParty(Constants.PARTY_ACCESS_TOKEN, accessToken);
//		AccountDao.removeAccount(Constants.ACCOUNT_ACCESS_TOKEN, accessToken);
		
	}
	
	public Account getAccount(){
		Account account = new Account();
		account.accessToken = "A30F6F091D0FD22919319843E413E945";
		account.avatar.tiny = "http://q.qlogo.cn/qqapp/1104475777/8F4D383F411644C1977325939A9D8F6E/40";
		account.avatar.mid = "http://q.qlogo.cn/qqapp/1104475777/8F4D383F411644C1977325939A9D8F6E/100";
		account.nickname = "Blue Snail";
		account.city = "长沙";
		account.province = "湖南";
		account.gender = "男";
		return account;
	}

}
