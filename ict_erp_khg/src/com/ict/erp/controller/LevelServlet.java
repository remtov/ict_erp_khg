
package com.ict.erp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = ICTUtils.getCmd(uri);
		uri = "/views" + uri;
		try {
			if (cmd == null || cmd.equals("")) {
				uri = "/views/notFound";
			} else if (cmd.equals("levelList")) {
				request.setAttribute("liList", ls.getLiList(null));
			} else if (cmd.equals("saveLevelList")) {
				List<LevelInfo> iList = new ArrayList<LevelInfo>();

				String[] liNames = request.getParameterValues("liName");
				String[] liLevels = request.getParameterValues("liLevel");
				String[] liDesces = request.getParameterValues("liDesces");
				for (int i = 0; i < liNames.length; i++) {
					int level = Integer.parseInt(liLevels[i]);
					LevelInfo li = new LevelInfo(0, level, liNames[i], liDesces[i]);
					iList.add(li);
					}
				Map<String, List<LevelInfo>> map = new HashMap<String, List<LevelInfo>>();
				map.put("iList", iList);
				map.put("uList", new ArrayList<LevelInfo>());
				Map<String,Object>rMap = ls.insertNupdateLiList(map);
				request.setAttribute("rMap", rMap);
				} else {
				uri = "/views/notFound";
			}
		} catch (SQLException e) {
			System.out.println(e);
			request.setAttribute("error", e.getMessage());
			uri = "/views/error";
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

	// erd
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}