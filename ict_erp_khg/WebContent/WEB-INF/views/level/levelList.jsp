<%@page import="com.ict.erp.vo.LevelInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/menu/left.jsp" />
		<div id="page-content-wrapper">
			<div>
				<a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle
					Menu</a>
			</div>
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>레벨번호</th>
						<th>레벨등급</th>
						<th>레벨명</th>
						<th>레벨설명</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${liList}" var="li">
						<tr>
							<td>${li.liNum}</td>
							<td>${li.liLevel}</td>
							<td>${li.liName}</td>
							<td>${li.liDesc}</td>
						</tr>
					</c:forEach>
					<c:if test="${empty liList }">
						<tr>
							<td colspan="4">레벨이 없습니다.</td>
						</tr>
					</c:if>
				</tbody>
			</table>
			<div class="btns">
				<button id="add" onclick="addRow()">레벨추가</button>
				<button id="save" onclick="saveLevel()">레벨저장</button>
				<button id="del" onclick="deleteLevel()">레벨삭제</button>
			</div>

		</div>
	</div>
	<script>
var emtyList = ${empty liList};

function addRow(){
	if(emptyList){
		var html="<tr>";
	 html+='<td>&nbsp;</td>';
	 html+='<td><input type="text" name="liLevel"></td>';
	 html+='<td><input type="text" name="liName"></td>';
	 html+='<td><input type="text" name="liDesc"></td>';
	 html+='</tr>';
	 var obj = document.queryselector("#liTbody");
	 if(emptyList){
		 obj.innerHTML= html;
		 emptyList = false;
	 }else{
		 obj.innerHTML+= html;
	 }
		
	}
	function makeParam(name){
	var objs = document.querySelectorAll('input[name='+name+']');
	var param = ''
	for(var i=0;i<objs.length;i++){
		param += name + '='+ objs[i].value + '&';
			
	}
	return param;
		}

	function saveLevel(){
		var params = makeParam('liLevel');
		params +=  makeParam('liName');
		params +=  makeParam('liDesc');
		alert(params);
		}
	
}

</script>
	<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />