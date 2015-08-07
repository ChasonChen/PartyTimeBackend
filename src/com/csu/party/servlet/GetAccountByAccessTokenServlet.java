package com.csu.party.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csu.party.Constants;
import com.csu.party.dao.AccountDao;
import com.csu.party.model.Account;
import com.google.gson.Gson;

public class GetAccountByAccessTokenServlet extends HttpServlet {

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
		
		String accessToken = request.getParameter("accessToken");
		Account account=AccountDao.getAccount(Constants.ACCOUNT_ACCESS_TOKEN, accessToken);
		out.print(gson.toJson(account));
	}

}
