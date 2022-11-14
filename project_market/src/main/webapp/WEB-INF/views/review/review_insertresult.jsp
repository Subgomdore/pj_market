<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ include file="../fix/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section class="main-pj">
		<div class="detail-content-pj">

<c:if test="${result == 1 }">
	<script>
		alert("리뷰 작성이 완료 되었습니다!");
		location.href = "review_boardlist.do?&product_num=${product.product_num}";
	</script>
</c:if>

<c:if test="${result == 2 }">
	<script>
		alert("첨부파일이 2MB를 초과하여 리뷰 등록이 실패하였습니다.");
		history.go(-1);
	</script>
</c:if>

<c:if test="${result == 3 }">
	<script>
		alert("이미지 만 등록 가능합니다 ");
		history.go(-1);
	</script>
</c:if>
</div>
</section>
</body>
</html>
<%@ include file="../fix/footer.jsp"%>