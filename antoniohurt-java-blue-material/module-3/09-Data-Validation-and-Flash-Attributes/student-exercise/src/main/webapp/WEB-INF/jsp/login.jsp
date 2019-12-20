<c:set var="pageTitle" value="Home Page"/>
<%@include file="common/header.jspf" %>

<h2>Login</h2>

<form:form action="login" method="POST" modelAttribute="login">

<label for="email">Email</label>
<form:form action="email" placeholder="please enter your email:">
<form: errors path="email"/>

<label for="password">Password</label>
<input type=text name="password" placeholder="please enter your password:"/>
<br>

<button type="submit">Submit</button>
</form></form:form></form:form>

<%@include file="common/footer.jspf" %>

