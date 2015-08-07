package com.csu.party.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csu.party.dao.AccountDao;
import com.csu.party.model.Account;
import com.google.gson.Gson;

public class GetAllAccountsServlet extends HttpServlet {

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
		
		String accessToken = request.getParameter("accessToken");
		String strOffset = request.getParameter("offset");
		String strSize = request.getParameter("size");
		
		Integer offset = null == strOffset ? null : Integer.valueOf(strOffset);
		Integer size = null==strSize ? null : Integer.valueOf(strSize);
		List<Account> accounts = AccountDao.getAllAccount(accessToken,offset, size);
		
		out.print(new Gson().toJson(accounts));
	}

}
