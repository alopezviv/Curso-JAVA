package com.empleados.app.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empleados.app.beans.Shop;

public interface ShopDAO extends JpaRepository<Shop, Integer>{

}
