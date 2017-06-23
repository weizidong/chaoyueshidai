package xin.chaoyueshidai.module.wechat.msg.dto;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/**
 * mpNews消息体
 * 
 * @author WeiZiDong
 *
 */
@SuppressWarnings("serial")
public class MPNEWS implements Serializable {
	private String media_id;

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
