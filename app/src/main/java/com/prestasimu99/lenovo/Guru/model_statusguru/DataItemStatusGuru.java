package com.prestasimu99.lenovo.Guru.model_statusguru;


import com.google.gson.annotations.SerializedName;


public class DataItemStatusGuru {

	@SerializedName("user_jp")
	private String userJp;

	@SerializedName("user_alamat")
	private String userAlamat;

	@SerializedName("user_status")
	private String userStatus;

	@SerializedName("user_nama")
	private String userNama;

	@SerializedName("user_email")
	private String userEmail;

	@SerializedName("user_password")
	private String userPassword;

	@SerializedName("user_telpon")
	private String userTelpon;

	@SerializedName("user_ktp")
	private String userKtp;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("user_kec")
	private String userKec;

	@SerializedName("user_level")
	private String userLevel;

	@SerializedName("user_kelurahan")
	private String userKelurahan;

	@SerializedName("user_kab")
	private String userKab;

	@SerializedName("user_ijazah")
	private String userIjazah;

	public void setUserJp(String userJp){
		this.userJp = userJp;
	}

	public String getUserJp(){
		return userJp;
	}

	public void setUserAlamat(String userAlamat){
		this.userAlamat = userAlamat;
	}

	public String getUserAlamat(){
		return userAlamat;
	}

	public void setUserStatus(String userStatus){
		this.userStatus = userStatus;
	}

	public String getUserStatus(){
		return userStatus;
	}

	public void setUserNama(String userNama){
		this.userNama = userNama;
	}

	public String getUserNama(){
		return userNama;
	}

	public void setUserEmail(String userEmail){
		this.userEmail = userEmail;
	}

	public String getUserEmail(){
		return userEmail;
	}

	public void setUserPassword(String userPassword){
		this.userPassword = userPassword;
	}

	public String getUserPassword(){
		return userPassword;
	}

	public void setUserTelpon(String userTelpon){
		this.userTelpon = userTelpon;
	}

	public String getUserTelpon(){
		return userTelpon;
	}

	public void setUserKtp(String userKtp){
		this.userKtp = userKtp;
	}

	public String getUserKtp(){
		return userKtp;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setUserKec(String userKec){
		this.userKec = userKec;
	}

	public String getUserKec(){
		return userKec;
	}

	public void setUserLevel(String userLevel){
		this.userLevel = userLevel;
	}

	public String getUserLevel(){
		return userLevel;
	}

	public void setUserKelurahan(String userKelurahan){
		this.userKelurahan = userKelurahan;
	}

	public String getUserKelurahan(){
		return userKelurahan;
	}

	public void setUserKab(String userKab){
		this.userKab = userKab;
	}

	public String getUserKab(){
		return userKab;
	}

	public void setUserIjazah(String userIjazah){
		this.userIjazah = userIjazah;
	}

	public String getUserIjazah(){
		return userIjazah;
	}

	@Override
 	public String toString(){
		return 
			"DataItemStatusGuru{" +
			"user_jp = '" + userJp + '\'' + 
			",user_alamat = '" + userAlamat + '\'' + 
			",user_status = '" + userStatus + '\'' + 
			",user_nama = '" + userNama + '\'' + 
			",user_email = '" + userEmail + '\'' + 
			",user_password = '" + userPassword + '\'' + 
			",user_telpon = '" + userTelpon + '\'' + 
			",user_ktp = '" + userKtp + '\'' + 
			",user_id = '" + userId + '\'' + 
			",user_kec = '" + userKec + '\'' + 
			",user_level = '" + userLevel + '\'' + 
			",user_kelurahan = '" + userKelurahan + '\'' + 
			",user_kab = '" + userKab + '\'' + 
			",user_ijazah = '" + userIjazah + '\'' + 
			"}";
		}
}