<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Name List Example</title>
	</head>
	<body>
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Adult</th>
			</tr>
			<c:forEach var="person" items="${personList}">
				<tr>
					<td><c:out value="${person.firstName}" /></td>
					<td><c:out value="${person.lastName}" /></td>
					<td><c:out value="${person.age}" /></td>
					<td><c:out value="${person.adult}" /></td>
				</tr>
			</c:forEach>
		</table>
		
		<h2><c:out value="${doug.firstName}" /> lives in <c:out value="${doug.address.city}" />, <c:out value="${doug.address.state}" /></h2>
		
		<h2><c:out value="${person.firstName}" /></h2>
		
	</body>
</html>