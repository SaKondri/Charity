package com.friends.charity.view.template.admin.menu.slider;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.view.template.admin.menu.addpicture.model.AddPictureModel;
import com.friends.charity.view.template.admin.menu.addpicture.model.SliderPic;

@Named
@SessionScoped
public class AddPicture implements Serializable {
	private List<AddPictureModel> pictureModels;
	private AddPictureModel addPictureModel;
	private SliderPic pic;
	
	public SliderPic getPic() {
		if(pic == null){
			pic = new SliderPic();
		}
		return pic;
	}
	public void setPic(SliderPic pic) {
		this.pic = pic;
	}
	public AddPictureModel getAddPictureModel() {
		if(addPictureModel == null){
			addPictureModel = new AddPictureModel();
		}
		return addPictureModel;
	}
	public void setAddPictureModel(AddPictureModel addPictureModel) {
		this.addPictureModel = addPictureModel;
	}
	public List<AddPictureModel> getPictureModels() {
		if(pictureModels == null){
			pictureModels = new ArrayList<>();
		}
		return pictureModels;
	}
	public void setPictureModels(List<AddPictureModel> pictureModels) {
		this.pictureModels = pictureModels;
	}
	
	public void fileUpload(FileUploadEvent event) throws UnsupportedEncodingException {
		getPic().setName(event.getFile().getFileName());
		getPic().setPic(event.getFile().getContents());
		try {
			new GeneralService().save(getPic());
			FacesMessage msg = new FacesMessage("Succesful", "" + "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		setImageNames(null);
//		setPictureModel(new AddPictureModel());
//		getPictureModel().setPicture(event.getFile().getContents());
//		getPictureModel().setName(getUtf_8(event.getFile().getFileName()));
//		setFileNameTest(getUtf_8(event.getFile().getFileName()));
//		getPictures().add(getPictureModel());
//		getNameInList();
//		getPictre();
//		FacesMessage msg = new FacesMessage("Succesful", "" + "");
//		FacesContext.getCurrentInstance().addMessage(null, msg);
//
	}

	
}
