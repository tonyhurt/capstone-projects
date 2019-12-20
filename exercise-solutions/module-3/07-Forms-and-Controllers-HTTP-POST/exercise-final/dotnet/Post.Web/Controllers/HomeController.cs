using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Post.Web.DAL;
using Post.Web.Models;

namespace Post.Web.Controllers
{
    public class HomeController : Controller
    {
        private IReviewDAL reviewDal = new ReviewSqlDal("Data Source=.\\sqlexpress;Initial Catalog=squirrels;Integrated Security=True;");

        // GET: Home
        public ActionResult Index()
        {
            IList<Review> reviews = reviewDal.GetAllReviews();
            return View("Index", reviews);
        }

        // GET: Home/NewReview
        public ActionResult NewReview()
        {
            return View("NewReview", new Review());
        }

        // POST: Home/NewReview
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult NewReview(Review model)
        {
            reviewDal.SaveReview(model);
            return RedirectToAction("Index");
        }


        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
