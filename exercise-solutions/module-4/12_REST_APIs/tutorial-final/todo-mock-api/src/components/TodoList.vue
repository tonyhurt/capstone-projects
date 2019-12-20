<template>
  <div class="todo-list">
    <header>
      <h1>My Daily Routine</h1>
      <button v-on:click="toggleForm">Add Todo <i class="fas fa-plus"></i></button>
    </header>
    <ul>
      <li v-show="showTodoForm">
        <input type="text" class="new-todo" v-model="newTodo" placeholder="Add New Todo" v-on:keyup.enter="addTodo">
      </li>
      <li
        v-for="todo in todos"
        v-bind:key="todo.id"
        v-bind:class="{'todo-completed': todo.completed}"
        v-on:click="changeStatus(todo.id, $event)">
        <input type="checkbox">
        {{todo.task}}
        <i class="far fa-check-circle" v-bind:class="{completed: todo.completed}"></i>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      apiURL: "http://5c53257da659410014eeea10.mockapi.io/api/todos",
      todos: [],
      showTodoForm: false,
      newTodo: ""
    };
  },
  methods: {
    changeStatus(id, event) {
      const arrIndex = this.todos.findIndex(todo => todo.id == id);
      this.todos[arrIndex].completed = !this.todos[arrIndex].completed;

      // the checkbox might not have been target of the click event
      if (event.target.type != "checkbox") {
        const checkbox = event.target.querySelector('input[type="checkbox"]');
        checkbox.checked = !checkbox.checked;
      }
    },
    toggleForm() {
      this.showTodoForm = !this.showTodoForm;
    },
    addTodo() {
      const maxid = Math.max(...this.todos.map(todo => todo.id));
      const todo = { id: maxid + 1, task: this.newTodo, completed: false };

      // use fetch to create a new todo in our mockAPI.
      fetch(this.apiURL, {
        method: "POST",
        headers: {
          "Content-Type": "application/json; charset=utf-8"
        },
        body: JSON.stringify(todo)
      })
        .then(response => {
          if (response.ok) {
            // if our post was successful add the todo to our todos array so the user can see it
            // the next time this page is refreshed the new task will be pulled from the server.
            this.todos.push(todo);
          }
        })
        .catch(err => console.error(err));

      // clear the value so the user can type another task
      this.newTodo = "";
    }
  },
  created() {
    fetch(this.apiURL)
      .then(response => {
        return response.json();
      })
      .then(todos => {
        this.todos = todos;
      })
      .catch(err => console.log(err));
  }
};
</script>

<style>
.todo-list {
  width: 450px;
  background: #fff;
  margin: 50px auto;
  font-family: "Roboto Condensed", sans-serif;
  border-radius: 10px;
}
header {
  background: #f2f2f2;
  color: #4b86a6;
  text-transform: uppercase;
  margin: 0px;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}
h1 {
  color: #4b86a6;
  padding: 10px;
  font-size: 24px;
  text-transform: uppercase;
  display: inline-block;
  padding: 0 0 0 20px;
}
header button {
  float: right;
  margin: 20px 20px 0 0;
  color: #4b86a6;
  text-decoration: none;
  padding: 8px 20px;
  border:none;
  outline: none;
  cursor: pointer;
}
ul {
  list-style-type: none;
  margin: 0px;
  padding: 0px;
}
li {
  font-size: 24px;
  border-bottom: 1px solid #f2f2f2;
  padding: 10px 20px;
  cursor: pointer;
}
li:last-child {
  border: 0px;
}
li.todo-completed {
  text-decoration: line-through;
  color: darkgray;
}
i.far.fa-check-circle {
  float: right;
  color: darkgray;
}

i.far.fa-check-circle.completed {
  color: green;
}
input[type="checkbox"] {
  font-size: 40px;
  vertical-align: middle;
  margin-top: 0px;
}
.new-todo {
  width: 90%;
  font-size: 18px;
  padding: 10px;
  margin: 0 10px;
}
</style>
