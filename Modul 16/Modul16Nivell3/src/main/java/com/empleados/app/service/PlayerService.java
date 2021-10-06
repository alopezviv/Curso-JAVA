package com.empleados.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import com.empleados.app.Dao.PlayerDao;
import com.empleados.app.entity.DiceRoll;
import com.empleados.app.entity.Player;

@Service
public class PlayerService {

	@Autowired
	PlayerDao dao;
	public Player getPlayer(UUID id) throws Exception {
		Optional<Player> p =dao.findById(id);
		if(p.isPresent()) {
			return p.get();
		}else {
			throw new Exception("Player doesn't exist");
		}
	}
	
	public List<Player> getPlayers() {
		return dao.findAll();
	}
	public void createPlayer(Player p) throws Exception {
		if(p.getName().isBlank()) {
			throw new Exception("Debe rellenar el campo de nombre");
		}else if(dao.findDistinctByName(p.getName()).isPresent() ) {
			throw new Exception("Nombre no disponible");
		}else {
			dao.save(p);
		}
		dao.save(p);
	}
	public Player getPlayerByName(String name) throws Exception {
		if(dao.findDistinctByName(name).isPresent() ) {
			return dao.findDistinctByName(name).get();
		}else {
			throw new Exception("El Jugador no Existe");
		}
	}
	public void modifyPlayer(Player p) {
		dao.save(p);
	}
	
	public void play(UUID id) throws Exception {
		Player p = getPlayer(id);
		p.getRolls().add(new DiceRoll());
		p.setWinningPercentage(calculateWinningPercentage(p));
		dao.save(p);
	}
	public void play2(UUID id) throws Exception {
		Player p = getPlayer(id);
		p.getRolls2().add(new DiceRoll());
		p.setWinningPercentage2(calculateWinningPercentage2(p));
		dao.save(p);
	}
	public void play3(UUID id) throws Exception {
		Player p = getPlayer(id);
		p.getRolls3().add(new DiceRoll());
		p.setWinningPercentage3(calculateWinningPercentage3(p));
		dao.save(p);
	}
	public List<DiceRoll> getDiceRolls(UUID id) throws Exception {
		
		return getPlayer(id).getRolls();
	}
	public List<DiceRoll> getDiceRolls2(UUID id) throws Exception {
			
			return getPlayer(id).getRolls2();
		}
	public List<DiceRoll> getDiceRolls3(UUID id) throws Exception {
		
		return getPlayer(id).getRolls3();
	}
	public void deleteRolls(UUID id) throws Exception {
		Player p = getPlayer(id);
		p.getRolls().clear();
		calculateWinningPercentage(p);
		dao.save(p);
	}
	public void deleteRolls2(UUID id) throws Exception {
		Player p = getPlayer(id);
		p.getRolls2().clear();
		calculateWinningPercentage(p);
		dao.save(p);
	}
	public void deleteRolls3(UUID id) throws Exception {
		Player p = getPlayer(id);
		p.getRolls3().clear();
		calculateWinningPercentage(p);
		dao.save(p);
	}
	public float calculateWinningPercentage(Player p) {

		float result = 0;
		int win = 0;
		int lose = 0;
		
		for(int i = 0 ; i <p.getRolls().size(); i++) {
			int d1 = p.getRolls().get(i).getDice1();
			int d2 = p.getRolls().get(i).getDice2();
			if(d1 + d2 == 7) {
				win++;
			}else {
				lose++;
			}
		}
		if(win == 0) {
			result = 0;
		}else {
			int total = win + lose;
			float r = (float) ((win/(double)total)*100);
			result = r;
		}
		
		
		return result;
	}
	public float calculateWinningPercentage2(Player p) {

		float result = 0;
		int win = 0;
		int lose = 0;
		
		for(int i = 0 ; i <p.getRolls2().size(); i++) {
			int d1 = p.getRolls2().get(i).getDice1();
			int d2 = p.getRolls2().get(i).getDice2();
			if(d1 + d2 == 8) {
				win++;
			}else {
				lose++;
			}
		}
		if(win == 0) {
			result = 0;
		}else {
			int total = win + lose;
			float r = (float) ((win/(double)total)*100);
			result = r;
		}
		
		
		return result;
	}
	public float calculateWinningPercentage3(Player p) {

		float result = 0;
		int win = 0;
		int lose = 0;
		
		for(int i = 0 ; i <p.getRolls3().size(); i++) {
			int d1 = p.getRolls3().get(i).getDice1();
			int d2 = p.getRolls3().get(i).getDice2();
			if(d1 + d2 > 7) {
				win++;
			}else {
				lose++;
			}
		}
		if(win == 0) {
			result = 0;
		}else {
			int total = win + lose;
			float r = (float) ((win/(double)total)*100);
			result = r;
		}
		
		
		return result;
	}
	
