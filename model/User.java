package model;

import java.time.LocalDate;

public class User {
	private String name;
	private String password;
	private LocalDate dob;
	private String address;
	private long phone;
	private String emailId;
	private String gender;
	private String qualification;
	private String state;
	private String userType;
	public User(String name, String password, LocalDate dob, String address, long phone, String emailId, String gender,
			String qualification, String state, String userType) {
		super();
		this.name = name;
		this.password = password;
		this.dob = dob;
		this.address = address;
		this.phone = phone;
		this.emailId = emailId;
		this.gender = gender;
		this.qualification = qualification;
		this.state = state;
		this.userType = userType;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", dob=" + dob + ", address=" + address + ", phone="
				+ phone + ", emailId=" + emailId + ", gender=" + gender + ", qualification=" + qualification
				+ ", state=" + state + ", userType=" + userType + "]";
	}
}