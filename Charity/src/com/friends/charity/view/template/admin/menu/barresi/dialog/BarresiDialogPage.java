package com.friends.charity.view.template.admin.menu.barresi.dialog;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.friends.charity.model.MoshakhasateMotaghazi;
import com.friends.charity.model.UserImage;

@Named
@SessionScoped
public class BarresiDialogPage implements Serializable {
	private static final long serialVersionUID = 1L;
	private MoshakhasateMotaghazi motaghazil;
	private UserImage ba;

	public MoshakhasateMotaghazi getMotaghazil() {
		if (motaghazil == null) {
			motaghazil = new MoshakhasateMotaghazi();
		}
		setBa(motaghazil.getUserImage());
		return motaghazil;
	}

	public void setMotaghazil(MoshakhasateMotaghazi motaghazil) {
		this.motaghazil = motaghazil;

	}

	public UserImage getBa() {
		if (ba == null) {
			ba = new UserImage();
		}
		return ba;
	}

	public void setBa(UserImage ba) {
		this.ba = ba;
	}

	public StreamedContent getImage() {
		if (!getBa().isHasPic()) {
			return null;
		} else {
			StreamedContent content = new DefaultStreamedContent(
					new ByteArrayInputStream(getBa().getImage()), "image/jpeg");
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
