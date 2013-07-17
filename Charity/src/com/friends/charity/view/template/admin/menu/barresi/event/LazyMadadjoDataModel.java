package com.friends.charity.view.template.admin.menu.barresi.event;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.StreamedContent;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.MoshakhasateMotaghazi;
import com.friends.charity.model.UserImage;

public class LazyMadadjoDataModel extends LazyDataModel<MoshakhasateMotaghazi>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<MoshakhasateMotaghazi> madadjos;
	private GeneralService service;
	private List<MoshakhasateMotaghazi> datasource;
	private HashMap<Integer, UserImage> params;

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

	@Override
	public Object getRowKey(MoshakhasateMotaghazi motaghazi) {
		return motaghazi.getFirstname();
	}

	@Override
	public List<MoshakhasateMotaghazi> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, String> filters) {
		int index = 0;

		List<MoshakhasateMotaghazi> data = new ArrayList<MoshakhasateMotaghazi>();
		try {
			datasource = getService().selectList("selectUsers", null, first,
					pageSize);
			for (MoshakhasateMotaghazi m : datasource) {
				m.getUserImage().setI(index);
				getParams().put(index, m.getUserImage());
				index++;
			}
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
		int totalSize = (getService().selectList("selectUsers", null)).size();
		setRowCount(totalSize);
		setPageSize(pageSize);
		// int dataSize = data.size();
		// this.setRowCount(dataSize);
		// setPageSize(pageSize);
		//
		// // paginate
		// if (dataSize > pageSize) {
		// try {
		// return data.subList(first, first + pageSize);
		// } catch (IndexOutOfBoundsException e) {
		// return data.subList(first, first + (dataSize % pageSize));
		// }
		// } else {
		return data;
		// }
	}

	public StreamedContent getImage() {
		String param = (String) ((HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest())
				.getParameter("param");
		if (param != null) {
			if (!getParams().get(Integer.parseInt(param)).isHasPic()) {
				return nullPic();
			} else {
				return new DefaultStreamedContent(new ByteArrayInputStream(
						(getParams().get(Integer.parseInt(param)).getImage())));
			}
		} else {

			return new DefaultStreamedContent();
		}
	}

	public StreamedContent nullPic() {
		InputStream inputStream = FacesContext.getCurrentInstance()
				.getExternalContext()
				.getResourceAsStream("/resources/images/image2.jpg");

		return new DefaultStreamedContent(inputStream, "image/jpg");
	}

	public List<MoshakhasateMotaghazi> getMadadjos() {
		return madadjos;
	}

	public GeneralService getService() {
		if (service == null) {
			service = new GeneralService();
		}
		return service;
	}

	public HashMap<Integer, UserImage> getParams() {
		if (params == null) {
			params = new HashMap<>();
		}
		return params;
	}

	public void setParams(HashMap<Integer, UserImage> params) {
		this.params = params;
	}

}