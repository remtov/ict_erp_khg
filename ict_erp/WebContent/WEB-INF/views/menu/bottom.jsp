<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String rPath = request.getContextPath();
String title = "클라우드 프로젝트";
String uri = request.getRequestURI();
%>
<body>
<div align="right" style="position:absolute; right:0px; bottom:0px;">




<h4>김현구 HyunGoo Kim</h4>

address : 서울 금천 독산 |  Phone : 010-2703-7486 | email : remnanttov@gmail.com | instagram : j1_jayone | facebook : remnanttov<br>
Photo by Sarah Dorweiler on Unsplash

</div>


<script>
    $('#menu-toggle').click(function(e) {
        e.preventDefault();
        $('#wrapper').toggleClass('toggled');
    });
    $(document).ready(function(){
    	try{
	    	var uri = '<%=uri%>';
	    	uri = uri.replace('/WEB-INF/views','');
	    	uri = uri.replace('.jsp','');
	    	var navs = document.querySelectorAll('.sidebar-nav li');
	    	for(var i=0;i<navs.length;i++){
	    		navs[i].classList.remove('active');
	    	}
	    	var nav = document.querySelector('.sidebar-nav li a[href="' + uri +'"]');
	    	nav.parentNode.classList.add('active');
    	}catch(e){
    		console.log('(확인!!)메뉴 없음 : ' + e);
    	}
        $('#wrapper').toggleClass('toggled');
    })
</script>
</body>
</html>