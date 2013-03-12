package com.stratostech.reservos.client.mvp.place;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.place.shared.Place;

public abstract class PlaceAbstract extends Place {

	private String placeName;
	private HashMap<String, String> parameters;

	public PlaceAbstract(String token) {
		placeName = token;
		parameters = null;
	}

	public PlaceAbstract(HashMap<String, String> parameters) {
		this.parameters = parameters;
		if (parameters.isEmpty())
			this.placeName = null;
		else {
			StringBuilder sb = new StringBuilder();
			int i = 0;
			for (String name : parameters.keySet()) {
				String val = parameters.get(name);
				if (i != 0) {
					sb.append(",");
				}
				i++;
				sb.append(name);
				sb.append("=");
				sb.append(val);
			}
			this.placeName = sb.toString();
		}
	}

	public String getPlaceName() {
		return placeName;
	}

	public Map getParameters() {
		if (parameters == null)
			parsePlaceName();
		return parameters;
	}

	private void parsePlaceName() {
		parameters = new HashMap();
		if (placeName == null || "".equals(placeName))
			return;

		String[] params = placeName.split(",");
		for (String param : params) {
			String[] p = param.split("=");
			if (p.length == 2) {
				String name = p[0];
				String value = p[1];
				parameters.put(name, value);
			}
		}
	}

}
