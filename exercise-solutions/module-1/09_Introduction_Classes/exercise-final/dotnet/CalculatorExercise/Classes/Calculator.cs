﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TechElevator.Classes
{
    public class Calculator
    {
        public int Result { get; private set; }

        /// <summary>
        /// This method adds the provided value to the result
        /// </summary>
        /// <param name="addend">The value to be added to the current result</param>
        /// <returns>The result after adding addend</returns>
        public int Add(int addend)
        {
            this.Result += addend;
            return this.Result;
        }

        /// <summary>
        /// Subtracts provided value from the result
        /// </summary>
        /// <param name="subtrahend">subtrahend the value to be subtracted from current result</param>
        /// <returns>result after subtracting subtrahend</returns>
        public int Subtract(int subtrahend)
        {
            this.Result -= subtrahend;
            return this.Result;
        }

        /// <summary>
        /// Multiplies the current result by multiplier
        /// </summary>
        /// <param name="multiplier">the value to multiply the result by</param>
        /// <returns>result after multiplying by multiplier</returns>
        public int Multiply(int multiplier)
        {
            this.Result *= multiplier;
            return this.Result;
        }

        /// <summary>
        /// Raises the current result by the power of exponent. Negative exponents not supported.
        /// If negative is provided treat it as though it were positive (i.e. uses the Absolute value)
        /// </summary>
        /// <param name="exponent">The power to raise by</param>
        /// <returns>Current result raised by the power of exponent</returns>
        public int Power(int exponent)
        {
            this.Result = (int)Math.Pow(this.Result, exponent);
            return this.Result;
        }

        /// <summary>
        /// Resets the result value to 0
        /// </summary>
        public void Reset()
        {
            this.Result = 0;
        }
    }
}
