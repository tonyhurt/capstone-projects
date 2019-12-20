<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Container for Filter Choices
        Each link should take the user to this current page and use any combination of the following
        querystring parameters to filter the page:
        - maxPrice (number)
        - minPrice (number)
        - minRating (number)
        - category (string) - Home, Apparel, Jewelry, Garden

        NOTE: A parameter is passed to this view that is called `baseRoute`. `baseRoute`
        refers to the page that the filters should be associated with. For instance, if you are on the products
        page, the value of the `baseRoute` should be the route for products and on the tiles page, should be the
        route for tiles.
        -->
<div id="filter-options">
	<h3>Refine By</h3>
	<ul>
		<c:url value="${baseRoute}" var="under25Url">
			<c:param name="maxPrice" value="25" />
		</c:url>
		
		<c:url value="${baseRoute}" var="range25To50Url">
			<c:param name="minPrice" value="25" />
			<c:param name="maxPrice" value="50" />
		</c:url>
		
		<c:url value="${baseRoute}" var="over50Url">
			<c:param name="minPrice" value="50" />
		</c:url>
	
		<li><a href="${under25Url}">Under $25</a></li>
		<li><a href="${range25To50Url}">$25 to $50</a></li>
		<li><a href="${over50Url}">$50 &amp; Above</a></li>
	</ul>
	<p>Avg. Review</p>
	<ul>
		<li>
			<c:url value="${baseRoute}" var="stars4Url">
				<c:param name="minRating" value="4" />
			</c:url>
			<a class="rating" href="${stars4Url}">
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span>&#9734;</span> &amp; Up
			</a>
		</li>
		<li>
			<c:url value="${baseRoute}" var="stars3Url">
				<c:param name="minRating" value="3" />
			</c:url>
			<a class="rating" href="${stars3Url}">
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span> &amp; Up
			</a>
		</li>
		<li>
			<c:url value="${baseRoute}" var="stars2Url">
				<c:param name="minRating" value="2" />
			</c:url>
			<a class="rating" href="${stars2Url}">
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span> &amp; Up
			</a>
		</li>
		<li>
			<c:url value="${baseRoute}" var="stars1Url">
				<c:param name="minRating" value="1" />
			</c:url>
			<a class="rating" href="${stars1Url}">
				<span class="filled">&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span> &amp; Up
			</a>
		</li>
	</ul>
	<p>Category</p>
	      <c:url value="${$baseRoute}" var="catHomeUrl">
	      		<c:param name="category" value="Home" />
	      </c:url>
	      <c:url value="${$baseRoute}" var="catApparelUrl">
	      		<c:param name="category" value="Apparel" />
	      </c:url>
	      <c:url value="${$baseRoute}" var="catJewelryUrl">
	      		<c:param name="category" value="Jewelry" />
	      </c:url>
	      <c:url value="${$baseRoute}" var="catGardenUrl">
	      		<c:param name="category" value="Garden" />
	      </c:url>	      
	
	<ul>
		<li><a href="${catHomeUrl}">Home</a></li>
		<li><a href="${catApparelUrl}">Apparel</a></li>
		<li><a href="${catJewelryUrl}">Jewelry</a></li>
		<li><a href="${catGardenUrl}">Garden</a></li>
	</ul>
</div>
