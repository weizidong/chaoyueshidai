package xin.chaoyueshidai.module.wechat.msg.dto;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/**
 * 图文消息的消息体
 * 
 * @author WeiZiDong
 *
 */
@SuppressWarnings("serial")
public class ARTICLE implements Serializable {
	private String title; // 图文消息标题
	private String description;// 图文消息描述
	private String picurl;// 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
	private String url;// 点击图文消息跳转链接

	public ARTICLE() {
		super();
	}

	public ARTICLE(String title, String description, String url, String picurl) {
		this.title = title;
		this.description = description;
		this.url = url;
		this.picurl = picurl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
