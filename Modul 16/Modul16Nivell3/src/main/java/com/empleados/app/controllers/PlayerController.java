package com.empleados.app.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empleados.app.entity.DiceRoll;
import com.empleados.app.entity.Player;
import com.empleados.app.service.PlayerService;

@CrossOrigin
@RestController
public class PlayerController {

	@Autowired
	PlayerService ps;
	@GetMapping("/players")
	public ResponseEntity<List<Player>> getPlayers(){
		return new ResponseEntity<List<Player>>(ps.getPlayers(), HttpStatus.OK);
	}
	@GetMapping("/players/{id}")
	public ResponseEntity<Player> getPlayers(@PathVariable UUID id){
		try {
			Player player = ps.getPlayer(id);
			return new ResponseEntity<Player>(player, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
	}
	@GetMapping("/player/{name}")
	public ResponseEntity<Player> getPlayerByName(@PathVariable String name){
		try {
			return new ResponseEntity<Player>(ps.getPlayerByName(name), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/players")
	public ResponseEntity<String> postPlayer(Player p) {
		try {
			ps.createPlayer(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Player created!", HttpStatus.OK);
	}
	@PutMapping("/players")
	public ResponseEntity<String> modifyPlayer(Player p) {
		ps.modifyPlayer(p);
		return new ResponseEntity<>("Player modified!", HttpStatus.OK);
	}
	@PostMapping("/players/{id}/games")
	public ResponseEntity<String> play(@PathVariable UUID id) {
		try {
			ps.play(id);
			return new ResponseEntity<>("Roll!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/players/{id}/games2")
	public ResponseEntity<String> play2(@PathVariable UUID id) {
		try {
			ps.play2(id);
			return new ResponseEntity<>("Roll!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/players/{id}/games3")
	public ResponseEntity<String> play3(@PathVariable UUID id) {
		try {
			ps.play3(id);
			return new ResponseEntity<>("Roll!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/players/{id}/games")
	public ResponseEntity<String> deleteRolls(@PathVariable UUID id) {
		try {
			ps.deleteRolls(id);
			return new ResponseEntity<>("Rolls Deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/players/{id}/games2")
	public ResponseEntity<String> deleteRolls2(@PathVariable UUID id) {
		try {
			ps.deleteRolls2(id);
			return new ResponseEntity<>("Rolls Deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/players/{id}/games3")
	public ResponseEntity<String> deleteRolls3(@PathVariable UUID id) {
		try {
			ps.deleteRolls3(id);
			return new ResponseEntity<>("Rolls Deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/players/{id}/games")
	public ResponseEntity<List<DiceRoll>> getRolls(@PathVariable UUID id) {
		try {
			return new ResponseEntity<>(ps.getDiceRolls(id), HttpStatus.OK );
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/players/{id}/games2")
	public ResponseEntity<List<DiceRoll>> getRolls2(@PathVariable UUID id) {
		try {
			return new ResponseEntity<>(ps.getDiceRolls2(id), HttpStatus.OK );
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/players/{id}/games3")
	public ResponseEntity<List<DiceRoll>> getRolls3(@PathVariable UUID id) {
		try {
			return new ResponseEntity<>(ps.getDiceRolls3(id), HttpStatus.OK );
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/players/ranking/losser")
	public ResponseEntity<Player> getLosser() {
		return new ResponseEntity<>(ps.getLowestRanking(),HttpStatus.OK);
	}
	@GetMapping("/players/ranking/losser2")
	public ResponseEntity<Player> getLosser2() {
		return new ResponseEntity<>(ps.getLowestRanking2(),HttpStatus.OK);
	}
	@GetMapping("/players/ranking/losser3")
	public ResponseEntity<Player> getLosser3() {
		return new ResponseEntity<>(ps.getLowestRanking3(),HttpStatus.OK);
	}
	@GetMapping("/players/ranking/winner")
	public ResponseEntity<Player> getWinner() {
		
		return new ResponseEntity<>(ps.getHighestRanking(),HttpStatus.OK);
	}
	@GetMapping("/players/ranking/winner2")
	public ResponseEntity<Player> getWinner2() {
		
		return new ResponseEntity<>(ps.getHighestRanking2(),HttpStatus.OK);
	}
	@GetMapping("/players/ranking/winner3")
	public ResponseEntity<Player> getWinner3() {
		
		return new ResponseEntity<>(ps.getHighestRanking3(),HttpStatus.OK);
	}
	@GetMapping("/players/ranking")
	public ResponseEntity<Float> getRanking() {
		
		return new ResponseEntity<>(ps.getRanking(),HttpStatus.OK);
	}
	@GetMapping("/players/ranking2")
	public ResponseEntity<Float> getRanking2() {
		
		return new ResponseEntity<>(ps.getRanking2(),HttpStatus.OK);
	}
	@GetMapping("/players/ranking3")
	public ResponseEntity<Float> getRanking3() {
		
		return new ResponseEntity<>(ps.getRanking3(),HttpStatus.OK);
	}
}
