package xin.chaoyueshidai.module.wechat.msg.dto;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/**
 * voice消息体
 * 
 * @author WeiZiDong
 *
 */
@SuppressWarnings("serial")
public class VOICE implements Serializable {
	private String media_id; // 语音文件id，可以调用上传临时素材或者永久素材接口获取

	public VOICE() {
		super();
	}

	public VOICE(String media_id) {
		this.media_id = media_id;
	}

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
