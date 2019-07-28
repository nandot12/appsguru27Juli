package com.prestasimu99.lenovo.Guru.modelhome;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataItem implements Serializable {

	@SerializedName("order_lat")
	private String orderLat;

	@SerializedName("user_jp")
	private String userJp;

	@SerializedName("user_nama")
	private String userNama;

	@SerializedName("user_password")
	private String userPassword;

	@SerializedName("order_jp")
	private String orderJp;

	@SerializedName("order_hp")
	private String orderHp;

	@SerializedName("order_user")
	private String orderUser;

	@SerializedName("order_status")
	private String orderStatus;

	@SerializedName("user_ktp")
	private String userKtp;

	@SerializedName("order_guru")
	private String orderGuru;

	@SerializedName("user_kelurahan")
	private String userKelurahan;

	@SerializedName("user_ijazah")
	private String userIjazah;

	@SerializedName("booking_ket")
	private String bookingKet;

	@SerializedName("order_tanggal")
	private String orderTanggal;

	@SerializedName("user_alamat")
	private String userAlamat;

	@SerializedName("user_status")
	private String userStatus;

	@SerializedName("user_email")
	private String userEmail;

	@SerializedName("user_telpon")
	private String userTelpon;

	@SerializedName("order_alamat")
	private String orderAlamat;

	@SerializedName("order_lon")
	private String orderLon;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("user_kec")
	private String userKec;

	@SerializedName("user_level")
	private String userLevel;

	@SerializedName("user_kab")
	private String userKab;

	@SerializedName("order_id")
	private String orderId;

	public void setOrderLat(String orderLat){
		this.orderLat = orderLat;
	}

	public String getOrderLat(){
		return orderLat;
	}

	public void setUserJp(String userJp){
		this.userJp = userJp;
	}

	public String getUserJp(){
		return userJp;
	}

	public void setUserNama(String userNama){
		this.userNama = userNama;
	}

	public String getUserNama(){
		return userNama;
	}

	public void setUserPassword(String userPassword){
		this.userPassword = userPassword;
	}

	public String getUserPassword(){
		return userPassword;
	}

	public void setOrderJp(String orderJp){
		this.orderJp = orderJp;
	}

	public String getOrderJp(){
		return orderJp;
	}

	public void setOrderHp(String orderHp){
		this.orderHp = orderHp;
	}

	public String getOrderHp(){
		return orderHp;
	}

	public void setOrderUser(String orderUser){
		this.orderUser = orderUser;
	}

	public String getOrderUser(){
		return orderUser;
	}

	public void setOrderStatus(String orderStatus){
		this.orderStatus = orderStatus;
	}

	public String getOrderStatus(){
		return orderStatus;
	}

	public void setUserKtp(String userKtp){
		this.userKtp = userKtp;
	}

	public String getUserKtp(){
		return userKtp;
	}

	public void setOrderGuru(String orderGuru){
		this.orderGuru = orderGuru;
	}

	public String getOrderGuru(){
		return orderGuru;
	}

	public void setUserKelurahan(String userKelurahan){
		this.userKelurahan = userKelurahan;
	}

	public String getUserKelurahan(){
		return userKelurahan;
	}

	public void setUserIjazah(String userIjazah){
		this.userIjazah = userIjazah;
	}

	public String getUserIjazah(){
		return userIjazah;
	}

	public void setBookingKet(String bookingKet){
		this.bookingKet = bookingKet;
	}

	public String getBookingKet(){
		return bookingKet;
	}

	public void setOrderTanggal(String orderTanggal){
		this.orderTanggal = orderTanggal;
	}

	public String getOrderTanggal(){
		return orderTanggal;
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

	public void setUserEmail(String userEmail){
		this.userEmail = userEmail;
	}

	public String getUserEmail(){
		return userEmail;
	}

	public void setUserTelpon(String userTelpon){
		this.userTelpon = userTelpon;
	}

	public String getUserTelpon(){
		return userTelpon;
	}

	public void setOrderAlamat(String orderAlamat){
		this.orderAlamat = orderAlamat;
	}

	public String getOrderAlamat(){
		return orderAlamat;
	}

	public void setOrderLon(String orderLon){
		this.orderLon = orderLon;
	}

	public String getOrderLon(){
		return orderLon;
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

	public void setUserKab(String userKab){
		this.userKab = userKab;
	}

	public String getUserKab(){
		return userKab;
	}

	public void setOrderId(String orderId){
		this.orderId = orderId;
	}

	public String getOrderId(){
		return orderId;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"order_lat = '" + orderLat + '\'' + 
			",user_jp = '" + userJp + '\'' + 
			",user_nama = '" + userNama + '\'' + 
			",user_password = '" + userPassword + '\'' + 
			",order_jp = '" + orderJp + '\'' + 
			",order_hp = '" + orderHp + '\'' + 
			",order_user = '" + orderUser + '\'' + 
			",order_status = '" + orderStatus + '\'' + 
			",user_ktp = '" + userKtp + '\'' + 
			",order_guru = '" + orderGuru + '\'' + 
			",user_kelurahan = '" + userKelurahan + '\'' + 
			",user_ijazah = '" + userIjazah + '\'' + 
			",booking_ket = '" + bookingKet + '\'' + 
			",order_tanggal = '" + orderTanggal + '\'' + 
			",user_alamat = '" + userAlamat + '\'' + 
			",user_status = '" + userStatus + '\'' + 
			",user_email = '" + userEmail + '\'' + 
			",user_telpon = '" + userTelpon + '\'' + 
			",order_alamat = '" + orderAlamat + '\'' + 
			",order_lon = '" + orderLon + '\'' + 
			",user_id = '" + userId + '\'' + 
			",user_kec = '" + userKec + '\'' + 
			",user_level = '" + userLevel + '\'' + 
			",user_kab = '" + userKab + '\'' + 
			",order_id = '" + orderId + '\'' + 
			"}";
		}
}