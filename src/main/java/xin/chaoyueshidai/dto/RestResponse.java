package xin.chaoyueshidai.dto;

import com.alibaba.fastjson.JSON;

/**
 * rest 响应结果
 * 
 * @author WeiZiDong
 *
 */
public class RestResponse {
	// 状态
	private int code;
	// 返回信息
	private String msg;
	// 响应数据
	private Object data;

	public RestResponse() {
	}

	public RestResponse(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public RestResponse(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static RestResponse error(String msg) {
		return new RestResponse(500, msg);
	}

	public static RestResponse error(int code, String msg) {
		return new RestResponse(code, msg);
	}

	public static RestResponse success(Object data) {
		return new RestResponse(200, "成功", data);
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
