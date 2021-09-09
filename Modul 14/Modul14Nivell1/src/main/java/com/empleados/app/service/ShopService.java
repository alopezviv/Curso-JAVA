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
	
	public void createShop(Shop s) {
		sh.save(s);
		
	}
	
	public List<Shop> getShops(){
		return sh.findAll();
	}
	public Shop getShop(int id) throws Exception {
		Optional<Shop> s = sh.findById(id);
		if(s.isPresent()) {
			Shop shop = s.get();
			return shop;
		}else {
			throw new Exception("Shop doesn't exists");
		}
	}
	public boolean shopHasSpace(int id) throws Exception {
		boolean result = false;
		Optional<Shop> s = sh.findById(id);
		if(s.isPresent()){
			Shop shop = s.get();
			if(shop.getPicturesNumber() < shop.getCapacity()) {
				result = true;
			}else {
				throw new Exception("Shop doesn't have space");
			}
			return result;
 
		}else {
			throw new Exception("Shop doesn't exists");
		}					
	}
	public void updateShopPicturesNumber(int id) {
		int picNumber = pic.getPictures(id).size();
		Shop s = sh.findById(id).get();
		s.setPicturesNumber(picNumber);
		sh.save(s);
		
	}
	
}
