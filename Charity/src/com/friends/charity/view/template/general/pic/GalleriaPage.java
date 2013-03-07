package com.friends.charity.view.template.general.pic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import com.friends.charity.view.template.general.pic.event.GalleriaEvent;

@Named
public class GalleriaPage implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<String> images;

	@PostConstruct
	public void init() {
		images = new ArrayList<>();
		for (int i = 1; i <= 4; i++) {
			images.add("charity" + i + ".jpg");
		}
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

}
