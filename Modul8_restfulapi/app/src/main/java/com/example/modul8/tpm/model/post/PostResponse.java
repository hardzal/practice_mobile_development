package com.example.modul8.tpm.model.post;

import com.google.gson.annotations.SerializedName;

public class PostResponse{

	@SerializedName("dataItem")
	private DataItem dataItem;

	@SerializedName("errors")
	private Object errors;

	public void setDataItem(DataItem dataItem){
		this.dataItem = dataItem;
	}

	public DataItem getDataItem(){
		return dataItem;
	}

	public void setErrors(Object errors){
		this.errors = errors;
	}

	public Object getErrors(){
		return errors;
	}

	@Override
 	public String toString(){
		return 
			"PostResponse{" + 
			"dataItem = '" + dataItem + '\'' +
			",errors = '" + errors + '\'' + 
			"}";
		}
}