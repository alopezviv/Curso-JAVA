package com.empleados.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empleados.app.Dao.PlayerDao;
import com.empleados.app.entity.Player;

@Service
public class PlayerService {

	@Autowired
	PlayerDao dao;
	
	public List<Player> getPlayers() {
		return dao.findAll();
	}
	public void createPlayer(Player p) {
		dao.save(p);
	}
	public void modifyPlayer(Player p) {
		dao.save(p);
	}
	
	
}
