<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<body>
<c:if test="${!empty rMap }">
<script>
	alert('${rMap.msg}');
	if(${rMap.cnt}==1){
		location.href="/ticketMovie/ticketMovieList";
	}
</script>
</c:if>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/menu/left.jsp" />
	<div id="page-content-wrapper">
		<form action="/ticketMovie/ticketMovieUpdate" method="post">
		<table class="table table-bordered">
			<tr>
				<th>영화제목</th>
				<td><input type="text" name="tmName" value="${tm.tmName}"></td>
			</tr>
			<tr>
				<th>티켓가격</th>
				<td><input type="password" name="miPwd"></td>
			</tr>
			<tr>
				<th>상영일</th>
				<td><input type="text" name="miName" value="${tm.miName}"></td>
			</tr>
			<tr>
				<th>종료일</th>
				<td><input type="email" name="miEmail" value="${tm.miEmail}"></td>
			</tr>
			<tr>
				<th>영화설명</th>
				<td><input type="number" name="miPhone" value="${tm.miPhone}"></td>
			</tr>
			<tr>
				<th>영화포스터</th>
				<td><input type="number" name="miZipcode" value="${tm.miZipcode}"></td>
			</tr>
		
			<tr>
				<td colspan="2"><button data-action="/ticketMovie/ticketMovieUpdate">영화수정</button> <button data-action="/ticketMovie/ticketMovieDelete">영화삭제</button></td>
			</tr>
		</table>
		<input type="hidden" name="miNum" value="${tm.miNum}">
		</form>
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />