package com.revature.model;

import java.util.ArrayList;
import java.sql.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class Post.
 */
@Entity
@Table(name = "POSTS")
public class Post {
	
	/** The post id. */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="postSequence")
    @SequenceGenerator(name="postSequence", sequenceName="POST_SEQ", allocationSize=1)
	@Column(name="POST_ID")
	private int postId;
	
	/** The message. */
	@Column(name="MESSAGE")
	private String message;
	
	/** The num of likes. */
	@Column(name="NUM_OF_LIKES")
	private int numOfLikes;
	
	/** The date. */
	@Column(name="DATE_SUBMITTED")
	private Date date;
	
	/** The image. */
	@Column(name="IMAGE")
	private String image;
//	@OneToMany(mappedBy="post", fetch = FetchType.EAGER)
//	@Fetch(value = FetchMode.SUBSELECT)
//	@JsonIgnore
//	private List<Image> images;

	//@OneToMany(mappedBy="post", fetch = FetchType.EAGER)
	//@Fetch(value = FetchMode.SUBSELECT)
	//@JsonIgnore
	//private List<Comment> comments;
	
	/**
 * Gets the image.
 *
 * @return the image
 */
public String getImage() {
		return image;
	}

	/**
	 * Sets the image.
	 *
	 * @param image the new image
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/** The user. */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private User user;

	/** The likers. */
	@ManyToMany(mappedBy="likedPosts", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<User> likers = new ArrayList<>();
	
	/**
	 * Instantiates a new post.
	 */
	public Post() {}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Instantiates a new post.
	 *
	 * @param postId the post id
	 * @param message the message
	 * @param image the image
	 * @param numOfLikes the num of likes
	 * @param user the user
	 */
	public Post(int postId, String message, String image, int numOfLikes, User user) {
		super();
		this.postId = postId;
		this.message = message;
		this.image = image;
		this.numOfLikes = numOfLikes;
		this.user = user;
	}

	/**
	 * Gets the post id.
	 *
	 * @return the post id
	 */
	public int getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the new post id
	 */
	public void setPostId(int postId) {
		this.postId = postId;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * Gets the num of likes.
	 *
	 * @return the num of likes
	 */
	public int getNumOfLikes() {
		return numOfLikes;
	}

	/**
	 * Sets the num of likes.
	 *
	 * @param numOfLikes the new num of likes
	 */
	public void setNumOfLikes(int numOfLikes) {
		this.numOfLikes = numOfLikes;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

//	public List<Comment> getComments() {
//		return comments;
//	}
//
//	public void setComments(List<Comment> comments) {
//		this.comments = comments;
//	}

	/**
 * Gets the likers.
 *
 * @return the likers
 */
public List<User> getLikers() {
		return likers;
	}

	/**
	 * Sets the likers.
	 *
	 * @param likers the new likers
	 */
	public void setLikers(List<User> likers) {
		this.likers = likers;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", message=" + message + ", numOfLikes=" + numOfLikes
				+ ", user=" + user.toStringTwo() + ", likers=" + printLikers(likers) + "]";
	}
	
	/**
	 * To string two.
	 *
	 * @return the string
	 */
	public String toStringTwo() {
		return "Post [postId=" + postId + ", message=" + message + ", numOfLikes=" + numOfLikes
				+ "]";
	}
	
	/**
	 * Prints the likers.
	 *
	 * @param users the users
	 * @return the list
	 */
	public List<String> printLikers(List<User> users) {
		List<String> strings = new ArrayList<>();
		for(User u: users) {
			strings.add((u.toStringTwo()));
		}
		return strings;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		//result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + ((likers == null) ? 0 : likers.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + numOfLikes;
		result = prime * result + postId;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Post other = (Post) obj;
//		if (comments == null) {
//			if (other.comments != null)
//				return false;
//		} else if (!comments.equals(other.comments))
//			return false;
		// if (images == null) {
		// 	if (other.images != null)
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (likers == null) {
			if (other.likers != null)
				return false;
		} else if (!likers.equals(other.likers))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (numOfLikes != other.numOfLikes)
			return false;
		if (postId != other.postId)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
