package com.example;

public class TicTacToe {
	public void addBoard() {
		char [] board = new char[10];
		for(int i=1; i<10; i++)
			board[i] = ' ';
	}
	public static void main(String[] args) {
		System.out.println("Welcome");
		TicTacToe t = new TicTacToe();
		t.addBoard();
	}
}