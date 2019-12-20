using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace Post.Web.Models
{
    public class Review
    {
        public int Id { get; set; }

        [Display(Name = "Enter your name:")]
        public string Username { get; set; }

        [Display(Name = "How many stars:")]
        public int Rating { get; set; }

        [Display(Name = "Provide a title:")]
        public string Title { get; set; }

        [Display(Name = "Review")]
        public string Message { get; set; }

        public DateTime ReviewDate { get; set; }
    }
}
