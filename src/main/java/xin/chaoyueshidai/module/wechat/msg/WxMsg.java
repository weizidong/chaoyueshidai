package xin.chaoyueshidai.module.wechat.msg;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;

import xin.chaoyueshidai.module.wechat.base.MsgType;
import xin.chaoyueshidai.module.wechat.msg.dto.ARTICLE;
import xin.chaoyueshidai.module.wechat.msg.dto.IMAGE;
import xin.chaoyueshidai.module.wechat.msg.dto.MPNEWS;
import xin.chaoyueshidai.module.wechat.msg.dto.MUSIC;
import xin.chaoyueshidai.module.wechat.msg.dto.NEWS;
import xin.chaoyueshidai.module.wechat.msg.dto.TEXT;
import xin.chaoyueshidai.module.wechat.msg.dto.VIDEO;
import xin.chaoyueshidai.module.wechat.msg.dto.VOICE;
import xin.chaoyueshidai.module.wechat.msg.dto.WXCARD;

/**
 * 推送消息的基类
 * 
 * @author WeiZiDong
 *
 */
@SuppressWarnings("serial")
public class WxMsg implements Serializable {
	private String touser; // 成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）。特殊情况：指定为@all，则向关注该企业应用的全部成员发送
	private String msgtype; // 消息类型，此时固定为：text （支持消息型应用跟主页型应用）
	private TEXT text; // text消息
	private IMAGE image; // image消息
	private VOICE voice; // voice消息
	private VIDEO video; // video消息
	private MUSIC music; // music消息
	private NEWS news; // news消息
	private MPNEWS mpnews; // mpnews消息
	private WXCARD wxcard; // 卡券消息

	public WxMsg() {
		super();
	}

	public WxMsg(String touser, TEXT text) {
		this.touser = touser;
		this.msgtype = MsgType.TEXT;
		this.text = text;
	}

	public WxMsg(String touser, IMAGE image) {
		this.touser = touser;
		this.msgtype = MsgType.IMAGE;
		this.image = image;
	}

	public WxMsg(String touser, VOICE voice) {
		this.touser = touser;
		this.msgtype = MsgType.VOICE;
		this.voice = voice;
	}

	public WxMsg(String touser, VIDEO video) {
		this.touser = touser;
		this.msgtype = MsgType.VIDEO;
		this.video = video;
	}

	public WxMsg(String touser, MUSIC music) {
		this.touser = touser;
		this.msgtype = MsgType.MUSIC;
		this.music = music;
	}

	public WxMsg(String touser, MPNEWS mpnews) {
		this.touser = touser;
		this.msgtype = MsgType.MPNEWS;
		this.mpnews = mpnews;
	}

	public WxMsg(String touser, WXCARD wxcard) {
		this.touser = touser;
		this.msgtype = MsgType.WXCARD;
		this.wxcard = wxcard;
	}

	public WxMsg(String touser, List<ARTICLE> articles) {
		this.touser = touser;
		this.msgtype = MsgType.NEWS;
		this.news = new NEWS(articles);
	}

	public WxMsg(String touser, ARTICLE article) {
		this.touser = touser;
		this.msgtype = MsgType.NEWS;
		this.news = new NEWS(Arrays.asList(article));
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public TEXT getText() {
		return text;
	}

	public void setText(TEXT text) {
		this.text = text;
	}

	public IMAGE getImage() {
		return image;
	}

	public void setImage(IMAGE image) {
		this.image = image;
	}

	public VOICE getVoice() {
		return voice;
	}

	public void setVoice(VOICE voice) {
		this.voice = voice;
	}

	public VIDEO getVideo() {
		return video;
	}

	public void setVideo(VIDEO video) {
		this.video = video;
	}

	public MUSIC getMusic() {
		return music;
	}

	public void setMusic(MUSIC music) {
		this.music = music;
	}

	public WXCARD getWxcard() {
		return wxcard;
	}

	public void setWxcard(WXCARD wxcard) {
		this.wxcard = wxcard;
	}

	public NEWS getNews() {
		return news;
	}

	public void setNews(NEWS news) {
		this.news = news;
	}

	public MPNEWS getMpnews() {
		return mpnews;
	}

	public void setMpnews(MPNEWS mpnews) {
		this.mpnews = mpnews;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
