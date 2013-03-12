package com.stratostech.reservos.client.mvp.place;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class HomePlace extends PlaceAbstract {

	public HomePlace(String token) {
		super(token);
	}

	@Prefix("home")
	public static class Tokenizer implements PlaceTokenizer<HomePlace> {

		public String getToken(HomePlace place) {
			return place.getPlaceName();
		}

		public HomePlace getPlace(String token) {
			return new HomePlace(token);
		}
	}
}
