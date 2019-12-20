<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<h1>City Results for ${param.countryCode}</h1>
	
		<ol>
			<c:forEach items="${cityList}" var="city">
				<li>${city.name}</li>
			</c:forEach>
		</ol>
	
	</body>
</html>