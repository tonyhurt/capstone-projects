<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="common/header.jsp">
	<c:param name="title" value="Fibonacci"></c:param>
</c:import>

<nav id="page-options">
	<ul>
		<c:set var="numberOfItems" value="20" />
		<c:url var="fibonacciRoute" value="fibonacci.jsp">
			<c:param value="${ numberOfItems }" name="max" />
		</c:url>
		<li>
			<a href="<c:out value="${ fibonacciRoute }" />"><c:out value="${ numberOfItems }" /></a>
		</li>

		<c:set var="numberOfItems" value="50" />
		<c:url var="fibonacciRoute" value="fibonacci.jsp">
			<c:param value="${ numberOfItems }" name="max" />
		</c:url>
		<li>
			<a href="<c:out value="${ fibonacciRoute }" />"><c:out value="${ numberOfItems }" /></a>
		</li>

		<c:set var="numberOfItems" value="100" />
		<c:url var="fibonacciRoute" value="fibonacci.jsp">
			<c:param value="${ numberOfItems }" name="max" />
		</c:url>
		<li>
			<a href="<c:out value="${ fibonacciRoute }" />"><c:out value="${ numberOfItems }" /></a>
		</li>
	</ul>
</nav>

<ul id="fibonacci">
 <c:set var="fibonacciOne" value="0" />
  <c:set var="fibonacciTwo" value="1" />
   
   <c:forEach begin="1" end="${param.max}" var="i">
   <c:set var="fibonacciThree" value="${fibonacciOne + fibonacciTwo}" />
   <c:if test="${fibonacciThree < param.max}">
   <li>${fibonacciThree}</li>
   <c:set var="fibonacciOne" value="${fibonacciTwo}" />
    <c:set var="fibonacciTwo" value="${fibonacciThree}"/>
    </c:if>
    </c:forEach>
</ul>

<c:import url="common/footer.jsp"></c:import>