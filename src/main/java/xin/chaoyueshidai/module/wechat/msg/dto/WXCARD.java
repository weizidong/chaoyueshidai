package xin.chaoyueshidai.module.wechat.msg.dto;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/**
 * 卡券消息体
 * 
 * @author WeiZiDong
 *
 */
@SuppressWarnings("serial")
public class WXCARD implements Serializable {
	private String card_id;

	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
