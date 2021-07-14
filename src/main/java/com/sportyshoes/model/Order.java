package com.sportyshoes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class Order {

	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Customer customer;
	
	@OneToMany(mappedBy="order")
	private List<LineOrderItem> lineItems = new ArrayList<LineOrderItem>();

	public Order() {
		super();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	public List<LineOrderItem> getLineItems() {
		return lineItems;
	}

	public void addtLineItem(LineOrderItem lineItem) {
		this.lineItems.add(lineItem);
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Order [id=%s]", id);
	}
	
	
	
	
}
