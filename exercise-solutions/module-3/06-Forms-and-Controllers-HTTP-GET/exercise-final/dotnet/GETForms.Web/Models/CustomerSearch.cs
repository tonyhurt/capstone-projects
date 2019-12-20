using Microsoft.AspNetCore.Mvc.Rendering;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Threading.Tasks;

namespace GETForms.Web.Models
{
    public class CustomerSearch
    {
        /// <summary>
        /// The customer's name
        /// </summary>
        public string Name { get; set; }

        /// <summary>
        /// The column to sort by.
        /// </summary>
        [DisplayName("Sort By")]
        public string SortByColumn { get; set; }

        /// <summary>
        /// Available options for search.
        /// </summary>
        public IList<SelectListItem> SortOptions { get; set; } = new List<SelectListItem>()
        {
            new SelectListItem() { Text = "Last Name", Value = "last_name" },
            new SelectListItem() { Text = "Email", Value = "email" },
            new SelectListItem() { Text = "Active", Value = "active"}
        };

        /// <summary>
        /// Customer's search results.
        /// </summary>
        public IList<Customer> Results { get; set; } = new List<Customer>();
    }
}
