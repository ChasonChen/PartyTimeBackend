package com.csu.party.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csu.party.Constants;
import com.csu.party.dao.AccountDao;
import com.csu.party.model.Account;
import com.csu.party.model.LatLonPoint;
import com.google.gson.Gson;

public class UpdateAccountLocation extends HttpServlet {

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
		
		double latitude = Double.valueOf(request.getParameter("latitude"));
		double longitude = Double.valueOf(request.getParameter("longitude"));
		String accessToken =request.getParameter("accessToken"); 
		LatLonPoint accountLocation = new LatLonPoint(latitude, longitude);
		Account account = AccountDao.getAccount
				(Constants.ACCOUNT_ACCESS_TOKEN, accessToken);
		if(null==account)
			return;
		account.currentPos = accountLocation;
		AccountDao.update(account);
	}

}
