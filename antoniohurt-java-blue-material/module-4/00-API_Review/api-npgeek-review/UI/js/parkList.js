

document.addEventListener('DOMContentLoaded', () => {
    
    fetchParks();

});

function fetchParks() {

    fetch('http://localhost:8080/api-npgeek-review/api/park')
        .then( response => {
            return response.json();
        })
        .then( data => {
            showParks(data);
        })
        .catch( err => console.error(err) );

}

function showParks(parks) {

    if ('content' in document.createElement('template')) {

        const container = document.getElementById('main');

        parks.forEach( park => {

            const tmpl = document.getElementById('park-info-template')
                .content.cloneNode(true);

            const parkDetailUrl = `/parkDetail.html?parkCode=${park.parkCode}`;
            const parkImgName = `./img/parks/${park.parkCode.toLowerCase()}.jpg`;
            tmpl.querySelector('img').src = parkImgName;

            tmpl.querySelectorAll('a').forEach( link => {
                link.setAttribute('href', parkDetailUrl);
            })

            tmpl.querySelector('h1').querySelector('a').innerText = park.parkName;
            tmpl.querySelector('h4').innerText = park.state;
            tmpl.querySelector('p').innerText = park.parkDescription;
            
            container.appendChild(tmpl);
        });


    } else {
        console.error("You need a better browser!");
    }

}