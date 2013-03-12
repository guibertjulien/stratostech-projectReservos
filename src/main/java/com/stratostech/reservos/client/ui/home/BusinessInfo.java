package com.stratostech.reservos.client.ui.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.Widget;
import com.stratostech.reservos.client.model.PlaceResultModel;
import com.stratostech.reservos.client.ui.AbstractForm;

public class BusinessInfo extends AbstractForm implements IHomeView {

	private static BusinessInfoUiBinder uiBinder = GWT.create(BusinessInfoUiBinder.class);

	@UiField
	Label label_name;
	@UiField
	Label label_address;
	@UiField
	TabPanel tabPanel_schedule;
	
	private Widget parentLink;

	private PlaceResultModel placeResultModel;

	interface BusinessInfoUiBinder extends UiBinder<Widget, BusinessInfo> {
	}

	public BusinessInfo() {
		initWidget(uiBinder.createAndBindUi(this));

		tabPanel_schedule.selectTab(0);
	}

	public void setPresenter(Presenter presenter) {
		// TODO Auto-generated method stub

	}

	public void setEventBus(EventBus eventBus) {
		// TODO Auto-generated method stub

	}

	public void init() {
		label_name.setText("");
		label_address.setText("");
		tabPanel_schedule.selectTab(0);
	}


	@UiHandler("button_return")
	void onButton_returnClick(ClickEvent event) {
		if (parentLink instanceof FormSearch) {
			FormSearch formSearch = (FormSearch) parentLink;
			formSearch.previousPage();
		}
	}


	/**
	 * @return the parentLink
	 */
	public Widget getParentLink() {
		return parentLink;
	}

	/**
	 * @param parentLink
	 *            the parentLink to set
	 */
	public void setParentLink(Widget parentLink) {
		this.parentLink = parentLink;
	}
	
	/**
	 * @return the placeResultModel
	 */
	public PlaceResultModel getPlaceResultModel() {
		return placeResultModel;
	}

	/**
	 * @param placeResultModel
	 *            the placeResultModel to set
	 */
	public void setPlaceResultModel(PlaceResultModel placeResultModel) {
		this.placeResultModel = placeResultModel;
		label_name.setText(placeResultModel.getName());
		label_address.setText(placeResultModel.getAddress());
	}

}
