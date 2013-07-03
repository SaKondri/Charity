package com.friends.charity.view.template.admin.menu.barresi.event;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.MoshakhasateMotaghazi;

@Named
public class MadadjoListEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	// private LazyDataModel<MoshakhasateMotaghazi> lazyModel;
	private GeneralService service;
	private List<MoshakhasateMotaghazi> list;

	@PostConstruct
	public void init() {
		new LazyDataModel<MoshakhasateMotaghazi>() {
			private static final long serialVersionUID = 1L;
			List<MoshakhasateMotaghazi> ls = new ArrayList<>();

			public List<MoshakhasateMotaghazi> load(int startingAt,
					int maxPerPage, String sortField, SortOrder sortOrder,
					Map<String, String> filters) {
				try {
					ls = getService().selectList("selectUsers", null,
							startingAt, maxPerPage);
					for (MoshakhasateMotaghazi mm : ls) {
						getList().add(mm);
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setPageSize(maxPerPage);
				return list;
			}

			@Override
			public Object getRowKey(MoshakhasateMotaghazi motaghazi) {
				return motaghazi.getId();
			}

			@Override
			public MoshakhasateMotaghazi getRowData(String motaghaziId) {
				Integer id = Integer.valueOf(motaghaziId);

				for (MoshakhasateMotaghazi motaghazi : getList()) {
					if (id.equals(motaghazi.getId())) {
						return motaghazi;
					}
				}

				return null;
			}
		};

	}

	public List<MoshakhasateMotaghazi> getList() {
		if (list == null) {
			list = new ArrayList<>();
		}
		return list;
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