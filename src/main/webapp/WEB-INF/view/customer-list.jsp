<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Customer</title>
</head>
<body>
	
	<div id="wrapper">
		
		<div id="content">
		
		<!-- add new button: Add Customer -->
		<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'"
		/>
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					
					
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
					</tr>
					
				</c:forEach>
			</table>
		
		</div>
	
	</div>
</body>
</html>