<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1>What is your favourite season?</h1>

<form action="<c:url value="/greetingThree" />" method="POST">
    <input type="text" name="season" />
    <input type="submit" value="Next >>" />
</form>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />