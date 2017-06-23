package xin.chaoyueshidai.module.wechat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.chaoyueshidai.module.wechat.base.MsgType;
import xin.chaoyueshidai.module.wechat.base.XmlResp;
import xin.chaoyueshidai.module.wechat.event.Event;
import xin.chaoyueshidai.module.wechat.msg.WxMsgReceiver;
import xin.chaoyueshidai.param.WechatMsg;

// 微信业务
@Service
public class WechatService {
	@Autowired
	private WxMsgReceiver receiver;
	@Autowired
	private Event event;

	// 微信推送的消息分发
	public String push(WechatMsg msg) {
		switch (msg.getMsgType().toLowerCase()) {
		case MsgType.TEXT:
			return receiver.text(msg);
		case MsgType.IMAGE:
			return receiver.img(msg);
		case MsgType.VOICE:
			return receiver.voice(msg);
		case MsgType.VIDEO:
			return receiver.video(msg);
		case MsgType.SHORTVIDEO:
			return receiver.shortvideo(msg);
		case MsgType.LOCATION:
			return receiver.location(msg);
		case MsgType.LINK:
			return receiver.link(msg);
		case MsgType.EVENT:
			return event.push(msg);
		default:
			return XmlResp.SUCCESS;
		}
	}

}
