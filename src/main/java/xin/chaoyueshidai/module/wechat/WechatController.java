package xin.chaoyueshidai.module.wechat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import xin.chaoyueshidai.param.WechatMsg;
import xin.chaoyueshidai.utils.Configs;
import xin.chaoyueshidai.utils.SignatureUtil;
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
	@RequestMapping(value = "/fw", method = RequestMethod.POST)
	public void fwPush(@RequestBody String data, HttpServletResponse response) throws IOException {
		log.debug("接收到服务号推送的消息。。。");
		log.debug("参数：\n" + data);
		WechatMsg msg = WeChatXmlUtil.xmlToBean(data, WechatMsg.class);
		String rMsg = wechatService.push(msg);
		log.debug("结果：\n" + rMsg);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(rMsg);
		out.flush();
		out.close();
	}

	/**
	 * 验证回调URL
	 */
	@RequestMapping(value = "/fw", method = RequestMethod.GET)
	@ResponseBody
	public String fwVerifyURL(@RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp,
			@RequestParam("nonce") String nonce, @RequestParam("echostr") String echostr) {
		Boolean check = SignatureUtil.checkSignature(Configs.Token, signature, timestamp, nonce);
		log.debug("验证回调URL：" + check);
		if (check) {
			return echostr;
		}
		return null;
	}
}
