document.addEventListener('DOMContentLoaded', () => {
	
	const searchForm = document.querySelector('form');
	
	searchForm.addEventListener('submit', event => {
		
		const name = document.querySelector("input[name='name']").value;
		
		console.log(name + " submitted");
		
		loadActors(name);
		
		event.preventDefault();
	});
	
});

function loadActors(name) {
	
	fetch("http://localhost:8080/api-review-actor-search-final/api/actor?name=" + name)
		.then (response => {
			return response.json();
		})
		.then ( actors => {
			addActorsToPage(actors);
		})
		.catch( err => console.error(err) );
	
}

function addActorsToPage(actors) {
	
	const table = document.querySelector('table');
	
	// Need to delete everything but the header before adding new rows
	// This code only works for 1 entry
	for (let i = 1; i < table.rows.length; i++) {
		table.deleteRow(i);
	}
	
	actors.forEach( actor => {
		let row = table.insertRow(-1);
		let cell = row.insertCell(0);
		cell.innerText = `${actor.firstName} ${actor.lastName}`;
	});
	
}