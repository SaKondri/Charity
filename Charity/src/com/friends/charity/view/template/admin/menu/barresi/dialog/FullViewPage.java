package com.friends.charity.view.template.admin.menu.barresi.dialog;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.MamorinTahghigh;
import com.friends.charity.model.MoshakhasateMotaghazi;
import com.friends.charity.model.UserImage;
import com.friends.charity.model.farzand.Farzandan;

//@ManagedBean(name = "fullViewPage")
@Named
@SessionScoped
public class FullViewPage implements Serializable {
	private static final long serialVersionUID = 1L;
	private GeneralService service;
	private MoshakhasateMotaghazi motaghazi;
	private List<Farzandan> farzandans;

	private HashMap<Integer, UserImage> map;

	private int index = 0;

	public GeneralService getService() {
		if (service == null) {
			service = new GeneralService();
		}
		return service;
	}

	public MoshakhasateMotaghazi getMotaghazi() {
		if (motaghazi == null) {
			motaghazi = new MoshakhasateMotaghazi();
		}
		return motaghazi;
	}

	public void setMotaghazi(MoshakhasateMotaghazi motaghazi) {
		this.motaghazi = motaghazi;
	}

	public List<Farzandan> getFarzandans() {
		return farzandans;
	}

	public void setFarzandans(List<Farzandan> farzandans) {
		this.farzandans = farzandans;
	}

	public HashMap<Integer, UserImage> getMap() {
		if (map == null) {
			map = new HashMap<>();
		}
		return map;
	}

	public void setMap(HashMap<Integer, UserImage> map) {
		this.map = map;
	}

	public void btnInfo(ActionEvent actionEvent) {
		String str;
		str = (String) ((HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest()).getParameter("ide");
		if (str != null) {
			long id = Long.parseLong(str);
			MoshakhasateMotaghazi m;
			m = getService().select("selectUser", id);
			setMotaghazi(m);

			index++;
			getMotaghazi().getUserImage().setI(index);
			getMap().put(index, getMotaghazi().getUserImage());

			Map<String, Object> params = new HashMap<>();
			params.put("id", id);
			List<Farzandan> list = getService().selectList("selectFarzandan",
					params);
			farzandans = new ArrayList<>();
			farzandans = list;
		}
	}

	public StreamedContent getImage() {
		byte[] image;
		if (index == 0) {
			return null;
		}
		image = (getMap().get(index)).getImage();
		if (image == null) {
			InputStream stream = FacesContext
					.getCurrentInstance()
					.getExternalContext()
					.getResourceAsStream(
							"/resources/images/NO-IMAGE-AVAILABLE.jpg");
			return new DefaultStreamedContent(stream);
		} else {
			StreamedContent content = new DefaultStreamedContent(
					new ByteArrayInputStream(image));
			return content;
		}
	}

}
