<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<h1>Step three: What is the population?</h1>
	
	<form action="<c:url value="/addCity/stepThree" />" method="POST">
		<input type="number" name="population" />
		<input type="submit" value="Confirm >>" />
	</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />