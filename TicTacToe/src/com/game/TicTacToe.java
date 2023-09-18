package com.game;

import java.util.Scanner;

public class TicTacToe {
	private Player player1,player2;
	private Board board;
	private int numPlayers;

	public static void main(String[] args) {
		TicTacToe t=new TicTacToe();
		t.startGame();
		
		
	}
	
	public void startGame() {
		Scanner s=new Scanner(System.in);
		//Take players input
		player1=takePlayerInput(++numPlayers);
		player2=takePlayerInput(++numPlayers);
		
		while(player1.getSymbol()==player2.getSymbol()) {
			System.out.println("Symbol already taken !! Please enter the symbol again to proceed!");
			player2.setSymbol(s.next().charAt(0));
		}
		//create the board
		board =new Board(player1.getSymbol(),player2.getSymbol());
		
		//play the game
		boolean player1Turn=true;
		int status=Board.INCOMPLETE;
		while(status==Board.INCOMPLETE || status==Board.INVALID_MOVE) {  //if it is invalid or incomplete take input
			if(player1Turn) {
				System.out.println("Player 1 -"+player1.getName()+" 's turn ");
			     System.out.println("Enter x: ");
			     int x=s.nextInt();
			     System.out.println("Enter y: ");
			     int y=s.nextInt();
			     
			      status=board.move(player1.getSymbol(),x,y); //make move and tell status also
			      if(status==Board.INVALID_MOVE) {
			    	  System.out.println("Invalid move !! Please try again !!");
			        continue;
			      }
			    
			}else {
				System.out.println("Player 2 -"+player2.getName()+" 's turn ");
			     System.out.println("Enter x: ");
			     int x=s.nextInt();
			     System.out.println("Enter y: ");
			     int y=s.nextInt();
			     
			      status=board.move(player2.getSymbol(),x,y); //make move and tell status also
			      if(status==Board.INVALID_MOVE) {
			    	  System.out.println("Invalid move !! Please try again !!");
			    	  continue;
			      }
			     
			}
			  player1Turn=!player1Turn;
		      board.print();
		
		}
		
		if(status==Board.PLAYER1WINS) {
			System.out.println("Player 1 - "+ player1.getName()+" wins!!");
		}else if(status==Board.PLAYER2WINS) {
			System.out.println("Player 2 - "+ player2.getName()+" wins!!");
		}else {
			System.out.println("It's a draw!");
		}
		
	
	}
	private Player takePlayerInput(int num) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Player "+num+"'s name: ");
		String name=sc.nextLine();
		System.out.println("Enter the Player "+num+ "'s symbol: ");
		char symbol =sc.next().charAt(0);
		Player p = new Player(name,symbol);
		return p;
	}
}
