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
				<td><input type="text" name="uTmName" value="${tm.tmName}"></td>
			</tr>
			<tr>
				<th>티켓가격</th>
				<td><input type="number" name="uTmPrice" value="${tm.tmPrice}"></td>
			</tr>
			<tr>
				<th>상영일</th>
				<td><input type="date" name="uTmStartDat" value="${tm.tmStartDat}"></td>
			</tr>
			<tr>
				<th>종료일</th>
				<td><input type="date" name="uTmEndDat" value="${tm.tmEndDat}"></td>
			</tr>
			<tr>
				<th>영화설명</th>
				<td><input type="text" name="uTmDesc" value="${tm.tmDesc}"></td>
			</tr>
			<tr>
				<th>영화포스터</th>
				<td><input type="file" name="uTmImg" value="${tm.tmImg}"></td>
			</tr>
		
			<tr>
				<td colspan="2"><button>영화수정</button> <button data-action="/ticketMovie/ticketMovieDelete">영화삭제</button></td>
			</tr>
		</table>
		<input type="hidden" name="tmNum" value="${tm.tmNum}">
		</form>
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />