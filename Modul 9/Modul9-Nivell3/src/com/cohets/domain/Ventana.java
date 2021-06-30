package com.cohets.domain;
import javax.swing.*;
public class Ventana extends JFrame{
	public Ventana() {
		setSize(500,500);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
		setLocation(300,300);
		addPanel();
	}
	
	public void addPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
	}
}
	