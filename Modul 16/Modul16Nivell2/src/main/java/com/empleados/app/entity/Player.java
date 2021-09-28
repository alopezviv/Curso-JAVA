package com.empleados.app.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Document(collection = "players")
public class Player {

	@Id
	private UUID id;
	private boolean anonim;
	private String name;
	private List<DiceRoll> rolls = new ArrayList<>();
	private List<DiceRoll> rolls2 = new ArrayList<>();
	private List<DiceRoll> rolls3 = new ArrayList<>();
	
	float winningPercentage = 0;
	float winningPercentage2 = 0;
	float winningPercentage3 = 0;
	
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
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		
		this.id = id;
		
	}
	public String getName() {
		if(isAnonim()) {
			return "Anonim";
		}else{
			return name;
			}
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
	@JsonIgnore
	public boolean isNew() {
        return getId() == null;
    }
	//@JsonIgnore
	public boolean isAnonim() {
		return anonim;
	}
	public void setAnonim(boolean isAnonim) {
		this.anonim = isAnonim;
	}
	
	
}
