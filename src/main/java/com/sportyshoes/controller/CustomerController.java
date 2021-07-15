package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sportyshoes.model.Customer;
import com.sportyshoes.repository.CustomerRepositoryImpl;
import com.sportyshoes.repository.GenericRepository;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private GenericRepository<Customer> customerRepositoryImpl;
	
	@GetMapping("/list")
	public String getCustomerList(Model model) {
		
		List<Customer> customers = customerRepositoryImpl.getList();
		
		for(Customer c: customers)
			System.out.println(c.toString());
		
		model.addAttribute("customers", customers);
		
		return "customer-list";
				
	}

}
