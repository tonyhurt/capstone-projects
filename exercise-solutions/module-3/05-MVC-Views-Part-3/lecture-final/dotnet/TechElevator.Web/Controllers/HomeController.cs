using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using TechElevator.Web.DAL;
using TechElevator.Web.Models;

namespace TechElevator.Web.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            // If there is time, this would be a good opportunity to use to teach the students about DI
            // the project has two separate data sources to enable us to switch out the DAO
            //IPostDAO dao = new PostFileDAO(@"DAL/data.csv");
            IPostDAO dao = new PostSqlDAO(@"Data Source=.\sqlexpress;Initial Catalog=TEgram;Integrated Security=True");
            IList<Post> posts = dao.GetPosts();

            return View(posts);
        }
    }
}