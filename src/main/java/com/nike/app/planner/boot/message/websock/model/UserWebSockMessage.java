
package com.nike.app.planner.boot.message.websock.model;

import com.nike.app.planner.boot.data.entity.UserProfile;

public class UserWebSockMessage extends SimpleWebSockMessage {

	private UserProfile userInfo = null;
	private String imgUrl = null;

	public UserWebSockMessage() {
		super();
	}

	public UserProfile getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserProfile userInfo) {
		this.userInfo = userInfo;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}