package com.empleados.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empleados.app.beans.Shop;
import com.empleados.app.service.ShopService;
@CrossOrigin
@RestController
@RequestMapping("")
public class ShopController {

	@Autowired
	ShopService sh;
	
	@GetMapping("/shops")
	public ResponseEntity<List<Shop>> getShops() {
		return new ResponseEntity<>(sh.getShops(), HttpStatus.OK);
	}
	@PostMapping("/shops")
	public ResponseEntity<String> createShop(Shop s) {
		sh.createShop(s);
		return new ResponseEntity<>("Shop created", HttpStatus.OK);
	}
}
