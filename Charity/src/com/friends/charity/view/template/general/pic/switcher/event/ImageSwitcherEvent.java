package com.friends.charity.view.template.general.pic.switcher.event;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

@Named
public class ImageSwitcherEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<String> images;

	public ImageSwitcherEvent() {
		images = new ArrayList<>();
		images.add("image-slider-1.jpg");
		images.add("image-slider-2.jpg");
	}

	public List<String> getImages() {
		return images;
	}
}
