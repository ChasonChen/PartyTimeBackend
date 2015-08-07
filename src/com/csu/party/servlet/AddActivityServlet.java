package com.csu.party.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csu.party.dao.PartyDao;
import com.csu.party.model.ActivityCounter;
import com.csu.party.model.Party;

public class AddActivityServlet extends HttpServlet {

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
		
		String partyID = request.getParameter("partyID");
		String activityID = request.getParameter("activityID");
		String activityTitle = request.getParameter("activityTitle");
		
		boolean isActivityExist= false;
		Party party = PartyDao.getPartyByID(partyID);
		for (ActivityCounter temp : party.activities) {
			if (activityID.equals(temp.activityID)) {
				isActivityExist = true;
			}
		}
		if (isActivityExist) {
			out.print("isExist");
		}else {
			party.activities.add(new ActivityCounter(activityID, 1, activityTitle));
			PartyDao.updatePartyByID(party);
			out.print("isAdded");
		}
	}

}
