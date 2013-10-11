package com.msci.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.msci.client.Lab03AddPerson;

public class Lab03DisplayPersonsForm extends Composite implements Lab03AddPerson {

	@UiField FlexTable personsTable;
	@UiField Button removeButton;
	
	@UiHandler("removeButton")
	public void removePerson(ClickEvent event){
		for(int i=personsTable.getRowCount()-1;i>=0;i--){
			CheckBox chk = (CheckBox)personsTable.getWidget(i, 0);
			if(chk.getValue())
				personsTable.removeRow(i);
		}
		if(personsTable.getRowCount() == 0){
			removeButton.setVisible(false);
		}
	}
	
	public void addPerson(String name,int age,String gender){
		int row = personsTable.getRowCount();
		personsTable.setWidget(row, 0, new CheckBox());
		personsTable.setText(row, 1, name);
		personsTable.setText(row, 2, age+"");
		personsTable.setText(row, 3, gender);
		personsTable.setVisible(true);
		removeButton.setVisible(true);
	}
	
	
	private static Lab03DisplayPersonsFormUiBinder uiBinder = GWT
			.create(Lab03DisplayPersonsFormUiBinder.class);

	interface Lab03DisplayPersonsFormUiBinder extends
			UiBinder<Widget, Lab03DisplayPersonsForm> {
	}

	public Lab03DisplayPersonsForm() {
		initWidget(uiBinder.createAndBindUi(this));
	}
}
