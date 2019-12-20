﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PostageCalculator.Classes
{
    public class SPUTwoDayGround : IDeliveryService
    {
        public string Name
        {
            get { return "SPU (2-day business)"; }
        }

        public double CalculateRate(int weightInOunces, int distanceInMiles)
        {
            double weightInLbs = weightInOunces / 16.0;

            return (weightInLbs * 0.050) * distanceInMiles;
        }
    }
}
