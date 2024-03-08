<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>



<section class ="container">
	<h3>Book List</h3>
	<p style="color:red;">${errorString }</p>
	<table class="table table-bordered">
		<thead style="background:#f1f1f1">
			<tr>
				<th>Mã sách</th>
				<th>Tên sách</th>
				<th>Tác giả</th>
				<th>Ngày ra mắt</th>
				<th>Giá</th>
				<th>Ảnh</th>
				<th>Sửa</th>
				<th>Xóa</th>
			
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${Book}" var="Book" >
				<tr>
					<td>${Book.getBookId()}</td>
					<td>${Book.getTitle()}</td>
					<td>${Book.getAuthor()}</td>
					<td>${Book.getRelease()}</td>
					<td>${Book.getPrice()}</td>
					<td>${Book.getPicture()}</td>
					<td><a href="BookEdit?BookId=${Book.getBookId()}">Sửa</a></td>
					<td><a href="BookDelete?BookId=${Book.getBookId()}">Xóa</a></td>
					
				</tr>
			
			</c:forEach>
		</tbody>
	</table>
	
	<a href="BookCreate">Tạo sách</a>
</section>

</body>
</html>