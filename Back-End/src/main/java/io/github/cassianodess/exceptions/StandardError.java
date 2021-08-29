package io.github.cassianodess.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long timestamps;
	private Integer status;
	private String msg;

	public StandardError() {

	}

	public StandardError(Long timestamps, Integer status, String msg) {
		this.timestamps = timestamps;
		this.status = status;
		this.msg = msg;
	}

	public Long getTimestamps() {
		return timestamps;
	}

	public void setTimestamps(Long timestamps) {
		this.timestamps = timestamps;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
