<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


	<form action="<c:url value = "/favoriteParks" />" method=GET></form>
	
	<h1 id="favorite-parks-title">Favorite National Parks*</h1>
	<h3 id="favorite-parks-subtext">*Results based on site survey.</h3>
	<div id="favorite-parks-list">
	<ol>
	<c:forEach items = "${results}" var="results">
	<div id = "favorite-park-tile">
	<body>

	
	<c:if test="${results.parkCode == 'cvnp'}">
	<li>Cuyahoga Valley National Park - ${results.parkCount} votes</li>
	<img src =" <c:url value="/img/parks/${results.parkCode}.jpg"/>">
	</c:if>
	
	<c:if test="${results.parkCode == 'enp'}">
	<li>Everglades National Park  - ${results.parkCount} votes</li>
	<img src =" <c:url value="/img/parks/${results.parkCode}.jpg"/>">
	</c:if>
	
	<c:if test="${results.parkCode == 'gncp'}">
	<li>Grand Canyon National Park  - ${results.parkCount} votes</li>
	<img src =" <c:url value="/img/parks/${results.parkCode}.jpg"/>">
	</c:if>
	
	<c:if test="${results.parkCode == 'gnp'}">
	<li>Glacier National Park  - ${results.parkCount} votes</li>
	<img src =" <c:url value="/img/parks/${results.parkCode}.jpg"/>">
	</c:if>
	
	<c:if test="${results.parkCode == 'gtnp'}">
	<li>Grand Teton National Park  - ${results.parkCount} votes</li>
	<img src =" <c:url value="/img/parks/${results.parkCode}.jpg"/>">
	</c:if>
	
	<c:if test="${results.parkCode == 'mrnp'}">
	<li>Mount Rainier National Park  - ${results.parkCount} votes</li>
	<img src =" <c:url value="/img/parks/${results.parkCode}.jpg"/>">
	</c:if>
	
	<c:if test="${results.parkCode == 'rmnp'}">
	<li>Rocky Mountain National Park  - ${results.parkCount} votes</li>
	<img src =" <c:url value="/img/parks/${results.parkCode}.jpg"/>">
	</c:if>
	
	<c:if test="${results.parkCode == 'ynp'}">
	<li>Yellowstone National Park  - ${results.parkCount} votes</li>
	<img src =" <c:url value="/img/parks/${results.parkCode}.jpg"/>">
	</c:if>
	
	<c:if test="${results.parkCode == 'ynp2'}">
	<li>Yosemite National Park  - ${results.parkCount} votes</li>
	<img src =" <c:url value="/img/parks/${results.parkCode}.jpg"/>">
	</c:if>
		
	</body>
	
	</div>
	</c:forEach>
	
	</ol>













<c:import url="/WEB-INF/jsp/common/footer.jsp" />