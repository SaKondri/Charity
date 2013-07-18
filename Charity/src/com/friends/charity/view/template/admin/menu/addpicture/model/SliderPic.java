package com.friends.charity.view.template.admin.menu.addpicture.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Past;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.friends.charity.model.BaseEntity;

@Entity
@Table(name = "SLIDER_PIC")
@NamedQueries({
	@NamedQuery(name ="showPics" , query = "select sp from SliderPic sp"),
	@NamedQuery(name = "selectPic" , query = "select sp.pic from SliderPic sp where sp.name =:name")
})
public class SliderPic extends BaseEntity{
	@Column (name = "NAME")
	private String name; 
	@Column (name = "DISCREPTION")
	private String discreption;
	@Lob
	private byte [] pic;
	@Transient
	private int i;
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
	
	public void setI(int i) {
		this.i = i;
	}
	public int getI() {
		return i;
	}
	
}