<%@page import="com.ict.erp.vo.LevelInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<body>
<div id="wrapper"> 
<jsp:include page="/WEB-INF/views/menu/left.jsp" />
	<div id="page-content-wrapper">
		<div style="margin:10px">
		<a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
		</div>
		<div style="margin:5px;">
			<select name="scType">
				<option value="liNum">레벨번호</option>
				<option value="liLevel">레벨등급</option>
				<option value="liName">레벨명</option>
				<option value="liDesc">레벨설명</option>
							
			</select> 
			<!--셀렉트박스의 벨류가 scType 담긴다. -->
			: 
			
			<input type="text" name="scText" onkeyup="checkEnter(event)">
			<!--텍스트박스에 글자를 쓰고 엔터를 치는순간 체크엔터가 구동된다.
			체크엔터는 서치레벨로 이어져 구동된다.onkeyup은 키보드 키가 눌려지는 순간
			체크엔터라는 함수에 이벤트라는 메개변수를 넣어 호출하는 구문이다.86-->
			
			<button onclick="searchLevel()">검색</button>
			<!--검색버튼을 누르는 순간 서치레벨이 구동된다.-->
			
			
		</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th><input type="checkbox" onclick="chkAll(this)"></th>
					<th>레벨번호</th>
					<th>레벨등급</th>
					<th>레벨명</th>
					<th>레벨설명</th>
				</tr>
			</thead>
			<tbody id='liTbody'>
			<c:forEach items="${liList}" var="li">
				<tr>
					<td><input type="checkbox" name="liNum" value="${li.liNum}"></td>
					<td>${li.liNum}</td>
					<td>${li.liLevel}</td>
					<td>${li.liName}</td>
					<td>${li.liDesc}</td>
				</tr>
			</c:forEach>
			<c:if test="${empty liList}">
				<tr>
					<td colspan="5">레벨이 없습니다.</td>
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
	$(document).ready(function(){
		document.querySelector('input[name=scText]').focus(); 
	});
	
	var cnt = '${rMap.cnt}';
	
	if(cnt){
		if(cnt>0){
			alert('${rMap.msg}');
			location.href='/level/levelList';
		}
	}
	
	
	function checkEnter(e){
		/*<!-- 이벤트매게변수는 e로 바뀌고-->*/
		if(e.keyCode===13){
			/*<!-- 입력된 키코드가 엔터일때 써치레벨을 호출한다.-->*/
			searchLevel(); 
		}
	}
	/*<!-- 검색창에서 엔터를 치는순간
	13과 e의 키코드가 데이터타입까지 같을때 서치레벨로 넘긴다. 
	여기서 키코드 13은 엔터를 의미한다.158 -->
	*/
	
	var emptyList = '${empty liList}';
	
	function addRow(){
		var html = '<tr>';
		html += '<td>&nbsp;</td>';
		html += '<td>&nbsp;</td>';
		html += '<td><input type="text" name="liLevel"></td>';
		html += '<td><input type="text" name="liName"></td>';
		html += '<td><input type="text" name="liDesc"></td>';
		html += '</tr>';
		var obj = document.querySelector('#liTbody');
		
		if(emptyList==='true'){
			obj.innerHTML = html;
			emptyList = false;
		}else{
			obj.insertAdjacentHTML('beforeend',html);
		}
	}
	
	
	function makeParam(name,option){
		var selector = 'input[name=' + name + ']';
		if(!document.querySelector(selector)){
			selector = 'select[name=' + name + ']';
			if(!document.querySelector(selector)){
				selector = 'textarea[name=' + name + ']';
			}
		}
		if(option){
			selector += option;
		}
		var objs = document.querySelectorAll(selector);
		var param = ''
		for(var i=0;i<objs.length;i++){
			param += name + '=' + objs[i].value + '&';
		}
		return param;
	}
	
	
	function saveLevel(){
		var params = makeParam('liLevel');
		params += makeParam('liName');
		params += makeParam('liDesc');
		location.href='/level/saveLevelList?' + params;
	}
	
	
	function chkAll(f){
		document.querySelectorAll('input[name=liNum]').forEach((el)=>{
			el.checked = f.checked;
		});
	}
	
	function deleteLevel(){
		var params = makeParam('liNum',':checked');
		location.href='/level/deleteLevelList?' + params;
	}
	
	function searchLevel(){
		/*<!-- 엔터나 검색버튼클릭시 구동된다. -->*/
		var params = makeParam('scType');
		/*<!-- 셀렉트박스에 담긴 변수를 파람스라는 변수에 담는다. -->*/
		params += makeParam('scText');
		/*<!-- 셀렉트박스에 텍스트박스의 내용이 붙여진다. -->*/
		location.href = '/level/levelList?' + params;
		/*<!-- url에 localhost이후의 내용이 출력된다 파람즈의 담긴내용이 물음표이후에 붙여져서-->
		페이지의 URL 전체 정보를 반환합니다. URL을 지정하여 페이지를 이동할 수도 있습니다.
		*/
	}
	
</script>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />