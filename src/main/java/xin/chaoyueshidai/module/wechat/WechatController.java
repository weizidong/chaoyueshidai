package xin.chaoyueshidai.module.wechat;

import javax.annotation.Resource;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xin.chaoyueshidai.param.WechatMsg;
import xin.chaoyueshidai.utils.AesException;
import xin.chaoyueshidai.utils.Configs;
import xin.chaoyueshidai.utils.WXBizMsgCrypt;
import xin.chaoyueshidai.utils.WeChatXmlUtil;

// 微信请求
@Controller
@RequestMapping("/rest/wechat")
public class WechatController {
	private static final Logger log = LogManager.getLogger(WechatController.class);
	@Resource
	private WechatService wechatService;

	/**
	 * 服务号回调过来的信息(明文传输)
	 */
	@RequestMapping(value = "/fw", method = RequestMethod.POST, consumes = MediaType.TEXT_XML, produces = MediaType.TEXT_XML)
	public String fwPush(String data) {
		log.debug("接收到微信推送的消息。。。");
		log.debug("参数：" + data);
		WechatMsg msg = WeChatXmlUtil.xmlToBean(data, WechatMsg.class);
		String rMsg = wechatService.push(msg);
		log.debug("结果：" + rMsg);
		return rMsg;
	}

	/**
	 * 验证回调URL
	 */
	@RequestMapping(value = "/fw", method = RequestMethod.GET, produces = MediaType.TEXT_XML)
	public String fwVerifyURL(@RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp,
			@RequestParam("nonce") String nonce, @RequestParam("echostr") String echostr) {
		log.debug("验证回调URL...");
		String sEchoStr = null;
		try {
			WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(Configs.Token, Configs.EncodingAESKey, Configs.Appid);
			sEchoStr = wxcpt.VerifyURL(signature, timestamp, nonce, echostr);
		} catch (AesException e) {
			e.printStackTrace();
		}
		log.debug("验证回调URL结果：" + sEchoStr);
		return sEchoStr;
	}
}
