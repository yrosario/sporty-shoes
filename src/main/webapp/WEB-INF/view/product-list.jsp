<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Product</title>
</head>
<body>
	
	<div id="wrapper">
		
		<div id="content">
		
		<!-- add new button: Add Product -->
		<input type="button" value="Add Shoe"
				onclick="window.location.href='showFormForAdd'"
		/>
		
			<table>
				<tr>
					<th>Product name</th>
					<th>gender</th>
					<th>style</th>
					<th>brand</th>
					<th>size</th>
					<th>price</th>
					<th>qty</th>
				</tr>
				
				<!-- loop over and print our products -->
				<c:forEach var="tempProduct" items="${products}">
				
					<!-- construct an "update" link with product id -->
					<c:url var="updateLink" value="/shoe/showFormForUpdate">
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>
					
					<!-- construct an "Delete" link with customer id -->
					<c:url var="deleteLink" value="/product/delete">
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>
					
					
					<tr>
						<td> ${tempProduct.name} </td>
						<td> ${tempProduct.gender} </td>
						<td> ${tempProduct.style} </td>
						<td> ${tempProduct.brand} </td>
						<td> ${tempProduct.size} </td>
						<td> ${tempProduct.price} </td>
						<td> ${tempProduct.qty} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<!-- display the delete link -->
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this product?'))) return false">Delete</a>
							
						</td>
					</tr>
					
				</c:forEach>
			</table>
		
		</div>
	
	</div>
</body>
</html>
