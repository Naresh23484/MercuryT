package Data_Project;

public class MercuryCredential {
	String firstName=null;
	String lastName=null;
	double number=0;
	String phone=null;
	String email=null;
	String address=null;
	String city=null;
	String state_province=null;
	String postalCode=null;
	String country=null;
	String uName=null;
	String passWord=null;
	String confirmpassWord=null;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getNumber() {
		return number;
	}
	public void setNumber(double number) {
		this.number = number;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState_province() {
		return state_province;
	}
	public void setState_province(String state_province) {
		this.state_province = state_province;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalcode) {
		this.postalCode = postalcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "MercuryCredential [firstName=" + firstName + ", lastName=" + lastName + ", number=" + number
				+ ", phone=" + phone + ", email=" + email + ", address=" + address + ", city=" + city
				+ ", state_province=" + state_province + ", postalCode=" + postalCode + ", country=" + country
				+ ", uName=" + uName + ", passWord=" + passWord + ", confirmpassWord=" + confirmpassWord + "]";
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getConfirmpassWord() {
		return confirmpassWord;
	}
	public void setConfirmpassWord(String confirmpassWord) {
		this.confirmpassWord = confirmpassWord;
	}
	public MercuryCredential(String firstName, String lastName, double number, String phone, String email,
			String address, String city, String state_province, String postalCode, String country, String uName,
			String passWord, String confirmpassWord) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state_province = state_province;
		this.postalCode = postalCode;
		this.country = country;
		this.uName = uName;
		this.passWord = passWord;
		this.confirmpassWord = confirmpassWord;
	}
	public MercuryCredential() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
