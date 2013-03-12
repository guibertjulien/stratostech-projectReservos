package com.stratostech.reservos.client.event;

import java.util.ArrayList;

import com.google.gwt.event.shared.GwtEvent;
import com.stratostech.reservos.client.model.PlaceResultModel;

public class UpdatePlaceListEvent extends GwtEvent<UpdatePlaceListEventHandler> {

	public static Type<UpdatePlaceListEventHandler> TYPE = new Type<UpdatePlaceListEventHandler>();

	private ArrayList<PlaceResultModel> listPlaceResult;

	public UpdatePlaceListEvent(ArrayList<PlaceResultModel> listPlaceResult) {
		this.listPlaceResult = listPlaceResult;
	}

	@Override
	public Type<UpdatePlaceListEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(UpdatePlaceListEventHandler handler) {
		handler.handleUpdatePlaceListEvent(this);
	}

	/**
	 * @return the tYPE
	 */
	public static Type<UpdatePlaceListEventHandler> getTYPE() {
		return TYPE;
	}

	/**
	 * @param tYPE
	 *            the tYPE to set
	 */
	public static void setTYPE(Type<UpdatePlaceListEventHandler> tYPE) {
		TYPE = tYPE;
	}

	/**
	 * @return the listPlaceResult
	 */
	public ArrayList<PlaceResultModel> getListPlaceResult() {
		return listPlaceResult;
	}

	/**
	 * @param listPlaceResult
	 *            the listPlaceResult to set
	 */
	public void setListPlaceResult(ArrayList<PlaceResultModel> listPlaceResult) {
		this.listPlaceResult = listPlaceResult;
	}
}