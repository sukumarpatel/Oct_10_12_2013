package com.msci.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.msci.client.ui.SampleForm;

public class Day02EntryPoint implements EntryPoint {
	public void onModuleLoad() {
		RootPanel.get().add(new SampleForm());
	}
}
