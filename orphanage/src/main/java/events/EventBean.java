package events;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class EventBean {
@Override
	public String toString() {
		return "EventBean [eventName=" + eventName + ", volunteerName=" + volunteerName + ", noParticipants="
				+ noParticipants + ", desc=" + desc + ", imageURL=" + imageURL + ", eventDate=" + eventDate + ", url="
				+ url + "]";
	}
private String eventName;
private String volunteerName;
private int noParticipants;
private String desc;
private MultipartFile imageURL;
private Date eventDate;
private String url;
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public Date getEventDate() {
	return eventDate;
}
public void setEventDate(Date eventDate) {
	this.eventDate = eventDate;
}
public String getEventName() {
	return eventName;
}
public void setEventName(String eventName) {
	this.eventName = eventName;
}
public String getVolunteerName() {
	return volunteerName;
}
public void setVolunteerName(String volunteerName) {
	this.volunteerName = volunteerName;
}
public int getNoParticipants() {
	return noParticipants;
}
public void setNoParticipants(int noParticipants) {
	this.noParticipants = noParticipants;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public MultipartFile getImageURL() {
	return imageURL;
}
public void setImageURL(MultipartFile imageURL) {
	this.imageURL = imageURL;
} 
}
