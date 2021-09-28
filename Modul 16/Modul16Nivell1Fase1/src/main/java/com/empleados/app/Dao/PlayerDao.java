package com.empleados.app.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empleados.app.entity.Player;

public interface PlayerDao extends JpaRepository<Player, Integer>{
	Optional<Player> findDistinctByName(String name);

}
