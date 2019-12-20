let reviews = [];

/**
 * This function when invoked will look at an array of reviews
 * and add it to the page by cloning the #review-template
 */
function displayReviews() {
    console.log("Display Reviews...");
    
    // first check to make sure the browsers supports templates
    if ('content' in document.createElement('template')) {
        // query the document for .reviews and put it in a variable called container
        const container = document.querySelector('.reviews');
        // loop over the reviews array
        reviews.forEach( (review) => {
            // get the template, clone it, find all the elements and assign data to them
            const tmpl = document.getElementById('review-template').content.cloneNode(true);
            tmpl.querySelector('img').setAttribute('src', review.avatar);
            tmpl.querySelector('.username').innerText = review.username;
            tmpl.querySelector('h2').innerText = review.title;
            tmpl.querySelector('.published-date').innerText = review.publishedOn;
            tmpl.querySelector('.user-review').innerText = review.review;

            // append the template to the DOM
            container.appendChild(tmpl);
        });

    } else {
        console.error("You need a better browser!");
    }
}

function loadReviews() {
    console.log("Load Reviews...");

    // Remote API URL
    //fetch('http://5dd69774ce4c300014403ae7.mockapi.io/productdata')

    // Local File URL
    fetch('data.json')
        .then( (response) => {
            return response.json();
        })
        .then( (data) => {
            reviews = data;
            displayReviews();
        })
        .catch( (err) => {
            console.error(err);
        });

}

document.addEventListener('DOMContentLoaded', () => {
    const button = document.querySelector('button');
    button.addEventListener('click', () => {
        loadReviews();
        button.disabled = true;
    });
});