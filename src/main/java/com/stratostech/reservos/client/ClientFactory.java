package com.stratostech.reservos.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.stratostech.reservos.client.ui.business.IBusinessView;
import com.stratostech.reservos.client.ui.home.IHomeView;

public interface ClientFactory {
	EventBus getEventBus();

	PlaceController getPlaceController();

	IHomeView getHomeView();
	
	IBusinessView getBusinessView();
}