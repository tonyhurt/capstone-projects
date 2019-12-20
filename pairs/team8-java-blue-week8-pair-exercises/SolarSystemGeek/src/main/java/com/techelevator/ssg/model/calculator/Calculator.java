package com.techelevator.ssg.model.calculator;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

	public Map<String, Double> calculateAlienAge(long newTravelTimePlusAge) {
		Map<String, Double> planetAges = new HashMap<String, Double>();

		double mercuryAge = (newTravelTimePlusAge * 365 / 87.96);
		planetAges.put("mercury", mercuryAge);

		double venusAge = (newTravelTimePlusAge * 365 / 224.68);
		planetAges.put("venus", venusAge);

		double marsAge = (newTravelTimePlusAge * 365 / 686.98);
		planetAges.put("mars", marsAge);

		double jupiterAge = (newTravelTimePlusAge / 11.862);
		planetAges.put("jupiter", jupiterAge);

		double saturnAge = (newTravelTimePlusAge / 29.456);
		planetAges.put("saturn", saturnAge);

		double uranusAge = (newTravelTimePlusAge / 84.07);
		planetAges.put("uranus", uranusAge);

		double neptuneAge = (newTravelTimePlusAge / 164.81);
		planetAges.put("neptune", neptuneAge);

		double plutoAge = (newTravelTimePlusAge / 247.7);
		planetAges.put("pluto", plutoAge);

		return planetAges;

	}

	public Map<String, Double> calculateAlienWeight(int userWeight) {
		Map<String, Double> planetWeights = new HashMap<String, Double>();

		double mercuryWeight = userWeight * 3.59;
		planetWeights.put("mercury", mercuryWeight);

		double venusWeight = userWeight * 8.87;
		planetWeights.put("venus", venusWeight);

		double marsWeight = userWeight * 3.77;
		planetWeights.put("mars", marsWeight);

		double jupiterWeight = userWeight * 25.95;
		planetWeights.put("jupiter", jupiterWeight);

		double saturnWeight = userWeight * 11.08;
		planetWeights.put("saturn", saturnWeight);

		double uranusWeight = userWeight * 10.67;
		planetWeights.put("uranus", uranusWeight);

		double neptuneWeight = userWeight * 14.07;
		planetWeights.put("neptune", neptuneWeight);

		double plutoWeight = userWeight * 0.42;
		planetWeights.put("pluto", plutoWeight);

		return planetWeights;

	}

	public Map<String, Long> calculateDriveTime(String transportation, String planet) {
		long speed = 0;
		if (transportation.equals("walking")) {
			speed = 3;
		} else if (transportation.equals("car")) {
			speed = 100;
		} else if (transportation.equals("bulletTrain")) {
			speed = 200;
		} else if (transportation.equals("boeing747")) {
			speed = 570;
		} else if (transportation.equals("concorde")) {
			speed = 1350;
		}

		Map<String, Long> driveTimes = new HashMap<String, Long>();

		long mercuryTravelTime = (long) (speed * 56974146);
		driveTimes.put("mercury", mercuryTravelTime);

		Long venusTravelTime = (long) (speed * 25724767);
		driveTimes.put("venus", venusTravelTime);

		Long marsTravelTime = (long) (speed * 48678219);
		driveTimes.put("mars", marsTravelTime);

		Long jupiterTravelTime = (long) (speed * 390674710);
		driveTimes.put("jupiter", jupiterTravelTime);

		Long saturnTravelTime = (long) (speed * 792248270);
		driveTimes.put("saturn", saturnTravelTime);

		Long uranusTravelTime = (long) (speed * 1692662530);
		driveTimes.put("uranus", uranusTravelTime);
		
		Long neptuneTravelTime =  speed *  2703959960l;
		driveTimes.put("neptune", neptuneTravelTime);

		long plutoTravelTime = speed * 4670000000l;
		driveTimes.put("pluto", plutoTravelTime);

		return driveTimes;
	}

}
