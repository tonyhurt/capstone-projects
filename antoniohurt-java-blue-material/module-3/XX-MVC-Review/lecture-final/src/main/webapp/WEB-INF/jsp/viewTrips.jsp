<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h1><c:out value="${user.name}" />'s Trips</h1>


<ol>
	<c:forEach items="${trips}" var="trip">
		<li>${trip.name}</li>
	</c:forEach>
</ol>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />