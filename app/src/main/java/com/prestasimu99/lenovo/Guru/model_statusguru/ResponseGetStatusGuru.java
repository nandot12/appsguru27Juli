package com.prestasimu99.lenovo.Guru.model_statusguru;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class ResponseGetStatusGuru{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("data")
	private List<DataItemStatusGuru> data;

	@SerializedName("status")
	private boolean status;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setData(List<DataItemStatusGuru> data){
		this.data = data;
	}

	public List<DataItemStatusGuru> getData(){
		return data;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseGetStatusGuru{" + 
			"pesan = '" + pesan + '\'' + 
			",data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}