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
<!-- <script type="text/javascript" src="/pro/js/sales_pay.js"></script> -->
<style>

</style>
</head>
<jsp:include page="/head.pro" flush="true" />
<body>
<jsp:include page="/left.pro" flush="true" />

<div class="centercolumn" >
  
  <!-- 가운데 영역 (주내용 담길 곳) -->
	 <!-- 삭제 데이터 전송용 폼태그 -->
	 <form method="post" action="" id="frm2">
	 	<input type="hidden" name="rno" id="rno">
	 	<input type="hidden" name="pno" id="repno">
	 </form>
	 <form method="post" action="" id="frm3">
	 	<input type="hidden" name="spno" id="spno">
	 </form>
	 <!-- 수정 데이터 전송용 폼태그 -->
	 <form method="post" action="/pro/sales/sales_modify.pro" id="frm4">
	 	<input type="hidden" name="pno" id="pno">
	 	<input type="hidden" name="ptt" id="ptt">
	 	<input type="hidden" name="pbd" id="pbd">
	 	<input type="hidden" name="cate" id="cate">
	 </form>
	 <!-- 좋아요 데이터 전송용 폼태그 -->
	<form method="post" action="" id="likefrm">
		 <input type="hidden" id="asid" name="memid" value="${SID}">
		 <input type="hidden" id="apno" name="pno" value="${DATA.pno}">
		 <input type="hidden" id="aptt" name="ptt" value="${DATA.ptt}">
		 <input type="hidden" id="apbd" name="pbd" value="${DATA.pbd}">
		 <input type="hidden" id="acate" name="cate" value="${DATA.cate}">
	</form>
	 
	<div id="detail">
		<br>
		<div id="topForm"><h3><b>매장 정보</b>
			<span id="burger" value="${MEMID}">&nbsp
				<c:if test="${MEMID eq null}">
					<img id="burger1" alt="" src="/pro/upload/burger1.png">
				</c:if>
				<c:if test="${MEMID == SID}">
					<img id="burger2" alt="" src="/pro/upload/burger2.png">
				</c:if>
				&nbsp<span id="likecnt">${DATA.lcnt}</span>
			</span></h3>
		</div>
		<hr>
		<br>
		<div id="board">
		<c:if test="${not empty CAR}">
			<div id="car">
				<h5 id="car_h5" name="car">매장진입 추천차량</h5>
				<h4 id="car_h4"><b>${CAR}</b></h4>
			</div>
		</c:if>
			<h2 id="pro_ptt" name="ptt"><b>${DATA.ptt}</b></h2>
			<h4 id="pro_bceo" name="bceo">${DATA.name}</h4>
			<h4 id="pro_bloc" name="bloc">${DATA.bloc}</h4>
		</div>
		<br>
		 <br>
		 <div style="display: flex; justify-content:center; align-items: center;">
		 	<span id="map"></span>
			<img id="img" alt="" src="/pro/upload/${DATA.savename}">
		 </div>
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bfbcb2a9b1a94611a8804b0d71d6315c&libraries=services"></script>
		
		<script>
			var mapContainer = document.getElementById('map');
			var mapOption = {
			    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			    level: 3 // 지도의 확대 레벨
			}// 지도를 표시할 div 
			
			// 지도를 생성합니다    
			var map = new kakao.maps.Map(mapContainer, mapOption); 
			
			
			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new kakao.maps.services.Geocoder();
			 
			// 주소로 좌표를 검색합니다
			geocoder.addressSearch('${DATA.bloc}' , function(result, status) {
			
			    // 정상적으로 검색이 완료됐으면 
			     if (status === kakao.maps.services.Status.OK) {
			
			        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			        
			        // 결과값으로 받은 위치를 마커로 표시합니다
			        var marker = new kakao.maps.Marker({
			            map: map,
			            position: coords
			        });
			
			        // 인포윈도우로 장소에 대한 설명을 표시합니다
			        var infowindow = new kakao.maps.InfoWindow({
	
			            content: '<div style="width:150px;text-align:center;padding:6px 0;">${DATA.bname}</div>'
			        });
			        infowindow.open(map, marker);
			
			        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			        
			        map.setCenter(coords);
			     }
			});  
		</script>
		<br>
	<hr class="border_orange">
		 <div name="pbd" id="pbd">
		 	<h5 id="pbd_h5"><b>매장 홍보글</b></h5>
		 	<br>
		 	<h3>${DATA.pbd}</h3>
			 </div>
    <hr class="border_orange">
   <!--  <form method="post" action="/kakaoPay">
    	<button>카카오페이로 결제하기</button>
	</form> -->
	<!-- <img alt="" src="/pro/img/payment_icon_yellow_medium.png" action=""> -->
	<div id="btn_detail">
	<c:if test="${SID eq DATA.memid}">
	<button id="delete" class="delete" value="${DATA.pno}" >삭제</button>
	<button id="modi" class="modi" value="${DATA.pno}">수정</button>				
	</c:if>
		<button id="list" class="list">목록</button>
		<button id="review" class="review">리뷰(${DATA.rcnt})</button>
	</div>
			<div id="reviewWrite">
				<br>
				<br>
				<div>
					<div>
						<span>
							<h4>
								<strong>리뷰</strong>
							</h4>
						</span>
					</div>
					<div>
						<div>
							<div>
								<div id="rWrite">
									<form id="ajax" action="" method="post">
										<input type="hidden" name="pno" value="${DATA.pno}"> <input
											type="hidden" name="memid" value="${SID}">
										<div id="rst">
											<h6>
												<b>평점</b>
											</h6>
											<select id="rstSelect" name="rst">
												<option value="5">★★★★★
												<option value="4">★★★★
												<option value="3">★★★
												<option value="2">★★
												<option value="1">★
											</select> <br>
											<h6>
												<b>이미지첨부</b>
											</h6>
											<!-- 	<form id="imgfrm" method="post" enctype="multipart/fom"> -->
											<input type="file" name="file" id="file_saWrite"><br>
											<!-- 	</form> -->
										</div>
										<textarea id="reviewTitle" name="rtt"
											placeholder="리뷰제목을 입력해주세요."></textarea>
										<textarea id="reviewArea" name="rbd"
											placeholder="리뷰내용을 입력해주세요."></textarea>
										<br>
										<button id="reviewOK">등록</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	<div id="reviewList">
     <!-- ajax 들어갈 위치 -->
	</div>
    <hr>
</div>		
<div style="height: 30px;"> </div>

<jsp:include page="/right.pro" flush="true" />
<!-- footer -->
<div class="footer">
	
</div>

</body>
<script type="text/javascript" src="/pro/js/sales_ajax.js"></script>
</html>