<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Excelsior Vending"/>

<%@include file="common/header.jspf"%>

<h1>Select a Venue</h1>


<ol>
	<c:forEach items="${venues}" var="venue">
		<c:url var="venueURL" value="/venue">
			<c:param name="venueName" value="${venue}" />
		</c:url>
		<li><a href="${venueURL}"><c:out value="${venue}" /></a></li>
	
	
	</c:forEach>
</ol>




<%@include file="common/footer.jspf"%>