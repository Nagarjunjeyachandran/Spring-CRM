package com.ajueshchan.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ajueshchan.springdemo.entity.Customer;
import com.ajueshchan.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<Customer> custom=customerService.getCustomers();

		theModel.addAttribute("customer",custom);
		
		return "list-customers";
	}
	
	@GetMapping("/showNewCustomerForm")
	public String showNewCustomerForm(Model theModel) {
		
		Customer theCustomer =new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomerForm")
	public String saveCustomerForm(@ModelAttribute("customer") Customer theCustomer) {
		
		customerService.saveCustomers(theCustomer); 
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showUpdateCustomerForm")
	public String showUpdateCustomerForm(@RequestParam("customerId") int identity,
			                                            Model theModel) {
		// Get customer id from database
		Customer custom=customerService.getCustomer(identity);
		
		//set id into model attribute
		
		theModel.addAttribute("customer",custom);
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int identity,
                                         Model theModel) {
		// Get customer id from database
		customerService.deleteCustomer(identity);

		return "redirect:/customer/list";
	}
	
    @GetMapping("/search")
	 public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
	                                    Model theModel) {

	        // search customers from the service
	        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
	                
	        // add the customers to the model
	        theModel.addAttribute("customer", theCustomers);

	        return "list-customers";        
	    }
	
}


