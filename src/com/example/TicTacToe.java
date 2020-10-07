package com.example;

import java.util.*;

public class TicTacToe {
	public final static int TAIL = 0;
	public final static int HEAD = 1;
	public static char Comp;
	public static char[] board;
	public static char userChoice;
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
		do {
		System.out.println("Select location from 1 to 9 on the baord:");
		position = sc.nextInt();
		Integer [] validCells = {1, 2, 3, 4, 5, 6, 7, 8, 9};
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
	public static void moveAtLocation(char[] board, char Choice) {
		boolean empty = false;
		if(Choice==userChoice) {
		int position = moveLocation(board);
		board[position] = Choice;
		}
		else {
		do {
		int position = (int)(Math.floor((Math.random()*10)%9)+1);
		empty = isFree(board, position);
		if(empty)
			board[position] = Choice;	
		}while(empty==false);
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
			moveAtLocation(board, userChoice);
		}
		else if(gameToss == TAIL) {
			moveAtLocation(board, Comp);
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
				System.out.println(" Game Over ! Computer Wins Tic Tac Toe Game");
			System.exit(0);
		}
		else {
			if(board[1]!=' ' && board[2]!=' ' && board[3]!=' ' && board[4]!=' '
				&&board[5]!=' ' && board[6]!=' ' && board[7]!=' ' && board[8]!=' '
				&& board[9]!=' ') {
			System.out.println("TIE");
			System.exit(0);
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
	public static void main(String[] args) {
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
		}
		System.out.println("User-"+userChoice+" Computer-"+Comp);
		firstPlayer(gameToss);
	}
}