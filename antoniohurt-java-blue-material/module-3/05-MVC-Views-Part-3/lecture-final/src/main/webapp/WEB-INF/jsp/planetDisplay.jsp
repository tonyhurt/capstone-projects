<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<c:url var="descriptionUrl" value="/planetDescription" >
			<c:param name="id" value="${planet.name}" />
		</c:url>

		<h2><c:out value="${planet.name}" /></h2>
		
		<a href="${descriptionUrl}">
			<img src="<c:url value="img/${planet.imageName}" />" style="width:200px;"/>
		</a>
		
		<p>
			<b>Au from the Sun:</b><c:out value="${planet.auFromSun}" />
			<br />
			<b>Number of Moons:</b><c:out value="${planet.numberOfMoons }" />
		</p>