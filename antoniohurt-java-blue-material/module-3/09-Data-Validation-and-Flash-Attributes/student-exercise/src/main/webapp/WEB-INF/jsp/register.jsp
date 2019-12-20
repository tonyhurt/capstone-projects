<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form %>

<c:set var="pageTitle" value="Home Page"/>

<%@include file="common/header.jspf" %>

<h2>Register</h2>

<c:url var="register" value="/register" />

<form:form 

<%@include file="common/footer.jspf" %>