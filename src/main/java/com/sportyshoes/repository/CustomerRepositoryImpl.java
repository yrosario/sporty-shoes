package com.sportyshoes.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.sportyshoes.model.Customer;

@Repository
public class CustomerRepositoryImpl implements GenericRepository<Customer> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getList() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		Query<Customer> query =
				currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		for(Customer c : customers)
			System.out.println(c.toString());

		return customers;
	}
	

	@Override
	public Customer getById(Integer id) {
		return null;
	}

	@Override
	public void updateById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
