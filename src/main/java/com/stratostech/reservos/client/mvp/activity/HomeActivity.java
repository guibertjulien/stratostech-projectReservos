package com.stratostech.reservos.client.mvp.activity;

import java.util.logging.Logger;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.stratostech.reservos.client.ClientFactory;
import com.stratostech.reservos.client.mvp.place.HomePlace;
import com.stratostech.reservos.client.serviceApi.MapsService;
import com.stratostech.reservos.client.ui.home.IHomeView;

public class HomeActivity extends TwgAbstractActivity implements IHomeView.Presenter {

	Logger log = Logger.getLogger(HomeActivity.class.getName());

	private IHomeView homeView;

	public HomeActivity(HomePlace place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		HomePlace place = (HomePlace) clientFactory.getPlaceController().getWhere();

		homeView = clientFactory.getHomeView();
		this.eventBus = eventBus;
		homeView.setPresenter(this);
		homeView.setEventBus(eventBus);

		homeView.init();

		panel.setWidget(homeView.asWidget());

		MapsService.setEventBus(eventBus);
		MapsService.initializePlaceSearchBox();
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
