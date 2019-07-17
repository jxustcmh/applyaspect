package com.hx.applyaspect.model;

import lombok.Data;

/**
 * @author jxlgcmh
 * @create 2019-07-17 21:37
 */
@Data
public class MyResponse {
	private int status;
	private String message;
	
	public MyResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}
}
