package com.msci.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.msci.client.Lab03AddPerson;

public class Lab03AddPersonForm extends Composite{
	private Lab03AddPerson lab03AddPerson;
	@UiField TextBox nameTextBox;
	@UiField TextBox ageTextBox;
	@UiField RadioButton maleRadio;
	@UiField RadioButton femaleRadio;
	@UiField Button addButton;
	
	@UiHandler("addButton")
	public void addPerson(ClickEvent event){
		String name = nameTextBox.getValue();
		int age = Integer.parseInt(ageTextBox.getValue());
		String gender = maleRadio.getValue()?"Male":"Female";
		lab03AddPerson.addPerson(name,age, gender);
	}
	
	public void setLab03AddPerson(Lab03AddPerson lab03AddPerson) {
		this.lab03AddPerson = lab03AddPerson;
	}

	private static Lab03AddPersonFormUiBinder uiBinder = GWT
			.create(Lab03AddPersonFormUiBinder.class);

	interface Lab03AddPersonFormUiBinder extends
			UiBinder<Widget, Lab03AddPersonForm> {
	}

	public Lab03AddPersonForm() {
		initWidget(uiBinder.createAndBindUi(this));
	}
}
