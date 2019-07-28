package com.prestasimu99.lenovo.Guru.modelsignup;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("jp_nama")
	private String jpNama;

	@SerializedName("jp_jenjang")
	private String jpJenjang;

	@SerializedName("jp_id")
	private String jpId;

	public void setJpNama(String jpNama){
		this.jpNama = jpNama;
	}

	public String getJpNama(){
		return jpNama;
	}

	public void setJpJenjang(String jpJenjang){
		this.jpJenjang = jpJenjang;
	}

	public String getJpJenjang(){
		return jpJenjang;
	}

	public void setJpId(String jpId){
		this.jpId = jpId;
	}

	public String getJpId(){
		return jpId;
	}

	@Override
 	public String toString(){
		return 
			"DataItemStatusGuru{" +
			"jp_nama = '" + jpNama + '\'' + 
			",jp_jenjang = '" + jpJenjang + '\'' + 
			",jp_id = '" + jpId + '\'' + 
			"}";
		}
}