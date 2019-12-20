<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product List View" />
</c:import>

<div id="card-page">
	<c:import url="/WEB-INF/jsp/common/filters.jsp">
		<c:param name="baseRoute" value="/products" />
	</c:import>

	<div class="main-content">
		<!-- Container for Sorting Choices -->
		<div id="sorting-options">
			<h3>Sort By</h3>
			<ul>
				<li>
					<a href="/products?sortOrder=PriceLowToHigh">
						Price - Low to High
					</a>
				</li>
				<li>
					<a href="/products?sortOrder=PriceHighToLow">
						Price - High to Low</a>
					</li>
				<li>
					<a href="/products?sortOrder=RatingHighToLow">
						Rating - High to Low
					</a>
				</li>
			</ul>
		</div>

		<!-- Container for all of the Products -->
		<div id="grid">
			<c:forEach var="product" items="${products}">
				<div class="tile ${product.remainingStock == 0 ? 'sold-out' : ''}">
					<c:choose>
						<c:when test="${product.remainingStock == 0}">
							<span class="banner">Sold Out</span>
						</c:when>
						<c:when test="${product.topSeller}">
							<span class="banner top-seller">Top Seller!</span>
						</c:when>
					</c:choose>

					<c:url var="productImageUrl" value="/images/product-images/${product.imageName}" />
					<c:url var="productDetailUrl" value="/products/detail">
						<c:param name="id" value="${product.id}" />
					</c:url>
					<a class="product-image" href="${productDetailUrl}"> 
						<img src="${productImageUrl}" />
					</a>
					<div class="details">
						<p class="name">${product.name}</p>

						<!-- .filled will make the star solid -->
						<div class="rating">
							<c:forEach begin="1" end="5" var="starCount">
								<span
									class="${starCount <= product.averageRating ? 'filled' : ''}">&#9734;
								</span>
							</c:forEach>
						</div>

						<c:if test="${product.remainingStock > 0 && product.remainingStock <= 5}">
							<span class="product-alert">Only ${product.remainingStock} left!</span>
						</c:if>
						<p class="price">
							<fmt:formatNumber value="${product.price}" type="CURRENCY" />
						</p>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />