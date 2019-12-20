<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<form action="<c:url value = "/" var="home"/>" method=GET>
<c:forEach var="parks" items="${parks}">
<div id="homepage-content">
		
			<a class="park-image" href="/m3-java-capstone/details?parkcode=${parks.parkCode}"><img
				src="<c:url value = "/img/parks/${parks.parkCode}.jpg"/>" /> </a>
				<div id="homepage-info">
				<p class ="name">${parks.parkName} - ${parks.state}</p>
				<p class ="description">${parks.parkDescription}</p>
				
		
</div>
</div>

</c:forEach>
</form>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />