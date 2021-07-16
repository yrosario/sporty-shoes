<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Form</title>
</head>
<body>
	
	<div id="wrapper">
		<div id="headder">
			<h2>CRM - Custom Relationship Manager</h2>
		</div>
		
		<div id="container">
			<h3>Save Customer</h3>
			
			<form:form action="saveCustomer" modelAttribute="customer" method="POST">
			
			
				<!-- need to associate this data with customer id -->
				<form:hidden path="id"/>
				
				
				<table>
					<tbody>
						<tr>
							<td><label>First Name:</label></td>
							<td><form:input path="firstName" /></td>
						</tr>
						<tr>
							<td><label>Last Name:</label></td>
							<td><form:input path="lastName" /></td>
						</tr>
						<tr>
							<td><label>Address:</label></td>
							<td><form:input path="address" /></td>
						</tr>
						<tr>
							<td><label>Birthday:</label></td>
							<td><form:input type="date" path="birthday" /></td>
						</tr>
						<tr>	
							<td><label>Email:</label></td>
							<td><form:input path="email" /></td>
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
				<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
			</p>
		</div>
	</div>
</div>
	
	
	

</body>
</html>