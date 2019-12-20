<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<h1>New Geek Post</h1>

<form action="<c:url value="/postToSpaceForum" />" method="POST">


	<label for="username">Username</label> <input type="text"
		name="username" /> <label for="subject">Subject</label> <input
		type="text" name="subject" /> <label for="message">Message</label> <input
		type="text" name="message" />

	<button type="submit">Submit</button>

</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />