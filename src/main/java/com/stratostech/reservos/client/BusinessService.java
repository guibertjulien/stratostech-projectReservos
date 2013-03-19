package com.stratostech.reservos.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.stratostech.reservos.shared.dto.BusinessDto;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("business")
public interface BusinessService extends RemoteService {

	void createBusiness(BusinessDto c);

	BusinessDto getBusiness(Long id);

	List getAllBusiness();

	void deleteAllBusiness();
}
