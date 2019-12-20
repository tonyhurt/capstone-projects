using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Validation.Web.Models;


namespace Validation.Web.Controllers
{
    public class UsersController : Controller
    {
        // GET: User
        public IActionResult Index()
        {
            return View("Index");
        }

        // GET: User/Register
        [HttpGet]
        public IActionResult Register()
        {
            return View("Register");
        }

        // POST: User/Register
        [HttpPost]
        public IActionResult Register(RegistrationViewModel model)
        {
            if (!ModelState.IsValid)
            {
                return View("Register", model);
            }
            TempData["Message"] = "You have successfully registered";
            return RedirectToAction("Confirmation", "Users");
        }

        // GET: User/Confirmation
        public IActionResult Confirmation()
        {
            string message = TempData["Message"] as string;

            // If there is a message, show it
            if (message != null)
            {                
                return View("Confirmation", (object)message);
            }

            // Else take them to the home page
            return RedirectToAction("Index", "Users");
        }

        // GET: User/Login
        [HttpGet]
        public IActionResult Login()
        {
            return View("Login");
        }

        // POST: User/Login  
        [HttpPost]
        public IActionResult Login(LoginViewModel model)
        {
            if (!ModelState.IsValid)
            {
                return View("Login", model);
            }

            TempData["Message"] = "You have successfully logged in";
            return RedirectToAction("Confirmation", "Users");
        }
    }
}