package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportyshoes.model.Product;
import com.sportyshoes.repository.GenericRepository;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private GenericRepository<Product> productRepository;
	
	@GetMapping("/list")
	public String getProductList(Model model) {
		
		List<Product> products = productRepository.getList();
		
		model.addAttribute("products", products);
		
		return "product-list";
				
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Product product = new Product();
		
		model.addAttribute("product", product);
		
		return "product-form";
	}
	
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product, Model model) {

		
		productRepository.save(product);
		
		
		return "redirect:/product/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId") int id, Model model) {
		
		//Retrieve product from product repository by id
		Product product = productRepository.getById(id);
		
		
		model.addAttribute("product", product);
		
		return "product-form";
	}
	
	@GetMapping("delete")
	public String deleteProduct(@RequestParam("productId") int id) {
		
		productRepository.deleteById(id);
		
		return "redirect:/product/list";
	}


}
