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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSequence")
    @SequenceGenerator(name="userSequence", sequenceName="USER_SEQ", allocationSize=1)
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="FIRST_NAME")
	private String first_name;
	
	@Column(name="LAST_NAME")
	private String last_name;
	
	@Column(name="USER_EMAIL")
	private String user_email;
	
	@Column(name="USER_PASSWORD")
	private String user_password;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="DATE_OF_BIRTH")
	private String date_of_birth;
	
	@Column(name="BIOGRAPHY")
	private String biography;
	
	@Column(name="PROFILE_IMAGE")
	private String profile_image;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Post> myPosts;

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}

	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<Comment> myComments;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinTable(name="USERS_FRIENDS",
		joinColumns={@JoinColumn(name="USER_ID")},
		inverseJoinColumns={@JoinColumn(name="FRIEND_ID")})
	private List<User> friends;
	
	/* needed for self-join many to many */
	@ManyToMany(mappedBy="friends")
	@JsonIgnore
	private List<User> others;

	@ManyToMany(cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinTable(name="LIKED_POSTS",
		joinColumns={@JoinColumn(name="USER_ID")},
		inverseJoinColumns={@JoinColumn(name="POST_ID")})
	private List<Post> likedPosts;
	
	public User() {}
	
	public User(String user_email, String user_password) {
		super();
		this.user_email = user_email;
		this.user_password = user_password;
	}

	public User(String first_name, String last_name, String user_email, String user_password, String gender,
			String date_of_birth) {
		super();
		this.user_email = user_email;
		this.user_password = user_password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.date_of_birth = date_of_birth;
		this.gender = gender;
	}

	

	public User(int userId, String first_name, String last_name, String user_email, String user_password, String gender,
			String date_of_birth, List<Post> myPosts, List<User> friends, List<Post> likedPosts) {
		super();
		this.userId = userId;
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_email = user_email;
		this.user_password = user_password;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
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

	public String getuser_email() {
		return user_email;
	}

	public void setuser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getuser_password() {
		return user_password;
	}

	public void setuser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getfirst_name() {
		return first_name;
	}

	public void setfirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getlast_name() {
		return last_name;
	}

	public void setlast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getdate_of_birth() {
		return date_of_birth;
	}

	public void setdate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
		return "User [userEmail=" + user_email + ", user_password=" + user_password + ", first_name="
				+ first_name + ", last_name=" + last_name + ", dateOfBirth=" + date_of_birth + ", gender=" + gender
				+ ", profile="+"]";
	}

	public String toStringTwo() {
		return "User [userId=" + userId + ", userEmail=" + user_email + ", user_password=" + user_password + ", first_name="
				+ first_name + ", last_name=" + last_name + ", gender=" + gender + ", profile="  + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
	
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((friends == null) ? 0 : friends.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((likedPosts == null) ? 0 : likedPosts.hashCode());
		result = prime * result + ((user_email == null) ? 0 : user_email.hashCode());
		result = prime * result + userId;
		result = prime * result + ((user_password == null) ? 0 : user_password.hashCode());
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
		
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
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
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
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
		if (user_email == null) {
			if (other.user_email != null)
				return false;
		} else if (!user_email.equals(other.user_email))
			return false;
		if (userId != other.userId)
			return false;
		if (user_password == null) {
			if (other.user_password != null)
				return false;
		} else if (!user_password.equals(other.user_password))
			return false;
		return true;
	}
}
