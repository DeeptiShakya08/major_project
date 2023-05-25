package childcrud;

import java.sql.Date;

public class ViewChildBean {
//	 name     dob       hair_colour     gender     child_pid                             image_url     doj        adation_request     adaptor_mail    
	private String name;
	private Date dob;
	private String hairColour;
	private String gender;
	private String childId;
	private String imageUrl;
	private Date doj;
	private boolean adaptionRequest;
	private String adaptorMail;

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

	public String getHairColour() {
		return hairColour;
	}

	public void setHairColour(String hairColour) {
		this.hairColour = hairColour;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public boolean isAdaptionRequest() {
		return adaptionRequest;
	}

	public void setAdaptionRequest(boolean adaptionRequest) {
		this.adaptionRequest = adaptionRequest;
	}

	public String getAdaptorMail() {
		return adaptorMail;
	}

	public void setAdaptorMail(String adaptorMail) {
		this.adaptorMail = adaptorMail;
	}

}
