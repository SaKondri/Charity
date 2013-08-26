//package com.friends.charity.test.model;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//
//import com.friends.charity.model.BaseEntity;
//
//@Entity
//@Table(name = "EMPLOYEE")
//@NamedQueries({ @NamedQuery(name = "select_Join", query = "select em from Employee em join em.meetings as meet where meet.subject=:sub") })
//public class Employee extends BaseEntity{
//
////	@Id
////	@Column(name = "ID")
////	@GeneratedValue
////	private Long employeeId;
//
//	@Column(name = "FIRSTNAME")
//	private String firstname;
//
//	@Column(name = "LASTNAME")
//	private String lastname;
//	@ManyToMany(cascade = { CascadeType.ALL })
//	@JoinTable(name = "EMPLOYEE_MEETING", joinColumns = { @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID") }, inverseJoinColumns = { @JoinColumn(name = "MEETING_ID", referencedColumnName = "ID") })
//	private Set<Meeting> meetings = new HashSet<Meeting>();
//
//	public Employee() {
//	}
//
//	public Employee(String firstname, String lastname) {
//		this.firstname = firstname;
//		this.lastname = lastname;
//	}
//
//
//	public String getFirstname() {
//		return firstname;
//	}
//
//	public void setFirstname(String firstname) {
//		this.firstname = firstname;
//	}
//
//	public String getLastname() {
//		return lastname;
//	}
//
//	public void setLastname(String lastname) {
//		this.lastname = lastname;
//	}
//
//	public Set<Meeting> getMeetings() {
//		return meetings;
//	}
//
//	public void setMeetings(Set<Meeting> meetings) {
//		this.meetings = meetings;
//	}
//
//}
