package com.ict.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ict.erp.service.MusicService;
import com.ict.erp.service.impl.MusicServiceImpl;
import com.ict.erp.vo.MusicChart;


@WebServlet(
		urlPatterns = "/json/*"
		)

public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gs = new Gson();// 스트링을 객체로 바꿔주는 역할
	
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<String,String> pMap = gs.fromJson(request.getParameter("param"),Map.class);
		System.out.println(pMap);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		MusicService ms = new MusicServiceImpl();
		
		List<MusicChart> musicList;
		try {
			musicList = ms.selectMusicList(null);
			String resStr =gs.toJson(musicList);
			pw.println(resStr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		Map<String,String> pMap = gs.fromJson(request.getParameter("param"),Map.class);
		System.out.println(pMap);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		MusicService ms = new MusicServiceImpl();
		
		
		try {
			List<MusicChart> musicList = ms.selectMusicList(null);
			String resStr =gs.toJson(musicList);
			pw.println(resStr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		
	}

	public static void main(String[] args) {
		String jsonStr = "{\"a\":\"1\"}";
		Gson gs = new Gson();
		List<Map<String,String>> list = gs.fromJson(jsonStr, List.class);
		System.out.println(list);
//
		
//		
//		Map<String,String> map = gs.fromJson(json.)
//		gs.fromJson(jsonStr,map);
			}
	
}
