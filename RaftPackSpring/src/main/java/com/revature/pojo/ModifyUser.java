package com.revature.pojo;

public class ModifyUser {
	private int userId;
	private String profileImage;
	private String firstname;
	private String lastname;
	private String useremail;
	private String gender;
	private String biography;

	public ModifyUser(int userId, String profileImage, String firstname, String lastname, String useremail,
			String gender, String biography) {
		super();
		this.userId = userId;
		this.profileImage = profileImage;
		this.firstname = firstname;
		this.lastname = lastname;
		this.useremail = useremail;
		this.gender = gender;
		this.biography = biography;
	}

	public ModifyUser() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

}
