<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<h1>City Search</h1>
		<form action="<c:url value="/searchResults" />" method="GET">
			<label for="name">Country Code:</label>
			<input type="text" name="countryCode" />
			<button type="submit">Search</button>
		</form>
	</body>
</html>