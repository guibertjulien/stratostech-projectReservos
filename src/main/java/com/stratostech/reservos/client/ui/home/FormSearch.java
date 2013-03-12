package com.stratostech.reservos.client.ui.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.stratostech.reservos.client.ui.AbstractForm;

public class FormSearch extends AbstractForm implements IHomeView {

	private static FormSearchUiBinder uiBinder = GWT.create(FormSearchUiBinder.class);

	interface FormSearchUiBinder extends UiBinder<Widget, FormSearch> {
	}

//	@UiField
//	TextBox textBox_what;
//	@UiField
//	TextBox textBox_where;
	@UiField
	TextBox searchBox;
	@UiField
	TabLayoutPanel tabLayoutPanel;
	@UiField
	Button button;
	@UiField
	SearchResultList searchResultList;
	@UiField
	BusinessInfo businessInfo;
	
	public FormSearch() {
		initWidget(uiBinder.createAndBindUi(this));
//		
//		textBox_what.getElement().setAttribute("placeHolder", "Hair Stylist");
//
//		textBox_where.getElement().setAttribute("placeHolder", "Chicago");
		
		searchResultList.setParentLink(asWidget());
		
		// definition de l'id pour js
		searchBox.getElement().setId("searchBox");
		searchBox.getElement().setPropertyString("placeholder", "hair cut Chicago");
		searchBox.getElement().setPropertyString("type", "search");
	}

	@UiHandler("button")
	void onButtonClick(ClickEvent event) {
		nextPage();
	}

	public void nextPage() {
		tabLayoutPanel.selectTab(tabLayoutPanel.getSelectedIndex() + 1);
	}

	public void previousPage() {
		tabLayoutPanel.selectTab(tabLayoutPanel.getSelectedIndex() - 1);
	}

	public void setPresenter(Presenter presenter) {
		// TODO Auto-generated method stub
		
	}

	public void setEventBus(EventBus eventBus) {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		searchResultList.init();
		businessInfo.init();
		
		tabLayoutPanel.selectTab(0);
		tabLayoutPanel.forceLayout();
	}

}
