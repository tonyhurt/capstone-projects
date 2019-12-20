using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using GETForms.Web.DAL;
using GETForms.Web.Models;
using Microsoft.AspNetCore.Mvc;

namespace GETForms.Web.Controllers
{
    public class ActorsController : Controller
    {
        /// <summary>
        /// The request to display an empty search page.
        /// </summary>
        /// <returns></returns>
        public IActionResult Index()
        {
            return View("Index", new ActorSearch());
        }

        /// <summary>
        /// The request to display search results.
        /// </summary>
        /// <param name="request"></param>
        /// <returns></returns>
        public IActionResult SearchResult(ActorSearch request)
        {
            IActorDAL dal = new ActorDAL(@"Data Source=.\SQLEXPRESS;Initial Catalog=DVDStore;Integrated Security=True");
            IList<Actor> actors = dal.FindActors(request.LastName);
            request.Results = actors;

            return View("Index", request);
        }
    }
}