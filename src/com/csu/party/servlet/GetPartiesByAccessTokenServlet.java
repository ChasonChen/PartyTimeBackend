package com.csu.party.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csu.party.dao.PartyDao;
import com.csu.party.model.Party;
import com.google.gson.Gson;

public class GetPartiesByAccessTokenServlet extends HttpServlet {

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
		String strOffset = request.getParameter("offset");
		String strSize = request.getParameter("size");
		
		Integer offset = strOffset==null? null : Integer.valueOf(strOffset);
		Integer size = strSize == null ? null : Integer.valueOf(strSize);
		
		List<Party> parties=PartyDao.getPartiesByAccessToken(accessToken, offset, size);
		out.print(gson.toJson(parties));
	}

}
