<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Name List Example</title>
	</head>
	<body>
		<ol>
			<c:forEach var="name" items="${requestScope.nameList}">
				<li>${name}</li>
			</c:forEach>
		</ol>	
		
		<h2>${nameList[2]}</h2>
		
		<h2>A herd of crows is a ${herds.Crow}</h2>
		
		<ul>
			<c:forEach var="herdEntry" items="${herds}">
				<li>A herd of ${herdEntry.key} is called ${herdEntry.value}</li>
			</c:forEach>
		</ul>
	</body>
</html>