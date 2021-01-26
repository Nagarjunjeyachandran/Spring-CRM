package com.ajueshchan.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ajueshchan.springdemo.dao.CustomerDao;
import com.ajueshchan.springdemo.entity.Customer;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		
		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomers(Customer theCustomer) {
		// TODO Auto-generated method stub
		 customerDao.saveCustomers(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int identity) {
		// TODO Auto-generated method stub
		return customerDao.getCustomer(identity);
	}

	@Override
	@Transactional
	public void deleteCustomer(int identity) {
		// TODO Auto-generated method stub
		customerDao.deleteCustomer(identity);
	}
	
	 @Override
	 @Transactional
	    public List<Customer> searchCustomers(String theSearchName) {

	        return customerDao.searchCustomers(theSearchName);
	    }  	   

}
