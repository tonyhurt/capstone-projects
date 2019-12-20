


document.addEventListener('DOMContentLoaded', () => {
    
   const parkCode = getParkCodeFromURL();
   let weatherScale = determineWeatherScale();

   setScaleChangeLink(weatherScale);
   fetchPark(parkCode);
   fetchParkWeather(parkCode, weatherScale);

    const scaleSwitch = document.querySelector('.scaleSwitch').querySelector('a');
    scaleSwitch.addEventListener('click', (event) => {
        weatherScale = weatherScale.toUpperCase() === 'F' ? 'C' : 'F';
        setScaleChangeLink(weatherScale);
        setStoredWeatherScale(weatherScale);
 
        fetchParkWeather(parkCode, weatherScale);

        event.preventDefault();
    });
});




function fetchPark(parkCode) {

    fetch(`http://localhost:8080/api-npgeek-review/api/park/${parkCode.toUpperCase()}`)
        .then( response => { 
            return response.json();
        })
        .then( data => {
            displayPark(data);
        })
        .catch( err => console.error(err) )

}

function fetchParkWeather(parkCode, scale) {

    fetch(`http://localhost:8080/api-npgeek-review/api/park/${parkCode.toUpperCase()}/weather/${scale}`)
        .then (response => {
            return response.json();
        })
        .then( data => {
            displayWeather(data);
        })
        .catch( err => console.error(err) )

}

function setScaleChangeLink(ws) {

    document.querySelector('.scaleSwitch').querySelector('span').innerText = `Show in ${ws === 'C' ? 'Fahrenheit' : 'Celsius'}`;
}


function displayWeather(weather) {
    //console.table(weather);

    if ('content' in document.createElement('template')) {

        const container = document.querySelector('.parkWeatherMain');
        
        // Remove all the previous weather elements
        const days = container.querySelectorAll('.day');
        days.forEach( d => {
            d.parentElement.removeChild(d);
        });

        weather.dailyWeather.forEach( (day, index) => {

            const tmpl = document.getElementById('weather-template')
                .content.cloneNode(true);

            const dayClass = index === 0 ? 'weatherToday' : 'weatherDay';
            tmpl.querySelector('.weatherDisplay').classList.add(dayClass);
            tmpl.querySelector('.weatherDisplay').classList.add('day');

            tmpl.querySelector('h3').innerText = day.dayName;

            const weatherImgUrl = `./img/weather/${day.forecast.replace(/\s/g,'')}.png`;
            tmpl.querySelector('img').src = weatherImgUrl;
            
            tmpl.querySelector('h4').innerText = day.forecast;

            tmpl.querySelector('.tempHigh').querySelector('div:nth-child(2)').innerText = day.highWithScale;
            tmpl.querySelector('.tempLow').querySelector('div:nth-child(2)').innerText = day.lowWithScale;
            
            const ul = tmpl.querySelector('ul');
            day.warnings.forEach( warning => {
                const li = document.createElement('li');
                li.innerText = warning;
                ul.appendChild(li);
            });
            
            container.appendChild(tmpl);
        });


    } else {
        console.error("You need a better browser!");
    }
}


function displayPark(park) {
    //console.table(park);

    const parkImgName = `img/parks/${park.parkCode.toLowerCase()}.jpg`;

    document.querySelector('.parkDetailImage').setAttribute('style', `background-image: url(${parkImgName});`);
    document.querySelector('.quote').insertAdjacentText('afterbegin', `"${park.inspirationalQuote}"`);
    document.querySelector('.quoteSource').innerText = park.inspirationalQuoteSource;

    document.querySelector('.ParkDescription').insertAdjacentText('afterbegin', park.parkDescription);
    document.querySelector('.Name').innerText = park.parkName;
    document.querySelector('.State').innerText = park.state;
    document.querySelector('.Founded').innerText = `Founded ${park.yearFounded}`;

    document.querySelector('.CampSitesCount').innerText = park.numberOfCampsites;
    document.querySelector('.VisitorCount').innerText = park.annualVisitorCount;
    
    let fee = 'Free';
    if (park.entryFee != 0) {
        fee = `$${park.entryFee}`
    }
    document.querySelector('.EntryFee').innerText = fee;

    document.querySelector('.Climate').innerText = park.climate;
    document.querySelector('.Acerage').innerText = park.acreage;
    document.querySelector('.milesOfTrails').innerText = park.milesOfTrail;
    document.querySelector('.elevation').innerText = `${park.elevationInFeet}ft`;
    document.querySelector('.animalsCount').innerText = park.numberOfAnimalSpecies;
    

}


function getParkCodeFromURL() {
    const url = new URL(window.location.href);
    return url.searchParams.get('parkCode');
}

function determineWeatherScale() {
    let urlScale = getWeatherScaleFromURL();
    if (urlScale) {
        urlScale = (urlScale.toUpperCase() != 'C' && urlScale.toUpperCase() != 'F') ? 'F' : urlScale;
        setStoredWeatherScale(urlScale);
    }
    const storedScale = getStoredWeatherScale();
    return (!storedScale) ? 'F' : storedScale;

}

function getWeatherScaleFromURL() {
    const url = new URL(window.location.href);
    return url.searchParams.get('t');
}

function getStoredWeatherScale() {

    if (typeof(Storage) !== "undefined") {
        return localStorage.tempscale;
      } else {
        console.error("Local Storage is not available");
        return null;
      }
}

function setStoredWeatherScale(scale){

    if (typeof(Storage) !== "undefined") {
        localStorage.tempscale = scale;
      } else {
        console.error("Local Storage is not available");
      }
}