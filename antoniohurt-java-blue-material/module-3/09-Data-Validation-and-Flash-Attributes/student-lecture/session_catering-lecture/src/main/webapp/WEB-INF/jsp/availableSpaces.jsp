<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Excelsior Vending"/>

<%@include file="common/header.jspf"%>

<h1>Available Spaces at ${venueName}</h1>


	<table>
	
		<tr>
			<th>Name</th>
			<th>Daily Rate</th>
			<th>Max Occupancy</th>
		</tr>
	
	
		<c:forEach items="${spaces}" var="entry">
			<tr>
				<td><c:out value="${entry.value.spaceName}" /></td>
				<td>$<c:out value="${entry.value.dailyRate}" /></td>
				<td><c:out value="${entry.value.maxOccupancy}" /></td>
			</tr>
		</c:forEach>
	
	</table>

	<c:forEach items="${spaces}" var="entry">
		<form action="<c:url value="/booking" />" method="POST">
			<label for="reservedFor">Reserved For:</label>
			<input type="text" name="reservedFor" />
			
			<input type="hidden" name="venueName" value="${venueName}" />
			<input type="hidden" name="spaceId" value="${entry.key}" />
			<input type="hidden" name="venueName" value="${venueName}" />
			<input type="hidden" name="attendees" value="${reservation.reservationAttendees}" />
			<input type="hidden" name="startDate" value="${reservation.startDate}" />
			<input type="hidden" name="endDate" value="${reservation.endDate}" />
		
			<button type="submit">Make Reservation</button>
		</form>
	
	
	</c:forEach>


<%@include file="common/footer.jspf"%>