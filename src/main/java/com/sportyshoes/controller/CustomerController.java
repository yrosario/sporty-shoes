package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sportyshoes.model.Customer;
import com.sportyshoes.repository.GenericRepository;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private GenericRepository<Customer> customerRepository;
	
	@GetMapping("/list")
	public String getCustomerList(Model model) {
		
		List<Customer> customers = customerRepository.getList();
		
		for(Customer c: customers)
			System.out.println(c.toString());
		
		model.addAttribute("customers", customers);
		
		return "customer-list";
				
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	
	@PostMapping("/saveCustomer")
	public String saveCustmer(@ModelAttribute("customer") Customer customer, Model model) {
		
		customerRepository.save(customer);
		
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		
		//Retrieve customer from customer repository by id
		Customer customer = customerRepository.getById(id);
		
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}

}
