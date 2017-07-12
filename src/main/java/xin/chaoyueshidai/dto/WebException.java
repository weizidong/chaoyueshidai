package xin.chaoyueshidai.dto;

import com.alibaba.fastjson.JSON;

@SuppressWarnings("serial")
public class WebException extends RuntimeException {
	private int code;
	private String msg;

	public WebException() {
	}

	public WebException(int code, String msg, Throwable cause) {
		super(msg, cause);
		this.code = code;
		this.msg = msg;
	}

	public WebException(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
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
