/*
* Add Events and functions to move the Ship and Win the game
*/

document.addEventListener('DOMContentLoaded', () => {
    // Creates the Grid -- this should only occur after the DOM loads
    createGrid();

    document.querySelector('body').addEventListener('keyup', (event) => {

        if (event.key === 'ArrowRight') {
            moveShipRight();
        }
        if (event.key === 'ArrowLeft') {
            moveShipLeft();
        }
        if (event.key === 'ArrowDown') {
            moveShipDown();
        }
        if (event.key === 'ArrowUp') {
            moveShipUp();
        }


    });

    document.getElementById('resetButton').addEventListener('click', (event) => {
        resetGame();
        event.preventDefault();
    });

});

function moveShipRight() {
    const ship = getShipLocation();
    const right = ship.nextElementSibling;
    moveShip(ship, right);
}

function moveShipLeft() {
    const ship = getShipLocation();
    const left = ship.previousElementSibling;
    moveShip(ship, left);
}

function moveShipDown() {
    const ship = getShipLocation();
    const down = getUpperOrLowerElementAtIndex(ship, ship.parentElement.nextElementSibling);
    moveShip(ship, down);
}

function moveShipUp() {
    const ship = getShipLocation();
    const up = getUpperOrLowerElementAtIndex(ship, ship.parentElement.previousElementSibling);
    moveShip(ship, up);
}

function moveShip(ship, newPos) {
    if (canMoveToElement(newPos)) {
        if (isWin(newPos)) {
            win();
        } else {
            ship.classList.remove('boat');
            newPos.classList.add('boat');
        }
    }
}

function canMoveToElement(element) {
    if (element == null || element.classList.contains('pirate')) {
        return false;
    }
    return true;
}

function isWin(nextElement) {
    return nextElement.classList.contains('treasure'); 
}

function win() {
    const announce = document.querySelector('.announce');
    announce.classList.add('winText');
    announce.innerText = "You Win!";
    getShipLocation().classList.remove('boat');
}

function getUpperOrLowerElementAtIndex(ship, newElement) {
    let elementAtIndex = null;
    if (newElement != null) {
        const index = Array.from(ship.parentNode.children).indexOf(ship);
        elementAtIndex = newElement.childNodes[index];
    }

    return elementAtIndex;
}

function getShipLocation() {
    return document.getElementById('frame').querySelector('.boat');
}


/**
 * Reset the Game
 */
function resetGame() {

    const ship = getShipLocation();
    if (ship != null) {
        ship.classList.remove('boat');
    }

    // Inform the user they can start
    const announce = document.querySelector('.announce');
    if (announce.classList.contains('winText')) {
        announce.classList.remove('winText');
    }
    announce.innerText = "Play!";

    const frame = document.getElementById('frame');

    // Set the starting location of the boat 
    frame.firstElementChild.firstElementChild.classList.add('boat');

    // Set the starting location of the treasure
    const lastPosition = frame.lastElementChild.lastElementChild;
    if (lastPosition.classList.contains('pirate')) {
        lastPosition.classList.remove('pirate');
    }
    lastPosition.classList.add('treasure');

}

/**
 * Creates the game grid
 */
function createGrid() {

    const frame = document.getElementById('frame');

    // Add Code to create the game grid
    for (let i = 0; i < 10 ; i++) {
        buildRow(frame); 
    }
    resetGame();
}

/**
 * Builds the grid rows
 * @param {element} frame 
 */
function buildRow(frame) {
    const row = document.createElement('div');
    row.classList.add('row');
    frame.insertAdjacentElement('beforeend', row);
   // Add code to create rows
    for (let i = 0; i < 10 ; i++) {
        buildSquare(row, i); 
    }    
}

/**
 * Builds the grid squares 
 * @param {element} row 
 * @param {int} count 
 */
function buildSquare(row, count) {
   // Add code to create the grid Squares
    const container = document.createElement('div');
    container.classList.add('square');
    // Randomly creates pirates, but not on the first elemment
    if (count > 1) {
        if ((Math.floor(Math.random() * 100) + 1) > 85) {
            // Add the pirates here
            container.classList.add('pirate');
        } 
    }

    row.insertAdjacentElement('beforeend', container);
    
}



