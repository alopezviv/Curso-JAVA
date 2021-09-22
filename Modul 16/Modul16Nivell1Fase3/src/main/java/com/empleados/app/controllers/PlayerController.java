package com.empleados.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empleados.app.entity.DiceRoll;
import com.empleados.app.entity.Player;
import com.empleados.app.service.PlayerService;

@RestController
public class PlayerController {

	@Autowired
	PlayerService ps;
	@GetMapping("/players")
	public ResponseEntity<List<Player>> getPlayers(){
		return new ResponseEntity<List<Player>>(ps.getPlayers(), HttpStatus.OK);
	}
	@PostMapping("/players")
	public ResponseEntity<String> postPlayer(Player p) {
		ps.createPlayer(p);
		return new ResponseEntity<>("Player created!", HttpStatus.OK);
	}
	@PutMapping("/players")
	public ResponseEntity<String> modifyPlayer(Player p) {
		ps.modifyPlayer(p);
		return new ResponseEntity<>("Player modified!", HttpStatus.OK);
	}
	@PostMapping("/players/{id}/games")
	public ResponseEntity<String> play(@PathVariable String id) {
		try {
			ps.play(id);
			return new ResponseEntity<>("Roll!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/players/{id}/games")
	public ResponseEntity<String> deleteRolls(@PathVariable String id) {
		try {
			ps.deleteRolls(id);
			return new ResponseEntity<>("Rolls Deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/players/{id}/games")
	public ResponseEntity<List<DiceRoll>> getRolls(@PathVariable String id) {
		try {
			return new ResponseEntity<>(ps.getDiceRolls(id), HttpStatus.OK );
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/players/ranking/losser")
	public ResponseEntity<Player> getLosser() {
		return new ResponseEntity<>(ps.getLowestRanking(),HttpStatus.OK);
	}
	@GetMapping("/players/ranking/winner")
	public ResponseEntity<Player> getWinner() {
		
		return new ResponseEntity<>(ps.getHighestRanking(),HttpStatus.OK);
	}
	@GetMapping("/players/ranking")
	public ResponseEntity<Float> getRanking() {
		
		return new ResponseEntity<>(ps.getRanking(),HttpStatus.OK);
	}
}
