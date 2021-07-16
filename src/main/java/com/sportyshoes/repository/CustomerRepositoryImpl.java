package com.sportyshoes.repository;

import java.util.List;

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

		Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);

		List<Customer> customers = query.getResultList();

		for (Customer c : customers)
			System.out.println(c.toString());

		return customers;
	}

	@Override
	@Transactional
	public Customer getById(Integer id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer customer = currentSession.get(Customer.class, id);
		
		return customer;
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(customer);

	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		

		@SuppressWarnings("rawtypes")
		Query theQuery = 
				currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", id);
		
		theQuery.executeUpdate();	
		

	}

}
