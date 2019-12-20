<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Container for Filter Choices -->
<div id="filter-options">
	<h3>Refine By</h3>
	<ul>
		<li>
			<c:url var="priceRangeUrl" value="${baseRoute}">
				<c:param name="maxPrice" value="25" />
			</c:url> 
			<a href="${priceRangeUrl}">Under $25</a>
		</li>
		<li>
			<c:url var="priceRangeUrl" value="${baseRoute}">
				<c:param name="minPrice" value="25" />
				<c:param name="maxPrice" value="50" />
			</c:url> 
			<a href="${priceRangeUrl}">$25 to $50</a>
		</li>
		<li>
			<c:url var="priceRangeUrl" value="${baseRoute}">
				<c:param name="minPrice" value="50" />
			</c:url> 
			<a href="${priceRangeUrl}">$50 &amp; Above</a>
		</li>
	</ul>
	<p>Avg. Review</p>
	<ul>
		<c:forEach var="ratingStep" begin="1" end="4">
			<c:set var="minRating" value="${5 - ratingStep}" />
			<c:url var="minRatingUrl" value="${baseRoute}">
				<c:param name="minRating" value="${minRating}" />
			</c:url>
			<li>
				<a class="rating" href="${minRatingUrl}"> 
					<c:forEach var="starCount" begin="1" end="5">
						<span class="${starCount <= minRating ? 'filled' : ''}">&#9734;</span>
					</c:forEach> &amp; Up
				</a>
			</li>
		</c:forEach>
	</ul>
	<p>Category</p>
	<ul>
		<li>
			<c:url var="categoryUrl" value="${baseRoute}">
				<c:param name="category" value="Home" />
			</c:url> 
			<a href="${categoryUrl}">Home</a>
		</li>
		<li>
			<c:url var="categoryUrl" value="${baseRoute}">
				<c:param name="category" value="Apparel" />
			</c:url> 
			<a href="${categoryUrl}">Apparel</a>
		</li>
		<li>
			<c:url var="categoryUrl" value="${baseRoute}">
				<c:param name="category" value="Jewelry" />
			</c:url> 
			<a href="${categoryUrl}">Jewelry</a>
		</li>
		<li>
			<c:url var="categoryUrl" value="${baseRoute}">
				<c:param name="category" value="Garden" />
			</c:url> 
			<a href="${categoryUrl}">Garden</a>
		</li>
	</ul>
</div>