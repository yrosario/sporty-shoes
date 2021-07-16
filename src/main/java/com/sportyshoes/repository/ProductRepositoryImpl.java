package com.sportyshoes.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.sportyshoes.model.Product;

@Repository
public class ProductRepositoryImpl implements GenericRepository<Product> {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Product> getList() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Product> query = currentSession.createQuery("from Product", Product.class);

		List<Product> products = query.getResultList();

		for (Product p : products)
			System.out.println(p.toString());

		return products;
	}

	@Override
	@Transactional
	public Product getById(Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Product product = currentSession.get(Product.class, id);
		
		return product;
	}

	@Override
	@Transactional
	public void save(Product product) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(product);
		
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("rawtypes")
		Query query =
				currentSession.createQuery("delete from Product where id=:productId");
		query.setParameter("productId", id);
		
		query.executeUpdate();
	}

}
