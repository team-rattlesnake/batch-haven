package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENTS")
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CommentSequence")
    @SequenceGenerator(name="CommentSequence", sequenceName="COMMENT_SEQ", allocationSize=1)
	@Column(name="COMMENT_ID")
	private int CommentId;
	
	@Column(name="COMMENT")
	private String Comment;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="POST_ID")
	private Post post;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private User user;

	public Comment() {
		super();
	}

	public Comment(int CommentId, String Comment) {
		super();
		this.CommentId = CommentId;
		this.Comment = Comment;
	}

	public int getCommentId() {
		return CommentId;
	}

	public void setCommentId(int CommentId) {
		this.CommentId = CommentId;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String Comment) {
		this.Comment = Comment;
	}

	@Override
	public String toString() {
		return "Comment [CommentId=" + CommentId + ", Comment=" + Comment + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Comment == null) ? 0 : Comment.hashCode());
		result = prime * result + CommentId;
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
		Comment other = (Comment) obj;
		if (Comment == null) {
			if (other.Comment != null)
				return false;
		} else if (!Comment.equals(other.Comment))
			return false;
		if (CommentId != other.CommentId)
			return false;
		return true;
	}
}
