package com.friends.charity.view.template.admin.menu.addpicture;

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

import com.friends.charity.view.template.admin.menu.addpicture.model.AddPictureModel;

@Named
@SessionScoped
public class AddPicture implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<AddPictureModel> pictures;
	private AddPictureModel pictureModel;
	private String test;
	private List<String> imageNames;
	private String iamgeView;
	///////////////
	private String fileNameTest;
	private String systemNameTest;
	
	
	
	public String getFileNameTest() {
		return fileNameTest;
	}

	public void setFileNameTest(String fileNameTest) {
		this.fileNameTest = fileNameTest;
	}

	public String getSystemNameTest() {
		return systemNameTest;
	}

	public void setSystemNameTest(String systemNameTest) {
		this.systemNameTest = systemNameTest;
	}

	public String getIamgeView() {
		return iamgeView;
	}

	public void setIamgeView(String iamgeView) {
		this.iamgeView = iamgeView;
	}

	private String pathTest;

	// private Map<String, > params;

	public String getPathTest() {
		return pathTest;
	}

	public void setPathTest(String pathTest) {
		this.pathTest = pathTest;
	}

	// public Map<String, String> getParams() {
	// if(params == null){
	// params = new HashMap<String, byte>();
	// }
	// return params;
	// }
	// public void setParams(Map<String, byte> params) {
	// this.params = params;
	// }
	public List<String> getImageNames() {
		if (imageNames == null) {
			imageNames = new ArrayList<>();
		}
		return imageNames;
	}

	public void setImageNames(List<String> imageNames) {
		this.imageNames = imageNames;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public List<AddPictureModel> getPictures() {
		if (pictures == null) {
			pictures = new ArrayList<>();
		}
		return pictures;
	}

	public AddPictureModel getPictureModel() {
		if (pictureModel == null) {
			pictureModel = new AddPictureModel();
		}
		return pictureModel;
	}

	public void setPictureModel(AddPictureModel pictureModel) {
		this.pictureModel = pictureModel;
	}

	public void setPictures(List<AddPictureModel> pictures) {
		this.pictures = pictures;
	}

	public String btnAdd(ActionEvent actionEvent) {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, getPictureModel()
						.getName(), "okey"));
		return null;
	}

	public void fileUpload(FileUploadEvent event) throws UnsupportedEncodingException {
		setImageNames(null);
		setPictureModel(new AddPictureModel());
		getPictureModel().setPicture(event.getFile().getContents());
		getPictureModel().setName(getUtf_8(event.getFile().getFileName()));
		setFileNameTest(getUtf_8(event.getFile().getFileName()));
		getPictures().add(getPictureModel());
		getNameInList();
		getPictre();
		FacesMessage msg = new FacesMessage("Succesful", "" + "");
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public void getNameInList() {

		for (AddPictureModel pic : getPictures()) {
			getImageNames().add(pic.getName());
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, pic
							.getPicture().toString(), pic.getName()));
		}
	}

	public StreamedContent getImage() {
		String id = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("imageName");
		System.out.println(id+"#######################################################3");
		return new DefaultStreamedContent(new ByteArrayInputStream(getPictre()
				.get(id)));

	}

	public Map<String, byte[]> getPictre() {
		Map<String, byte[]> params = new HashMap<>();

		for (AddPictureModel pictureModel : getPictures()) {
			params.put(pictureModel.getName(), pictureModel.getPicture());
		}
		return params;
	}

	public StreamedContent findPictureName(String str) throws UnsupportedEncodingException {
//		String iamgeName = ((HttpServletRequest) FacesContext
//				.getCurrentInstance().getExternalContext().getRequest())
//				.getParameter("imageName");
		
		setSystemNameTest(str);

		return new DefaultStreamedContent(new ByteArrayInputStream(getPictre().get(getUtf_8(str))));
	}
	
	public  String getUtf_8(String str) throws UnsupportedEncodingException{
		String s=new String(str.getBytes("ISO-8859-1"),"UTF-8");
		return s;
	}
	public void btnEqulas(ActionEvent actionEvent){
		if(getFileNameTest().equals(getSystemNameTest()));
		System.out.println("=================================================== Okey Equals");
	}
}
