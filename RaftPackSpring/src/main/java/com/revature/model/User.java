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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Entity
@Table(name = "USERS")
public class User {
	
	/** The user id. */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSequence")
    @SequenceGenerator(name="userSequence", sequenceName="USER_SEQ", allocationSize=1)
	@Column(name="USER_ID")
	private int userId;
	
	/** The first name. */
	@Column(name="FIRST_NAME")
	private String first_name;
	
	/** The last name. */
	@Column(name="LAST_NAME")
	private String last_name;
	
	/** The user email. */
	@Column(name="USER_EMAIL")
	private String user_email;
	
	/** The user password. */
	@Column(name="USER_PASSWORD")
	private String user_password;
	
	/** The gender. */
	@Column(name="GENDER")
	private String gender;
	
	/** The date of birth. */
	@Column(name="DATE_OF_BIRTH")
	private String date_of_birth;
	
	/** The biography. */
	@Column(name="BIOGRAPHY")
	private String biography;
	
	/** The profile image. */
	@Column(name="PROFILE_IMAGE")
	private String profile_image;
	
	/** The my posts. */
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<Post> myPosts;

	/**
	 * Gets the biography.
	 *
	 * @return the biography
	 */
	public String getBiography() {
		return biography;
	}

	/**
	 * Sets the biography.
	 *
	 * @param biography the new biography
	 */
	public void setBiography(String biography) {
		this.biography = biography;
	}

	/**
	 * Gets the profile image.
	 *
	 * @return the profile image
	 */
	public String getProfile_image() {
		return profile_image;
	}

	/**
	 * Sets the profile image.
	 *
	 * @param profile_image the new profile image
	 */
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}

	//@OneToMany(mappedBy="user")
	//@Fetch(value = FetchMode.SUBSELECT)
	//@JsonIgnore
	//private List<Comment> myComments;
	
	/** The friends. */
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	@JoinTable(name="USERS_FRIENDS",
		joinColumns={@JoinColumn(name="USER_ID")},
		inverseJoinColumns={@JoinColumn(name="FRIEND_ID")})
	private List<User> friends;
	
	/** The others. */
	/* needed for self-join many to many */
	@ManyToMany(mappedBy="friends")
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<User> others;

	/** The liked posts. */
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	//@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	@JoinTable(name="LIKED_POSTS",
		joinColumns={@JoinColumn(name="USER_ID")},
		inverseJoinColumns={@JoinColumn(name="POST_ID")})
	private List<Post> likedPosts = new ArrayList<>();
	
	/**
	 * Instantiates a new user.
	 */
	public User() {}
	
	/**
	 * Instantiates a new user.
	 *
	 * @param user_email the user email
	 * @param user_password the user password
	 */
	public User(String user_email, String user_password) {
		super();
		this.user_email = user_email;
		this.user_password = user_password;
	}
	
	

	/**
	 * Instantiates a new user.
	 *
	 * @param userId the user id
	 * @param first_name the first name
	 * @param last_name the last name
	 */
	public User(int userId, String first_name, String last_name) {
		super();
		this.userId = userId;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param first_name the first name
	 * @param last_name the last name
	 * @param user_email the user email
	 * @param user_password the user password
	 * @param gender the gender
	 * @param date_of_birth the date of birth
	 */
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
	
	

	

	/**
	 * Instantiates a new user.
	 *
	 * @param first_name the first name
	 * @param last_name the last name
	 * @param user_email the user email
	 * @param user_password the user password
	 * @param gender the gender
	 * @param date_of_birth the date of birth
	 * @param biography the biography
	 * @param profile_image the profile image
	 */
	public User(String first_name, String last_name, String user_email, String user_password, String gender,
			String date_of_birth, String biography, String profile_image) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_email = user_email;
		this.user_password = user_password;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.biography = biography;
		this.profile_image = profile_image;
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param userId the user id
	 * @param first_name the first name
	 * @param last_name the last name
	 * @param user_email the user email
	 * @param user_password the user password
	 * @param gender the gender
	 * @param date_of_birth the date of birth
	 * @param myPosts the my posts
	 * @param friends the friends
	 * @param likedPosts the liked posts
	 */
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

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Gets the user email.
	 *
	 * @return the user email
	 */
	public String getuser_email() {
		return user_email;
	}

	/**
	 * Sets the user email.
	 *
	 * @param user_email the new user email
	 */
	public void setuser_email(String user_email) {
		this.user_email = user_email;
	}

	/**
	 * Gets the user password.
	 *
	 * @return the user password
	 */
	public String getuser_password() {
		return user_password;
	}

	/**
	 * Sets the user password.
	 *
	 * @param user_password the new user password
	 */
	public void setuser_password(String user_password) {
		this.user_password = user_password;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getfirst_name() {
		return first_name;
	}

	/**
	 * Sets the first name.
	 *
	 * @param first_name the new first name
	 */
	public void setfirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getlast_name() {
		return last_name;
	}

	/**
	 * Sets the last name.
	 *
	 * @param last_name the new last name
	 */
	public void setlast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * Gets the date of birth.
	 *
	 * @return the date of birth
	 */
	public String getdate_of_birth() {
		return date_of_birth;
	}

	/**
	 * Sets the date of birth.
	 *
	 * @param date_of_birth the new date of birth
	 */
	public void setdate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the my posts.
	 *
	 * @return the my posts
	 */
	public List<Post> getMyPosts() {
		return myPosts;
	}

	/**
	 * Sets the my posts.
	 *
	 * @param myPosts the new my posts
	 */
	public void setMyPosts(List<Post> myPosts) {
		this.myPosts = myPosts;
	}

	/**
	 * Gets the friends.
	 *
	 * @return the friends
	 */
	public List<User> getFriends() {
		return friends;
	}

	/**
	 * Sets the friends.
	 *
	 * @param friends the new friends
	 */
	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	/**
	 * Gets the liked posts.
	 *
	 * @return the liked posts
	 */
	public List<Post> getLikedPosts() {
		return likedPosts;
	}

	/**
	 * Sets the liked posts.
	 *
	 * @param likedPosts the new liked posts
	 */
	public void setLikedPosts(List<Post> likedPosts) {
		this.likedPosts = likedPosts;
	}
	
	/**
	 * Prints the friends.
	 *
	 * @param friends the friends
	 * @return the list
	 */
	public List<String> printFriends(List<User> friends) {
		List<String> myFriends = new ArrayList<>();
		for (User user : friends) {
			myFriends.add(user.toStringTwo());
		}
		return myFriends;
	}
		
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", first_name=" + first_name + ", last_name=" + last_name + ", user_email="
				+ user_email + ", user_password=" + user_password + ", gender=" + gender + ", date_of_birth="
				+ date_of_birth + ", biography=" + biography + ", profile_image=" + profile_image + ", myPosts="
				+ myPosts + ", likedPosts=" + likedPosts + "]";
	}
	
	

	/**
	 * To string two.
	 *
	 * @return the string
	 */
	public String toStringTwo() {
		return "User [userId=" + userId + ", userEmail=" + user_email + ", user_password=" + user_password + ", first_name="
				+ first_name + ", last_name=" + last_name + ", gender=" + gender + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
