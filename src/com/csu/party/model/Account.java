package com.csu.party.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
	public String _id;
	public String accessToken;
	public String nickname;
	public String name;
	public String tel;
	public String password;
	public Avatar avatar;
	public String city;
	public String province;
	public String gender;
	public String email;
	public String signature;
	public LatLonPoint currentPos;
	public List<String> friends;

	public String birthday;
	public String cTime;
	public String uTime;
	public String lastLoginTime;

	public Boolean isCreator;
	public Boolean isMember;

	public Account() {
		this.avatar = new Avatar();
		this.friends = new ArrayList<String>();
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public LatLonPoint getCurrentPos() {
		return currentPos;
	}

	public void setCurrentPos(LatLonPoint currentPos) {
		this.currentPos = currentPos;
	}

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getcTime() {
		return cTime;
	}

	public void setcTime(String cTime) {
		this.cTime = cTime;
	}

	public String getuTime() {
		return uTime;
	}

	public void setuTime(String uTime) {
		this.uTime = uTime;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Boolean getIsCreator() {
		return isCreator;
	}

	public void setIsCreator(Boolean isCreator) {
		this.isCreator = isCreator;
	}

	public Boolean getIsMember() {
		return isMember;
	}

	public void setIsMember(Boolean isMember) {
		this.isMember = isMember;
	}

	@Override
	public String toString() {
		return "Account [_id=" + _id + ", accessToken=" + accessToken
				+ ", nickname=" + nickname + ", name=" + name + ", tel=" + tel
				+ ", password=" + password + ", avatar=" + avatar + ", city="
				+ city + ", province=" + province + ", gender=" + gender
				+ ", email=" + email + ", signature=" + signature
				+ ", currentPos=" + currentPos + ", friends=" + friends
				+ ", birthday=" + birthday + ", cTime=" + cTime + ", uTime="
				+ uTime + ", lastLoginTime=" + lastLoginTime + ", isCreator="
				+ isCreator + ", isMember=" + isMember + "]";
	}

}
