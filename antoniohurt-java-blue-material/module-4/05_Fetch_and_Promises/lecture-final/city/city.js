document.addEventListener('DOMContentLoaded', ()  => {
    loadCities();
});

function loadCities() {

    fetch('city.json')
        .then( response => {
            return response.json();
        })
        .then( data => {
            displayCities(data);
        })
        .catch ( error => {
            console.error(error);
        });

}

function displayCities(cities) {
    console.log("Display Cities.... ");

    if ('content' in document.createElement('template')) {

        const container = document.getElementById('cities');

        cities.forEach( city => {

            const tmpl = document.getElementById('city-template').content.cloneNode(true);
            tmpl.querySelector('h2').innerText = city.name;
            tmpl.querySelector('.location').innerText = `${city.district}, ${city.countryCode}`;
            tmpl.querySelector('.population').innerText = city.population;

            container.appendChild(tmpl);
        });

    } else {
        console.error("Templates not supported");
    }
}