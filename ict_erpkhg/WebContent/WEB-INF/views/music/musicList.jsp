<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>

	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/menu/left.jsp" />

		<div id="page-content-wrapper">

			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>노래제목</th>
						<th>가수</th>
						<th>배급사</th>
						<th>좋아요</th>
						<th>싫어요</th>
						<th>점수</th>
						<th>발매일</th>
					</tr>
				</thead>

				<tbody>
					<c:if test="${empty mcList}">
						<tr>
							<td colspan="7">sorry. i don't have any song</td>
						</tr>
					</c:if>

					<c:forEach items="${mcList}" var="mc">
						<tr>
							<td>${mc.mcNum}</td>
							<td><a href="/music/musicView?mcNum=${mc.mcNum}">${mc.mcName}</a></td>
							<td>${mc.mcSinger}</td>
							<td>${mc.mcVendor}</td>
							<td>${mc.mcLike}</td>
							<td>${mc.mcDislike}</td>
							<td>${mc.mcLike - mc.mcDislike}점</td>
							<td>${mc.mcCredat}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div>
				<button data-page="/music/musicInsert">노래입력</button>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />