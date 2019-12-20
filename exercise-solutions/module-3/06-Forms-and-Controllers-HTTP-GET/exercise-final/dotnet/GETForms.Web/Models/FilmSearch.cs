using Microsoft.AspNetCore.Mvc.Rendering;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Threading.Tasks;

namespace GETForms.Web.Models
{
    public class FilmSearch
    {
        /// <summary>
        /// The minimum length of the film to search for.
        /// </summary>
        [DisplayName("Minimum Length")]
        public int? MinimumLength { get; set; }

        /// <summary>
        /// The maximum length of the film to search for.
        /// </summary>
        [DisplayName("Maximum Length")]
        public int? MaximumLength { get; set; }

        /// <summary>
        /// The genre of the film to search for.
        /// </summary>
        [DisplayName("Genre")]
        public string Genre { get; set; }

        /// <summary>
        /// The genres available to be searched.
        /// </summary>
        public List<SelectListItem> Genres { get; private set; } = new List<SelectListItem>();


        public void AddGenres (IList<string> newGenres)
        {
            foreach (string genre in newGenres)
            {
                Genres.Add(new SelectListItem { Text = genre, Value = genre });
            }           
        }
                             
        /// <summary>
        /// The results returned.
        /// </summary>
        public IList<Film> Results { get; set; } = new List<Film>();
    }
}
