package com.uca.capas.tareaLabo3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.tareaLabo3.domain.Product;

@Controller
public class ProductoController {
	private List<Product> products = new ArrayList<Product>();
	
	@GetMapping("/producto")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		
		products.add(new Product(1, "Mario Sunshine", 10));
		products.add(new Product(2, "Mario Kart", 20));
		products.add(new Product(3, "Mario Galaxy", 50));
		products.add(new Product(4, "Mario Party", 100));
		
		mav.setViewName("productos");
		mav.addObject("product", new Product() );
		mav.addObject("productos", products);
		
		return mav;
	}	
	
	@PostMapping("/validar")
	public ModelAndView validar(Product product) {
		ModelAndView mav = new ModelAndView();
		//mav.setViewName("/error");
		mav.addObject("product", product);
		if(product.getCantidad() > products.get(product.getId()).getCantidad()) {
			mav.addObject("product", product);
			mav.setViewName("/error");
		}else {
			mav.addObject("product", product);
			mav.setViewName("/comprar");
		}
		
		return mav;
	}
	
}
