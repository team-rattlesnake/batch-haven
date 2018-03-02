package com.revature.model;

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

@Entity
@Table(name = "POSTS")
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="postSequence")
    @SequenceGenerator(name="postSequence", sequenceName="POST_SEQ", allocationSize=1)
	@Column(name="POST_ID")
	private int postId;
	
	@Column(name="MESSAGE")
	private String message;
	
	@Column(name="NUM_OF_LIKES")
	private int numOfLikes;
	
	@Column(name="DATE_SUBMITTED")
	private Date date;
	
	@OneToMany(mappedBy="post", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<Image> images;

	//@OneToMany(mappedBy="post", fetch = FetchType.EAGER)
	//@Fetch(value = FetchMode.SUBSELECT)
	//@JsonIgnore
	//private List<Comment> comments;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private User user;

	@ManyToMany(mappedBy="likedPosts", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<User> likers;
	
	public Post() {}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Post(int postId, String message, List<Image> images, int numOfLikes, User user) {
		super();
		this.postId = postId;
		this.message = message;
		this.images = images;
		this.numOfLikes = numOfLikes;
		this.user = user;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public int getNumOfLikes() {
		return numOfLikes;
	}

	public void setNumOfLikes(int numOfLikes) {
		this.numOfLikes = numOfLikes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", message=" + message + ", images=" + images + ", numOfLikes=" + numOfLikes
				+ ", user=" + user + "]";
	}
	
	public String toStringTwo() {
		return "Post [postId=" + postId + ", message=" + message + ", image=" + images + ", numOfLikes=" + numOfLikes
				+ ", user=" + user.toStringTwo() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + numOfLikes;
		result = prime * result + postId;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Post other = (Post) obj;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
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
