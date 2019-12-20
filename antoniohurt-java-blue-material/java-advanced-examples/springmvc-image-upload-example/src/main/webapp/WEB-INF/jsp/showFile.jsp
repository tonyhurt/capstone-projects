<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h1>Path on Server</h1>
<h3>${message}</h3>

<br />
<br />
<h1>Image</h1>

<%--
	To display the file use the the route to the retrieval GET API method.   /image/ with the 
	name of the image that should be loaded.  In this case it is testImage, because that value is hardcoded
	in the controller.   In most projects this will be a generated name.  
 --%>
<c:url var="imgUrl" value="/image/testImage" />
<img src="${imgUrl}" />



<c:import url="/WEB-INF/jsp/common/footer.jsp" />