package xin.chaoyueshidai.module.config;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSON;

// 配置
@SuppressWarnings("serial")
public class Config implements Serializable {
	// 字段
	private String filed;
	// 值
	private String value;
	// 上一次的值
	private String lastValue;
	// 修改时间
	private Date time;

	public String getFiled() {
		return filed;
	}

	public void setFiled(String filed) {
		this.filed = filed == null ? null : filed.trim();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value == null ? null : value.trim();
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

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}