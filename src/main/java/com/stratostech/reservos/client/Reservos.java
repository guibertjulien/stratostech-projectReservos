package com.stratostech.reservos.client;

import java.util.logging.Logger;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;
import com.stratostech.reservos.client.mvp.mapper.AppActivityMapper;
import com.stratostech.reservos.client.mvp.mapper.AppPlaceHistoryMapper;
import com.stratostech.reservos.client.mvp.place.HomePlace;
import com.stratostech.reservos.client.ui.footer.Footer;
import com.stratostech.reservos.client.ui.header.Header;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Reservos implements EntryPoint {

	private static final Logger log = Logger.getLogger(Reservos.class.getName());

	private Place defaultPlace = new HomePlace("TestHome");
	private SimplePanel appWidget = new SimplePanel();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		log.info("onModuleLoad - start");

//		HomePage homePage = new HomePage();
//		RootLayoutPanel.get().add(homePage);

		ClientFactory clientFactory = GWT.create(ClientFactory.class);
		EventBus eventBus = clientFactory.getEventBus();
		PlaceController placeController = clientFactory.getPlaceController();

		// Start ActivityManager for the main widget with our
		// ActivityMapper
		ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
		ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
		activityManager.setDisplay(appWidget);

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);

		DockLayoutPanel appPanel = new DockLayoutPanel(Unit.EM);
		appPanel.addNorth(new Header(), 3);
		appPanel.addSouth(new Footer(), 2);
		appPanel.add(appWidget);

		RootLayoutPanel rootLayoutPanel = RootLayoutPanel.get();
		rootLayoutPanel.add(appPanel);
		rootLayoutPanel.setStyleName("rootLayoutPanel");

		// Goes to the place represented on URL else default place
		historyHandler.handleCurrentHistory();

		log.info("onModuleLoad - end");
	}
}
