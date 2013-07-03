package com.friends.charity.view.template.admin.menu.barresi.event;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.MoshakhasateMotaghazi;

public class LazyMadadjoDataModel extends LazyDataModel<MoshakhasateMotaghazi> {
	private static final long serialVersionUID = 1L;
	private List<MoshakhasateMotaghazi> madadjos;
	private GeneralService service;

	@Override
	public List<MoshakhasateMotaghazi> load(int startingAt, int maxPerPage,
			String sortField, SortOrder sortOrder, Map<String, String> filters) {
		try {
			madadjos = getService().selectList("selectUsers", null, startingAt,
					maxPerPage);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setPageSize(maxPerPage);
		return madadjos;
	}

	@Override
	public Object getRowKey(MoshakhasateMotaghazi motaghazi) {
		return motaghazi.getId();
	}

	@Override
	public MoshakhasateMotaghazi getRowData(String motaghaziId) {
		Integer id = Integer.valueOf(motaghaziId);

		for (MoshakhasateMotaghazi motaghazi : madadjos) {
			if (id.equals(motaghazi.getId())) {
				return motaghazi;
			}
		}

		return null;
	}

	public GeneralService getService() {
		if (service == null) {
			service = new GeneralService();
		}
		return service;
	}

	public void setService(GeneralService service) {
		this.service = service;
	}

}