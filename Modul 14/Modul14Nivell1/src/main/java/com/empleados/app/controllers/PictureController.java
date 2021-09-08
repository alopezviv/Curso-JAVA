package com.empleados.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empleados.app.beans.Picture;
import com.empleados.app.service.PictureService;

@RestController
public class PictureController {

	@Autowired
	PictureService pic;
	
	@GetMapping("/shops/{id}/pictures")
	public List<Picture> getPictures(@PathVariable int id){
		
		return pic.getPictures(id).getBody();
	}
	@DeleteMapping("/shops/{id}/pictures")
	public void deletePictures(@PathVariable int id){
		
		pic.deletePictures(id);
	}
	@PostMapping("/shops/{id}/pictures")
	public void createPictures(Picture p, @PathVariable int id){
		
		pic.createPictures(p, id);
	}
}
