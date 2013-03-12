package com.stratostech.reservos.client.ui.business;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class BusinessViewImpl extends Composite implements IBusinessView {

	private static BusinessViewImplUiBinder uiBinder = GWT.create(BusinessViewImplUiBinder.class);

	interface BusinessViewImplUiBinder extends UiBinder<Widget, BusinessViewImpl> {
	}

	@UiField
	QuickAccount quickAccount;

	public BusinessViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setPresenter(Presenter presenter) {
		// TODO Auto-generated method stub

	}

	public void setEventBus(EventBus eventBus) {
		// TODO Auto-generated method stub

	}

	public void init() {
		quickAccount.init();
	}

}
