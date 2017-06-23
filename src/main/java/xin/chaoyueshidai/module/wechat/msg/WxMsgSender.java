package xin.chaoyueshidai.module.wechat.msg;

import java.text.MessageFormat;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

import xin.chaoyueshidai.module.wechat.Token;
import xin.chaoyueshidai.module.wechat.base.FwAPI;
import xin.chaoyueshidai.utils.Configs;
import xin.chaoyueshidai.utils.HttpClientUtil;
import xin.chaoyueshidai.utils.ThreadPoolUtils;

/**
 * 发送消息到微信
 * 
 * @author WeiZiDong
 *
 */
public class WxMsgSender {
	private static final Logger log = LogManager.getLogger(WxMsgSender.class);

	/**
	 * 发送消息
	 */
	private static void send(WxMsg msg) {
		ThreadPoolUtils.execute(() -> {
			log.debug("发送消息:" + msg);
			Token token = Token.get(FwAPI.TOKEN, Configs.Appid, Configs.Secret);
			String uri = MessageFormat.format(FwAPI.SEND_CUSTOM, token.getAccess_token());
			String result = HttpClientUtil.doPostJson(uri, msg, String.class);
			JSONObject nodes = JSONObject.parseObject(result);
			if (nodes.containsKey("errcode") && nodes.getInteger("errcode") > 0) {
				log.error(result);
				throw new RuntimeException("<" + nodes.getInteger("errcode") + ">" + nodes.getString("errmsg"));
			}
		});
	}

	/**
	 * 批量推送到服务号
	 */
	public static void batchSendToFw(List<String> openids, WxMsg msg) {
		if (openids == null || openids.size() <= 0) {
			return;
		}
		openids.forEach((openid) -> {
			msg.setTouser(openid);
			send(msg);
		});
	}
}
