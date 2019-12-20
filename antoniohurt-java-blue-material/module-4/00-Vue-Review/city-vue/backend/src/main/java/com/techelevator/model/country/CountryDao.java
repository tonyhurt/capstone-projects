package com.techelevator.model.country;

import java.util.List;

public interface CountryDao {

	List<Country> getAllCountries();
	List<SelectListItem> getAllCountryCodeForSelection();
	List<SelectListItem> getAllRegionsForCountryCode(String CountryCode);
}
