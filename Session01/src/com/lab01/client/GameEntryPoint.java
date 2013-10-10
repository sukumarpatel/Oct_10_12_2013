package com.lab01.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.lab01.client.model.Game;

public class GameEntryPoint implements EntryPoint {

	private TextBox guessTextBox;
	private Button guessButton;
	private Label messageLabel;
	private Label attemptsLabel;
	private Game game;
	
	private void playAgain(){
		game = new Game();
		messageLabel.setText("");
		attemptsLabel.setText("");
		guessTextBox.setValue("0");
	}
	public void onModuleLoad() {
		game = new Game();
		guessTextBox = new TextBox();
		guessButton = new Button("Guess");
		guessButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				int guess = Integer.parseInt(guessTextBox.getValue());
				game.play(guess);
				messageLabel.setText(game.getMessage());
				attemptsLabel.setText("Attempts: " + game.getAttempts());
				guessTextBox.selectAll();
				if(game.isGameOver()){
					boolean playAgain = Window.confirm("Do you want to play again?");
					if(playAgain){
						playAgain();
					}
					else{
						guessButton.setEnabled(false);
					}
				}
			}
		});
		messageLabel = new Label();
		attemptsLabel = new Label();
		RootPanel.get("guessform").add(guessTextBox);
		RootPanel.get("guessform").add(guessButton);
		RootPanel.get("messageh2").add(messageLabel);
		RootPanel.get("attemptsh2").add(attemptsLabel);
		
	}
}
