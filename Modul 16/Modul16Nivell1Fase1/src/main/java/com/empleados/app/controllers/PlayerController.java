package com.empleados.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.empleados.app.service.PlayerService;

@RestController
public class PlayerController {

	@Autowired
	PlayerService ps;
}
