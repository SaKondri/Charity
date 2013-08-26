//package com.friends.charity.test.model;
//
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//
//import com.friends.charity.model.BaseEntity;
//
//@Entity
//@Table(name = "MEETING")
//@NamedQueries({ @NamedQuery(name = "select_Meet", query = "select mt from Meeting mt join mt.employees as em where em.firstname=:fn") })
//public class Meeting extends BaseEntity{
//
////	@Id
////	@Column(name = "ID")
////	@GeneratedValue
////	private Long meetingId;
//
//	@Column(name = "SUBJECT")
//	private String subject;
//
//	@Column(name = "MEETING_DATE")
//	private Date meetingDate;
//
//	@ManyToMany(mappedBy = "meetings")
//	private Set<Employee> employees = new HashSet<Employee>();
//
//	public Meeting() {
//
//	}
//
//	public Meeting(String subject) {
//		this.subject = subject;
//	}
//
//	public String getSubject() {
//		return subject;
//	}
//
//	public void setSubject(String subject) {
//		this.subject = subject;
//	}
//
//}