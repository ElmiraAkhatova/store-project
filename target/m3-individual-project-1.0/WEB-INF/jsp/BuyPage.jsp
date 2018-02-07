<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<!DOCTYPE html >
<html>
<head>
<c:url var="cssHref" value="/css/site.css" />
<link type="text/css" rel="stylesheet" href="${cssHref}" />
<title>My project</title>
</head>
<body>
	<h1>Welcome to the home page!</h1>
	<a href="./productList">Navigate to ProductList</a>
	<div class="formInputGroup">
		<label for="category" style = "color:black;">Menu:</label> 
		<select name="category" id="category">
			<option value="0">Dresses</option>
			<option value="1">Skirts</option>
			<option value="2">Pants</option>
			<option value="3">Jeans</option>
			<option value="4">Tops</option>
			<option value="5">Jackets</option>
			<option value="6">Scarfs</option>
			<option value="7">Bags</option>
			<option value="6">Sweaters</option>
		</select>
	</div>
	<div class="formInputGroup">
		<label for="category" style = "color:black;">Size:</label> 
		<select name="category" id="category">
			<option value="0">XS</option>
			<option value="1">S</option>
			<option value="2">M</option>
			<option value="3">L</option>
			<option value="4">XL</option>
			<option value="5">XXL</option>
		</select>
	</div>
	<div class="formInputGroup">
			<label for="submitBtn"></label> 
			<input class="formSubmitButton" id="submitBtn" name="submitBtn" type="submit" value="Submit" />
		</div>
</body>
</html>
