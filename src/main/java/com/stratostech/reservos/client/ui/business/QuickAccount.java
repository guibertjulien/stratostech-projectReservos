package com.stratostech.reservos.client.ui.business;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.stratostech.reservos.client.ui.AbstractForm;

public class QuickAccount extends AbstractForm implements IBusinessView {

	private Presenter presenter;

	private EventBus eventBus;

	private static quickAccountUiBinder uiBinder = GWT.create(quickAccountUiBinder.class);

	@UiField
	Button button;
	@UiField
	TabLayoutPanel tabLayoutPanel_form;

	interface quickAccountUiBinder extends UiBinder<Widget, QuickAccount> {
	}

	public QuickAccount() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("button")
	void onButtonClick(ClickEvent event) {

		presenter.createBusiness();

		tabLayoutPanel_form.selectTab(1);
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public void setEventBus(EventBus eventBus) {
		this.eventBus = eventBus;
	}

	public void init() {
		tabLayoutPanel_form.selectTab(0);
		tabLayoutPanel_form.forceLayout();
	}
}
