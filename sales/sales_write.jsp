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
<!-- 글쓰기 데이터 보낼 폼태그 -->
<form method="post" action="" id="frm" enctype="multipart/form-data">
	<input type="hidden" id="memid" name="memid">
	<input type="hidden" id="ptt" name="ptt">
	<input type="hidden" id="cate" name="cate">
	<input type="hidden" id="pbd" name="pbd">
	<!-- <div style="dispaly:non -->
<div>
<jsp:include page="/left.pro" flush="true" />
  <!-- 가운데 영역 (주내용 담길 곳) -->
   <div class="centercolumn" >
	   <div class="card">
			<table id="table_saWrite">
				<tr>
					<td>작성자</td>
					<td id="sid_saWrite" value="${SID}">${SID}</td>
				</tr>
				<tr>
					<td>분 류</td>
					<td>
					<div>
						<select id="cate_saWrite">
							<option value="eat">음식점
							<option value="cth">자동차극장
							<option value="atc">캠핑장
							<option value="etc">기타
						</select>
					</div>
					</td>
				</tr>
				<tr>
					<td>제 목</td>
					<td><input id="ptt_saWrite" type="text" /></td>
				</tr>
				<tr>
					<td >내 용</td>
					<td>
						<textarea id="pbd_write"></textarea>
					</td>
				</tr>
			</table>
			<div id="fileAdd">
				<h6>파일첨부</h6>
				<input type="file" name="file" id="file_saWrite"><br>
			</div>
			<div>
				<button id="save">등록</button>
				<button id="list">목록</button>
			</div>
		</div>
	</div>
</div>
</form>
<jsp:include page="/right.pro" flush="true" />
<!-- footer -->
<div class="footer">
	
</div>

</body>
</html>