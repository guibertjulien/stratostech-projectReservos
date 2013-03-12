package com.stratostech.reservos.client.mvp.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.stratostech.reservos.client.ClientFactory;

/**
 * Propri�t�s et m�thodes communes aux activit�s. H�rite de AbstractActivity.
 * 
 * @author Julien singleton InfosWidget2 & LoadingWidget
 */
public abstract class TwgAbstractActivity extends AbstractActivity {

	protected ClientFactory clientFactory;

	protected static EventBus eventBus;

	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		// TODO Auto-generated method stub
		
	}
}
