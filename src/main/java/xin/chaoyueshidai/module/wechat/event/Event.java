package xin.chaoyueshidai.module.wechat.event;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xin.chaoyueshidai.enums.Subscribe;
import xin.chaoyueshidai.module.user.User;
import xin.chaoyueshidai.module.user.UserService;
import xin.chaoyueshidai.module.wechat.base.MsgType;
import xin.chaoyueshidai.module.wechat.base.XmlResp;
import xin.chaoyueshidai.module.wechat.msg.dto.ARTICLE;
import xin.chaoyueshidai.param.WechatMsg;
import xin.chaoyueshidai.utils.Configs;
import xin.chaoyueshidai.utils.ThreadPoolUtils;

/**
 * 微信事件消息处理
 * 
 * @author WeiZiDong
 *
 */
@Component
public class Event {
	@Autowired
	private UserService userService;

	/**
	 * 处理事件
	 */
	public String push(WechatMsg msg) {
		switch (msg.getEvent().toUpperCase()) {
		case MsgType.Event.SUBSCRIBE:
			return subscribe(msg);
		case MsgType.Event.UNSUBSCRIBE:
			return unsubscribe(msg);
		case MsgType.Event.SCAN:
			return scan(msg);
		case MsgType.Event.LOCATION:
			return location(msg);
		case MsgType.Event.CLICK:
			return click(msg);
		case MsgType.Event.VIEW:
			return view(msg);
		default:
			return XmlResp.SUCCESS;
		}
	}

	/**
	 * 点击菜单跳转链接时的事件推送
	 */
	private String view(WechatMsg msg) {
		// TODO 点击菜单跳转链接时的事件推送
		return XmlResp.SUCCESS;
	}

	/**
	 * 上报地理位置事件
	 */
	private String location(WechatMsg msg) {
		// TODO 上报地理位置事件
		return XmlResp.SUCCESS;
	}

	/**
	 * 扫描带参数二维码事件
	 */
	private String scan(WechatMsg msg) {
		// TODO 扫描带参数二维码事件
		return XmlResp.SUCCESS;
	}

	// 自定义菜单事件
	private String click(WechatMsg msg) {
		// TODO 自定义菜单事件
		return XmlResp.SUCCESS;
	}

	// 取消关注事件
	private String unsubscribe(WechatMsg msg) {
		ThreadPoolUtils.execute(() -> {
			User u = userService.getByOpenId(msg.getFromUserName());
			u.setSubscribe(Subscribe.未关注);
			userService.update(u);
		});
		return XmlResp.SUCCESS;
	}

	// 关注事件
	private String subscribe(WechatMsg msg) {
		User u = userService.getByOpenId(msg.getFromUserName());
		ARTICLE a1 = new ARTICLE("操作说明", "订阅号操作说明", Configs.hostname + "/rest/user/fwh/update",
				Configs.hostname + "/static/img/me.png");
		if (u == null) {
			u = new User();
			u.setOpenid(msg.getFromUserName());
			u.setSubscribe(Subscribe.已关注);
			u.setSubscribeTime(new Date());
			userService.save(u);
			ARTICLE a2 = new ARTICLE("完善资料", "亲爱的用户，欢迎你，请完善资料!以便提供后续的服务！", Configs.hostname + "/rest/user/fwh/update",
					Configs.hostname + "/static/img/me.png");
			return XmlResp.buildNews(msg.getFromUserName(), msg.getToUserName(), Arrays.asList(a1, a2));
		} else {
			u.setSubscribe(Subscribe.已关注);
			u.setSubscribeTime(new Date());
			userService.update(u);
			return XmlResp.buildNews(msg.getFromUserName(), msg.getToUserName(), Arrays.asList(a1));
		}
	}
}
