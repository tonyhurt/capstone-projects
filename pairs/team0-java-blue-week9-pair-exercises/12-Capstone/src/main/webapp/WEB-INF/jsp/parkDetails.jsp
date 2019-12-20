<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h2 id="details-title"> ${ parks.parkName} - ${ parks.state} </h2>

<div id="park-details">
<div id="image-and-quote">
<img 
src =" <c:url value="/img/parks/${parks.parkCode}.jpg"/>">

<p id="quote"> "${ parks.inspirationalQuote}"</p>
<p id="quote-author"> - ${ parks.quoteSource}</p>
</div>

<div id="park-details-text">
<ul>
<li id="park-details-description"> ${ parks.parkDescription}</li>
<p></p>
<div id="park-details-list">
<li> Park acreage: ${ parks.acreage} acres</li>
<li> Elevation: ${ parks.elevation} feet</li>
<li> Total miles of trail: ${ parks.milesOfTrail} miles</li>
<li> Number of campsites: ${ parks.numberOfCampsites}</li>
<li> Climate: ${ parks.climate}</li>
<li> Year founded: ${ parks.yearFounded}</li>
<li> Number of annual visitors: ${ parks.annualVisitorCount} </li>
<li> Entry fee: $${ parks.entryFee}.00</li>
<li> Number of animal species: ${ parks.numberOfAnimalSpecies}</li>

</ul>
</div>
</div>
</div>

<p> </p>

<div id="weather">

<c:forEach items="${listOfWeather}" var="weather">
<div id="weather-details">

<img id="weather-photos"
src = "<c:url value = "/img/weather/${weather.forecast}.png"/>"> 

    <p id="temperature">${weather.high}&#8457; / ${weather.low}&#8457;</p>
    <c:if test="${weather.forecast == 'sunny' }">
    <p> Pack sun block!</p>
    </c:if>
    
    <c:if test="${weather.forecast == 'snow' }">
    <p>Pack snowshoes!</p>
    </c:if>
    
    <c:if test="${weather.forecast == 'rain' }">
    <p>Bring rain gear and waterproof shoes!</p>
    </c:if>
    
    <c:if test="${weather.forecast == 'thunderstorms' }">
    <p>Dangerous conditions. Seek shelter or avoid hiking on exposed trails.</p>
    </c:if>
    
    <c:if test="${weather.high > 75 || weather.low > 75 }">
    <p>Warm weather conditions. Pack an extra gallon of water.</p>
    </c:if>
    
    <c:if test="${weather.low < 20 || weather.high < 20 }">
    <p>Dangerous conditions. Exposed skin in low temperatures can result in frost bite.</p>
    </c:if>
    
    <c:if test="${weather.high - weather.low > 20 }">
    <p>Varying daily temperature range. Pack breathable layers.</p>
    </c:if>
    </div>
</c:forEach>
</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />