package com.empleados.app.Dao;



import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.empleados.app.entity.Player;

public interface PlayerDao extends MongoRepository<Player, Integer>{

	Optional<Player> findById(String id);

}
