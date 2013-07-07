package com.friends.charity.view.template.admin.menu.barresi.event;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.LazyDataModel;

import com.friends.charity.model.MoshakhasateMotaghazi;
import com.friends.charity.model.UserImage;

@Named
public class MadadjoListEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	private LazyDataModel<MoshakhasateMotaghazi> lazyMadadjoDataModel;
	private MoshakhasateMotaghazi motaghazil;

	@PostConstruct
	public void init() {
		List<MoshakhasateMotaghazi> list = new ArrayList<>();
		lazyMadadjoDataModel = new LazyMadadjoDataModel(list);
	}

	public LazyDataModel<MoshakhasateMotaghazi> getLazyMadadjoDataModel() {
		return lazyMadadjoDataModel;
	}

	public MoshakhasateMotaghazi getMotaghazil() {
		return motaghazil;
	}

	public void setMotaghazil(MoshakhasateMotaghazi motaghazil) {
		this.motaghazil = motaghazil;

	}

	// private void getPic(UserImage image) {
	// setBa(image.getImage());
	// }

	private UserImage ba;

	public UserImage getBa() {
		if (ba == null) {
			ba = new UserImage();
		}
		return ba;
	}

	public void setBa(UserImage ba) {
		this.ba = ba;
	}

	public final DefaultStreamedContent getImage() {
		if (getBa() == null) {
			return new DefaultStreamedContent();
		} else {
			DefaultStreamedContent content = new DefaultStreamedContent(
					new ByteArrayInputStream(getBa().getImage()));
			return content;
		}
	}

	public void onRowSelect(SelectEvent event) {
		MoshakhasateMotaghazi mo = ((MoshakhasateMotaghazi) event.getObject());
		FacesMessage msg = new FacesMessage("Car Unselected",
				((MoshakhasateMotaghazi) event.getObject())
						.getFirstname()
						.concat(" ")
						.concat(((MoshakhasateMotaghazi) event.getObject())
								.getLastname()));
		setBa(mo.getUserImage());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}