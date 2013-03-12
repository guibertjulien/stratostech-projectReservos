package com.stratostech.reservos.client.ui.home;

import java.util.ArrayList;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SingleSelectionModel;
import com.stratostech.reservos.client.event.UpdatePlaceListEvent;
import com.stratostech.reservos.client.event.UpdatePlaceListEventHandler;
import com.stratostech.reservos.client.model.PlaceResultModel;
import com.stratostech.reservos.client.ui.AbstractForm;

public class FormSearch extends AbstractForm implements IHomeView, UpdatePlaceListEventHandler {

	private static FormSearchUiBinder uiBinder = GWT.create(FormSearchUiBinder.class);

	interface FormSearchUiBinder extends UiBinder<Widget, FormSearch> {
	}

	protected Presenter presenter;

	protected EventBus eventBus;

	private PlaceResultModel placeResultModelSelect;

	@UiField
	TextBox searchBox;
	@UiField
	TabLayoutPanel tabLayoutPanel;
	@UiField
	Button button_go;
	// @UiField
	// SearchResultList searchResultList;
	@UiField
	BusinessInfo businessInfo;
	@UiField
	ScrollPanel scrollPanel;

	@UiField(provided = true)
	CellList<PlaceResultModel> cellList = new CellList<PlaceResultModel>(new PlaceResultCell());

	private ListDataProvider<PlaceResultModel> dataProviderSearchBox = new ListDataProvider<PlaceResultModel>();

	private final SingleSelectionModel<PlaceResultModel> selectionModelSearchBox = new SingleSelectionModel<PlaceResultModel>();

	/**
	 * The Cell used to render a {@link PlaceResultModel}.
	 */
	static class PlaceResultCell extends AbstractCell<PlaceResultModel> {

		public PlaceResultCell() {
		}

		@Override
		public void render(Context context, PlaceResultModel value, SafeHtmlBuilder sb) {
			// Value can be null, so do a null check..
			if (value == null) {
				return;
			}

			sb.appendHtmlConstant("<table width='100%'>");

			// Add the image.
			sb.appendHtmlConstant("<tr><td width='10%'>");
			sb.appendHtmlConstant("<img src='" + value.getIcon() + "' width='16px' height='16px'/>");
			sb.appendHtmlConstant("</td>");

			// Add the name.
			sb.appendHtmlConstant("<td width='80%'>");
			sb.appendEscaped(value.getName());
			sb.appendHtmlConstant("</td>");

			// Add the rating.
			sb.appendHtmlConstant("<td width='10%' align='right'>");
			if (value.getRating() != null) {
				sb.appendEscaped(value.getRating().toString());
			} else {
				sb.appendEscaped("nc");
			}
			sb.appendHtmlConstant("</td></tr></table>");
		}
	}

	public FormSearch() {
		initWidget(uiBinder.createAndBindUi(this));

		// searchResultList.setParentLink(asWidget());
		businessInfo.setParentLink(asWidget());

		// definition de l'id pour js
		searchBox.getElement().setId("searchBox");
		searchBox.getElement().setPropertyString("placeholder", "Ex : hair cut Chicago");
		searchBox.getElement().setPropertyString("type", "search");

		selectionModelSearchBox.addSelectionChangeHandler(new Handler() {

			public void onSelectionChange(SelectionChangeEvent event) {
				placeResultModelSelect = selectionModelSearchBox.getSelectedObject();
			}
		});

		cellList.setSelectionModel(selectionModelSearchBox);
		dataProviderSearchBox.addDataDisplay(cellList);

	}

	@UiHandler("button_go")
	void onButton_goClick(ClickEvent event) {
		businessInfo.setPlaceResultModel(placeResultModelSelect);
		nextPage();
	}

	public void nextPage() {
		tabLayoutPanel.selectTab(tabLayoutPanel.getSelectedIndex() + 1);
	}

	public void previousPage() {
		tabLayoutPanel.selectTab(tabLayoutPanel.getSelectedIndex() - 1);
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public void setEventBus(EventBus eventBus) {
		this.eventBus = eventBus;

		// ecouteurs d'evenements
		eventBus.addHandler(UpdatePlaceListEvent.TYPE, this);
	}

	public void init() {
		// searchResultList.init();
		businessInfo.init();

		dataProviderSearchBox.getList().clear();
		scrollPanel.setVisible(false);

		tabLayoutPanel.selectTab(0);
		tabLayoutPanel.forceLayout();
	}

	public void handleUpdatePlaceListEvent(UpdatePlaceListEvent event) {
		System.out.println("Event: handleUpdatePlaceListEvent");

		ArrayList<PlaceResultModel> listPlaceResult = event.getListPlaceResult();

		dataProviderSearchBox.getList().clear();

		if (listPlaceResult != null) {
			dataProviderSearchBox.getList().addAll(listPlaceResult);
			scrollPanel.setVisible(true);
		}
	}
}
