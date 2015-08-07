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
import com.csu.party.model.Account;
import com.google.gson.Gson;

public class LoginByQQServlet extends HttpServlet {

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
		String jsonString = request.getParameter("jsonStr");
		Account account = gson.fromJson(jsonString, Account.class);
		account.lastLoginTime = sdf.format(new java.util.Date());
		account.uTime = sdf.format(new Date());
		
		Account accountFromDB = AccountDao.getAccount(
				Constants.ACCOUNT_ACCESS_TOKEN, account.accessToken);

		if (null!=accountFromDB) {
			account.name = accountFromDB.name;
			account.tel = accountFromDB.tel;
			account.cTime = accountFromDB.cTime;
			account.currentPos = accountFromDB.currentPos;
			account.birthday = accountFromDB.birthday;
			account.email = accountFromDB.email;
			account.lastLoginTime = accountFromDB.lastLoginTime;
			account.signature = accountFromDB.signature;
			AccountDao.updateQQLoginAccountInfo(account);;
		} else {
			account.cTime = sdf.format(new java.util.Date());
			AccountDao.add(account);
		}
		Account accountResp=AccountDao.getAccount(Constants.ACCOUNT_ACCESS_TOKEN, account.accessToken);
		out.write(gson.toJson(accountResp));
	}

}
