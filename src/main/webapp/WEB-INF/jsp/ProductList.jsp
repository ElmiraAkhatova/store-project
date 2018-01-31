<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
</head>
<body>
	<h1>Welcome to the product list!</h1>
	<a href="./addProduct">Add a Product</a>

	<table>
		<c:forEach var="i" begin="0" end="${products.size() - 1}">
			<tr>
				<td>
					<img width="50px"src="${products[i].getImgUrl()}"></img>
				</td>
				<td>
					<ul>
						<li>${products[i].getCategory()}</li>
						<li>${products[i].getCondition()}</li>
						<li>${products[i].getColor()}</li>
						<li>${products[i].getSize()}</li>
						<li>${products[i].getPrice()}</li>
					</ul>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>