package com.game;

public class Board {
	private char board[][];
	private int boardSize=3;
	private char p1Symbol,p2Symbol;
	//count of number of cells that are filled
	private int count;
	
	private static final char EMPTY=' ';
	public static final int PLAYER1WINS=1;
	public static final int PLAYER2WINS=2;
	public static final int DRAW=3;
	public static final int INCOMPLETE=4;
	public static final int INVALID_MOVE=5;



	

	public Board(char p1Symbol, char p2Symbol ) {
		board=new char[boardSize][boardSize];
		for(int i=0;i<boardSize;i++) {
			for(int j=0;j<boardSize;j++) {
				board[i][j]=EMPTY;
			}
		}
		this.p1Symbol=p1Symbol;
		this.p2Symbol=p2Symbol;
	}
	public Board(char p1Symbol) {
		board=new char[boardSize][boardSize];
		for(int i=0;i<boardSize;i++) {
			for(int j=0;j<boardSize;j++) {
				board[i][j]=EMPTY;
			}
		}
		this.p1Symbol=p1Symbol;
		
	}
	public int move(char symbol, int x, int y) {
		 //check if its a valid move
	          if(x<0 || x>= boardSize || y<0 || y>=boardSize  || board[x][y]!=EMPTY) {
	        	  return INVALID_MOVE;
	          }
	          board[x][y]=symbol;
	          count++;
	          
	          //wining condition
	          //check xth row 
	          if(board[x][0]==board[x][1] &&board[x][0]==board[x][2]) {
	        	  return symbol==p1Symbol?PLAYER1WINS:PLAYER2WINS;
	          }
	          
	          //Column 
	          if(board[0][y]==board[1][y] &&board[0][y]==board[2][y]) {
	        	  return symbol==p1Symbol?PLAYER1WINS:PLAYER2WINS;
	          }
	          //Diagonals
	          /* important to check if the diagonal is empty or not if all empty it will become true even if x or y is not placed in that coordinate                          */
	          if(board[0][1]!=EMPTY &&board[0][1]==board[1][1] && board[1][1]==board[2][1]) {
	        	  return symbol==p1Symbol?PLAYER1WINS:PLAYER2WINS;
	          }
	          
	          if(board[0][0]!=EMPTY && board[0][0]==board[1][1] && board[1][1]==board[2][2]) {
	        	  return symbol==p1Symbol?PLAYER1WINS:PLAYER2WINS;
	          }
	          if(board[0][2]!=EMPTY &&board[0][2]==board[1][1] && board[1][1]==board[2][0]) {
	        	  return symbol==p1Symbol?PLAYER1WINS:PLAYER2WINS;
	          }
	          
	          if(count==boardSize*boardSize) {
	        	  return DRAW;
	          }
	           
				return INCOMPLETE;
	}
	public void print() {
		System.out.println("------------");
		 for(int i=0;i<boardSize;i++) {
			 for(int j=0;j<boardSize;j++) {
				 System.out.print("| "+board[i][j]+" |");
			 }
			 System.out.println();
		 }
		 System.out.println();
		
		System.out.println("------------");
	}
		 
		
	}
	


