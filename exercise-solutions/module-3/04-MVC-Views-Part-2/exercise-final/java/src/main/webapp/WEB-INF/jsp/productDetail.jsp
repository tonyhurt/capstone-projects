<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product Details" />
</c:import>

<!-- Container for the Product -->
<div id="product-detail">
	<c:url var="imageUrl"
		value="/images/product-images/${product.imageName}" />
	<img class="product-image" src="${imageUrl}" />
	<div class="product-description">
		<h3>${product.name}</h3>

		<div class="rating">
			<c:forEach var="starCount" begin="1" end="5">
				<span class="${starCount <= product.averageRating ? 'filled' : ''}">&#9734;</span>
			</c:forEach>
		</div>

		<c:if
			test="${product.remainingStock > 0 && product.remainingStock <= 5}">
			<p class="alert-remaining">BUY NOW! Only
				${product.remainingStock} left!</p>
		</c:if>

		<p class="description">${product.description}</p>
		<p class="price">
			<fmt:formatNumber value="${product.price}" type="CURRENCY" />
		</p>

		<c:choose>
			<c:when test="${product.remainingStock == 0}">
				<button disabled>Sold Out</button>
			</c:when>
			<c:otherwise>
				<button class="action">Add to Cart</button>
			</c:otherwise>
		</c:choose>

	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />