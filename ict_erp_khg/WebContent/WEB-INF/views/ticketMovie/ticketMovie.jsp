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
		
						<th>번호</th>
						<th>영화이름</th>
						<th>티켓가격</th>
						<th>상영일</th>
						<th>종료일</th>
						<th>영화설명</th>
						<th>관객수</th>
						<th>영화포스터</th>
					</tr>
				</thead>
				<tbody id='tmTbody'>
				<c:forEach items="${tmList}" var="tm">
					<tr>
						<td>${tm.tmNum}</td>
						<td>${tm.tmName}</td>
						<td>${tm.tmPrice}</td>
						<td>${tm.tmStartDat}</td>
						<td>${tm.tmEndDat}</td>
						<td>${tm.tmDesc}</td>
						<td>${tm.tmCnt}</td>
						<td>${tm.tmImg}</td>
					</tr>
				</c:forEach>
				</tbody>				
			</table>
			<button data-page="/views/ticketMovie/ticketMovieInsert">영화입력</button>
		
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />


