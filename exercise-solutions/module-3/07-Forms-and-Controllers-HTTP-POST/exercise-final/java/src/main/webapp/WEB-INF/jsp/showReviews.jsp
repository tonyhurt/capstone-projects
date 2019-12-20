<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
		<h2>Reviews</h2>
		<c:url var="addReviewUrl" value="/addReview" />
		<h3><a href="${addReviewUrl}">Write a Review</a></h3>
		<c:forEach var="review" items="${reviews}" >
			<div class="review">
				<p><span class="title"><c:out value="${review.title}" /></span> (<c:out value="${review.username}" />) </p>
				<p><c:out value="${review.dateSubmitted}" /></p>
				<div>
					<c:forEach var="cnt" begin="1" end="${review.rating}" >
						<img class="ratingStar" src="img/star.png" />
					</c:forEach>
				</div>
				<p><c:out value="${review.text}" /></p>
			</div>
		</c:forEach>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />