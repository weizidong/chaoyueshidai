package xin.chaoyueshidai.module.wechat.msg;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import xin.chaoyueshidai.module.wechat.base.XmlResp;
import xin.chaoyueshidai.module.wechat.event.EventKey;
import xin.chaoyueshidai.module.wechat.msg.dto.ARTICLE;
import xin.chaoyueshidai.param.WechatMsg;
import xin.chaoyueshidai.utils.Configs;

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
		ARTICLE a = null;
		// TODO 文本消息回复
		if (StringUtils.equalsIgnoreCase(msg.getContent(), EventKey.RSS)) {
			a = new ARTICLE("RSS订阅", "公众号操作说明", Configs.hostname + "/rest/rss", Configs.hostname + "");
		} else if (StringUtils.equalsIgnoreCase(msg.getContent(), EventKey.NOTE)) {
			a = new ARTICLE("笔记记录", "公众号操作说明", Configs.hostname + "", Configs.hostname + "");
		} else if (StringUtils.equalsIgnoreCase(msg.getContent(), EventKey.ME)) {
			a = new ARTICLE("我的信息", "公众号操作说明", Configs.hostname + "", Configs.hostname + "");
		}
		if (a != null) {
			return XmlResp.buildNews(msg.getFromUserName(), msg.getToUserName(), Arrays.asList(a));
		}
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
