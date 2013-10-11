package com.msci.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.msci.client.ui.Lab03AddPersonForm;
import com.msci.client.ui.Lab03DisplayPersonsForm;

public class Lab03EntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {
		Lab03AddPersonForm addPersonForm = new Lab03AddPersonForm();
		Lab03DisplayPersonsForm displayPersonsForm = new Lab03DisplayPersonsForm();
		addPersonForm.setLab03AddPerson(displayPersonsForm);
		
		RootPanel.get().add(addPersonForm);
		RootPanel.get().add(displayPersonsForm);
	}

}
