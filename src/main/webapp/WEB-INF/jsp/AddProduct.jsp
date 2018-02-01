<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>

<c:import url="/WEB-INF/jsp/header.jsp" />

<c:url var="cssHref" value="/css/site.css" />
<link type="text/css" rel="stylesheet" href="${cssHref}" />
<title>My project</title>
</head>
<body>
	<h1>You can add your product here!</h1>

	<c:url var="formAction" value="/addProduct" />
	<form method="POST" action="${formAction}">
		<div class="formInputGroup">
			<label for="title">Description/Title:</label> <input type="text"
				name="title" id="title" />
		</div>

		<div class="formInputGroup">
			<label for="category" style="color: black;">Category:</label> <select
				name="category" id="category">
				<option value="Dresses">Dresses</option>
				<option value="Skirts">Skirts</option>
				<option value="Pants">Pants</option>
				<option value="Jeans">Jeans</option>
				<option value="Tops">Tops</option>
				<option value="Jackets">Jackets</option>
				<option value="Scarfs">Scarfs</option>
				<option value="Bags">Bags</option>
				<option value="Sweaters">Sweaters</option>
			</select>
		</div>

		<div class="formInputGroup">
			<label for="size" style="color: black;">Size:</label> <select
				name="size" id="size">
				<option value="XS">XS</option>
				<option value="S">S</option>
				<option value="M">M</option>
				<option value="L">L</option>
				<option value="XL">XL</option>
				<option value="XXL">XXL</option>
			</select>
		</div>

		<div class="formInputGroup">
			<label for="color">Color:</label> <input type="text" name="color" id="color" />
		</div>

		<div class="formInputGroup">
			<label for="condition">Condition:</label> <select name="condition"
				id="condition">
				<option value="New">New</option>
				<option value="Excellent">Excellent</option>
				<option value="Good">Good</option>
			</select>
		</div>

		<div class="formInputGroup">
			<label for="price">Price:</label> <input type="text" name="price" id="price" />
		</div>
		
		<div class="formInputGroup">
			<label for="imgUrl">URL to image of your product:</label> 
			<input type="text" name="imgUrl" id="imgUrl" />
		</div>
		
		<div class="formInputGroup">
			<label for="submitBtn"></label> 
			<input class="formSubmitButton" id="submitBtn" name="submitBtn" type="submit" value="Submit" />
		</div>

	</form>

</body>
</html>