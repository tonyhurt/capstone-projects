const API_URL = 'http://localhost:8080/api-npgeek-review/api/survey';

document.addEventListener('DOMContentLoaded', () => {

    document.querySelector('form').addEventListener('submit', (event) => {
        event.preventDefault();
        handleFormSubmit();
    });

});

function handleFormSubmit() {

    clearErrors();

    if (validateForm()) {
        const survey = {};

        survey.parkCode = document.getElementById('parkCode').value;
        survey.emailAddress =  document.getElementById('emailAddress').value;
        survey.state = document.getElementById('state').value;
        survey.acivityLevel = document.querySelectorAll("input[name=acivityLevel]:checked")[0].value;

        saveSurvey(survey);
    }

}


function saveSurvey(survey) {
    
    const apiUrl = 'http://localhost:8080/api-npgeek-review/api/survey';

    fetch(apiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(survey)
    })
    .then( response => {
        if (response.ok) {
            window.location.href = 'surveyResults.html';
        } else {
            console.error(`Post failed ${response}`);
        }
    })
    .catch( err => { console.error(err) });

}


function validateForm() {

    let valid = true;
    const errorList = [];

    const parkCode = document.getElementById('parkCode').value;
    const emailAddress =  document.getElementById('emailAddress').value;
    const state = document.getElementById('state').value;
    const acivityLevel = document.querySelectorAll("input[name=acivityLevel]:checked")[0];

    if (!parkCode) {
        errorList.push("Please select a Park");
        valid = false;
    }

    if (!emailAddress) {
        errorList.push("Missing email address");
        valid = false;
    }

    if (!state) {
        errorList.push("Please select a State");
        valid = false;
    }

    if (!acivityLevel) {
        errorList.push("Please select an Activity Level");
        valid = false;
    }

    if (!valid) {
        showErrors(errorList);
    }

    return valid;

}

function showErrors(errorList) {
    const errorUl = document.querySelector('.errors').querySelector('ul');

    errorList.forEach( err => {
        const li = document.createElement('li');
        li.innerText = err;
        li.classList.add('validationError');
        errorUl.appendChild(li);
    });

}

function clearErrors() {
    Array.from(document.querySelector('.errors').querySelector('ul').children).forEach( li => {
        li.parentElement.removeChild(li);
    })
}