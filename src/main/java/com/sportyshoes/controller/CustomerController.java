package com.sportyshoes.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String saveCustmer(@ModelAttribute("customer") Customer customer, Model model, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {
		
		System.out.println(customer.getBirthday());
		
		//convert date format to ISO format
		localDate = customer.getBirthday();
		
		customer.setBirthday(localDate);
		
		System.out.println(customer.getBirthday());
		customerRepository.save(customer);
		
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		
		//Retrieve customer from customer repository by id
		Customer customer = customerRepository.getById(id);
		
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@GetMapping("delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		
		customerRepository.deleteById(id);
		
		return "redirect:/customer/list";
	}

}
