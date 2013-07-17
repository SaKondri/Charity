package com.friends.charity.view.template.admin.menu.barresi.event;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.primefaces.event.DragDropEvent;

import com.friends.charity.model.MoshakhasateMotaghazi;

@Named
public class MadadjoListEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	private LazyMadadjoDataModel lazyMadadjoDataModel;
	private List<MoshakhasateMotaghazi> drops;

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