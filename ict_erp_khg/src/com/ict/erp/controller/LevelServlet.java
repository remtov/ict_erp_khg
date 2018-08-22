package com.ict.erp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.common.ICTUtils;
import com.ict.erp.service.LevelService;
import com.ict.erp.service.impl.LevelServiceImpl;
import com.ict.erp.vo.LevelInfo;


public class LevelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LevelService ls = new LevelServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = ICTUtils.getCmd(uri);
		uri = "/views" + uri;
		try {
			if(cmd==null|| cmd.equals("")) {
				uri = "/views/notFound";
			}else if(cmd.equals("levelList")) {
				request.setAttribute("liList", ls.getLiList(null));
			}else {
				uri = "/views/notFound";
			}
		}catch(SQLException e) {
			System.out.println(e);
			request.setAttribute("error", e.getMessage());
			uri = "/views/error";
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}
//erd
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
