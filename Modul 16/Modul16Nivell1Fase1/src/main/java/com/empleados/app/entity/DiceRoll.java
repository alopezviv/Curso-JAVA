package com.empleados.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="dicerolls")
public class DiceRoll {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private int dice1;
	private int dice2;
	@ManyToOne
	@JoinColumn(name="player_id", nullable=false)
	private Player player;
	public DiceRoll() {
		
	}
	public DiceRoll(Player player) {
		this.dice1 = (int)Math.ceil(Math.random()*6);
		this.dice2 = (int)Math.ceil(Math.random()*6);
		this.player = player;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getDice1() {
		return dice1;
	}
	public void setDice1(int dice1) {
		this.dice1 = dice1;
	}
	public int getDice2() {
		return dice2;
	}
	public void setDice2(int dice2) {
		this.dice2 = dice2;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
}
