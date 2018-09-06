<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>

	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/menu/left.jsp" />
		<div id="page-content-wrapper">
			<div>
				<a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
			</div>
			<h1>Welcome J1's Page</h1>
			<p>환영합니다 J1 의 페이지입니다.</p>
			<img align="rignt" style="width: 70%; height: auto;" src="<%=rPath%>/imgs/backGroundImg01.jpg">
			
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />