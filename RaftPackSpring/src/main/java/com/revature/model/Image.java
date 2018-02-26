package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "IMAGES")
public class Image {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="imageSequence")
    @SequenceGenerator(name="imageSequence", sequenceName="IMAGE_SEQ", allocationSize=1)
	@Column(name="IMAGE_ID")
	private int imageId;
	
	@Column(name="IMAGE")
	private String image;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="POST_ID")
	private Post post;

	public Image() {
		super();
	}

	public Image(int imageId, String image) {
		super();
		this.imageId = imageId;
		this.image = image;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Image [imageId=" + imageId + ", image=" + image + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + imageId;
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
		Image other = (Image) obj;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (imageId != other.imageId)
			return false;
		return true;
	}
}
