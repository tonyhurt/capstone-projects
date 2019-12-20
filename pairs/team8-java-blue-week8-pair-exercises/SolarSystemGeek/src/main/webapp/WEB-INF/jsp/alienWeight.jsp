<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="calculator">

	<h1>Alien Weight Calculator</h1>

	<form action="<c:url value="/alienWeightResults" />" method="GET">
		<div>
			<label for="planets">Choose a planet:</label> 
				<select name="planets">
					<option value="mercury">Mercury</option>
					<option value="venus">Venus</option>
					<option value="earth">Earth</option>
					<option value="mars">Mars</option>
					<option value="jupiter">Jupiter</option>
					<option value="saturn">Saturn</option>
					<option value="uranus">Uranus</option>
					<option value="neptune">Neptune</option>
					<option value="pluto">Pluto</option>
				</select>
		</div>
		
		<div>
			<label for="name">Enter your Earth weight:</label> 
				<input type="text" name="userWeight" />
		</div>
		
		<div>
			<button type="submit">Calculate weight</button>
		</div>

	</form>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />