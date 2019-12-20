<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<%--
	The upload form uses a standard HTML form for POST, but must have the 
	enctype set to multipart/form-data
	
	The field that uploads the file should be a HTML input type of "file"
 --%>
 <form method="POST" action="uploadFile" enctype="multipart/form-data">
    File to upload: <input type="file" name="file" ><br />
    <input type="submit" value="Upload">
</form>
<c:if test="${not empty message}">
    ${message} 
</c:if>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />