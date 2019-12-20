package com.techelevator;

import com.techelevator.dao.CustomerDao;
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

    @RequestMapping(path = "/customerForm", method = RequestMethod.GET)
    public String showCustomerForm() {
        return "customerList";
    }

    @RequestMapping(path = "customerSearch", method = RequestMethod.GET)
    public String searchCustomers(@RequestParam String search, @RequestParam String sortBy, ModelMap modelHolder) {
        modelHolder.put("customers", customerDao.searchAndSortCustomers(search, sortBy));
        return "customerList";
    }
}