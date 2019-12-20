<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Films List"/>

<%@include file="common/header.jspf"%>
<form action="<c:url value="/requestFilms"/>" method="GET">
			<label for="genre">Minimum Length:</label>
			<input type="text" name="minLength" />
			<label for="genre">Maximum Length:</label>
			<input type="text" name="maxLength" />
			<label for="genre">Genre:</label>
			<input type="text" name="genre" />
			
			<input type="submit" value="Search" />
</form>
<table class="table">
<td>Title</td>
<td>Description</td>
<td>Release Year</td>
<td>Length</td>
<td>Rating</td>
<c:forEach items="${listOfFilms}" var="film">
<tr>
    <td>${film.title }</td>
    <td> ${film.description }</td>
    <td> ${film.releaseYear }</td>
    <td> ${film.length }</td>
    <td> ${film.rating }</td>
</tr>
</c:forEach>
</table> 

<%@include file="common/footer.jspf"%>