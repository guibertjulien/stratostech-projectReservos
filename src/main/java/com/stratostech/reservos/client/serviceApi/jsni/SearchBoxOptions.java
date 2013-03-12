package com.stratostech.reservos.client.serviceApi.jsni;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.maps.gwt.client.LatLng;
import com.google.maps.gwt.client.LatLngBounds;

/**
 * The options that can be set on an <code>SearchBox</code>
 * 
 * object.
 * 
 * THIS SOURCE CODE IS GENERATED, DO NOT MODIFY
 */
public class SearchBoxOptions extends JavaScriptObject {

	public static final SearchBoxOptions create() {
		return JavaScriptObject.createObject().cast();
	}

	/**
	 * Protected constructor avoids default public constructor.
	 */
	protected SearchBoxOptions() {
		/* Java constructor is protected, */
	}

	/**
	 * The area in which to search for places. Results are biased towards, but
	 * not restricted to, places contained within these bounds.
	 */
	public final native void setBounds(LatLngBounds bounds)/*-{
		this.bounds = bounds;
	}-*/;

	/**
	 * The types of predictions to be returned. Supported types are '
	 * <code>establishment</code>
	 * 
	 * ' for businesses and ' <code>geocode</code>
	 * 
	 * ' for addresses. If neither is specified, both types are returned.
	 */
	public final native void setTypes(JsArrayString types)/*-{
		this.types = types;
	}-*/;

	public final native void setLocation(LatLng location)/*-{
		this.location = location;
	}-*/;

	public final native void setQuery(String query)/*-{
		this.query = query;
	}-*/;

	public final native void setRadius(double radius)/*-{
		this.radius = radius;
	}-*/;

}
