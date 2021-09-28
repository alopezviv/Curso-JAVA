package com.empleados.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
	public Player getPlayer(int id) throws Exception {
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
		if(p.getName().equals("Anonim")) {
			dao.save(p);
		}else if(dao.findDistinctByName(p.getName()).isPresent() ) {
			throw new Exception("Nombre no disponible");
		}else {
			dao.save(p);
		}
		
	}
	public void modifyPlayer(Player p) {
		dao.save(p);
	}
	
	public void play(int id) throws Exception {
		Player p = getPlayer(id);
		p.getRolls().add(new DiceRoll());
		p.setWinningPercentage(calculateWinningPercentage(p));
		dao.save(p);
	}
	public List<DiceRoll> getDiceRolls(int id) throws Exception {
		
		return getPlayer(id).getRolls();
	}
	public void deleteRolls(int id) throws Exception {
		Player p = getPlayer(id);
		p.getRolls().clear();
		calculateWinningPercentage(p);
		dao.save(p);
	}
	public float calculateWinningPercentage(Player p) {

		float result = 0;
		int win = 0;
		int lose = 0;
		
		/*for(DiceRoll dice: p.getRolls()) {
			if((dice.getDice1() + dice.getDice2()) == 7) {
				win++;
			}else {
				lose++;
			}
		}*/
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
	public Player getLowestRanking() {
		List<Player> pList = dao.findAll();
		pList.sort((a,b)-> Float.compare(a.getWinningPercentage() , b.getWinningPercentage()));
		return pList.get(0);
	}
	public Player getHighestRanking() {
		List<Player> pList = dao.findAll();
		pList.sort((a,b)-> Float.compare(a.getWinningPercentage() , b.getWinningPercentage()));
		return pList.get(pList.size()-1);
	}
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
}

