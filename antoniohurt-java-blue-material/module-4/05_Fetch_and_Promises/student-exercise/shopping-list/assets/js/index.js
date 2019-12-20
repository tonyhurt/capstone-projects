

function shoppingList() {

    fetch('assets/data/shopping-list.json')
        .then( response => {
            return response.json();
        })
        .then( data => {
            displayShoppingList(data);
        })
        .catch ( error => {
            console.error(error);
        })
    }

    function displayShoppingList(groceries) {
        console.log("Display Shopping List...");

        if(`content` in document.createElement(`template`)) {

            const container = document.querySelector('ul');

            groceries.forEach( list => {

                const tmpl = document.getElementById('shopping-list-item-template').content.cloneNode(true);
                tmpl.querySelector("li").insertAdjacentHTML('afterbegin',list.name);
                if( list.completed ) {
                    const circleCheck = tmpl.querySelector('.fa-check-circle');
                    const currentClass = circleCheck.className;
                    circleCheck.className = currentClass + " completed";
                  }
                container.appendChild(tmpl);
            });

        }else{
            console.error("Template not supported");
        }
    }

    
   
    const button = document.querySelector(".loadingButton");
    button.addEventListener("click",function() {
    shoppingList();
    button.disabled = true;
    });