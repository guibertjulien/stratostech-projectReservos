package com.stratostech.reservos.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.stratostech.reservos.client.ui.resources.Resources;

public abstract class AbstractForm extends Composite {

	Resources resources;

	/**
	 * 
	 */
	public AbstractForm() {
		super();

		resources = GWT.create(Resources.class);

		// injection des .css
		resources.styleWidget().ensureInjected();
	}

	public void show() {
		asWidget().setVisible(true);
	}

	public void hide() {
		asWidget().setVisible(false);
	}
}
