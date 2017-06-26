package xin.chaoyueshidai.module.config;

import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

// 配置
public class Config {
	// 用户id
	private Integer userid;
	// 最后一次配置
	@JSONField(serialize = false)
	private String lastValue;
	// 时间
	private Date time;
	// 配置
	private String value;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getLastValue() {
		return lastValue;
	}

	public void setLastValue(String lastValue) {
		this.lastValue = lastValue == null ? null : lastValue.trim();
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value == null ? null : value.trim();
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}