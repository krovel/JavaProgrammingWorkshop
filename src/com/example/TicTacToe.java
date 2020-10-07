package com.example;

import java.util.*;

public class TicTacToe {
	Scanner sc = new Scanner(System.in);
	public char[] addBoard() {
		char [] board = new char[10];
		for(int i=1; i<10; i++)
			board[i] = ' ';
		return board;
	}
	public char takeInput(){	
		System.out.println("Please choose either X or O:");
		char user = sc.next().charAt(0);
		return user;
	}
	public static void main(String[] args) {
		System.out.println("Welcome");
		char comp = ' ';
		TicTacToe t= new TicTacToe();
		t.addBoard();
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
	}
}