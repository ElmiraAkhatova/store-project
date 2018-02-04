<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<!DOCTYPE html >
<html>
<head>
</head>
<body>
	<h1>Welcome to the product list!</h1>

	<table>
		<c:forEach var="i" begin="0" end="${products.size() - 1}">
			<tr>
				<td><img width="50px" src="${products[i].getImgUrl()}"></img></td>
				<td>
					<ul>
						<li>${products[i].getTitle()}</li>
						<li>${products[i].getCategory()}</li>
						<li>${products[i].getCondition()}</li>
						<li>${products[i].getColor()}</li>
						<li>${products[i].getSize()}</li>
						<li>${products[i].getPrice()}</li>
						<li>quantity: <input type="number" value="0" id="quantity" />
						</li>
						<li><c:url var="doTransaction" value="/buy">
								<c:param name="quantity" value="0"></c:param>
								<c:param name="id" value="${products[i].id}"></c:param>
							</c:url>

							<form method="POST" action="${doTransaction}">
								<input type="submit" value="BUY" />
							</form></li>
					</ul>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>