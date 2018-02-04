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

<table>
		<c:forEach var="i" begin="0" end="${cart.size() - 1}">
			<tr>
				<td><img width="50px" src="${cart[i].getImgUrl()}"></img></td>
				<td>
					<ul>
						<li>${cart[i].getTitle()}</li>
						<li>${cart[i].getCategory()}</li>
						<li>${cart[i].getCondition()}</li>
						<li>${cart[i].getColor()}</li>
						<li>${cart[i].getSize()}</li>
						<li>${cart[i].getPrice()}</li>
			
						
					</ul>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<div>Total Price: $${totalPrice}</div>
</body>
</html>