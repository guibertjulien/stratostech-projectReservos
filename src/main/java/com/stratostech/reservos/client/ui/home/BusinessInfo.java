package com.stratostech.reservos.client.ui.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.Widget;
import com.stratostech.reservos.client.ui.AbstractForm;

public class BusinessInfo extends AbstractForm implements IHomeView {

	private static BusinessInfoUiBinder uiBinder = GWT.create(BusinessInfoUiBinder.class);
	@UiField
	TabPanel tabPanel_schedule;

	interface BusinessInfoUiBinder extends UiBinder<Widget, BusinessInfo> {
	}

	public BusinessInfo() {
		initWidget(uiBinder.createAndBindUi(this));

		tabPanel_schedule.selectTab(0);
	}

	public void setPresenter(Presenter presenter) {
		// TODO Auto-generated method stub

	}

	public void setEventBus(EventBus eventBus) {
		// TODO Auto-generated method stub

	}

	public void init() {
		tabPanel_schedule.selectTab(0);
	}

}
