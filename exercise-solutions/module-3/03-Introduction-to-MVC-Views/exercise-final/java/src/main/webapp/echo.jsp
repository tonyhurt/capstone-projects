<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="common/header.jsp">
	<c:param name="title" value="Echo"></c:param>
</c:import>

<nav id="page-options">
	<ul>
		<c:set var="routeCount" value="10" />
		<c:set var="routeWord" value="Echo" />
		<c:url var="echoRoute" value="echo.jsp">
			<c:param value="${ routeCount }" name="count" />
			<c:param value="${ routeWord }" name="word" />
		</c:url>
		<li>
			<a href="<c:out value="${ echoRoute }" />">${ routeWord } ${ routeCount }</a>
		</li>

		<c:set var="routeCount" value="20" />
		<c:set var="routeWord" value="Hello!" />
		<c:url var="echoRoute" value="echo.jsp">
			<c:param value="${ routeCount }" name="count" />
			<c:param value="${ routeWord }" name="word" />
		</c:url>
		<li>
			<a href="<c:out value="${ echoRoute }" />">${ routeWord } ${ routeCount }</a>
		</li>

		<c:set var="routeCount" value="50" />
		<c:set var="routeWord" value="Goodbye!" />
		<c:url var="echoRoute" value="echo.jsp">
			<c:param value="${ routeCount }" name="count" />
			<c:param value="${ routeWord }" name="word" />
		</c:url>
		<li>
			<a href="<c:out value="${ echoRoute }" />">${ routeWord } ${ routeCount }</a>
		</li>
	</ul>
</nav>

<ul>
	<c:set var="word" value="${ param.word }"/>
	<c:set var="font_start" value="${ param.count }"/>
	<c:forEach begin="0" end="${ font_start }" var="font_size">
		<li style="font-size:${ font_start - font_size }px">${ word }</li>
	</c:forEach>
</ul>

<c:import url="common/footer.jsp"></c:import>