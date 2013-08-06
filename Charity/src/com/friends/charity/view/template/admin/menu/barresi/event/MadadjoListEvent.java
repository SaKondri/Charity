package com.friends.charity.view.template.admin.menu.barresi.event;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.DragDropEvent;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.MoshakhasateMotaghazi;
import com.friends.charity.model.farzand.Farzandan;
import com.friends.charity.view.template.admin.menu.barresi.dialog.BarresiDialogPage;

@Named
public class MadadjoListEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	private LazyMadadjoDataModel lazyMadadjoDataModel;
	private List<MoshakhasateMotaghazi> drops;
	private MoshakhasateMotaghazi motaghazil;
	private List<Farzandan> farzandans;
	private GeneralService service;

	// @Inject
	// private BarresiDialogPage dialogPage;

	public MoshakhasateMotaghazi getMotaghazil() {
		return motaghazil;
	}

	public void setMotaghazil(MoshakhasateMotaghazi motaghazil) {
		this.motaghazil = motaghazil;
		// setFarzandans(null);
		// Map<String, Object> params = new HashMap<>();
		// params.put("id", motaghazil.getId());
		// List<Farzandan> list = getService().selectList("selectFarzandan",
		// params);

	}

	public List<Farzandan> getFarzandans() {
		// if (farzandans == null) {
		// farzandans = new ArrayList<>();
		// // Farzandan farzandan=new Farzandan();
		// // farzandan.setFirstname("sina");
		// // farzandans.add(farzandan);
		// }
		// String str;
		// str = (String) ((HttpServletRequest)
		// FacesContext.getCurrentInstance()
		// .getExternalContext().getRequest()).getParameter("id");
		// if (str != null) {
		// long id = Long.parseLong(str);
		// Map<String, Object> params = new HashMap<>();
		// params.put("id", id);
		// List<Farzandan> list = getService().selectList("selectFarzandan",
		// params);
		// farzandans = new ArrayList<>();
		// getFarzandans().addAll(list);
		// }
		return farzandans;
	}

	public void setFarzandans(List<Farzandan> farzandans) {
		this.farzandans = farzandans;
	}

	public GeneralService getService() {
		if (service == null) {
			service = new GeneralService();
		}
		return service;
	}

	@PostConstruct
	public void init() {
		List<MoshakhasateMotaghazi> list = new ArrayList<>();
		lazyMadadjoDataModel = new LazyMadadjoDataModel(list);
	}

	public LazyMadadjoDataModel getLazyMadadjoDataModel() {
		return lazyMadadjoDataModel;
	}

	public List<MoshakhasateMotaghazi> getDrops() {
		if (drops == null) {
			drops = new ArrayList<>();
		}
		return drops;
	}

	public void onCarDrop(DragDropEvent ddEvent) {
		MoshakhasateMotaghazi motaghazi = ((MoshakhasateMotaghazi) ddEvent
				.getData());

		getDrops().add(motaghazi);
		// carsSmall.remove(car);
	}

	// public BarresiDialogPage getDialogPage() {
	// return dialogPage;
	// }
	//
	// public void setDialogPage(BarresiDialogPage dialogPage) {
	// this.dialogPage = dialogPage;
	// }

	// public StreamedContent getContent() {
	// StreamedContent fileContent;
	// String param = FacesContext.getCurrentInstance().getExternalContext()
	// .getRequestParameterMap().get("id");
	// UserImage userImage;
	// userImage = new GeneralService().select("userImages",
	// Integer.parseInt(param));
	// if (userImage == null) {
	// return new DefaultStreamedContent();
	// } else {
	// fileContent = new DefaultStreamedContent(new ByteArrayInputStream(
	// userImage.getImage()));
	// }
	// return fileContent;
	// }

}