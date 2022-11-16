<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../fix/header.jsp"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<link href="${path}/resources/css/official.css" rel="stylesheet" /> 

<<<<<<< HEAD
<section>
	<form method=post action="off_write.do">
		<div class="offwirte-contain-pj">
			<div class="offwirte-header-pj">상세페이지</div>
			<div class="offwirte-writer-pj">
				<div class="offwirte-writer-col-pj">작성자</div>
				<div class="offwirte-input-pj" style="text-align: left;">${off.off_name}</div>
			</div>
			<div class="offwirte-writer-pj">
				<div class="offwirte-condate-col-pj">날짜</div>
				<div class="offwirte-condateprint-pj" style="text-align: left;"><fmt:formatDate value="${off.off_date}" pattern="yyyy-MM-dd HH:mm:ss" /></div>
				<div class="offwirte-condate-col-pj">조회수</div>
				<div class="offwirte-condateprint-pj" style="text-align: left;">${off.off_readcount}</div>
			</div>
			<div class="offwirte-writer-pj">
				<div class="offwirte-writer-col-pj">제목</div>
				<div class="offwirte-input-pj" style="text-align: left;">${off.off_subject}</div>
			</div>
			<div class="offwirte-wricontent-pj">
				<div class="offwirte-wricontent-col-pj">공지사항</div>
				<div class="offwirte-inputcontent-pj" style="text-align: left; line-height: 30px;"><pre>${off.off_content}</pre></div>
			</div>
			<div class="offlist-footer-pj">
				<button type="button" onClick="location.href='off_list.do?page=${page}'"> 목록 </button>
				<button type="button" onClick="location.href='off_updateform.do?off_num=${off.off_num}&page=${page}'">수정</button>
				<button type="button" onClick="location.href='off_deleteform.do?off_num=${off.off_num}&page=${page}'">삭제</button>
			</div>
=======
	<section class="main-pj">
		<div class="detail-content-pj">

			<table border=1 width=400 align=center>
				<caption>상세페이지</caption>
				<tr>
					<td>작성자</td>
					<td>${off.off_name}</td>
				</tr>
				<tr>
					<td>날짜</td>
					<td><fmt:formatDate value=${off.off_date }
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
				<tr>
					<td>조회수</td>
					<td>${off.off_readcount}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>${off.off_subject}</td>
				</tr>
				<tr>
					<td>내용</td>
					<td><pre>${off.off_content}</pre></td>
				</tr>
				<tr>
					<td colspan=2 align=center>
					<input type="button" value="목록"
						onClick="location.href='off_list.do?page=${page}'"> 
				
					<input type="button" value="수정"
						onClick="location.href='off_updateform.do?off_num=${off.off_num}&page=${page}'">

						<input type="button" value="삭제"
						onClick="location.href='off_deleteform.do?off_num=${off.off_num}&page=${page}'">

					</td>
				</tr>

			</table>
>>>>>>> branch 'ob2' of https://github.com/Subgomdore/pj_market.git
		</div>
	</form>
</section>
<%@ include file="../fix/footer.jsp"%>