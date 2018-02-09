<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>
<h2>My Shopping Cart!</h2>

<div class="header-right">
	    <span>${user.userName}</span>
	    <a href="/m3-individual-project/logout">Logout</a>
   	</div> 

<table>
		<c:forEach var="i" begin="0" end="${shoppingCart.getItems().size() - 1}">
			<tr>
				<td><img width="50px" src="${shoppingCart.getItems()[i].getProduct().getImgUrl()}"></img></td>
				<td>
					<ul>
						<li>${shoppingCart.getItems()[i].getProduct().getTitle()}</li>
						<li>${shoppingCart.getItems()[i].getProduct().getCategory()}</li>
						<li>${shoppingCart.getItems()[i].getProduct().getCondition()}</li>
						<li>${shoppingCart.getItems()[i].getProduct().getColor()}</li>
						<li>${shoppingCart.getItems()[i].getProduct().getSize()}</li>
						<li>${shoppingCart.getItems()[i].getProduct().getPrice()}</li>
						<li>Quantity: ${shoppingCart.getItems()[i].getQuantity()}</li>
						<c:url var="formAction" value="/editItem" />
						<li>
							<form action="${formAction}" id="form0" method="post">
								<input id="id" name="id" type="hidden" value="${shoppingCart.getItems()[i].getProduct().getId()}" />
								<button>Edit Item</button>
							</form>
						</li>
					</ul>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<div class="subtotal">Total Price: $${shoppingCart.getSubTotal()}</div>
	<a href="/m3-individual-project">Continue Shopping</a>
</body>
</html>