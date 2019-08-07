<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Buy Plants/Seeds</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-9">
				<h2>Buy Plants/Seeds</h2>
				<img style="width: 700px; heignt: 350px" alt="Company Logo"
					src="https://www.lamotte.fr/sites/default/files/assets/images/appartement-neuf-nantes-passage-saint-felix.jpg">
				<div style="margin-top: 20px" class="row ">
					<div>
						<table class="table">
							<thead style="background-color: green">
								<tr style="color: white">
									<th>Id</th>
									<th>Type</th>
									<th>Description</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>Total</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${itemList}">

									<tr>
										<td><c:out value="${item.getId()}" /></td>
										<td><c:out value="${item.getType()}" /></td>
										<td><c:out value="${item.getDescription()}" /></td>
										<td>Rs. <c:out value="${item.getPrice()}" /></td>
										<td><c:out value="${item.getQuantity()}" /></td>
										<td>Rs. <c:out value="${item.getTotal()}" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<hr>
						<form action="purchaseSeeds">
							Id <br> <input type="text" name="id"> <br>
							<br> Quantity <br> <input type="text" name="quantity">
							
							<h4 style="color: red">${error }</h4>
							<br> <br> <input class="btn btn-success" type="submit" value="BUY">

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>