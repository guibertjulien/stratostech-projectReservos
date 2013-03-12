package com.stratostech.reservos.client.ui.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class HomeViewImpl extends Composite implements IHomeView {

	private Presenter presenter;

	private EventBus eventBus;
	
	private static HomeViewImplUiBinder uiBinder = GWT.create(HomeViewImplUiBinder.class);

	interface HomeViewImplUiBinder extends UiBinder<Widget, HomeViewImpl> {
	}

	@UiField
	FormSearch formSearch;
	
	public HomeViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
		formSearch.setPresenter(presenter);
		
	}

	public void setEventBus(EventBus eventBus) {
		this.eventBus = eventBus;
		formSearch.setEventBus(eventBus);
	}

	public void init() {
		formSearch.init();
	}

}
