<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Item</title>
</head>
<body>

<h3>Edit shopping bag item!</h3>

 						<li>${itemToEditInCart.getProduct().getTitle()};</li>
						<li>${itemToEditInCart.getProduct().getCategory()}</li>
						<li>${itemToEditInCart.getProduct().getCondition()}</li>
						<li>${itemToEditInCart.getProduct().getColor()}</li>
						<li>${itemToEditInCart.getProduct().getSize()}</li>
						<li>${itemToEditInCart.getProduct().getPrice()}</li>
						<c:url var="formAction" value="/updateItem" />
						<li>
						<form action="${formAction}" id="form0" method="post">
						
						<input id="id" name="id" type="hidden" value="${itemToEditInCart.getProduct().getId()}" />
						<input id="quantity" name="quantity" type="number" value="${itemToEditInCart.getQuantity()}" /> 
						<input type='submit' value='save item'></input>
</form>
</li>
<li>
						<c:url var="removeAction" value="/removeItem" />
						<form action="${removeAction}"  method="post">
						
						<input id="id" name="id" type="hidden" value="${itemToEditInCart.getProduct().getId()}" />
						 
						<input type='submit' value='remove item'></input>
</form>
</li>
					
</body>
</html>