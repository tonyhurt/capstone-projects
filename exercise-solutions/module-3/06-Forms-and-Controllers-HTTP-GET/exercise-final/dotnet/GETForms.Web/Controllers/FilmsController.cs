using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using GETForms.Web.DAL;
using GETForms.Web.Models;
using Microsoft.AspNetCore.Mvc;

namespace GETForms.Web.Controllers
{
    public class FilmsController : Controller
    {
        // GET: Film
        public ActionResult Index()
        {
            IFilmDAL dal = new FilmDAL(@"Data Source=.\SQLEXPRESS;Initial Catalog=DVDStore;Integrated Security=True");
            IList<string> genres = dal.GetGenres();
            FilmSearch filmSearch = new FilmSearch();
            filmSearch.AddGenres(genres);
            return View("Index", filmSearch);
        }

        public ActionResult SearchResult(FilmSearch request)
        {
            IFilmDAL dal = new FilmDAL(@"Data Source=.\SQLEXPRESS;Initial Catalog=DVDStore;Integrated Security=True");
            IList<Film> films = dal.GetFilmsBetween(request.Genre, request.MinimumLength.GetValueOrDefault(0), request.MaximumLength.GetValueOrDefault(1000));
            request.Results = films;

            return View("Index", request);
        }
    }
}