

document.addEventListener('DOMContentLoaded', () => {
    
    fetchSurveyResults();

});

function fetchSurveyResults() {


    fetch('http://localhost:8080/api-npgeek-review/api/survey')
        .then( response => {
            return response.json();
        })
        .then( data => {
            showSurveyResults(data);
        })
        .catch( err => console.error(err) );


}

function showSurveyResults(results) {

    if ('content' in document.createElement('template')) {

        const container = document.querySelector('tbody');

        results.forEach( result => {

            const tmpl = document.getElementById('survey-result-template')
                .content.cloneNode(true);

            const parkDetailUrl = `/parkDetail.html?parkCode=${result.parkCode}`;
            const parkImgName = `./img/parks/${result.parkCode.toLowerCase()}.jpg`;
            tmpl.querySelector('img').src = parkImgName;

            tmpl.querySelector('a').setAttribute('href', parkDetailUrl);
            

            tmpl.querySelector('td.parkName').innerText = result.parkName;
            tmpl.querySelector('td.votes').innerText = result.votes;
            
            container.appendChild(tmpl);
        });


    } else {
        console.error("You need a better browser!");
    }

}