package com.ajueshchan.springdemo.dao;

import java.util.List;

import com.ajueshchan.springdemo.entity.Customer;

public interface CustomerDao {

	public List<Customer> getCustomers();
	
	public void saveCustomers(Customer theCustomer);
	
	public Customer getCustomer(int id);
	
	public void deleteCustomer(int identity);
	
	public List<Customer> searchCustomers(String theSearchName);
}
