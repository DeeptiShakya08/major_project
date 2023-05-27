package adaption;

import java.sql.Date;

public class AdoptionResBean {
	private String name;
	private Date dob;
	private String gender;
	private String childId;
	private Date doj;
	private String adoptorMail;
	private boolean accept;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getChildId() {
		return childId;
	}
	public void setChildId(String childId) {
		this.childId = childId;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getAdoptorMail() {
		return adoptorMail;
	}
	public void setAdoptorMail(String adoptorMail) {
		this.adoptorMail = adoptorMail;
	}
	public boolean isAccept() {
		return accept;
	}
	public void setAccept(boolean accept) {
		this.accept = accept;
	}
}
