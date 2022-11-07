<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/ab0cffe9ae.js"
	crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<c:set var="path" value="${pageContext.request.contextPath }" />
<link href="${path}/resources/css/header.css" rel="stylesheet">
<link href="${path}/resources/css/footer.css" rel="stylesheet">
<link href="${path}/resources/css/product.css" rel="stylesheet">
<link href="${path}/resources/css/cart.css" rel="stylesheet">
<link href="${path}/resources/css/like.css" rel="stylesheet">
</head>
<body>
<% session = request.getSession(); %>
	<header>
		<div class="header">
			<div class="logo">
				<img
					src="${pageContext.request.contextPath}/resources/img/gagu_logo1.png" />
			</div>

			<div class="center-box">
				<div class="input-box">
					<input id="search-bar" type="text" placeholder=" Search" />
					<button id="search-button">
						<i class="fa-solid fa-magnifying-glass fa-3x"></i>
					</button>
				</div>
			</div>
			<div class="login-box">
				<div class="login">
					<a href="loginform.do">'세션'</a> 
					<c:if test="${sessionScope.member_id==null}">
					<a href="member_login_go.do">로그인</a> 
					</c:if>
					<c:if test="${sessionScope.member_id!=null}">
					<a href="member_login_go.do">로그아웃</a> 
					</c:if>
					
					<c:if test="${sessionScope.member_id==null}">
					<a href="member_join.do">회원가입</a>
					</c:if>
					<c:if test="${sessionScope.member_id!=null}">
					<a href="member_edit.do">정보수정</a>
					</c:if>
					
				</div>
			</div>
		</div>
		<div class="navbar">
			<ul class="menu-bar">
				<li>
					<div class="menu-box">
						<a href="mainpage.do">Home</a>
					</div>
				</li>
				<li>
					<div class="dropdown menu-box">
						<button class="dropbtn">Category</button>
						<div class="dropdown-content">
							<a href="productlist.do?product_l=홈스마트">홈스마트</a>
							<a href="productlist.do?product_l=가구">가구</a>
							<a href="productlist.do?product_l=홈오피스">홈오피스</a> 
							<a href="productlist.do?product_l=침대매트리스">침대/매트리스</a> 
							<a href="productlist.do?product_l=어린이GaGu">어린이GaGu</a> 
							<a href="productlist.do?product_l=조명">조명</a>
							<a href="productlist.do?product_l=수납정리">수납/정리</a> 
							<a href="productlist.do?product_l=주방용품">주방용품</a> 
							<a href="productlist.do?product_l=주방가구">주방가구</a> 
							<a href="productlist.do?product_l=욕실">욕실</a> 
							<a href="productlist.do?product_l=텍스타일">텍스타일</a>
						</div>
					</div>
				</li>
				<li><div class="menu-box active">
						<a href="off_list.do">공지사항</a>
					</div></li>
				<li><div class="menu-box active">
						<a href="#">##</a>
					</div></li>
				<li><div class="menu-box active">
						<a href="review_writeform">Review</a>
					</div></li>
				<li><div class="dropdown menu-box">
						<button class="dropbtn">My Page</button>
						<div class="dropdown-content">
							<a href="listlike.do">찜목록</a> 
							<a href="listcart.do">장바구니</a> 
							<a href="#">내정보수정</a>
						</div>
					</div></li>
				<li><div class="dropdown menu-box">
						<button class="dropbtn">Manager</button>
						<div class="dropdown-content">
							<a href="insertproductform.do">상품등록</a>
							<a href="cart_list.do">매출현황</a>
						</div>
					</div></li>
			</ul>
		</div>
	</header>
</body>
<script src="${path}/resources/js/cart.js"></script>
<script src="${path}/resources/js/product.js"></script>
<script src="${path}/resources/js/like.js"></script>
</html>