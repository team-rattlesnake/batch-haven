package com.revature.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSequence")
    @SequenceGenerator(name="userSequence", sequenceName="USER_SEQ", allocationSize=1)
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="USER_EMAIL")
	private String userEmail;
	
	@Column(name="USER_PASSWORD")
	private String userPassword;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="DATE_OF_BIRTH")
	private String dateOfBirth;
	
	
	
	
	@OneToOne
	private Profile profile;
	
	@OneToMany(mappedBy="postId", fetch=FetchType.LAZY)
	private List<Post> myPosts;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<User> friends;
	
	@OneToMany(mappedBy="postId", fetch=FetchType.LAZY)
	private List<Post> likedPosts;
	
	public User() {}
	
	public User(String userEmail, String userPassword) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}
	
	

	public User( String userEmail, String userPassword, String firstName, String lastName, String gender) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}
	
	

	public User(String firstName, String lastName, String userEmail, String userPassword, String gender,
			String dateOfBirth) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}

	public User(String userEmail, String userPassword, String firstName, String lastName,
			 String gender, Profile profile, List<Post> myPosts,
			List<User> friends, List<Post> likedPosts) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.profile = profile;
		this.myPosts = myPosts;
		this.friends = friends;
		this.likedPosts = likedPosts;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Post> getMyPosts() {
		return myPosts;
	}

	public void setMyPosts(List<Post> myPosts) {
		this.myPosts = myPosts;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public List<Post> getLikedPosts() {
		return likedPosts;
	}

	public void setLikedPosts(List<Post> likedPosts) {
		this.likedPosts = likedPosts;
	}


	
	public List<String> printFriends(List<User> friends) {
		List<String> myFriends = new ArrayList<>();
		for (User user : friends) {
			myFriends.add(user.toStringTwo());
		}
		return myFriends;
	}
	
	
	
	@Override
	public String toString() {
		return "User [userEmail=" + userEmail + ", userPassword=" + userPassword + ", firstName="
				+ firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", profile=" + profile + ", myPosts=" + myPosts + ", friends=" + friends + ", likedPosts="
				+ likedPosts + "]";
	}

	public String toStringTwo() {
		return "User [userId=" + userId + ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", firstName="
				+ firstName + ", lastName=" + lastName + ", gender=" + gender + ", profile=" + profile + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
	
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((friends == null) ? 0 : friends.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((likedPosts == null) ? 0 : likedPosts.hashCode());
		result = prime * result + ((myPosts == null) ? 0 : myPosts.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
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
		User other = (User) obj;
		
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (friends == null) {
			if (other.friends != null)
				return false;
		} else if (!friends.equals(other.friends))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (likedPosts == null) {
			if (other.likedPosts != null)
				return false;
		} else if (!likedPosts.equals(other.likedPosts))
			return false;
		if (myPosts == null) {
			if (other.myPosts != null)
				return false;
		} else if (!myPosts.equals(other.myPosts))
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userId != other.userId)
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		return true;
	}
}
