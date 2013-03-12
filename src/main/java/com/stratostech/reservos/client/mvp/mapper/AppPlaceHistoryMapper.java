package com.stratostech.reservos.client.mvp.mapper;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.stratostech.reservos.client.mvp.place.BusinessPlace;
import com.stratostech.reservos.client.mvp.place.HomePlace;

@WithTokenizers({ HomePlace.Tokenizer.class, BusinessPlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
