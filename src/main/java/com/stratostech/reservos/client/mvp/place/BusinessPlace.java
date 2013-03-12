package com.stratostech.reservos.client.mvp.place;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class BusinessPlace extends PlaceAbstract {

	public BusinessPlace(String token) {
		super(token);
	}

	@Prefix("business")
	public static class Tokenizer implements PlaceTokenizer<BusinessPlace> {
		public String getToken(BusinessPlace place) {
			return place.getPlaceName();
		}

		public BusinessPlace getPlace(String token) {
			return new BusinessPlace(token);
		}
	}
}
