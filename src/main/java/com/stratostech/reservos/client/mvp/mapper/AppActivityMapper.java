package com.stratostech.reservos.client.mvp.mapper;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.stratostech.reservos.client.ClientFactory;
import com.stratostech.reservos.client.mvp.activity.BusinessActivity;
import com.stratostech.reservos.client.mvp.activity.HomeActivity;
import com.stratostech.reservos.client.mvp.place.BusinessPlace;
import com.stratostech.reservos.client.mvp.place.HomePlace;

public class AppActivityMapper implements ActivityMapper {
	private ClientFactory clientFactory;

	public AppActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	public Activity getActivity(Place place) {

		if (place instanceof HomePlace) {
			return new HomeActivity((HomePlace) place, clientFactory);
		}

		if (place instanceof BusinessPlace) {
			return new BusinessActivity((BusinessPlace) place, clientFactory);
		}

		return null;
	}

}