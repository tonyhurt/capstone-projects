<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

		<h1>Hello <c:out value="${user.name}" /></h1>
		

	<form action="<c:url value="/save" />" method="POST">
	
		<div>
			<label for="name">Name:</label>
			<input type="text" name="name" />
		</div>
		<div>
			<label for="description">Description:</label>
			<input type="text" name="description" />
		</div>
		<div>
			<label for="startDate">Start Date:</label>
			<input type="date" name="startDate" />
		</div>
		<div>
			<label for="endDate">End Date:</label>
			<input type="date" name="endDate" />
		</div>
		<div>
			<label for="miles">Miles:</label>
			<input type="number" name="miles" />
		</div>
		<div>
			<label for="type">Type:</label>
			<input type="text" name="type" />
		</div>
		<div>
			<input type="submit" value="Add Trip" />
		</div>
	</form>
		
<c:import url="/WEB-INF/jsp/common/footer.jsp" />

