<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<h1>If you weigh ${ param.userWeight } kg on planet Earth, then you weigh ${ newWeight } kg on ${ param.planets }</h1>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />