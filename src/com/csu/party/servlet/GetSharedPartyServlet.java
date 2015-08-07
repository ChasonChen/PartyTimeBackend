package com.csu.party.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csu.party.Constants;
import com.csu.party.dao.AccountDao;
import com.csu.party.dao.PartyDao;
import com.csu.party.model.Account;
import com.csu.party.model.AccountCounter;
import com.csu.party.model.Party;

public class GetSharedPartyServlet extends HttpServlet {

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
		
		String partyID = request.getParameter("partyID");
		Party party = PartyDao.getPartyByID(partyID);
		request.getSession().setAttribute("party", party);
		
		List<Account> accounts = new ArrayList<Account>(); 
		for(AccountCounter temp:party.invitedMembers){
			accounts.add(AccountDao.getAccount(Constants.ACCOUNT_ACCESS_TOKEN, temp.accessToken));
		}
		request.getSession().setAttribute("invitedMembers", accounts);
		Account creator=AccountDao.getAccount(Constants.ACCOUNT_ACCESS_TOKEN, party.accessToken);
		request.getSession().setAttribute("creator", creator);
		
		response.sendRedirect("index.jsp");
	}

}
