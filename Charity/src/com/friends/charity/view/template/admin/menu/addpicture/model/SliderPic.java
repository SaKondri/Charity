package com.friends.charity.view.template.admin.menu.addpicture.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.friends.charity.model.BaseEntity;

@Entity
@Table(name = "SLIDER_PIC")
@NamedQueries({
	@NamedQuery(name ="showPics" , query = "select sp from SliderPic sp")
})
public class SliderPic extends BaseEntity{
	@Column (name = "NAME")
	private String name;
	@Column (name = "DISCREPTION")
	private String discreption;
	@Lob
	private byte [] pic;
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiscreption() {
		return discreption;
	}
	public void setDiscreption(String discreption) {
		this.discreption = discreption;
	}
	
	
	
}
