<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/menu/left.jsp" />
		<div id="page-content-wrapper">
			<div class="container">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>영화이름</th>
							<th>티켓가격</th>
							<th>상영일</th>
							<th>종료일</th>
							<th>영화설명</th>
							<th>영화포스터</th>

						</tr>
					</thead>
					<tbody id='menuTbody'>
						<c:forEach items="${ticketMovieList}" var="ticketMovie">
							<tr>
								<td>${ticketMovie.tmNum}</td>
								<td>${ticketMovie.tmName}</td>
								<td>${ticketMovie.tmPrice}</td>
								<td>${ticketMovie.tmStartDat}</td>
								<td>${ticketMovie.tmEndDat}</td>
								<td>${ticketMovie.tmDesc}</td>
								<td>${ticketMovie.tmImg}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
				<button data-page="/views/ticketMovie/ticketMovieInsert">영화입력</button>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />