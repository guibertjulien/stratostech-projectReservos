package com.stratostech.reservos.client.ui.business;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface IBusinessView extends IsWidget {

	void setPresenter(Presenter presenter);

	void setEventBus(EventBus eventBus);

	void init();

	public interface Presenter {
		void goTo(Place place);
	}

}
