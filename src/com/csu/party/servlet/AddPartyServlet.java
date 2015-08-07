package com.csu.party.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csu.party.Constants;
import com.csu.party.dao.AccountDao;
import com.csu.party.dao.PartyDao;
import com.csu.party.model.Account;
import com.csu.party.model.AccountCounter;
import com.csu.party.model.ActivityCounter;
import com.csu.party.model.Party;

public class AddPartyServlet extends HttpServlet {

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

		SimpleDateFormat sdfDateFormat = new SimpleDateFormat(
				Constants.SIMPLE_DATE_FORMAT);

		String activityId = request.getParameter("added_activity_id");
		String activityTitle = request.getParameter("activity_title");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String accessToken = request.getParameter("access_token");
		String title = request.getParameter("title");
		String notice = request.getParameter("notice");
		String startTime = request.getParameter("start_time");
		String gatheringPlace = request.getParameter("gathering_place");

		Party party = new Party();
		
		if (null!=activityId) {
			party.activities.add(new ActivityCounter(activityId, 1,activityTitle));
		}
		party.accessToken = accessToken;
		party.title = title;
		party.notice = notice;
		party.startTime = startTime;
		party.gatheringPlace = gatheringPlace;
		party.cTime = sdfDateFormat.format(new Date());
		party.uTime = sdfDateFormat.format(new Date());
		party.invitedMembers.add(new AccountCounter(accessToken, true));
		Party partyResult=PartyDao.addParty(party);
		Account account = AccountDao.getAccount(Constants.ACCOUNT_ACCESS_TOKEN, accessToken);
		account.tel = tel;
		account.name = name;
		
		AccountDao.update(account);
		
		out.print(partyResult.id);
	}

}
