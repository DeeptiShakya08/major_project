package donation;

public class DonationBean {
 private String name;
 private String email;
 private String address;
 private String ItemName;
 private int amountOrNoOfItems;
 private String message;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getItemName() {
	return ItemName;
}
public void setItemName(String itemName) {
	ItemName = itemName;
}
public int getAmountOrNoOfItems() {
	return amountOrNoOfItems;
}
public void setAmountOrNoOfItems(int amountOrNoOfItems) {
	this.amountOrNoOfItems = amountOrNoOfItems;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
 
}
