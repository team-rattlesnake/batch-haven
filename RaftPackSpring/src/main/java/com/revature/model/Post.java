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
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private User user;

	@ManyToMany(mappedBy="likedPosts")
	//@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<User> likers = new ArrayList<>();
	
	public Post() {}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Post(int postId, String message, String image, int numOfLikes, User user) {
		super();
		this.postId = postId;
		this.message = message;
		this.image = image;
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<User> getLikers() {
		return likers;
	}

	public void setLikers(List<User> likers) {
		this.likers = likers;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", message=" + message + ", images=" + images + ", numOfLikes=" + numOfLikes
				+ ", user=" + user.toStringTwo() + ", likers=" + printLikers(likers) + "]";
	}
	
	public String toStringTwo() {
		return "Post [postId=" + postId + ", message=" + message + ", image=" + images + ", numOfLikes=" + numOfLikes
				+ "]";
	}
	
	public List<String> printLikers(List<User> users) {
		List<String> strings = new ArrayList<>();
		for(User u: users) {
			strings.add((u.toStringTwo()));
		}
		return strings;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		//result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + ((likers == null) ? 0 : likers.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
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
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
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
