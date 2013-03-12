package com.stratostech.reservos.client.ui.header;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class Header extends Composite {

	private static HeaderUiBinder uiBinder = GWT.create(HeaderUiBinder.class);
	@UiField
	Button button_Sign;
	@UiField
	Button button_BusinessSign;
	@UiField ListBox listBox_langue;

	interface HeaderUiBinder extends UiBinder<Widget, Header> {
	}

	public Header() {
		initWidget(uiBinder.createAndBindUi(this));
		
		listBox_langue.addItem("English");
		listBox_langue.addItem("French");
	}

	@UiHandler("button_Sign")
	void onButton_SignClick(ClickEvent event) {
		Window.alert("TODO");
	}

	@UiHandler("button_BusinessSign")
	void onButton_BusinessSignClick(ClickEvent event) {
		History.newItem("business:");
	}
}
