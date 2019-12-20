<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Customers List"/>


<%@include file="common/header.jspf"%>

<form action="<c:url value="/customerList"/>" method="GET">
			<input type="text" name="lastName" />
			<input type="submit" value="Search" />
			
			<div class="formInput">
        <label for="search"> Customer Name :</label> 
        <input type="text" name="search" id="search" />
    </div>
    
	<div class="formInput">
		<label for="sort"> Choose sort method: </label> 
		<select name="sort" id="sort">
			<option value="last_name"> Last Name </option>
			<option value="email"> Email </option>
			<option value="activebool"> Active </option>
		</select>
	</div>
			</form>
<table class="table">
<td>Name</td>
<td>Email</td>
<td>Active</td>
<c:forEach items="${listOfCustomers}" var="customer">
<tr>
    <td>${customer.firstName } ${customer.lastName } ${customer.email } ${customer.active }</td>
</tr>
</c:forEach>
</table> 

<%@include file="common/footer.jspf"%>