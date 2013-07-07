package com.friends.charity.view.template.admin.menu.slider;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.view.template.admin.menu.addpicture.model.SliderPic;
import com.sun.org.apache.bcel.internal.generic.GOTO;

@Named
@SessionScoped
public class ShowPicture implements Serializable{
	private static final long serialVersionUID = 1L;
	private SliderPic sliderPic;
	private List<SliderPic> listPics;
	private List<String> names;
	private GeneralService generalService;
	private List<StreamedContent> contents;
	public List<String> getNames() {
		if(names == null){
			names = new ArrayList<>();
		}
		return names;
	}
	public void setNames(List<String> names) {
		this.names = names;
	}
	public List<StreamedContent> getContents() {
		if(contents == null){
			contents = new ArrayList<>();
		}
		return contents;
	}
	public List<SliderPic> getListPics() {
		if(listPics == null){
			listPics = new ArrayList<>();
		}
		return listPics;
	}
	public void setListPics(List<SliderPic> listPics) {
		this.listPics = listPics;
	}
	public GeneralService getGeneralService() {
		if(generalService == null){
			generalService = new GeneralService();
		}
		return generalService;
	}
	public void setGeneralService(GeneralService generalService) {
		this.generalService = generalService;
	}
	public SliderPic getSliderPic() {
		if(sliderPic == null){
			sliderPic = new SliderPic();
		}
		return sliderPic;
	}
	public void setSliderPic(SliderPic sliderPic) {
		this.sliderPic = sliderPic;
	}
	
	public void getPics(){
		List<SliderPic> list=getGeneralService().selectList("showPics", null);
		for (SliderPic sliderPic : list) {
			
			//getContents().add(new DefaultStreamedContent(new ByteArrayInputStream(sliderPic.getPic())));
		}
	}
	private StreamedContent content;
	public StreamedContent getContent() {
		if(content == null){
			content = new DefaultStreamedContent();
		}
		return content;
	}
	public void setContent(StreamedContent content) {
		this.content = content;
	}
	
	
	@PostConstruct
	public void init(){
		List<SliderPic> list=getGeneralService().selectList("showPics", null);
		for (SliderPic sliderPic : list) {
			getNames().add(sliderPic.getName());
		}
		image(null);
	}
	@SuppressWarnings("unused")
	public StreamedContent image(String name) {
		if(name == null || name ==""){
			return new DefaultStreamedContent();

		}
		List<SliderPic> list=getGeneralService().selectList("showPics", null);
		System.out.println("naaaaaaaaammmmmeeeeee"+name);
		byte [] pic = null;
		
		for (SliderPic sliderPic : list) {
			if(name.equals(sliderPic.getName())){
				return new DefaultStreamedContent(new ByteArrayInputStream(pic));
			}
		}
		if (pic == null) {
			return new DefaultStreamedContent();
		}
		return null;
	}
	public StreamedContent getImage() {
		List<SliderPic> list=getGeneralService().selectList("showPics", null);
		if (list.get(1).getPic() == null) {
			return new DefaultStreamedContent();
		}
		return new DefaultStreamedContent(new ByteArrayInputStream(list.get(0).getPic()));
	}
}
