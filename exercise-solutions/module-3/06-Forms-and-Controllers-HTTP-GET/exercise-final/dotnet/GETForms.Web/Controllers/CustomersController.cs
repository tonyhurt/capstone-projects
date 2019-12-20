using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using GETForms.Web.DAL;
using GETForms.Web.Models;
using Microsoft.AspNetCore.Mvc;

namespace GETForms.Web.Controllers
{
    public class CustomersController : Controller
    {

        public ActionResult Index()
        {
            return View("Index", new CustomerSearch());
        }

        public ActionResult SearchResult(CustomerSearch request)
        {
            ICustomerDAL dal = new CustomerDAL(@"Data Source=.\SQLEXPRESS;Initial Catalog=DVDStore;Integrated Security=True");
            IList<Customer> customers = dal.SearchForCustomers(request.Name, request.SortByColumn);
            request.Results = customers;

            return View("Index", request);
        }
    }
}