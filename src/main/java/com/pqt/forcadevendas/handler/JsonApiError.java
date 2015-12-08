package com.pqt.forcadevendas.handler;

import java.util.UUID;

public class JsonApiError {

	private UUID id;
	private String title;
	private String detail;
	
	public JsonApiError(){}
	
	public JsonApiError(String title, String detail){
		this.id = UUID.randomUUID();
		this.title = title;
		this.detail = detail;
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
}
