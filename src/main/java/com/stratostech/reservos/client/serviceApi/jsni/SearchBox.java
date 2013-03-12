package com.stratostech.reservos.client.serviceApi.jsni;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.InputElement;
import com.google.maps.gwt.client.LatLngBounds;
import com.google.maps.gwt.client.MVCObject;
import com.google.maps.gwt.client.places.PlaceResult;

/**
 * A service to provide Place predictions based on a user's text input. It
 * attaches to an input element of type <code>text</code>
 * 
 * , and listens for text entry in that field. The list of predictions is
 * presented as a drop-down list, and is updated as text is entered.
 * 
 * THIS SOURCE CODE IS GENERATED, DO NOT MODIFY
 */
public class SearchBox extends MVCObject {

	/**
	 * This event is fired when a <code>PlaceResult</code>
	 * 
	 * is made available for a Place the user has selected. <br>
	 * If the user enters the name of a Place that was not suggested by the
	 * control and presses the Enter key, a <code>place_changed</code>
	 * 
	 * event will be fired that contains the user input in the <code>name</code>
	 * 
	 * property, with no other properties defined.
	 */
	public interface PlacesChangedHandler {

		/**
		 * Override to handle event.
		 */
		void handle();
	}

	/**
	 * Creates a new instance of <code>SearchBox</code>
	 * 
	 * that attaches to the specified input text field with the given options.
	 */
	public static native SearchBox create(InputElement inputField, SearchBoxOptions opts)/*-{
		var _opts;
		if (@com.google.gwt.core.client.GWT::isScript()()) {
			_opts = opts;
		} else {
			_opts = {};
			for (k in opts) {
				if (k != "__gwt_ObjectId") {
					_opts[k] = opts[k];
				}
			}
		}
		return new $wnd.google.maps.places.SearchBox(inputField, _opts);
	}-*/;

	/**
	 * Creates a new instance of <code>SearchBox</code>
	 * 
	 * that attaches to the specified input text field with the given options.
	 */
	public static native SearchBox create(InputElement inputField)/*-{
		return new $wnd.google.maps.places.SearchBox(inputField);
	}-*/;

	/**
	 * Protected constructor avoids default public constructor.
	 */
	protected SearchBox() {
		/* Java constructor is protected, */
	}

	/**
	 * Adds the given listener function to the given event name for the given
	 * object instance. Returns an identifier for this listener that can be used
	 * with removeListener().
	 */
	public final native void addPlacesChangedListener(PlacesChangedHandler handler)/*-{
		var _handler = $entry(function() {
			handler.@com.stratostech.reservos.client.serviceApi.jsni.SearchBox.PlacesChangedHandler::handle()();

		});
		$wnd.google.maps.event.addListener(this, "places_changed", _handler);
	}-*/;

	/**
	 * Like addListener, but the handler removes itself after handling the first
	 * event.
	 */
	public final native void addPlaceChangedListenerOnce(PlacesChangedHandler handler)/*-{
		var _handler = $entry(function() {
			handler.@com.stratostech.reservos.client.serviceApi.jsni.SearchBox.PlacesChangedHandler::handle()();

		});
		$wnd.google.maps.event.addListenerOnce(this, "place_changed", _handler);
	}-*/;

	/**
	 * Removes all listeners for all events for the given instance.
	 */
	public final native void clearInstanceListeners()/*-{
		$wnd.google.maps.event.clearInstanceListeners(this);
	}-*/;

	/**
	 * Removes all listeners for the given event for the given instance.
	 */
	public final native void clearPlaceChangedListeners()/*-{
		$wnd.google.maps.event.clearListeners(this, "place_changed");
	}-*/;

	/**
	 * Returns the bounds to which predictions are biased.
	 */
	public final native LatLngBounds getBounds()/*-{
		return this.getBounds();

	}-*/;

	/**
	 * Returns the details of the Place selected by the user, or
	 * <code>null</code>
	 * 
	 * if no Place has been selected yet.
	 */
	public final native JsArray<PlaceResult> getPlaces()/*-{
		return this.getPlaces();

	}-*/;

	/**
	 * Sets the preferred area within which to return Place results. Results are
	 * biased towards, but not restricted to, this area.
	 */
	public final native void setBounds(LatLngBounds bounds)/*-{
		this.setBounds(bounds);

	}-*/;

	/**
	 * Sets the types of predictions to be returned. Supported types are '
	 * <code>establishment</code>
	 * 
	 * ' for businesses and ' <code>geocode</code>
	 * 
	 * ' for addresses. If no type is specified, both types will be returned.
	 */
	public final native void setTypes(JsArrayString types)/*-{
		this.setTypes(types);

	}-*/;

	/**
	 * Triggers the given event. All arguments after eventName are passed as
	 * arguments to the listeners.
	 */
	public final native void triggerPlaceChanged(JavaScriptObject... varargs)/*-{
		var _varargs = @com.google.maps.gwt.client.ArrayHelper::toJsArray([Lcom/google/gwt/core/client/JavaScriptObject;)(varargs);
		$wnd.google.maps.event.trigger(this, "place_changed", _varargs);
	}-*/;

}
