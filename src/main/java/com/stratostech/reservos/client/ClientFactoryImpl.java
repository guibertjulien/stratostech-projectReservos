package com.stratostech.reservos.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.stratostech.reservos.client.ui.business.BusinessViewImpl;
import com.stratostech.reservos.client.ui.business.IBusinessView;
import com.stratostech.reservos.client.ui.home.HomeViewImpl;
import com.stratostech.reservos.client.ui.home.IHomeView;

public class ClientFactoryImpl implements ClientFactory {
	private final EventBus eventBus = new SimpleEventBus();
	private final PlaceController placeController = new PlaceController(eventBus);

	private final IHomeView homeView = new HomeViewImpl();

	private final IBusinessView businessView = new BusinessViewImpl();

	public EventBus getEventBus() {
		return eventBus;
	}

	public PlaceController getPlaceController() {
		return placeController;
	}

	public IHomeView getHomeView() {
		return homeView;
	}

	public IBusinessView getBusinessView() {
		return businessView;
	}

}