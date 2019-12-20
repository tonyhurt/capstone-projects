package com.techelevator;

import com.techelevator.dao.CustomerDao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerSearchController {

	@Autowired
	private CustomerDao customerDao;

	@RequestMapping("/customer")
	public String showCustomerSearchForm() {

		return "customerList";
	}

	@RequestMapping(path = "/customerList", method = RequestMethod.GET)
	public String showCustomerSearchForm(HttpServletRequest request) {
		String search = request.getParameter("lastName");
		String sort = request.getParameter("email");
		request.setAttribute("listOfCustomers", customerDao.getCustomers(search, sort));

		return "customerList";
	}

	@RequestMapping(path = "/customerListResults", method = RequestMethod.GET)
	public String searchCustomer(HttpServletRequest request) {
		request.setAttribute("customers",
				customerDao.getCustomers(request.getParameter("search"), request.getParameter("sort")));

		return "customerList";
	}

}