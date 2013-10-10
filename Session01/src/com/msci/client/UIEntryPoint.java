package com.msci.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class UIEntryPoint implements EntryPoint {

	private int num = 1;
	private int rowNum = 0;
	public void onModuleLoad() {
		Button btn = new Button("Click");
		final VerticalPanel vpanel = new VerticalPanel();
		final HorizontalPanel hpanel = new HorizontalPanel();
		final FlexTable table = new FlexTable();
		table.setBorderWidth(1);
		table.setCellSpacing(1);

		RootPanel.get().add(table);
		RootPanel.get().add(hpanel);
		RootPanel.get().add(btn);
		RootPanel.get().add(vpanel);
		btn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				table.setText(rowNum, 0, "Number: " + num);
				table.setWidget(rowNum, 1, new TextBox());
				TextBox tb = new TextBox();
				vpanel.add(tb);
				CheckBox chk = new CheckBox();
				hpanel.add(chk);
				num++;
				rowNum++;
			}
		});
	}

}
