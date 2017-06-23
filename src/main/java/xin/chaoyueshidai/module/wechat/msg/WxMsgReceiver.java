package xin.chaoyueshidai.module.wechat.msg;

import org.springframework.stereotype.Component;

import xin.chaoyueshidai.module.wechat.base.XmlResp;
import xin.chaoyueshidai.param.WechatMsg;

/**
 * 微信推送消息处理
 * 
 * @author WeiZiDong
 *
 */
@Component
public class WxMsgReceiver {

	/**
	 * 处理文本消息
	 */
	public String text(WechatMsg msg) {
		// TODO 处理文本消息
		return XmlResp.SUCCESS;
	}

	/**
	 * 处理图片消息
	 */
	public String img(WechatMsg msg) {
		// TODO 图片消息处理
		return XmlResp.SUCCESS;
	}

	/**
	 * 语音消息处理
	 */
	public String voice(WechatMsg msg) {
		// TODO 语音消息处理
		return XmlResp.SUCCESS;
	}

	/**
	 * 视频消息处理
	 */
	public String video(WechatMsg msg) {
		// TODO 视频消息处理
		return XmlResp.SUCCESS;
	}

	/**
	 * 小视频消息处理
	 */
	public String shortvideo(WechatMsg msg) {
		// TODO 小视频消息处理
		return XmlResp.SUCCESS;
	}

	/**
	 * 地理位置消息处理
	 */
	public String location(WechatMsg msg) {
		// TODO 地理位置消息处理
		return XmlResp.SUCCESS;
	}

	/**
	 * 链接消息处理
	 */
	public String link(WechatMsg msg) {
		// TODO 链接消息处理
		return XmlResp.SUCCESS;
	}
}
