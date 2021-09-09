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
	
	public List<Picture> getPictures(int shopId) {
		
		return  pic.findByShopId(shopId);	
	}
	@Transactional
	public void deletePictures(int shopId) {
		pic.deleteByShopId(shopId);
		sh.updateShopPicturesNumber(shopId);
			
	}
	public void createPictures(Picture p, int shopId) throws Exception {
		
		if(sh.shopHasSpace(shopId)) {
			//p.setEntranceDate();
			pic.save(p);
			sh.updateShopPicturesNumber(shopId);
			
		}
			
	}
}
