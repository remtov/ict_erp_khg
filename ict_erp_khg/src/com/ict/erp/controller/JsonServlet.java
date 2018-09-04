package com.ict.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet(
		urlPatterns = "/json/*"
		)

public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Gson gs = new Gson();// 스트링을 객체로 바꿔주는 역할
	
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Map<String,String> pMap = gs.fromJson(request.getParameter("param"),Map.class);
		System.out.println(pMap);
		response.setContentType("text/html;charset=tf-8");
		PrintWriter pw = response.getWriter();
		List<String> strList = new ArrayList<String>();
		for(int i=1;i<=10;i++) {
			strList.add("번호:" +i);
			
		}
		String resStr = gs.toJson(strList);
		pw.println(resStr);
		
		
		response.getWriter().append("Served at: ").append(pMap.toString());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		
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
