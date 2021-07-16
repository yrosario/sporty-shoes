<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Form</title>
</head>
<body>
	
	<div id="wrapper">
		<div id="headder">
			<h2>Product Manager</h2>
		</div>
		
		<div id="container">
			<h3>Save Customer</h3>
			
			<form:form action="saveProduct" modelAttribute="product" method="POST">
			
			
				<!-- need to associate this data with product id -->
				<form:hidden path="id"/>
				
				
				<table>
					<tbody>
						<tr>
							<td><label>Product Name:</label></td>
							<td><form:input path="name" /></td>
						</tr>
						<tr>
							<td><label>Gender:</label></td>
							<td><form:input path="gender" /></td>
						</tr>
						<tr>
							<td><label>style:</label></td>
							<td><form:input path="style" /></td>
						</tr>
						<tr>
							<td><label>brand:</label></td>
							<td><form:input path="brand" /></td>
						</tr>
						<tr>	
							<td><label>size:</label></td>
							<td><form:input path="size" /></td>
						</tr>
						<tr>	
							<td><label>price:</label></td>
							<td><form:input path="price" /></td>
						</tr>
						<tr>	
							<td><label></label></td>
							<td><input type="submit" value="save" class="save" /></td>
						</tr>
					
					</tbody>
				
				</table>
				
			</form:form>
			
			<div style="clear; both;">
			
			<p>
				<a href="${pageContext.request.contextPath}/shoe/list">Back to List</a>
			</p>
		</div>
	</div>
</div>
	
	
	

</body>
</html>