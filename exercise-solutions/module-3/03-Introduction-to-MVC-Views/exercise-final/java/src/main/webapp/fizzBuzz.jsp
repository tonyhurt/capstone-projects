<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="common/header.jsp">
	<c:param name="title" value="FizzBuzz"></c:param>
</c:import>

<nav id="page-options">
	<ul>
		<c:set var="numberOfItems" value="20" />
		<c:url var="fizzBuzzRoute" value="fizzBuzz.jsp">
			<c:param value="${ numberOfItems }" name="number" />
		</c:url>
		<li><a href="<c:out value="${ fizzBuzzRoute }" />"><c:out value="${ numberOfItems }" /></a></li>

		<c:set var="numberOfItems" value="50" />
		<c:url var="fizzBuzzRoute" value="fizzBuzz.jsp">
			<c:param value="${ numberOfItems }" name="number" />
		</c:url>
		<li><a href="<c:out value="${ fizzBuzzRoute }" />"><c:out value="${ numberOfItems }" /></a></li>

		<c:set var="numberOfItems" value="100" />
		<c:url var="fizzBuzzRoute" value="fizzBuzz.jsp">
			<c:param value="${ numberOfItems }" name="number" />
		</c:url>
		<li><a href="<c:out value="${ fizzBuzzRoute }" />"><c:out value="${ numberOfItems }" /></a></li>
	</ul>
</nav>

<ul id="fizzbuzz">
	<c:forEach begin="1" end="${ param.number }" var="number">
		<c:choose>
			<c:when test="${ number % 3 == 0 && number % 5 == 0 }">
				<li class="fizzbuzz">FizzBuzz!</li>
			</c:when>
			<c:when test="${ number % 3 == 0 }">
				<li class="fizz">Fizz!</li>
			</c:when>
			<c:when test="${ number % 5 == 0 }">
				<li class="buzz">Buzz!</li>
			</c:when>
			<c:otherwise>
				<li>${ number }</li>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</ul>

<c:import url="common/footer.jsp"></c:import>