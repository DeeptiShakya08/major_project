package childcrud;

import java.sql.Date;

public class AddChildBean {
private String name;
private Date dob;
private String gender;
private String hairColour;
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
public String getHairColour() {
	return hairColour;
}
public void setHairColour(String hairColour) {
	this.hairColour = hairColour;
}


}
