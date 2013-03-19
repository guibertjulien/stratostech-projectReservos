package com.stratostech.reservos.client.serviceApi;

import java.util.ArrayList;

import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.shared.EventBus;
import com.google.maps.gwt.client.LatLng;
import com.google.maps.gwt.client.LatLngBounds;
import com.google.maps.gwt.client.places.PlaceResult;
import com.stratostech.reservos.client.event.UpdatePlaceListEvent;
import com.stratostech.reservos.client.model.PlaceResultModel;
import com.stratostech.reservos.client.serviceApi.jsni.SearchBox;
import com.stratostech.reservos.client.serviceApi.jsni.SearchBox.PlacesChangedHandler;
import com.stratostech.reservos.client.serviceApi.jsni.SearchBoxOptions;

public abstract class MapsService {

	private static EventBus eventBus;

	private static InputElement inputElement_searchBox;

	/**
	 * @return the eventBus
	 */
	public static EventBus getEventBus() {
		return eventBus;
	}

	/**
	 * @param eventBus
	 *            the eventBus to set
	 */
	public static void setEventBus(EventBus eventBus) {
		MapsService.eventBus = eventBus;
	}

	public static void initializePlaceSearchBox() {

		System.out.println("Maps: initPlaceSearchBox");

		try {
			SearchBoxOptions searchBoxOptions = SearchBoxOptions.create();

			Element element_placeSearchBox = Document.get().getElementById("searchBox");
			inputElement_searchBox = InputElement.as(element_placeSearchBox);

			final SearchBox searchBox = SearchBox.create(inputElement_searchBox, searchBoxOptions);
			// searchBox.bindTo("bounds", map);

			searchBox.addPlacesChangedListener(new PlacesChangedHandler() {

				public void handle() {
					System.out.println("Maps: searchBox.addPlacesChangedListener");

					LatLngBounds bounds = LatLngBounds.create();

					JsArray<PlaceResult> result = searchBox.getPlaces();

					ArrayList<PlaceResultModel> listPlaceResult = new ArrayList<PlaceResultModel>();

					for (int i = 0; i < result.length(); i++) {

						final PlaceResultModel placeResultModel = convertToModel(result.get(i), i);

						LatLng latLng = LatLng.create(placeResultModel.getLatitude(), placeResultModel.getLongitude());
						bounds.extend(latLng);

						listPlaceResult.add(placeResultModel);
					}

					eventBus.fireEvent(new UpdatePlaceListEvent(listPlaceResult));
				}
			});
		} catch (JavaScriptException e) {
			// TODO
		}
	}

	public static PlaceResultModel convertToModel(PlaceResult placeResult, int indexOnMap) {
		final PlaceResultModel placeResultModel = new PlaceResultModel();

		placeResultModel.setId(placeResult.getId());
		placeResultModel.setIndexOnMap(indexOnMap);
		placeResultModel.setIcon(placeResult.getIcon());
		placeResultModel.setName(placeResult.getName());
		placeResultModel.setReference(placeResult.getReference());
		placeResultModel.setAddress(placeResult.getFormattedAddress());
		placeResultModel.setLatitude(placeResult.getGeometry().getLocation().lat());
		placeResultModel.setLongitude(placeResult.getGeometry().getLocation().lng());

		try {
			placeResultModel.setRating(String.valueOf(placeResult.getRating()));
		} catch (Exception e) {
			placeResultModel.setRating(String.valueOf(""));
		}
		
		// PhotoOptions photoOptions = PhotoOptions.create();
		//
		// photoOptions.setMaxWidth(100);
		// photoOptions.setMaxHeight(100);

		// if (TwgConstants.MAPS_EXP) {
		// placeResultModel.setPhotoUrl(getPhotoUrl(placeResult));
		// }

		return placeResultModel;
	}
}
