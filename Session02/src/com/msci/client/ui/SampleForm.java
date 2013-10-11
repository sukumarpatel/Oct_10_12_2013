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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class SampleForm extends Composite {

	@UiField
	TextBox nameTextBox;
	@UiField
	Button clickButton;
	
	@UiHandler("clickButton")
	public void clickButton_clicked(ClickEvent ce){
		Window.alert("Hello " + nameTextBox.getValue());
	}
	
	private static SampleFormUiBinder uiBinder = GWT
			.create(SampleFormUiBinder.class);

	interface SampleFormUiBinder extends UiBinder<Widget, SampleForm> {
	}

	public SampleForm() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
