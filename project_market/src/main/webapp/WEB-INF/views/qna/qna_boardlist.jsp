<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html>
<html>
<head>
<c:set var="path" value="${pageContext.request.contextPath }" />
<link href="${path}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${path}/resources/css/tb.css" rel="stylesheet">

<meta charset="UTF-8">
<title>Q&A BoardPage</title>
</head>
<body>
	${member_id } 님 환영합니다 <br>
	<c:set var ="session_id" value="${member_id }"/>
	<c:set var ="admin_user" value ="admin" />
	
	pageContext.request.contextPath : ${pageContext.request.contextPath } 


	<div class="container" align="center">
		<h2 class="text-primary">게시판 목록</h2>

		<c:if test="${empty boardlist}">
			<tr>
				<td colspan="5">데이터가 없습니다</td>
			</tr>
		</c:if>

		<c:if test="${not empty boardlist}">
			<c:forEach var="bl" items="${boardlist}">
				<table class="table table-striped">
					<tr>
					
						<td width="100" align="left">
						<c:if test="${bl.member_id ne 'admin' }">	<img src="${pageContext.request.contextPath}/resources/img/q.JPG"> </c:if>
						</td>
						<td width="250" align="left">사용자아이디</td>
						<td width="250" align="left">상품명</td>
						<td width="250" align="left">작성일</td>
						<td width="100" align="left"><c:if test="${session_id  eq admin_user }">
						<a href="qna_writeform.do?qna_no=${bl.qna_no }&product_num=${bl.product_num}&qna_group=${bl.qna_group}">[답변]</a></c:if></td>
					</tr>
					<tr>
						<td><c:if test="${bl.qna_re eq 1 }"><img src="${pageContext.request.contextPath}/resources/img/a.JPG"></c:if></td>

						<!-- ----------------------- ID 마스킹처리하는 구간 ----------------------- -->
						
						<td>
							<c:set var="name" value="${bl.member_id}" />
							<c:set var="admin" value="${'관리자' }" />
							<c:set var="length" value="${fn:length(name) }" />
							<c:set var="first" value="${fn:substring(name, 0, 3) }" />
							<c:set var="last" value="${fn:substring(name, 4, totalLength) }" />

							<c:if test="${!empty name and name ne 'admin'}">
								<c:out value="${first}" />
								<c:forEach var="count" begin="4" end="${fn:length(name) }" step="1">*</c:forEach>
							</c:if>
							
							<c:if test="${!empty name and name eq 'admin'}">
								<c:out value="${admin}" />
							</c:if>
						</td>

						<!-- ----------------------- ID 마스킹처리하는 END ----------------------- -->


						<td>${bl.product_num }</td>
						<td><fmt:formatDate value="${bl.qna_date}"
							pattern="yyyy-MM-dd HH:mm"/></td>
						<td><c:if test="${session_id  eq bl.member_id }"><a href="qna_updateform.do?qna_no=${bl.qna_no }">[수정]</a></c:if>
						</td>
					</tr>
					
					<th colspan=5><pre> ${bl.qna_content } </pre></th>
				</table>
			</c:forEach>
		
		</c:if>
		
		<!-- 테이블리스트끝 -->

		<ul class="pagination">
			<c:if test="${page <=1 }">
				<li><a>이전</a></li>
			</c:if>

			<c:if test="${page > 1 }">
				<li><a href="qna_boardlist.do?page=${page-1}">이전</a></li>
			</c:if>

			<c:forEach var="a" begin="${startpage}" end="${endpage}">
				<c:if test="${a == page }">
					<li><a>${a}</a></li>
				</c:if>
				<c:if test="${a != page }">
					<li><a href="qna_boardlist.do?page=${a}">${a}</a></li>
				</c:if>
			</c:forEach>

			<c:if test="${page >= maxpage }">
				<li><a>다음</a></li>
			</c:if>
			<c:if test="${page < maxpage }">
				<li><a href="qna_boardlist.do?page=${page+1}">다음</a></li>
			</c:if>

		</ul>

		<div align="center">
		
		<!-- qna_no 값 나중에 가져와서 세팅해야함. -------------------------------->
		
			<a href="qna_writeform.do" class="btn btn-info">문의글 작성</a>
		</div>
	</div>
</body>
</html>