package com.friends.charity.view.template.admin.menu.barresi.event;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.MoshakhasateMotaghazi;

public class LazyMadadjoDataModel extends LazyDataModel<MoshakhasateMotaghazi>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<MoshakhasateMotaghazi> madadjos;
	private GeneralService service;
	private List<MoshakhasateMotaghazi> datasource;

	public LazyMadadjoDataModel(List<MoshakhasateMotaghazi> datasource) {
		this.datasource = datasource;
	}

	@Override
	public MoshakhasateMotaghazi getRowData(String rowKey) {
		for (MoshakhasateMotaghazi motaghazi : datasource) {
			if (motaghazi.getFirstname().equals(rowKey)) {
				return motaghazi;
			}
		}
		return null;
	}

//	@Override
	//public void setRowIndex(int rowIndex) {
		//super.setRowIndex(rowIndex);
	//}

	//@Override
	//public void setRowCount(int rowCount) {
		// TODO Auto-generated method stub
	//	super.setRowCount(rowCount);
	//}

	@Override
	public Object getRowKey(MoshakhasateMotaghazi motaghazi) {
		return motaghazi.getFirstname();
	}

	@Override
	public List<MoshakhasateMotaghazi> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, String> filters) {
		List<MoshakhasateMotaghazi> data = new ArrayList<MoshakhasateMotaghazi>();
		try {
			datasource = getService().selectList("selectUsers", null, first,
					pageSize);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// filter
		for (MoshakhasateMotaghazi motaghazi : datasource) {
			boolean match = true;

			for (Iterator<String> it = filters.keySet().iterator(); it
					.hasNext();) {
				try {
					String filterProperty = it.next();
					String filterValue = filters.get(filterProperty);
					String fieldValue = String.valueOf(motaghazi.getClass()
							.getField(filterProperty).get(motaghazi));

					if (filterValue == null
							|| fieldValue.startsWith(filterValue)) {
						match = true;
					} else {
						match = false;
						break;
					}
				} catch (Exception e) {
					match = false;
				}
			}

			if (match) {
				data.add(motaghazi);
			}
		}

		// // sort
		// if (sortField != null) {
		// Collections.sort(data, new LazySorter(sortField, sortOrder));
		// }

		// rowCount
		int dataSize = data.size();
		this.setRowCount(dataSize);
		setPageSize(pageSize);

		// paginate
		if (dataSize > pageSize) {
			try {
				return data.subList(first, first + pageSize);
			} catch (IndexOutOfBoundsException e) {
				return data.subList(first, first + (dataSize % pageSize));
			}
		} else {
			return data;
		}
	}

	// @Override
	// public List<MoshakhasateMotaghazi> load(int startingAt, int maxPerPage,
	// String sortField, SortOrder sortOrder, Map<String, String> filters) {
	// try {
	// madadjos = getService().selectList("selectUsers", null, startingAt,
	// maxPerPage);
	//
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// setPageSize(maxPerPage);
	// return getMadadjos();
	// }
	//
	// @Override
	// public Object getRowKey(MoshakhasateMotaghazi motaghazi) {
	// return motaghazi.getId();
	// }
	//
	// @Override
	// public MoshakhasateMotaghazi getRowData(String motaghaziId) {
	// Integer id = Integer.valueOf(motaghaziId);
	//
	// for (MoshakhasateMotaghazi motaghazi : madadjos) {
	// if (id.equals(motaghazi.getId())) {
	// return motaghazi;
	// }
	// }
	//
	// return null;
	// }
	//
	// public List<MoshakhasateMotaghazi> getMadadjos() {
	// return madadjos;
	// }
	//
	public GeneralService getService() {
		if (service == null) {
			service = new GeneralService();
		}
		return service;
	}

}