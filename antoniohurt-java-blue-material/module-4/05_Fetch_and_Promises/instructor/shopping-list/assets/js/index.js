document.addEventListener('DOMContentLoaded', () => {
    document.querySelector('.loadingButton').addEventListener('click', () => {

        fetch('assets/data/shopping-list.json')
            .then( response => {
                return response.json();
            })
            .then( data => {
                buildList(data);
            })
            .catch( err => console.error(err) );

        
    });
});

function buildList(items) {
    console.log("Build List...");

    if ('content' in document.createElement('template')) {
        const container = document.querySelector('ul');

        items.forEach( item => {
            const tmpl = document.getElementById('shopping-list-item-template').content.cloneNode(true);
            tmpl.querySelector('li').insertAdjacentText('afterbegin', item.name);
            
            if (item.completed) {
                tmpl.querySelector('li').classList.add('completed');
            }

            container.appendChild(tmpl);
        });

    } else {
        console.error("You need a better browser");
    }
}