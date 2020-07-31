package com.psl.bean;

import java.util.Date;

public class Post {

	private String postId;
	private Date postDate;
	private String recepientName;
	private String pinCode;

	
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postDate=" + postDate
				+ ", recepientName=" + recepientName + ", pinCode=" + pinCode
				+ "]";
	}
	public Post(String postId, Date postDate, String recepientName,
			String pinCode) {
		super();
		this.postId = postId;
		this.postDate = postDate;
		this.recepientName = recepientName;
		this.pinCode = pinCode;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getRecepientName() {
		return recepientName;
	}

	public void setRecepientName(String recepientName) {
		this.recepientName = recepientName;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pinCode == null) ? 0 : pinCode.hashCode());
		result = prime * result
				+ ((postDate == null) ? 0 : postDate.hashCode());
		result = prime * result + ((postId == null) ? 0 : postId.hashCode());
		result = prime * result
				+ ((recepientName == null) ? 0 : recepientName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Post)) {
			return false;
		}
		Post other = (Post) obj;
		if (pinCode == null) {
			if (other.pinCode != null) {
				return false;
			}
		} else if (!pinCode.equals(other.pinCode)) {
			return false;
		}
		if (postDate == null) {
			if (other.postDate != null) {
				return false;
			}
		} else if (!postDate.equals(other.postDate)) {
			return false;
		}
		if (postId == null) {
			if (other.postId != null) {
				return false;
			}
		} else if (!postId.equals(other.postId)) {
			return false;
		}
		if (recepientName == null) {
			if (other.recepientName != null) {
				return false;
			}
		} else if (!recepientName.equals(other.recepientName)) {
			return false;
		}
		return true;
	}
	
	

}
