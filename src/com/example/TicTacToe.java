package com.example;

import java.util.*;

public class TicTacToe {
	public static Scanner sc = new Scanner(System.in);
	public char[] addBoard() {
		char [] board = new char[10];
		for(int i=1; i<board.length; i++)
			board[i] = ' ';
		return board;
	}
	public char takeInput() {
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
			System.out.println("Location is invalid or occupied. Try again");
		}while(isEmpty==false);
		if(isEmpty) {
			System.out.println("Position is empty");
		}
		else
			System.out.println("Not empty");
		return position;
	}
	public static void moveAtLocation(char[] board, char user) {
		int position = moveLocation(board);
		board[position] = user;
		showBoard(board);
	}
	public static void main(String[] args) {
		System.out.println("Welcome");
		char comp = ' ';
		TicTacToe t= new TicTacToe();
		char [] board=t.addBoard();
		char user = t.takeInput();
		if(user == 'X') {
			comp = 'O';}
		else if(user =='O') {
			comp='X';}
		else
		{
			System.out.println("Wrong choice");
		}
		System.out.println("User-"+user+" Computer-"+comp);
		showBoard(board);
		moveAtLocation(board,user);
	}
}