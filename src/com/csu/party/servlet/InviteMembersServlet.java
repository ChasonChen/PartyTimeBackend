package com.csu.party.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csu.party.Constants;
import com.csu.party.dao.AccountDao;
import com.csu.party.dao.PMessageDao;
import com.csu.party.dao.PartyDao;
import com.csu.party.model.Account;
import com.csu.party.model.AccountCounter;
import com.csu.party.model.MState;
import com.csu.party.model.PMessage;
import com.csu.party.model.Party;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class InviteMembersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.SIMPLE_DATE_FORMAT);
		
		String strAccessTokens = request.getParameter("accessTokens");
		String partyID = request.getParameter("partyID");
		TypeToken<List<String>> type = new TypeToken<List<String>>(){};
		List<String> accessTokens = gson.fromJson(strAccessTokens, type.getType());
		
		Party party = PartyDao.getPartyByID(partyID);
		for (String str : accessTokens) {
			boolean isExist = false;
			for(AccountCounter temp:party.invitedMembers){
				if (str.equals(temp.accessToken)) {
					isExist = true;
				}
			}
			if (!isExist) {
				party.invitedMembers.add(new AccountCounter(str, false));
			}
		}
		PartyDao.updatePartyByID(party);;
		
		List<MState> mStates = new ArrayList<MState>();
		for (String temp : accessTokens) {
			mStates.add(new MState(temp,false));
		}
		PMessage pMessage = new PMessage();
		pMessage.partyID = partyID;
		pMessage.mContent = "你接收到了《"+party.title+"》聚会的邀请！";
		pMessage.mStates = mStates;
		pMessage.cTime = sdf.format(new Date());
		PMessageDao.addMessage(pMessage);/**/
	}

}
