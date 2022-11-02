<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	
<!DOCTYPE html>
<html>
<head>
<style>
table {
	width: 45%;
	border-top: 1px solid #444444;
	border-collapse: collapse;
}

th, td {
	border-bottom: 1px solid #444444;
	border-left: 1px solid #444444;
	padding: 10px;
}

th:first-child, td:first-child {
	border-left: none;
}
</style>
<meta charset="UTF-8">
<title>상품문의 작성게시판</title>
</head>
<body>

	<hr>
	<h3 align=center> 상품문의글 작성</h3>
	<hr>	

	<div align=center>
		<form method="post" action="qna_boardinsert.do">

			
			 qna_no :<input name="qna_no" id="qna_no" size="14" value="${qna_no }" /> <br>
			member_id :<input name="member_id" id="member_id" size="14" value="${member_id }" /> <br>
			product_num :<input name="product_num" id="product_num" size="14"  /> <br>
			
			<c:if test="${member_id eq 'admin' }">qna_re: <input name="qna_re" id="qna_re" size="14" value="1" ><br></c:if>
			<c:if test="${member_id ne 'admin' }">qna_re: <input name="qna_re" id="qna_re" size="14" value="0" ><br></c:if>
			qna_content:<input name="qna_content" id="qna_content" size="150"  /> <br>
			<c:if test="${member_id eq 'admin' }" > qna_group: <input name="qna_group" id="qna_group" size="14" value="${qna_no }" />	<br></c:if>
			<c:if test="${member_id ne 'admin' }" > qna_group: <input name="qna_group" id="qna_group" size="14" value="0" />			<br></c:if>



			<input type="submit" value="등록" /> <input type="reset" value="취소" />

		</form>
	</div>
</body>
</html>