	public Player getLowestRanking() {
		List<Player> pList = dao.findAll();
		pList.sort((a,b)-> Float.compare(a.getWinningPercentage() , b.getWinningPercentage()));
		return pList.get(0);
	}
	public Player getLowestRanking2() {
		List<Player> pList = dao.findAll();
		pList.sort((a,b)-> Float.compare(a.getWinningPercentage2() , b.getWinningPercentage2()));
		return pList.get(0);
	}
	public Player getLowestRanking3() {
		List<Player> pList = dao.findAll();
		pList.sort((a,b)-> Float.compare(a.getWinningPercentage3() , b.getWinningPercentage3()));
		return pList.get(0);
	}
	public Player getHighestRanking() {
		List<Player> pList = dao.findAll();
		pList.sort((a,b)-> Float.compare(a.getWinningPercentage() , b.getWinningPercentage()));
		return pList.get(pList.size()-1);
	}
	public Player getHighestRanking2() {
		List<Player> pList = dao.findAll();
		pList.sort((a,b)-> Float.compare(a.getWinningPercentage2() , b.getWinningPercentage2()));
		return pList.get(pList.size()-1);
	}
	public Player getHighestRanking3() {
		List<Player> pList = dao.findAll();
		pList.sort((a,b)-> Float.compare(a.getWinningPercentage3() , b.getWinningPercentage3()));
		return pList.get(pList.size()-1);
	}
	//Calcula porcentage medio de victoria
	public float getRanking() {
		float result = 0;
		int win = 0;
		int lose = 0;
		List<Player> pList = dao.findAll();
		for(Player p: pList) {
			for(DiceRoll d: p.getRolls()) {
				if(d.getDice1() + d.getDice2() == 7) {
					win++;
				}else {
					lose++;
				}
			}
		}
		
		if(win == 0) {
			result = 0;
		}else {
			int total = win + lose;
			float r = (float) ((win/(double)total)*100);
			result = r;
		}
		return result;
	}
	public float getRanking2() {
		float result = 0;
		int win = 0;
		int lose = 0;
		List<Player> pList = dao.findAll();
		for(Player p: pList) {
			for(DiceRoll d: p.getRolls2()) {
				if(d.getDice1() + d.getDice2() == 8) {
					win++;
				}else {
					lose++;
				}
			}
		}
		
		if(win == 0) {
			result = 0;
		}else {
			int total = win + lose;
			float r = (float) ((win/(double)total)*100);
			result = r;
		}
		return result;
	}
	public float getRanking3() {
		float result = 0;
		int win = 0;
		int lose = 0;
		List<Player> pList = dao.findAll();
		for(Player p: pList) {
			for(DiceRoll d: p.getRolls3()) {
				if(d.getDice1() + d.getDice2() > 7) {
					win++;
				}else {
					lose++;
				}
			}
		}
		
		if(win == 0) {
			result = 0;
		}else {
			int total = win + lose;
			float r = (float) ((win/(double)total)*100);
			result = r;
		}
		return result;
	}
}

