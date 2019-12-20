package com.techelevator;

import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;

public class DAOExample {

	public static void main(String[] args) {
	
		/*
		 * *******************************************************
		 *                MAKING A CONNECTION 
		 * *******************************************************
		 */
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		
		/*
		 * *******************************************************
		 *               WORKING WITH THE DAO
		 * *******************************************************
		 */
		CityDAO dao = new JDBCCityDAO(worldDataSource);
		
		City smallville = new City();
		smallville.setCountryCode("USA");
		smallville.setDistrict("KS");
		smallville.setName("Smallville");
		smallville.setPopulation(42080);
		
		dao.save(smallville);
		
		City theCity = dao.findCityById(smallville.getId());
		
		System.out.println(theCity);
		
		List<City> theCities = dao.findCityByCountryCode("USA");
		
		for (City city : theCities) {
			System.out.println(city);
		}
		
	}

}
