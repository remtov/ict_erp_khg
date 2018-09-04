package com.ict.erp.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ict.erp.common.IBean;
import com.ict.erp.common.ICTUtils;
import com.ict.erp.service.MenuService;
import com.ict.erp.service.TicketService;
import com.ict.erp.service.impl.MenuServiceImpl;
import com.ict.erp.service.impl.TicketServiceImpl;
import com.ict.erp.vo.MusicChart;
import com.ict.erp.vo.TicketMovie;

public class TicketMovieServlet extends HttpServlet {

	private Log log = LogFactory.getLog(this.getClass());
	private static final long serialVersionUID = 1L;
	private String uri;
	private TicketService ts = new TicketServiceImpl();


	private static final int THRESHOLD_SIZE = 1024 * 1024 * 5;// 5MB
	private static final int UP_TOTAL_SIZE = 1024 * 1024 * 100;// 100MB
	private static final int UP_FILE_SIZE = 1024 * 1024 * 20;// 20MB

	private static final File TEMP_REPOSITORY = new File(System.getProperty("java.io.tmpdir"));
	private static final String UP_PATH = "C:\\jsp_studyKHG\\workspace\\git\\ict_erp_khg\\ict_erp_khg\\WebContent";

	
	
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		uri = req.getRequestURI();
		// 클라이언트의 요청이 무엇인지 판단하기 위해 마지막 '/'를 기준으로 uri를 잘라준다.
		String cmd = ICTUtils.getCmd(uri);
		res.setContentType("text/html;charset=utf-8");
		
		try {
			TicketMovie mc = IBean.parseRequest(req,TicketMovie.class);
			// 클라이언트의 요청이 musicChart일경우(uri : localhost/music/musicChart)
			if (cmd.equals("ticketMovieList")) {
				// 뮤직서비스에서 music리스트를 리턴하는 함수를 호출해준다.
				List<TicketMovie> tmList = ts.selectTmList(mc);
				req.setAttribute("tmList", tmList);
				// 해당 리스트를 포워딩할 jsp에서 포문을 돌리며 출력해주기위해
				// musicList라는 키값을 저장한다.
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 최하단에 있는 doService 메소드를 호출한다.
		doService(req, res);
	}
	// res.getWriter().append("Served at: ").append(req.getContextPath());
	// }

	// /*
	// * doGet 메소드는 클라이언트에서 get방식으로 보냈을때 실행되는 함수이다.
	// 예를들어 localhost/music/musicChart 라는 url로 method방식을 get으로 요청할경우
	// web.xml에 기술되어있는 url-pattern /music/*을 만족하기 때문에
	// MusicServlet을 생성(생성되어있을경우엔 다시 생성안함) 하고
	// doGet메소드를 자동으로 호출한다.
	// */

	
	
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		uri ="/views"+ req.getRequestURI();
		// 클라이언트의 요청이 무엇인지 판단하기 위해 마지막 '/'를 기준으로 uri를 잘라준다.
		String cmd = ICTUtils.getCmd(uri);
		
		try {
			// 클라이언트의 요청이 musicInsert일경우(uri : localhost/music/musicInsert)
		

			if (cmd.equals("ticketMovieInsert")) {
				if (!ServletFileUpload.isMultipartContent(req)) {
					throw new ServletException("폼 인크립트가 파일업로드에 적합하지 않습니다.");
				}
				DiskFileItemFactory dfFactory = new DiskFileItemFactory(THRESHOLD_SIZE, TEMP_REPOSITORY);

				ServletFileUpload sfu = new ServletFileUpload(dfFactory);
				sfu.setHeaderEncoding("utf-8");
				sfu.setSizeMax(UP_TOTAL_SIZE);
				sfu.setFileSizeMax(UP_FILE_SIZE);
				List<FileItem> fList = sfu.parseRequest(req);
				Map<String, String> params = new HashMap<String, String>();
				for (FileItem fi : fList) {
					if (fi.isFormField()) {
						params.put(fi.getFieldName(), fi.getString("utf-8"));
					} else {
						File f = new File(fi.getName());
						String fName = File.separator + "upload" + File.separator + System.currentTimeMillis()
								+ fi.getName().substring(fi.getName().lastIndexOf("."));

						String fPath = UP_PATH + fName;
						File sFile = new File(fPath);
						fi.write(sFile);
						params.put(fi.getFieldName(), fName);
					}
				}
				TicketMovie tm = IBean.parseRequest(params, TicketMovie.class);
				req.setAttribute("cnt", ts.insertTm(tm));				
			}
//		} catch (SQLException e) {
//			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		// 최하단에 있는 doService 메소드를 호출한다.
	doService(req, res);
//		 doGet(req, res);
	}



	// /*
	// * doPost 메소드는 클라이언트에서 post방식으로 보냈을때 실행되는 함수이다.
	// 예를들어 localhost/music/musicInsert 라는 url로 method방식을 post으로 요청할경우
	// web.xml에 기술되어있는 url-pattern /music/*을 만족하기 때문에
	// MusicServlet을 생성(생성되어있을경우엔 다시 생성안함) 하고
	// doPost메소드를 자동으로 호출한다.
	// 위의 설명된것과 같이 똑같은 url로 호출한다고 하더라도
	// 클라이언트의 method방식에 따라 doGet//doPost가 실행된다.
	// */

	private void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		RequestDispatcher rd = req.getRequestDispatcher("/views" + uri);
		rd.forward(req, res);

	}

}

// 클라이언트에서 요청한 uri앞에 '/views'를 붙여서 포워딩해준다.
// '/views'를 붙이는 이유는 ViewServlet을 호출하기 위해서임.

