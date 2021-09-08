package com.empleados.app.DAO;

import java.sql.Date;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.empleados.app.beans.Picture;

//@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class PictureDAOIT {

	@Autowired
	private PictureDAO pic;
	
	@BeforeEach
	public void bdSeed(){
		long now = System.currentTimeMillis();
		Date date = new Date(now);
		pic.save(new Picture("Javier" , 1));
		pic.save(new Picture("Pepe" , 1));
		pic.save(new Picture("Javier" , 2));
		pic.save(new Picture("Fran" , 2));
		pic.save(new Picture("Tito" , 2));

	}
	
	@Test
	public void findByShopIdTest(){
		assertEquals(2, pic.findByShopId(1).size());
		assertEquals(3, pic.findByShopId(2).size());
	}
	@Test
	@Transactional 
	public void deleteByShopIdTest(){
		assertEquals(2, pic.deleteByShopId(1));
		assertEquals(3, pic.deleteByShopId(2));
	}
	
}
