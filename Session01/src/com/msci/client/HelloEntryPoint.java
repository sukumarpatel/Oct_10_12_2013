package com.msci.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class HelloEntryPoint implements EntryPoint {
	public void onModuleLoad() {
		Label label = new Label("Enter your name");
		final TextBox nameTextBox = new TextBox();
		final Button button = new Button("Submit");
		
		RootPanel.get().add(label);
		RootPanel.get().add(nameTextBox);
		//RootPanel.get().add(button);
		RootPanel.get("container1").add(button);
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				String msg = "Hello " + nameTextBox.getValue();
				Window.alert(msg);
				nameTextBox.setEnabled(false);
				button.setVisible(false);
			}
		});
		
		
		//Window.alert("Hello World");
	}
}
