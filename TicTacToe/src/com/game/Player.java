package com.game;

public class Player {
	private String name;
	private char symbol;
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Player(String name, char symbol) {
		super();
		setName(name);
		setSymbol(symbol);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(!name.isEmpty()) {
			this.name = name;
		}else {
			System.out.println("Cant be Empty!");
		}
		
	}
	public char getSymbol() {
		return symbol;
	}
	public void setSymbol(char symbol) {
		if(symbol =='x' || symbol=='0' || symbol=='X' ) {
			this.symbol = symbol;
		}
		else {
			System.out.println("Enter valid symbol!");
		}
		
	}
	
	
	

}
