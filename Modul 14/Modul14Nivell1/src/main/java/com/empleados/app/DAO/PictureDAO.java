package com.empleados.app.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empleados.app.beans.Picture;

public interface PictureDAO extends JpaRepository<Picture, Integer> {

	List<Picture> findByShopId(int id);
	int deleteByShopId(int id);
}
