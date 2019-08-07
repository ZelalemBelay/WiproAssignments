<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Green Planet</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-9">
				<h2>Planet Green Login</h2>
				<img style="width: 800px; heignt: 400px" alt="Company Logo"
					src="https://www.lamotte.fr/sites/default/files/assets/images/appartement-neuf-nantes-passage-saint-felix.jpg">
				<div class="col-sm-10 text-center" style="margin-top: 20px">
					<form action="userLogin">
					    <input class="form-control" type="text"	placeholder="Email Address" name="email"> <br>
						<input class="form-control"	type="password" placeholder="Password" name="password"> <br>
						
						<div style="color:red"><h6> ${errorMessage}</h6></div>
						<input class="btn-success btn-lg" style="width: 200px" type="submit" value="Login">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>

</html>