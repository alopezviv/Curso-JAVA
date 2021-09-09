package com.empleados.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empleados.app.beans.Picture;
import com.empleados.app.service.PictureService;
@CrossOrigin
@RestController
public class PictureController {

	@Autowired
	PictureService pic;
	
	@GetMapping("/shops/{id}/pictures")
	public ResponseEntity<List<Picture>> getPictures(@PathVariable int id){
		
		return new ResponseEntity<>(pic.getPictures(id), HttpStatus.OK);
	}
	@DeleteMapping("/shops/{id}/pictures")
	public void deletePictures(@PathVariable int id){
		
		pic.deletePictures(id);
	}
	@PostMapping("/shops/{id}/pictures")
	public ResponseEntity<String> createPictures(Picture p, @PathVariable int id){
		
		try {
			pic.createPictures(p, id);
			
		} catch (Exception e) {
			if(e.getMessage().equals("Shop doesn't have space")) {
				return new ResponseEntity<>("Shop doesn't have space",HttpStatus.FORBIDDEN);
			}else {
				return new ResponseEntity<>("Shop doesn't exists",HttpStatus.NOT_FOUND);

			}
			
		}
		return new ResponseEntity<>("Picture Created",HttpStatus.OK);
	}
}
