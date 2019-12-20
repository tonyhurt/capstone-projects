<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h1>Path on Server</h1>
<h3>${message}</h3>

<br />
<br />
<h1>Image</h1>

<%--
	To display the file use the the route mapped in the springmvc-servlet.xml, in this case /images/ with the 
	name of the image that should be loaded.  In this case it is original filename returned by the controller.
	In most projects this will be a generated name that was retrieved from the database.  
 --%>
<img src="<c:url value="/images/${imgFileName}" />" />



<c:import url="/WEB-INF/jsp/common/footer.jsp" />