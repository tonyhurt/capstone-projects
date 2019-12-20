using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lecture
{
    public partial class LectureExample
    {

        /*
        12. Now write the above using the Ternary operator ?:
        */
        public string ReturnFizzIfThreeUsingTernary(int number)
        {
            // A ternary operator is used to evaluate to a single value 
            // see: http://book.techelevator.com/.net/10-logical-branching/conditional-code/01-conditional-code.html

            return (number == 3) ? "Fizz" : "";
        }
    }
}
