<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<body>
<c:if test="${!empty rMap }">
<script>
	alert('${rMap.msg}');
	if(${rMap.cnt}==1){
		location.href="/member/memberList";
	}
</script>
</c:if>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/menu/left.jsp" />
	<div id="page-content-wrapper">
		<form action="/member/memberUpdate" method="post">
		<table class="table table-bordered">
			<tr>
				<th>사원아이디</th>
				<td><input type="text" name="uMiId" value="${mi.miId}"></td>
			</tr>
			<tr>
				<th>사원비밀번호</th>
				<td><input type="password" name="uMiPwd"></td>
			</tr>
			<tr>
				<th>사원이름</th>
				<td><input type="text" name="uMiName" value="${mi.miName}"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="uMiEmail" value="${mi.miEmail}"></td>
			</tr>
			<tr>
				<th>폰번호</th>
				<td><input type="number" name="uMiPhone" value="${mi.miPhone}"></td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td><input type="number" name="uMiZipcode" value="${mi.miZipcode}"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="uMiAddress1" value="${mi.miAddress1}"></td>
			</tr>
			<tr>
				<th>상세주소</th>
				<td><input type="text" name="uMiAddress2" value="${mi.miAddress2}"></td>
			</tr>
			<tr>
				<th>부서</th>
				<td>
					<select name="diCode">
						<option>선택</option>
						<c:forEach items="${diList}" var="di">
							<option value="${di.diCode}">${di.diName}</option>
						</c:forEach>	
					</select>
				</td>
			</tr>
			<tr>
				<th>권한</th>
				<td>
					<select name="liLevel">
						<option>선택</option>
						<c:forEach items="${liList}" var="li">
							<option value="${li.liLevel}">${li.liName}</option>
						</c:forEach>	
					</select>
				</td>
			</tr>
			<tr>
				<th>상세정보</th>
				<td><input type="text" name="uMiDesc" value="${mi.miDesc}"></td>
			</tr>
			<tr>
				<td colspan="2"><button>부서수정</button> <button data-action="/member/memberDelete">부서삭제</button></td>
			</tr>
		</table>
		<input type="hidden" name="miNum" value="${mi.miNum}">
		</form>
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />