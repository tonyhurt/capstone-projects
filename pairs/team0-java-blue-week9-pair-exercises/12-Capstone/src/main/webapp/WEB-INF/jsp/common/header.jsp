<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>National Park Geek</title>
    <c:url value="/css/site.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>

<body>
    <header>
    		<c:url value="/" var="homePageHref" />
    		<c:url value="/survey" var="surveyPageHref" />
    		<c:url value="/favoriteParks" var="favoriteParksPageHref" />
    		<c:url value="/img/logo.png" var="logoSrc" />
        <a href="${homePageHref}">
        		<img src="${logoSrc}" alt="National Park Geek Logo" />
        </a>
        <h2>Explore The National Parks</h2>
        <p> Use this web application to learn more about our national parks! </p>
        
    </header>
        <nav>
        <ul>
        
            <li><a href="${homePageHref}">Home</a></li>
            <li><a href="${surveyPageHref}">Survey</a></li>   
            <li><a href="${favoriteParksPageHref}">Favorite Parks</a></li>             
                      
        </ul>
        </nav>
