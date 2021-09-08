package com.empleados.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.empleados.app.DAO.ShopDAO;
import com.empleados.app.beans.Shop;

@Service
public class ShopService {

	@Autowired
	ShopDAO sh;
	@Autowired
	PictureService pic;
	
	public ResponseEntity<String> createShop(Shop s) {
		sh.save(s);
		return ResponseEntity.ok("Shop created");
	}
	
	public ResponseEntity<List<Shop>> getShops(){
		List<Shop> listShop = sh.findAll();
		return new ResponseEntity<>(listShop, HttpStatus.OK);
	}
	public ResponseEntity<Shop> getShop(int id) {
		Optional<Shop> s = sh.findById(id);
		if(s.isPresent()) {
			Shop shop = s.get();
			return new ResponseEntity<>(shop, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	public ResponseEntity<Boolean> shopHasSpace(int id) {
		boolean result = false;
		Optional<Shop> s = sh.findById(id);
		if(s.isPresent()){
			Shop shop = s.get();
			if(shop.getPicturesNumber() < shop.getCapacity()) {
				result = true;
			}
			return new ResponseEntity<Boolean>(result, HttpStatus.OK);
 
		}else {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}					
	}
	public void updateShopPicturesNumber(int id) {
		int picNumber = pic.getPictures(id).getBody().size();
		Shop s = sh.findById(id).get();
		s.setPicturesNumber(picNumber);
		sh.save(s);
		
	}
	
}
