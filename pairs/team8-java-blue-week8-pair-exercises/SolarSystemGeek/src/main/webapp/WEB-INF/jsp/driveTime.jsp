<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="calculator">
	<h1>Alien Travel Calculator</h1>
	
	<form action="<c:url value="/driveTimeResults" />" method="GET">
	<div class="choosePlanet">
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
			<label for="transportation">Choose a mode of transportation:</label> <select
				name="transportation">
				<option value="walking">Walking</option>
				<option value="car">Car</option>
				<option value="bulletTrain">Bullet Train</option>
				<option value="boeing747">Boeing 747</option>
				<option value="concorde">Concorde</option>
			</select>
		</div>
		<div>
			<label for="name">Enter your Earth age:</label> 
			<input type="text" name="userAge" />
		</div>
		<div>
			<button type="submit">Calculate travel time</button>
		</div>
	</form>
	
	</div>
</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />