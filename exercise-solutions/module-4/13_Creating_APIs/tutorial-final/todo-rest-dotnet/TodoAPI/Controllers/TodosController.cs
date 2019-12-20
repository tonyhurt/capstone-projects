using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;

using TodoAPI.Models;
using TodoAPI.Services;

namespace TodoAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class TodosController : ControllerBase
    {

        private DataAccessLayer dal;

        public TodosController(DataAccessLayer dataAccessLayer) {
            dal = dataAccessLayer;
        }

        [HttpGet]
        public List<Todo> GetAll()
        {
            return dal.GetAll();
        }

        [HttpGet("{id}", Name = "GetTodo")]
        public ActionResult<Todo> GetTodo(int id)
        {
            var todo = dal.Get(id);

            if (todo != null)
            {
                return todo;
            }

            return NotFound();
        }

        [HttpPost]
        public ActionResult Create([FromBody] Todo todo)
        {
            dal.Add(todo);

            // Return a created at route to indicate where the resource can be found
            return CreatedAtRoute("GetTodo", new { id = todo.id }, todo);
        }

        [HttpPut("{id}")]
        public ActionResult Update(int id, Todo updatedTodo)
        {
            // Get the existing todo
            var existingTodo = dal.Get(id);

            // If that todo does not exists, return 404
            if (existingTodo == null)
            {
                return NotFound();
            }

            // Copy over the fields we want to change
            existingTodo.completed = updatedTodo.completed;

            // Save back to the database
            dal.Update(existingTodo);

            // return a 204
            return NoContent();
        }

        [HttpDelete("{id}")]
        public ActionResult Delete(int id)
        {
            var todo = dal.Get(id);

            if (todo == null)
            {
                // return HTTP 404
                return NotFound();
            }

            // delete the resource
            dal.Delete(id);

            // return HTTP 201
            return NoContent();
        }

    }
}