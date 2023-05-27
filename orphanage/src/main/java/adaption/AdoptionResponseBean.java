package adaption;

import java.sql.Date;

public class AdoptionResponseBean {
	private String name;
	private String gender;
	private String childId;
	private Date dor;
	private String adoptorName;
	private String adoptionStatus;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDor() {
		return dor;
	}

	public void setDor(Date dor) {
		this.dor = dor;
	}



	public String getAdoptorName() {
		return adoptorName;
	}

	public void setAdoptorName(String adoptorName) {
		this.adoptorName = adoptorName;
	}

	public String getAdoptionStatus() {
		return adoptionStatus;
	}

	public void setAdoptionStatus(String adoptionStatus) {
		this.adoptionStatus = adoptionStatus;
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

}
