package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PROFILES")
public class Profile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="profileSequence")
    @SequenceGenerator(name="profileSequence", sequenceName="PROFILE_SEQ", allocationSize=1)
	@Column(name="PROFILE_ID")
	private int profileId;
	
	@Column(name="PROFILE_IMAGE")
	private String profileImage;
	
	@Column(name="BIOGRAPHY")
	private String biography;
	
	public Profile() {}

	public Profile(int profileId, String profileImage, String biography) {
		super();
		this.profileId = profileId;
		this.profileImage = profileImage;
		this.biography = biography;
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", profileImage=" + profileImage + ", biography=" + biography + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((biography == null) ? 0 : biography.hashCode());
		result = prime * result + profileId;
		result = prime * result + ((profileImage == null) ? 0 : profileImage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		if (biography == null) {
			if (other.biography != null)
				return false;
		} else if (!biography.equals(other.biography))
			return false;
		if (profileId != other.profileId)
			return false;
		if (profileImage == null) {
			if (other.profileImage != null)
				return false;
		} else if (!profileImage.equals(other.profileImage))
			return false;
		return true;
	}
}
