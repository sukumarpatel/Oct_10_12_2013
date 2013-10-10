package com.lab02.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class Lab02EntryPoint implements EntryPoint {

	private TextBox nameTextBox,ageTextBox;
	private RadioButton maleRbtn, femaleRbtn;
	private Button addButton,removeButton;
	private FlexTable personsTable;
	private ClickHandler addPersonHandler,removePersonHandler;
	
	private void initializeComponents(){
		nameTextBox = new TextBox();
		RootPanel.get("namecontainer").add(nameTextBox);
		ageTextBox = new TextBox();
		RootPanel.get("agecontainer").add(ageTextBox);
		maleRbtn = new RadioButton("gender", "Male");
		femaleRbtn = new RadioButton("gender", "Female");
		RootPanel.get("gendercontainer").add(maleRbtn);
		RootPanel.get("gendercontainer").add(femaleRbtn);
		addButton = new Button("Add");
		addButton.addClickHandler(addPersonHandler);
		RootPanel.get("addcontainer").add(addButton);
		personsTable = new FlexTable();
		
		personsTable.setBorderWidth(1); 
		RootPanel.get().add(personsTable);
		removeButton = new Button("Remove");
		removeButton.addClickHandler(removePersonHandler);
		removeButton.setVisible(false);
		RootPanel.get().add(removeButton);
	}
	private void showHeader(){
		personsTable.setText(0, 0, "Select");
		personsTable.setText(0, 1, "Name");
		personsTable.setText(0, 2, "Age");
		personsTable.setText(0, 3, "Gender");
	}
	public void onModuleLoad() {
		addPersonHandler = new ClickHandler() {
			public void onClick(ClickEvent event) {
				removeButton.setVisible(true);
				if(personsTable.getRowCount() == 0){
					showHeader();
				}
				int rowToBeAdded = personsTable.getRowCount();
				personsTable.setWidget(rowToBeAdded, 0, new CheckBox());
				personsTable.setText(rowToBeAdded, 1, nameTextBox.getValue());
				personsTable.setText(rowToBeAdded, 2, ageTextBox.getValue());
				personsTable.setText(rowToBeAdded, 3, maleRbtn.getValue() == true?"Male":"Female");
			}
		};
		removePersonHandler = new ClickHandler() {
			public void onClick(ClickEvent event) {
				for(int i=personsTable.getRowCount()-1;i>0;i--){
					CheckBox chk = (CheckBox)personsTable.getWidget(i, 0);
					if(chk.getValue())
						personsTable.removeRow(i);
				}
				if(personsTable.getRowCount() == 1){
					removeButton.setVisible(false);
				}
			}
		};
		initializeComponents();
	}

}
