<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- <c:import url="/WEB-INF/jsp/common/header.jsp" />
 --%>
<h1>What is your favourite colour?</h1>

<form action="<c:url value="/greetingOne" />" method="POST">
    <input type="text" name="colour" />
    <input type="submit" value="Next >>" />
</form>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />