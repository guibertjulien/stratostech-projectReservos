package com.stratostech.reservos.client.ui.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.stratostech.reservos.client.ui.AbstractForm;

public class SearchResultList extends AbstractForm implements IHomeView {

	private static SearchResultListUiBinder uiBinder = GWT.create(SearchResultListUiBinder.class);

	interface SearchResultListUiBinder extends UiBinder<Widget, SearchResultList> {
	}

	/**
	 * The main DataGrid.
	 */
	@UiField(provided = true)
	DataGrid<String> dataGrid;

	/**
	 * The pager used to change the range of data.
	 */
	@UiField(provided = true)
	SimplePager pager;
	@UiField
	Anchor anchor;

	private Widget parentLink;

	public SearchResultList() {

		// Create a DataGrid.

		/*
		 * Set a key provider that provides a unique key for each contact. If
		 * key is used to identify contacts when fields (such as the name and
		 * address) change.
		 */
		dataGrid = new DataGrid<String>();
		dataGrid.setWidth("100%");

		/*
		 * Do not refresh the headers every time the data is updated. The footer
		 * depends on the current data, so we do not disable auto refresh on the
		 * footer.
		 */
		dataGrid.setAutoHeaderRefreshDisabled(true);

		// Set the message to display when the table is empty.
		dataGrid.setEmptyTableWidget(new Label("no results"));

		// Attach a column sort handler to the ListDataProvider to sort the
		// list.
		// ListHandler<ContactInfo> sortHandler = new
		// ListHandler<ContactInfo>(ContactDatabase.get().getDataProvider()
		// .getList());
		// dataGrid.addColumnSortHandler(sortHandler);

		// Create a Pager to control the table.
		SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
		pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
		pager.setDisplay(dataGrid);

		// // Add a selection model so we can select cells.
		// final SelectionModel<ContactInfo> selectionModel = new
		// MultiSelectionModel<ContactInfo>(
		// ContactDatabase.ContactInfo.KEY_PROVIDER);
		// dataGrid.setSelectionModel(selectionModel,
		// DefaultSelectionEventManager.<ContactInfo> createCheckboxManager());

		// // Initialize the columns.
		// initTableColumns(selectionModel, sortHandler);
		//
		// // Add the CellList to the adapter in the database.
		// ContactDatabase.get().addDataDisplay(dataGrid);
		initWidget(uiBinder.createAndBindUi(this));
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

	@UiHandler("anchor")
	void onAnchorClick(ClickEvent event) {
		if (parentLink instanceof FormSearch) {
			FormSearch formSearch = (FormSearch) parentLink;

			formSearch.nextPage();
		}
	}

	public void setPresenter(Presenter presenter) {
		// TODO Auto-generated method stub
		
	}

	public void setEventBus(EventBus eventBus) {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}
}
