<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<h1>If you are ${ param.userAge } years old on planet Earth, then you are ${ newAge } on ${ param.planets }</h1>
		<ol>
			<c:forEach items="${cityList }" var="city">
				<li>${ city.name }</li>
			</c:forEach>
		</ol>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />