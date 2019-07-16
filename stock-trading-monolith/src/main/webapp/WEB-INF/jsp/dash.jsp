<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>StockTrading</title>
</head>
<body>

<h2>Available Stocks</h2>
<table style="width:100%">
  <tr>
   <td>TICKER --- </td>
    <td>WIPRO</td>
    <td>INFY</td> 
    <td>TCS</td>
    <td>TECHM</td>
  </tr>
  <tr>
    <td>PRICE ---</td>
    <td>230.55</td>
    <td>949.44</td> 
    <td>335.65</td>
    <td>560.87</td>
  </tr>
</table>

	<form action="purchaseStock">
		TICKER 
		<br>
		<input type="text" name="ticker"> 
		<br>
		<br>
		QUANTITY
		<br>
		<input type="text" name="quantity"> 
		<br>
		<br>
		<input type="submit" value="BUY">

	</form>
</body>
</html>