package xin.chaoyueshidai.module.wechat.base;

import java.io.Serializable;

import javax.persistence.Transient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信返回结果基类
 * 
 * @author WeiZiDong
 *
 */
@SuppressWarnings("serial")
public class BaseResp implements Serializable {
	@Transient
	@JSONField(serialize = false)
	private Integer errcode;
	@Transient
	@JSONField(serialize = false)
	private String errmsg;

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
