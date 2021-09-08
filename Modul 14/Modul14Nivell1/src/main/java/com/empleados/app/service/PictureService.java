package com.empleados.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empleados.app.DAO.PictureDAO;
import com.empleados.app.beans.Picture;


@Service
public class PictureService {

	@Autowired
	PictureDAO pic;
	@Autowired
	ShopService sh;
	
	public ResponseEntity<List<Picture>> getPictures(int shopId) {
		
		return new ResponseEntity<>( pic.findByShopId(shopId), HttpStatus.OK);	
	}
	@Transactional
	public ResponseEntity<String> deletePictures(int shopId) {
		pic.deleteByShopId(shopId);
		return ResponseEntity.ok("Pictures Deleted");	
	}
	public ResponseEntity<String> createPictures(Picture p, int shopId) {
		
		if(sh.shopHasSpace(shopId).getBody()) {
			//p.setEntranceDate();
			pic.save(p);
			sh.updateShopPicturesNumber(shopId);
			return ResponseEntity.ok("Picture created");
		}else {
			return new ResponseEntity<>("Shop doesn't have enough space", HttpStatus.FORBIDDEN);
		}
			
	}
}
