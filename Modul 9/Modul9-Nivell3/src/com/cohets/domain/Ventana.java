package com.cohets.domain;
import java.awt.Color;

import javax.swing.*;
public class Ventana extends JFrame{
	JPanel panel;
	JTextField cajaTexto;
	public Ventana() {
		setSize(500,500);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocation(300,300);
		addPanel();
		setVisible(true);

	}
	
	public void addPanel() {
		panel = new JPanel(); 
		//panel.setBackground(Color.red);
		panel.setLayout(null);
		//panel.setSize(500, 500);
		this.getContentPane().add(panel);
		addTextBox();		

	}
	public void addTextBox() {
		//Crea caja de texto para que el usuario introduzca una nueva velocidadObjetivo
		cajaTexto = new JTextField();
		
		cajaTexto.setBounds(50, 50, 150, 30);
		panel.add(cajaTexto);
	}
	public void addButtonVelocidad(Coet c) {
		//Crea el botton con el acction listener para cambiar la velocidad objetivo del cohete
		JButton botonVelocidad = new JButton("Cambiar velocidad");
		botonVelocidad.setBounds(50, 80, 150, 30);
		botonVelocidad.addActionListener(e ->{
			if(c.getPropulsors().get(0).getT().isAlive() ) {
				c.parar();
			}
			if(c.getPropulsors().get(0).getT() == null){
				
			}
			c.setVelocitatObjectiu(Double.parseDouble(cajaTexto.getText()));
			new Thread(c).start();
		});
		panel.add(botonVelocidad);
		
	}
	public void addBottonAceleracion5(Coet c) {
		JButton aceleracion5 = new JButton("Acceleracion 5");
		aceleracion5.setBounds(300, 50, 150, 30);
		aceleracion5.addActionListener(e ->{
			if(c.getPropulsors().get(0).getT().isAlive() ) {
				c.parar();
			}
			if(c.getPropulsors().get(0).getT() == null){
				
			}
			c.getPropulsors().forEach(p -> p.setAceleracion(5));
			new Thread(c).start();
		});
		panel.add(aceleracion5);
	}
	public void addBottonAceleracion1(Coet c) {
		JButton aceleracion5 = new JButton("Acceleracion 1");
		aceleracion5.setBounds(300, 90, 150, 30);
		aceleracion5.addActionListener(e ->{
			if(c.getPropulsors().get(0).getT().isAlive() ) {
				c.parar();
			}
			if(c.getPropulsors().get(0).getT() == null){
				
			}
			c.getPropulsors().forEach(p -> p.setAceleracion(1));
			new Thread(c).start();
		});
		panel.add(aceleracion5);
	}
	
}
	