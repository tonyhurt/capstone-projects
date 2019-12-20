<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product List View" />
</c:import>

<div id="card-page">
	<c:import url="/WEB-INF/jsp/common/filters.jsp">
		<%-- Modify the baseRoute to apply filters to the current route. --%>
		<c:param name="baseRoute" value="/products" />
	</c:import>

	<div class="main-content">
		<!-- Container for Sorting Choices
         
         Each link should take the user to this current page and use any combination of the following
         querystring parameters to sort the page:
            - sortOrder (string) - PriceLowToHigh,PriceHighToLow,RatingHighToLow
    	-->
    	<c:url var="priceLowToHigh" value="/products">
    		<c:param name="sortOrder" value="PriceLowToHigh"/>
    	</c:url>
    	<c:url var="priceHighToLow" value="/products">
    		<c:param name="sortOrder" value="PriceHighToLow"/>
    	</c:url>
    	<c:url var="ratingHighToLow" value="/products">
    		<c:param name="sortOrder" value="RatingHighToLow"/>
    	</c:url>

    	
		<div id="sorting-options">
			<h3>Sort By</h3>
			<ul>
				<li><a href="${priceLowToHigh}">Price - Low to High</a></li>
				<li><a href="${priceHighToLow}">Price - High to Low</a></li>
				<li><a href="${ratingHighToLow}">Rating - High to Low</a></li>
			</ul>
		</div>

		<!-- Container for all of the Products -->
		<!-- The list of products is available using the `products` variable -->
		<div id="grid">

			<!-- 
			The following HTML shows different examples of what HTML could be rendered based on different rules. 
			For purposes of demonstration we've written it out so you can see it when you load the page up. 
			-->

			<!-- Standard Product -->
			
			<c:forEach var="product" items="${products}">
				
		
				<c:choose>
					<c:when test="${product.remainingStock == 0}">
						<div class="tile sold-out">
							<span class="banner">Sold Out</span>
					</c:when>
					<c:otherwise>
						<div class="tile">
				
						<c:if test="${product.topSeller == true}" >
							<span class="banner top-seller">Top Seller!</span>
						</c:if>
					</c:otherwise>
				</c:choose>
					
					<!-- Link to the Detail page using the product id (e.g. products/detail?id=1) -->
					<c:url var="productDetailURL" value="/products/detail">
						<c:param name="id" value="${product.id}" />
					</c:url>
					<a class="product-image" href="${productDetailURL}"> 
						<img src="<c:url value="/images/product-images/${product.imageName}" />" />
					</a>
	
					<div class="details">
						<p class="name"><c:out value="${product.name}" /></p>

						<!-- .filled will make the star solid -->
						<div class="rating">
							<c:forEach begin="1" end="5" var="cnt">
								<c:choose>
									<c:when test="${cnt <= product.averageRating}">
										<span class="filled">&#9734;</span> 
									</c:when>
									<c:otherwise>
										<span>&#9734;</span> 
									</c:otherwise>
								</c:choose>		
							</c:forEach>
						
						</div>
						<c:if test="${product.remainingStock > 0 && product.remainingStock <=5}">
							<span class="product-alert">Only <c:out value="${product.remainingStock}" /> left!</span>
						</c:if>
						
						<p class="price"><fmt:formatNumber type="currency" maxFractionDigits="2" minFractionDigits="2" value="${product.price}" /></p>
					</div>
				</div>
				
			</c:forEach>
			
			<%-- 

			<div class="tile ">
				<!-- Include this if the product is considered a Top Seller -->
				<span class="banner top-seller">Top Seller!</span>

				<!-- Link to the Detail page using the product id (e.g. products/detail?id=1) -->
				<a class="product-image" href="#"> 
					<img src="<c:url value="/images/product-images/grey-sofa.jpg" />" />
				</a>
				<div class="details">
					<p class="name">Grey Sofa</p>

					<!-- .filled will make the star solid -->
					<div class="rating">
						<span class="filled">&#9734;</span> 
						<span class="filled">&#9734;</span>
						<span class="filled">&#9734;</span> 
						<span class="filled">&#9734;</span>
						<span>&#9734;</span>
					</div>

					<!-- Include this if the remaining quantity is greater than 0, but less than or equal to 5 -->
					
					<p class="price">$939.00</p>
				</div>
			</div>

			<!-- Add the .sold-out class if the remaining quantity is 0 -->
			<div class="tile sold-out">
				<!-- Include this if the remaining quantity is 0 -->
				<span class="banner">Sold Out</span>

				<!-- Link to the Detail page using the product id (e.g. products/detail?id=1) -->
				<a class="product-image" href="#"> 
					<img src="<c:url value="/images/product-images/grey-sofa.jpg" />" />
				</a>
				<div class="details">
					<p class="name">Grey Sofa</p>

					<!-- .filled will make the star solid -->
					<div class="rating">
						<span class="filled">&#9734;</span> 
						<span>&#9734;</span> 
						<span>&#9734;</span>
						<span>&#9734;</span> 
						<span>&#9734;</span>
					</div>

					<p class="price">$939.00</p>
				</div>
			</div>
			--%>
		</div>
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />