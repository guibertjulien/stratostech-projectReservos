package com.stratostech.reservos.client.mvp.activity;

import java.util.logging.Logger;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.stratostech.reservos.client.ClientFactory;
import com.stratostech.reservos.client.mvp.place.BusinessPlace;
import com.stratostech.reservos.client.ui.business.IBusinessView;

public class BusinessActivity extends TwgAbstractActivity implements IBusinessView.Presenter {

	Logger log = Logger.getLogger(BusinessActivity.class.getName());

	private IBusinessView businessView;

	public BusinessActivity(BusinessPlace place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {

		BusinessPlace place = (BusinessPlace) clientFactory.getPlaceController().getWhere();

		businessView = clientFactory.getBusinessView();
		this.eventBus = eventBus;
		businessView.setPresenter(this);
		businessView.setEventBus(eventBus);

		businessView.init();

		panel.setWidget(businessView.asWidget());
	}

	/**
	 * Ask user before stopping this activity
	 */
	@Override
	public String mayStop() {
		return null;
	}

	/**
	 * Navigate to a new Place in the browser
	 */
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}
}
