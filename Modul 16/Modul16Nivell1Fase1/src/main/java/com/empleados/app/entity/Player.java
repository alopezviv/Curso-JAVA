package com.empleados.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "players")
public class Player {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL,  orphanRemoval = true)
	@JoinColumn(name="player_id", nullable=false)
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name.isBlank()) {
			this.name = "Anonim";
		}else {
			this.name = name;
		}
	}
	public float getWinningPercentage() {
		return winningPercentage;
	}
	public void setWinningPercentage(float winningPercentage) {
		this.winningPercentage = winningPercentage;
	}
	
	
	
}
