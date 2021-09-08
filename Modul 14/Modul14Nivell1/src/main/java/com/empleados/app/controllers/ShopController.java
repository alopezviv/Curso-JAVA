package com.empleados.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empleados.app.beans.Shop;
import com.empleados.app.service.ShopService;

@RestController
@RequestMapping("")
public class ShopController {

	@Autowired
	ShopService sh;
	
	@GetMapping("/shops")
	public List<Shop> getShops() {
		return sh.getShops().getBody();
	}
	@PostMapping("/shops")
	public void createShop(Shop s) {
		sh.createShop(s);
	}
}
