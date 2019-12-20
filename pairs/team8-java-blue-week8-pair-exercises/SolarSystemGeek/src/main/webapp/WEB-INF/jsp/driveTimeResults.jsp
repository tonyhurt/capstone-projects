<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<h1>Traveling by ${ param.transportation } you will reach ${ param.planets } in ${ newTravelTime } years. You will be ${ newAge } years old.</h1>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />