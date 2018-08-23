package test;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;

//class TestServlet implements Servlet {
//
//	public void doGet(String req, String res) {
//		System.out.println("요청정보 : " + req);
//		System.out.println("응답정보 : " + res);
//
//	}
//
//}
//
//public class LoadingTest {
//	public static Map<String, Servlet> context = new HashMap<String, Servlet>();
//
//	public static Servlet getServlet(String name) {
//
//		if (!context.containsKey(name)) {
//			context.put(name, new TestServlet());
//
//		}
//		return context.get(name);
//
//	}
//
//	public static void main(String[] args) {
//		Servlet s = getServlet("TestServlet");
//		s.doGet("김봉건","나가");
//		s = getServlet("TestServlet");
//		s.doGet("김봉건","나가");
//		s = getServlet("TestServlet");
//		s.doGet("김봉건","나가");
//		s = getServlet("TestServlet");
//		s.doGet("김봉건","나가");
//		
//
//	}
//
//}