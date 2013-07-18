package com.friends.charity.view.template.admin.menu.slider;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.view.template.admin.menu.addpicture.model.SliderPic;

@Named
@SessionScoped
public class AddPicture extends  javax.faces.render.Renderer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private GeneralService service;
	private SliderPic pic;
	@Inject
	private ShowPicture showPicture;
	private SliderPic selectedSlider;
	private String param;
	private Map<String, SliderPic> params;
	
	
	public void setParams(Map<String, SliderPic> params) {
		this.params = params;
	}
	public GeneralService getService() {
		if(service == null){
			service = new GeneralService();
		}
		return service;
	}
	public void setService(GeneralService service) {
		this.service = service;
	}
	public SliderPic getSelectedSlider() {
		if(selectedSlider == null){
			selectedSlider = new SliderPic();
		}
		return selectedSlider;
	}
	public void setSelectedSlider(SliderPic selectedSlider) {
		this.selectedSlider = selectedSlider;
	}
	public SliderPic getPic() {
		if(pic == null){
			pic = new SliderPic();
		}
		return pic;
	}
	public ShowPicture getShowPicture() {
		return showPicture;
	}
	public void setShowPicture(ShowPicture showPicture) {
		this.showPicture = showPicture;
	}
	public void setPic(SliderPic pic) {
		this.pic = pic;
	}
	
	
	
	public void fileUpload(FileUploadEvent event) throws UnsupportedEncodingException {
		getPic().setName(event.getFile().getFileName());
		getPic().setPic(event.getFile().getContents());
		try {
			
			getService().save(getPic());
			FacesMessage msg = new FacesMessage(" عکس", event.getFile().getFileName() + "با موفقیت ذخیرم شد ");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			getShowPicture().setPicLists(null);
			setParams(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Map<String, SliderPic> getParams() {
		if(params == null){
			params = new HashMap<>();
			for (SliderPic slid : getShowPicture().getPicLists()) {
				params.put(slid.getName(), slid);
			}
		}
		return params;
	}
	
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public StreamedContent getSelectedRowImage(){
		
		if(getParam() == null){
			return new DefaultStreamedContent();
		}
		else {
			try {
				Map<String, Object> params = new HashMap<>();
				params.put("name", getParam());
				byte [] pic= getService().select("selectPic", params);
				return new DefaultStreamedContent(new ByteArrayInputStream(pic));
			} catch (Exception e) {
				return new DefaultStreamedContent();
			}
			
			
		}
		
	}
	public String getRow(ActionEvent actionEvent){
		setParam(((String)((HttpServletRequest)  FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("slider")));
		return null;
	}
	public String deleteImage(ActionEvent actionEvent){
		
		setSelectedSlider(getParams().get(getParam()));
		try {
			getService().delete(getSelectedSlider());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,getParam(),"عکس پاک شد ."));
			getShowPicture().setPicLists(null);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,getParam(),"خطا عکس پاک نشد"));
		}
		return null;
	}
}