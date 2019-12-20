﻿using GETForms.Web.Models;
using System.Collections.Generic;

namespace GETForms.Web.DAL
{
    public interface IFilmDAL
    {
        /// <summary>
        /// Searches for films within the given parameters.
        /// </summary>
        /// <param name="genre"></param>
        /// <param name="minLength"></param>
        /// <param name="maxLength"></param>
        /// <returns></returns>
        IList<Film> GetFilmsBetween(string genre, int minLength, int maxLength);
        IList<string> GetGenres();
    }
}