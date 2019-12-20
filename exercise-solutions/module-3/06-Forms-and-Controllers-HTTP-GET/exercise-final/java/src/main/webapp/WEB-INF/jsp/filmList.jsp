<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Films List"/>

<%@include file="common/header.jspf"%>
<form method="GET" class="form-inline">
    <div class="form-group">
        <label for="minimumLength">Minimum Length: </label><input class="form-control" name="minimumLength" />
    </div>
    <div class="form-group">
        <label for="maximumLength">Maximum Length: </label><input class="form-control" name="maximumLength" />
    </div>
    <div class="form-group">
        <label for="genre">Genre: </label>
        <select class="form-control" name="genre">
            <option value="Comedy">Comedy</option>
            <option value="Action">Action</option>
            <option value="Horror">Horror</option>
            <option value="Family">Family</option>
            <option value="Drama">Drama</option>
        </select>
    </div>
    <input class="btn btn-default" name="search" value="Search" type="submit"/>
</form>
<table class="table">
<tr>
<th>Title</th>
<th>Description</th>
<th>Release Year</th>
<th>Length</th>
<th>Rating</th>
</tr>
<c:forEach items="${films}" var="film">
    <tr>
<td><c:out value="${film.title}"/></td>
<td><c:out value="${film.description}"/></td>
<td><c:out value="${film.releaseYear}"/></td>
<td><c:out value="${film.length}"/></td>
<td><c:out value="${film.rating}"/></td>
</tr>
</c:forEach>
</table>
<%@include file="common/footer.jspf"%>