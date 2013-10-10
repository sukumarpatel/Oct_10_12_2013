package com.lab01.client.model;

public class Game {
	private int target;
	private int attempts;
	private String message;
	private boolean gameOver;
	
	public boolean isGameOver() {
		return gameOver;
	}
	public int getAttempts() {
		return attempts;
	}
	public String getMessage() {
		return message;
	}
	public Game(){
		target = (int)(Math.random()*100);
	}
	public void play(int guess){
		attempts++;
		if(guess > target)
			message = "Aim Lower";
		else if(guess < target)
			message = "Aim Higher";
		else{
			message = "You've got it!!!";
			gameOver = true;
		}
	}
}
