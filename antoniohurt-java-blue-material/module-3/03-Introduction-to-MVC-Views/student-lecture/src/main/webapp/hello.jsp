<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>MVC Views Part 1 - Example: Hello, Internet!</title>
<style>
.red {
	color: red;
}

.blue {
	color: blue;
}
</style>
</head>
<body>
	<c:choose>
		<%-- We can reference the values of request parameters
			(e.g. from the query string) by using the "param" map.
			
			Here we are testing to see whether a query string 
			parameter called "name" was provided, and if it wasn't
			(i.e. it's empty) we're defaulting the name to "Internet" --%>
		<c:when test="${empty param.name}">
			<c:set var="name" value="Internet" />
		</c:when>
		<c:otherwise>
			<c:set var="name" value="${param.name}" />
		</c:otherwise>
	</c:choose>

	<h1>Hello, ${name}!</h1>

	<c:if test="${ name != 'Internet' }">
		<h2>You provided a name!</h2>
	</c:if>

	<c:choose>
		<c:when test="${empty param.lastName}">
			<h2>You didn't tell us your last name!</h2>
		</c:when>
		<c:when>test="${param.lastName == 'Fulton' }">
		<h2>Are you THE John Fulton?</h2>
		</c:when>
		<c:otherwise>
			<h2>You provided a last name</h2>
		</c:otherwise>
	</c:choose>

	<c:forEach begin="1" end="10" var="count">
		<h2>${count}</h2>
	</c:forEach>

	<c:set var="fullname" value="${name} ${param.lastName}" />
	<c:set var="count" value="10" />
	<c:if test="${not empty param.count}">
		<c:set var="count" value="$param.count" />
	</c:if>
	<ul>
		<c:forEach begin="1" end="${count}" var="num">
			<c:set var="cssClass" value="blue" />
			<c:if test="${num %2 == 0}">
				<c:set var="cssClass" value="red" />
			</c:if>
			<li>class="${cssClass}>{fullName}</li>
		</c:forEach>
	</ul>
</body>
</html>