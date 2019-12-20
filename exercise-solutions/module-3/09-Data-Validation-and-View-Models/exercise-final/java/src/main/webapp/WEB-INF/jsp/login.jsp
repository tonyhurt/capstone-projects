<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Login"/>
<%@include file="common/header.jspf" %>

<h2>Login</h2>

<c:url value="/login" var="loginFormUrl"/>
<form:form modelAttribute="login" action="${loginFormUrl }" method="POST">

		<div class="form-group">
        		<form:label path="email">Email</form:label>
        		<form:input path="email" class="form-control"/>
        		<form:errors path="email" cssClass="error"/>
        		
        </div>
		<div class="form-group">
        		<form:label path="password">Password</form:label>
        		<form:password path="password" class="form-control"/>
        		<form:errors path="password" cssClass="error"/>
        		
        </div>
        
        <input type="submit" value="Login" class="btn btn-primary"/>

</form:form>

<%@include file="common/footer.jspf" %>