package xin.chaoyueshidai.dto;

import com.alibaba.fastjson.JSON;

public class WebException {
	private Integer code;
	private String msg;

	public WebException() {
	}

	public WebException(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static WebException success(String msg) {
		return new WebException(200, msg);
	}

	public static WebException error(String msg) {
		return new WebException(500, msg);
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
