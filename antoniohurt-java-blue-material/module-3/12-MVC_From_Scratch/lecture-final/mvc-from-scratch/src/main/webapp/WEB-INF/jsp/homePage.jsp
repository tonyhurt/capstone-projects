<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<title>MVC Example</title>
	</head>
	
	<body>
		<h1>Hellow MVC World</h1>
		
		<form action="<c:url value="/" />" method="GET">
			<label for="countryCode">Country:</label>
			
			<select name="countryCode">
				<c:forEach items="${countries}" var="country">
					<c:set var="selected" value="" />
					<c:if test="${not empty selectedCountry && selectedCountry == country.code}">
						<c:set var="selected" value="SELECTED" />
					</c:if>
				
					<option value="${country.code}" ${selected}>${country.name}</option>
				</c:forEach>
			
			</select>
			
			<input type="submit" />
		</form>
		
		
		<c:if test="${not empty cities}">
			<ol>
				<c:forEach items="${cities}" var="city">
					<li><c:out value="${city.name}" /></li>
				</c:forEach>
			</ol>
		</c:if>
		
	</body>
	
</html>