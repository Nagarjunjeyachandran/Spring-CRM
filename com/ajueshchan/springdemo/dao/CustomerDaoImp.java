package com.ajueshchan.springdemo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ajueshchan.springdemo.entity.Customer;

@Repository
public class CustomerDaoImp implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		
		Query<Customer> query=session.createQuery("from Customer order by firstname",Customer.class);
		
	    List<Customer> result=query.getResultList();
		
		return result;
	}

	@Override
	public void saveCustomers(Customer theCustomer) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		
		Customer custom=session.get(Customer.class, id);
		
		return custom;
	}

	@Override
	public void deleteCustomer(int identity) {
		// TODO Auto-generated method stub
        Session session=sessionFactory.getCurrentSession();
		
        Query query=session.createQuery("delete from Customer where id=:tempid");
        query.setParameter("tempid", identity);
        query.executeUpdate();
		
		
	}
	
	 @Override
	    public List<Customer> searchCustomers(String theSearchName) {

	        // get the current hibernate session
	        Session currentSession = sessionFactory.getCurrentSession();
	        
	        Query theQuery = null;
	        
	        //
	        // only search by name if theSearchName is not empty
	        //
	        if (theSearchName != null && theSearchName.trim().length() > 0) {

	            // search for firstName or lastName ... case insensitive
	            theQuery =currentSession.createQuery("from Customer where lower(firstname) like :theName or lower(lastname) like :theName", Customer.class);
	            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

	        }
	        else {
	            // theSearchName is empty ... so just get all customers
	            theQuery =currentSession.createQuery("from Customer", Customer.class);            
	        }
	        
	        // execute query and get result list
	        List<Customer> customers = theQuery.getResultList();
	                
	        // return the results        
	        return customers;
	        
	    }

}
