using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Validation.Web.Models
{
    public class RegistrationViewModel
    {
        [Display(Name = "First Name")]
        [Required(ErrorMessage = "*")]
        [MaxLength(20, ErrorMessage = "The limit is {1} characters")]
        public string FirstName { get; set; }

        [Display(Name = "Last Name")]
        [Required(ErrorMessage = "*")]
        [MaxLength(20, ErrorMessage = "The limit is {1} characters")]
        public string LastName { get; set; }

        [EmailAddress(ErrorMessage = "invalid email")]
        [Required(ErrorMessage = "*")]
        public string Email { get; set; }

        [Display(Name = "Confirm Email")]        
        [Compare("Email", ErrorMessage = "Email address does not match")]
        public string ConfirmEmail { get; set; }

        [Required(ErrorMessage = "*")]
        [MinLength(8, ErrorMessage = "Password minimum is {1} characters")]
        public string Password { get; set; }

        [Display(Name = "Confirm")]
        [Compare("Password", ErrorMessage = "Passwords do not match")]
        public string ConfirmPassword { get; set; }
        
        [Display(Name = "Birthday")]
        [Required(ErrorMessage = "*")]
        [DataType(DataType.Date)]
        public DateTime BirthDate { get; set; }

        [Display(Name = "# of Tickets")]        
        [Range(1, 10, ErrorMessage = "{0} must be between {1} and {2}")]
        [Required]
        public int NumberOfTickets { get; set; }
    }
}