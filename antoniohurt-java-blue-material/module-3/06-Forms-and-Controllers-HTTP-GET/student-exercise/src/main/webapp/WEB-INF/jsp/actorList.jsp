<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>
<form action="<c:url value="/requestActors"/>" method="GET">
			<input type="text" name="lastName" />
			<input type="submit" value="Search" />
</form>
 <table class="table">
<tr>
<th>Name</th>
</tr>
<c:forEach items="${listOfActors}" var="actor">
<tr>
    <td>${actor.firstName } ${actor.lastName }</td>
</tr>
</c:forEach>
</table> 
<%@include file="common/footer.jspf"%>