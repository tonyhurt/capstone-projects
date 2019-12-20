<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>What is your favourite food?</h1>

<form action="<c:url value="/greetingTwo" />" method="POST">
    <input type="text" name="food" />
    <input type="submit" value="Next >>" />
</form>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />