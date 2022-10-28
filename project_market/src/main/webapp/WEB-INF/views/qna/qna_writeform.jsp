<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<form method="post" action="qna_boardinsert.do"
			onSubmit="return board_check()">
			<input type="hidden" name="qna_re" id="qna_re" size="14" value="0" />
			
			<table border=1>

				<tr>
					<th> Member_id</th>
					<td><input name="member_id" id="member_id" size="14"
						value="${member_id }" /></td>
				</tr>

				<tr>
					<th> Product_num</th>
					<td><input name="product_num" id="product_num" size="14"
						value="48" /></td>
				</tr>

				<tr>
					<th> Qna_content</th>
					<td><textarea name="qna_content" id="qna_content" rows="8"
							cols="50" class="input_box">ㅎㅇ</textarea></td>
				</tr>

			</table>


			<input type="submit" value="등록" /> <input type="reset" value="취소" />

		</form>
	</div>
</body>
</html>