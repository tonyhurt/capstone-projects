<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Excelsior Vending"/>

<%@include file="common/header.jspf"%>

<h3>Spaces for ${param.venueName}</h3> 


	<table>
	
		<tr>
			<th>Name</th>
			<th>Daily Rate</th>
			<th>Max Occupancy</th>
		</tr>
	
	
		<c:forEach items="${spaces}" var="space">
			<tr>
				<td><c:out value="${space.spaceName}" /></td>
				<td>$<c:out value="${space.dailyRate}" /></td>
				<td><c:out value="${space.maxOccupancy}" /></td>
			</tr>
		</c:forEach>
	
	</table>


	<form action="<c:url value="/availableSpaces" />" method="GET">
		<input type="hidden" name="venueName" value="${param.venueName}" />
		<label for="attendees">Number of Attendees:</label>
		<input type="number" name="attendees" />
		
		<label for="startDate">Start Date:</label>
		<input type="date" name="startDate" />
		
		<label for="duration">Number of Days:</label>
		<input type="number" name="duration" />
	
		<button type="submit">Check Availability</button>
	</form>



<%@include file="common/footer.jspf"%>