package com.csu.party.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.New;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csu.party.Constants;
import com.csu.party.dao.AccountDao;
import com.csu.party.model.Account;
import com.csu.party.model.AccountCounter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GetAccountsByAccessTokenServlet extends HttpServlet {

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
		
		String strInviteMembers = request.getParameter("inviteMembers");
		TypeToken<List<AccountCounter>> type = new TypeToken<List<AccountCounter>>(){};
		List<AccountCounter> inviteMembers =
				new Gson().fromJson(strInviteMembers, type.getType());
		List<Account> accounts = new ArrayList<Account>();
		for (AccountCounter ac : inviteMembers) {
			accounts.add(AccountDao.getAccount(Constants.ACCOUNT_ACCESS_TOKEN, 
					ac.accessToken));
		}
		out.print(new Gson().toJson(accounts));
	}

}
