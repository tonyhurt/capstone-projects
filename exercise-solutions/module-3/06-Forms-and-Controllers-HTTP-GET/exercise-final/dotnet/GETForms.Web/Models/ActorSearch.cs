using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Threading.Tasks;

namespace GETForms.Web.Models
{
    public class ActorSearch
    {
        /// <summary>
        /// The last name in the search
        /// </summary>
        [DisplayName("Last Name:")]
        public string LastName { get; set; }

        /// <summary>
        /// The list of actors returned by the search.
        /// </summary>
        public IList<Actor> Results { get; set; } = new List<Actor>();
    }
}
