<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Login"/>
<%@include file="common/header.jspf" %>

<h2>Login</h2>

<c:url value="/register" var="registerFormUrl"/>
<form:form modelAttribute="registration" action="${registerFormUrl }" method="POST">

		<div class="form-group">
        		<form:label path="firstName">First Name</form:label>
        		<form:input path="firstName" class="form-control"/>
        		<form:errors path="firstName" cssClass="error"/>
        		
        </div>
        <div class="form-group">
        		<form:label path="lastName">Last Name</form:label>
        		<form:input path="lastName" class="form-control"/>
        		<form:errors path="lastName" cssClass="error"/>
        		
        </div>
		<div class="form-group">
        		<form:label path="email">Email</form:label>
        		<form:input path="email" class="form-control"/>
        		<form:errors path="email" cssClass="error"/>
        		
        </div>
        <div class="form-group">
        		<form:label path="confirmEmail">Confirm Email</form:label>
        		<form:input path="confirmEmail" class="form-control"/>
        		<form:errors path="emailMatching" cssClass="error"/>
        		
        </div>
		<div class="form-group">
        		<form:label path="password">Password</form:label>
        		<form:password path="password" class="form-control"/>
        		<form:errors path="password" cssClass="error"/>
        		
        </div>
        <div class="form-group">
        		<form:label path="confirmPassword">Confirm Password</form:label>
        		<form:password path="confirmPassword" class="form-control"/>
        		<form:errors path="passwordMatching" cssClass="error"/>
        		
        </div>
        
        <div class="form-group">
        		<form:label path="birthDate">Birth Date (YYYY-MM-DD format)</form:label>
        		<form:input path="birthDate" class="form-control"/>
        		<form:errors path="birthDate" cssClass="error"/>
        		
        </div>
        
        <div class="form-group">
        		<form:label path="numOfTickets">Number of Tickets</form:label>
        		<form:input type="number" path="numOfTickets" class="form-control"/>
        		<form:errors path="numOfTickets" cssClass="error"/>
        		
        </div>
        
        <input type="submit" value="Register" class="btn btn-primary"/>

</form:form>

<%@include file="common/footer.jspf" %>