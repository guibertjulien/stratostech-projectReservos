package com.stratostech.reservos.client.ui.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * Resources used by the entire application.
 */
public interface Resources extends ClientBundle {

	@Source("widget.css")
	StyleWidget styleWidget();

	public interface StyleWidget extends CssResource {

		String mainPanel();

		String headerPanel();

		String formPanel();

		String actionPanel();

		String title1();

		String title2();

	}
}
