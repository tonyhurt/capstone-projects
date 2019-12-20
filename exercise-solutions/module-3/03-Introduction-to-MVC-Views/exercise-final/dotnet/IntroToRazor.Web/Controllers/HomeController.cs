using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using IntroToRazor.Web.Models;

namespace IntroToRazor.Web.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }

        // home/fizzbuzz
        // home/fizzbuzz?number=100
        public IActionResult FizzBuzz(int number = 100)
        {
            ViewData["number"] = number;

            return View();
        }

        // home/fibonacci
        // home/fibonacci?max=20
        public IActionResult Fibonacci(int max = 20)
        {
            ViewData["max"] = max;

            return View();
        }

        // home/echo?word=hello world&count=20
        // home/echo
        public IActionResult Echo(string word = "pick a word", int count = 10)
        {
            ViewData["word"] = word;
            ViewData["count"] = count;

            return View();
        }


        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
