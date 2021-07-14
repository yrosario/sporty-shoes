package com.sportyshoes.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="line-order-item")
public class LineOrderItem {

	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Order order;
	
	@ManyToOne
	private Product product;

	public LineOrderItem() {
		super();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("LineOrderItem [id=%s]", id);
	}
	
	
	
	
}
