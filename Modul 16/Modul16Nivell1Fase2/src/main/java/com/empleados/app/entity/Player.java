package com.empleados.app.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "players")
public class Player {

	@Id
	private String id;
	private String name;
	private List<DiceRoll> rolls = new ArrayList<>();
	
	float winningPercentage = 0;
	
	
	public Player() {}
	public Player(String name) {
		this.name = name;
	}
	public List<DiceRoll> getRolls() {
		return rolls;
	}
	public void setRolls(List<DiceRoll> rolls) {
		this.rolls = rolls;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getWinningPercentage() {
		return winningPercentage;
	}
	public void setWinningPercentage(float winningPercentage) {
		this.winningPercentage = winningPercentage;
	}
	
	
	
}
