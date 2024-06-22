<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<jsp:include page="index.jsp"></jsp:include>
	<div class="container">
				<h4>New Book Info</h4>
		<form action="editbook" method="post">
		<div class="alert-danger col-sm-5" role="alert">${error_msg}</div>

			<input type="hidden" name="code" class="form-control" value="${book.code}" >
			
			<div class="mb-4">
				<label class="form-lable">Name</label>
				<div class="col-sm-5">
					<input type="text" name="name" class="form-control" value="${book.name}">
				</div>
			</div>

			<div class="mb-4">
				<label class="form-lable">Price</label>

				<div class="col-sm-5">
					<input type="number" name="price" class="form-control" value="${book.price}">
				</div>
			</div>

			<div class="mb-4">
				<label class="form-lable">Author</label>

				<div class="col-sm-5">
					<input type="text" name="author" class="form-control" value="${book.author}">
				</div>
			</div>

			<div class="mb-4">
				<input type="submit" value="Updatebook" class="btn btn-primary">
			</div>

		</form>
	</div>
	
</body>
</html>