package com.friends.charity.view.template.admin.menu.slider;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.view.template.admin.menu.addpicture.model.SliderPic;

@Named
@ApplicationScoped
public class ShowPicture implements Serializable {
	private static final long serialVersionUID = 1L;
	private GeneralService generalService;
	private List<SliderPic> picLists;
	private Map<Integer, SliderPic> map;

	@PostConstruct
	public void init() {
		getPicLists();
	}

	public Map<Integer, SliderPic> getMap() {
		if (map == null) {
			map = new HashMap<>();
		}
		return map;
	}

	public List<SliderPic> getPicLists() {
		if (picLists == null) {
			picLists = new ArrayList<>();
			picLists = getGeneralService().selectList("showPics", null);
			int index = 0;
			for (SliderPic slid : picLists) {
				slid.setI(index);
				getMap().put(index, slid);
				index++;
			}
		}
		return picLists;
	}

	public void setPicLists(List<SliderPic> picLists) {
		this.picLists = picLists;
	}

	public GeneralService getGeneralService() {
		if (generalService == null) {
			generalService = new GeneralService();
		}
		return generalService;
	}

	public Map<String, byte[]> mapImage() {
		Map<String, byte[]> map = new HashMap<>();
		for (SliderPic pic : getPicLists()) {
			map.put(pic.getName(), pic.getPic());
		}
		return map;
	}

	public StreamedContent getPic() {
		String param = ((String) ((HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest())
				.getParameter("param"));
		if (param != null) {
			return new DefaultStreamedContent(new ByteArrayInputStream(
					(getMap().get(Integer.parseInt(param)).getPic())));
		} else {
			return new DefaultStreamedContent();
		}
	}

}