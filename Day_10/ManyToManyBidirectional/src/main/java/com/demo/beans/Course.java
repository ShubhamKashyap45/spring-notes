package com.demo.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="coursetable")
public class Course {
	@Id
	private int cid;
	private String cname;
	@ManyToMany
	//@JoinTable(name="stud_course")
	private Set<Student> slist;
	public Course() {
		super();
	}
	public Course(int cid, String cname, Set<Student> slist) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.slist = slist;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<Student> getSlist() {
		return slist;
	}
	public void setSlist(Set<Student> slist) {
		this.slist = slist;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", slist=" + slist + "]";
	}
	

}
