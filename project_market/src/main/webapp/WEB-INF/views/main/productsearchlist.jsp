<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container" align="center">
	<div class="container" style="width:100%; padding:2px; border-color:#999; border-radius: 10px; border-style: dotted; border-width: 2px;">
		<c:if test="${empty keyword}">
			<h5 class="text-primary"><b>TABLER의 <font color=red>모든 상품</font>이 검색되었습니다.<b></h5>
		</c:if>
		
		<c:if test="${(not empty keyword) and (search eq 'product_name')}">
			<h5 class="text-primary"><b>상품명에 (<font color=red>${keyword }</font>)(이)가  포함된 상품입니다.<b></h5>
		</c:if>
	</div>
<c:if test="${empty list}">
		<table class="table table-hover">
			<tr>
				<td align=center><br><br><br>검색조건에 해당하는 <font color=red>
				</font> 상품이 없습니다<br><br><br><br><br></td>
			</tr>
		</table>
</c:if>		
<c:if test="${not empty list}">
		<!-- 상품 리스트 -->
		<c:forEach var="p" items="${list }">
			<div class="vf_product" style="float: left;">
				<table style="font-size:14px">
					<tr>
						<td style="padding:8px">
							<a href="${path }/productdetail.do?product_num=${p.product_num}">
							<img src= "<%=request.getContextPath()%>/resources/upload/${pl.product_img}" width=210px height=210px></a></td>
					</tr>
					<tr>
						<td style="padding:0 9 9 9" valign=top height=90px>
						<a href="${path}/productsearchlist.do?pageNum=1&search=product_sub&keyword=${p.product_sub}">[${p.product_sub}]</a><br>
							<b>${p.product_name}</b><br>
							구매가 : ${p.product_price}원<br>
							
						</td>
					</tr>
				</table>
			</div>
		</c:forEach>
</c:if>
</div>

<!-- 페이징 -->
<c:if test="${pp.endPage > 1}">	
<div class="container" align="center">
		<ul class="pagination">
				<c:if test="${pp.startPage > pp.pagePerBlk }">
					<li><a href="${path }/productsearchlist.do?pageNum=${pp.startPage - 1}&search=${search}&keyword=${keyword}}">이전</a></li>
				</c:if>
				<c:forEach var="i" begin="${pp.startPage}" end="${pp.endPage}">
					<li <c:if test="${pp.currentPage==i}">class="active"</c:if>><a
						href="${path }/productsearchlist.do?pageNum=${i}&search=${search}&keyword=${keyword}">${i}</a></li>
				</c:forEach>
				<c:if test="${pp.endPage < pp.totalPage}">
					<li><a href="${path }/productsearchlist.do?pageNum=${pp.endPage + 1}&search=${search}&keyword=${keyword}">다음</a></li>
				</c:if>
		</ul>
</div>
</c:if>
<br><br><br><br>

</body>
</html>