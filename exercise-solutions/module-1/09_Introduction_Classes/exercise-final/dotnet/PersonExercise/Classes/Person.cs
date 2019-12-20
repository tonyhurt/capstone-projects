﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TechElevator.Classes
{
    public class Person
    {

        public string FirstName { get; set; }        
        public string LastName { get; set; }        
        public int Age { get; set; }
        

        public string GetFullName()
        {
            return this.FirstName + " " + this.LastName;
        }

        public bool IsAdult()
        {
            return this.Age >= 18;
        }

    }
}
