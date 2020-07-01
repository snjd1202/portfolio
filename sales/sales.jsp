<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<link rel="stylesheet" href="/pro/css/w3.css" />
<link rel="stylesheet" href="/pro/css/sales.css" />
<link rel="stylesheet" href="/pro/css/side.css" />
<script type="text/javascript" src="/pro/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/pro/js/sales.js"></script>
<style>

</style>
<script type="text/javascript">

</script>
</head>
<jsp:include page="/head.pro" flush="true" />
<body>
<div class="row">
 <jsp:include page="/left.pro" flush="true" />
  <!-- 가운데 영역 (주내용 담길 곳) -->
<!-- 디테일 뽑는 폼태그 -->
<form method="get" action="" id="frm">
	<input type="hidden" name="pno" id="pno">
</form>
<!-- 조회수 폼태그 -->
<form method="post" action="/pro/sales/sales_bcnt.pro" id="frm1">
	<input type="hidden" name="bpno" id="bpno">
</form>
	
<input type="hidden" id="sid" name="memid" value="${SID}">
	
  <div class="centercolumn w3-center">
    <div class="card">
      <h2>팝니당</h2>
      <div>
	      <c:if test="${not empty SID}">
			<button id="write">글쓰기</button>
	      </c:if>
	  </div>
			<table id="saList">
				<tr>
					<th id="rno">NO</th>
					<th id="limg">썸네일</th>
					<th id="ptt">제목</th>
					<th id="bceo">작성자</th>
					<th id="today">작성일</th>
					<th id="bcnt">좋아요</th>
					<th id="bcnt">조회수</th>
				</tr>
				<c:forEach var="data" items="${LIST}">
					<tr class="salesList" id="${data.pno}" value="${data.memid}">
					  	<td>${data.rno}</td>
					  	<td><img id="rimg" src="/pro/upload/${data.savename}"></td>
					  	<td>${data.ptt}</td>
					  	<td>${data.bceo}</td>
					  	<td>${data.today}</td>
					  	<td>${data.lcnt}</td>
					  	<td>${data.bcnt}</td>
				  </tr>
				  <div id="sales_memid" value="${data.memid}"></div>
			  </c:forEach>
		  </table>
			<!-- 페이징 처리 부분 -->
		<!-- 
			<div class="w3-center" style="margin-top: 5px;">
				<div class="w3-bar w3-border">
					<c:if test="${PAGE.startPage lt (PAGE.pageGroup + 1) }">
						<span class="w3-bar-item w3-light-gray">PRE</span>
					</c:if>
					<c:if test="${PAGE.startPage ge (PAGE.pageGroup + 1) }">
						<span class="w3-bar-item pgbt w3-button w3-hover-blue pbtn"
							id="${PAGE.preNo}">PRE</span>
					</c:if>
					<c:forEach var="pageNo" begin="${PAGE.startPage}"
						end="${PAGE.endPage}">
						<span
							class="w3-bar-item pgbt w3-border-left w3-button w3-hover-blue pbtn">${pageNo}</span>
					</c:forEach>
					<c:if test="${PAGE.endPage ne PAGE.totalPage}">
						<span
							class="w3-bar-item pgbt w3-border-left w3-button w3-hover-blue pbtn"
							id="${PAGE.nextNo}">NEXT</span>
					</c:if>
					<c:if test="${PAGE.endPage eq PAGE.totalPage}">
						<span class="w3-bar-item  w3-border-left w3-light-gray ">NEXT</span>
					</c:if>
				</div>
				<!-- 페이징 처리 부분 끝 -->
				
				<div style="width: 100%;" class="w3-center" id="searchForm">
				<!-- 검색 데이터 보내기 폼태그 -->
					<form method="post" action="" id="search">
						<select name="condition" style="margin: 10px; height: 28px;">
							<option value="bdtt">제목</option>
							<option value="bdbd">내용</option>
							<option value="name">글쓴이</option>
						</select> 
						<input type="text" size="20" name="input" style="margin: 10px;" />
						<input id="serbtn" type="submit" value="search" style="margin: 10px;" />
					</form>
				</div>
			</div>
    </div>
</div>
  
<jsp:include page="/right.pro" flush="true" />

<!-- footer -->
<div class="footer">
	
</div>

</body>
</html>