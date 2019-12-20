<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h2>Write a Review</h2>

<c:url var="saveReviewUrl" value="/saveReview" />
<form action="${saveReviewUrl}" method="POST">

	<div class="form-group">
		<label for="username">Username:</label> <input type="text"
			name="username" placeholder="Username" />
	</div>
	<div class="form-group">
		<label for="rating">Rating:</label> 
		  <select name="rating">
			<c:forEach var="cnt" begin="1" end="5">
				<option value="${cnt}">${cnt}</option>
			</c:forEach>
		</select>
	</div>
	<div class="form-group">
		<label for="title">Review Title:</label> <input type="text"
			name="title" placeholder="Review Title"  />
	</div>
	<div class="form-group">
		<label for="text">Review Text:</label>
		<textarea name="text" rows="4" cols="50"  placeholder="Review Text" ></textarea>
	</div>
	
	<input class="formSubmitButton" type="submit" />

</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />