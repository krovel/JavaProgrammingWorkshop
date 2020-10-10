package com.example;

import java.util.*;

public class TicTacToe {
	public final static int TAIL = 0;
	public final static int HEAD = 1;
	public static char Comp;
	public static char[] board;
	public static char userChoice;
	public static String game;
	public static Scanner sc = new Scanner(System.in);
	
	public static char[] addBoard() {
		char [] board = new char[10];
		for(int i=1; i<board.length; i++)
			board[i] = ' ';
		return board;
	}
	public static char takeInput() {
		System.out.println("Please choose either X or O:");
		char user = sc.next().charAt(0);
		return user;
	}
	public static void showBoard(char[] board) {
		int i, j = 0;
		int boardPosition = 1;
		char[][] gameBoard = new char[3][3];
		System.out.println("Displaying Board:");
		for (i = 0; i < 3; i++) {
			for (j = 0; j < 3; j++) {
				gameBoard[i][j] = board[boardPosition];
				System.out.print(gameBoard[i][j]);
				if (j < 2)
					System.out.print(" | ");
				boardPosition++;
			}
			System.out.println();
			if (i < 2)
				System.out.println("---------");
		}
	}
	public static int moveLocation(char[] board) {
		boolean isEmpty = false;
		int position=0;
		Integer [] validCells = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		do {
		System.out.println("Select location from 1 to 9 on the baord:");
		position = sc.nextInt();
		if(board[position]==' '&& Arrays.asList(validCells).contains(position)) {
			isEmpty = true;
		}
		else 
			System.out.println("Location is invalid or occupied. Try another location:");
		}while(isEmpty==false);
		return position;
	}
	public static boolean isFree(char[] board, int position) {
		return board[position]==' ';
	}
	public static void moveAtLocation(char Choice) {
		if(Choice==userChoice) {
		int position = moveLocation(board);
		board[position] = Choice;
		}
		else {
		int position = computerPlaysLikeMe();
		board[position] = Choice;	
		}
		showBoard(board);
	}
	public static int toss() {
		int gameToss = (int)(Math.floor(Math.random()*10)%2);
		return gameToss;		
	}
	public static void firstPlayer(int gameToss) {
		if(gameToss == HEAD) {
			System.out.println("User will play first");
			gameConditions(gameToss);
		}
		if(gameToss == TAIL) {
			System.out.println("Computer will play first");
			gameConditions(gameToss);;		
		}
	}
	private static void gameConditions(int gameToss) {
		if(gameToss == HEAD) {
			moveAtLocation(userChoice);
		}
		else if(gameToss == TAIL) {
			moveAtLocation(Comp);
		}
		if((board[1]==board[2] && board[2]==board[3] && board[1]!=' ')
				|| (board[4]==board[5] && board[5]==board[6] && board[6]!=' ')
				|| (board[7]==board[8] && board[8]==board[9] && board[9]!=' ') 
				|| (board[1]==board[4] && board[4]==board[7] && board[7]!=' ')
				|| (board[2]==board[5] && board[5]==board[8] && board[8]!=' ')
				|| (board[3]==board[6] && board[6]==board[9] && board[9]!=' ')
				|| (board[1]==board[5] && board[5]==board[9] && board[9]!=' ')
				|| (board[3]==board[5] && board[5]==board[7] && board[7]!=' ')) {
			if(gameToss==HEAD)
				System.out.println("Congrats ! User Wins Tic Tac Toe Game");
			if(gameToss==TAIL)
				System.out.println("Game Over ! Computer Wins Tic Tac Toe Game");
		}
		else {
			if(board[1]!=' ' && board[2]!=' ' && board[3]!=' ' && board[4]!=' '
				&&board[5]!=' ' && board[6]!=' ' && board[7]!=' ' && board[8]!=' '
				&& board[9]!=' ') {
			System.out.println("It's a TIE ! Well Played");
			}
			else {
				if(gameToss == HEAD) {
					gameToss--;
					gameConditions(gameToss);
				}
				else if(gameToss == TAIL) {
					gameToss++;
					gameConditions(gameToss);
				}
			}
		}
	}
	public static int computerPlaysLikeMe() {
		int i = 0, k = 0, count = 0, position = 0;
		while(k<=6 && position==0) {
			count = 0;
			for(i=k+1; i<=k+3; i++) {
				if(board[i]==Comp)
					count++;
				}
			if(count==2) {
				i = i-3;
				while(count>=0) {
					if(board[i]!=Comp && isFree(board, i))
						position = i;
					else
						i++;
					count--;
				}
			}
			k = k + 3;
		}
		k = 0;
		while(k<=2 && position==0) {
			count = 0;
			for(i=k+1; i<=k+7; i=i+3) {
				if(board[i]==Comp)
					count++;
			}
			if(count==2) {
				i = i-9;
				while(count>=0) {
					if(board[i]!=Comp && isFree(board, i))
						position = i;
					else
					i=i+3;
				count--;
				}
			}
			k++;
		}
		if(position==0 && (board[1]==board[5] && board[1]==Comp) || (board[5]==board[9]
				&& board[5]==Comp) ||(board[1]==board[9] && board[9]==Comp)) {
			i = 1;
			while(i<=9 && position==0) {
				if(board[i]!=Comp && isFree(board, i))
					position = i;
				else
					i=i+4;
				}
			}
		if(position==0 && (board[3]==board[5] && board[3]==Comp) || (board[5]==board[7]
				&& board[5]==Comp) ||(board[3]==board[7] && board[7]==Comp)) {
			i = 3;
			while(i<=7 && position==0) {
				if(board[i]!=Comp && isFree(board, i))
					position = i;
				else
					i=i+2;
				}
			}
		if(position!=0) {
			return position;
		}		
		else {
			return computerPlaysLikeMeToBlock();
		}
	}
	public static int computerPlaysLikeMeToBlock() {
		int i = 0, k = 0, count = 0, position = 0;
		while(k<=6 && position==0) {
			count = 0;
		for(i=k+1; i<=k+3; i++) {
			if(board[i]==userChoice)
				count++;
		}
		if(count==2) {
			i = i-3;
			while(count>=0) {
			if(board[i]!=userChoice && isFree(board, i))
				position = i;
			else
				i++;
			count--;
		}
		}
		k = k + 3;
		}
		k = 0;
		while(k<=2 && position==0) {
			count = 0;
			for(i=k+1; i<=k+7; i=i+3) {
				if(board[i]==userChoice)
					count++;
			}
			if(count==2) {
				i = i-9;
				while(count>=0) {
				if(board[i]!=userChoice && isFree(board, i))
					position = i;
				else
					i=i+3;
				count--;
			}
			}
			k++;
			}
		if(position==0 && (board[1]==board[5] && board[1]==userChoice) || (board[5]==board[9]
				&& board[5]==userChoice) ||(board[1]==board[9] && board[9]==userChoice)) {
			i = 1;
			while(i<=9 && position==0) {
				if(board[i]!=userChoice && isFree(board, i))
					position = i;
				else
					i=i+4;
				}
			}
		if(position==0 && (board[3]==board[5] && board[3]==userChoice) || (board[5]==board[7]
				&& board[5]==userChoice) || (board[3]==board[7] && board[7]==userChoice)) {
			i = 3;
			while(i<=7 && position==0) {
				if(board[i]!=userChoice && isFree(board, i)) {
					position = i;
					System.out.println("position "+i);
				}
				else
					i=i+2;
				}
			}
		if(position!=0)
			return position;		
		else 
			return computerTakesFourCorners();

	}
	public static int computerTakesFourCorners() {
		int position = 0;
		if(board[1]==Comp && isFree(board, 9))
			position = 9;
		else if(board[3]==Comp && isFree(board, 7))
			position = 7;
		else if(board[7]==Comp && isFree(board, 3))
			position = 3;
		else if(board[9]==Comp && isFree(board, 1))
			position = 1;
		else {
			while(position==0) {
				int i = (int)(Math.floor((Math.random()*10)%9)+1);
				if(i==1 || i==3 || i==7 || i==9) {
				if(isFree(board, i))
					position = i;
				}
			}	
		}
		if(position!=0)
			return position;
		else
			return computerPlaystoTakesCenterOrSides();
	}
	public static int computerPlaystoTakesCenterOrSides() {
		int position = 0;
		if(isFree(board, 5))
			position = 5;
		else {
			while(position==0) {
			int i = (int)(Math.floor((Math.random()*10)%9)+1);
				if(isFree(board, i))
				position = i;
			}
		}
		return position;
	}
	public static void main(String[] args) {
		do {
			System.out.println("Welcome");
			board=addBoard();
			userChoice=takeInput();
			int gameToss = toss();
			if(userChoice == 'X') {
				Comp = 'O';}
			else if(userChoice =='O') {
				Comp='X';}
			else
			{
					System.out.println("Wrong choice");
					break;
		}
			System.out.println("User-"+userChoice+" Computer-"+Comp);
			firstPlayer(gameToss);
			System.out.println("Dare to play again ? (Yes/No)");
			game = sc.next().toLowerCase();
		}while(game.equals("yes"));
		System.out.println("Thank You for Playing! Have a Nice Day. :)");
	}
}