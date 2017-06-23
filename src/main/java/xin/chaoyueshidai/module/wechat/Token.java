package xin.chaoyueshidai.module.wechat;

import java.text.MessageFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSON;

import xin.chaoyueshidai.module.wechat.base.BaseResp;
import xin.chaoyueshidai.utils.EhcacheUtil;
import xin.chaoyueshidai.utils.HttpClientUtil;

/**
 * 获取AccessToken
 * 
 * @author WeiZiDong
 *
 */
@SuppressWarnings("serial")
public class Token extends BaseResp {
	private static final Logger log = LogManager.getLogger(Token.class);
	// 网页授权接口调用凭证
	private String access_token;
	// access_token接口调用凭证超时时间，单位（秒）
	private Long expires_in;
	// 获取令牌时间
	private Long timestamp;
	// 用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
	private String openid;
	// 用户刷新access_token
	private String refresh_token;
	// 用户授权的作用域，使用逗号（,）分隔
	private String scope;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public Long getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	public static Token get(String path, String appid, String secrect) {
		Token token = (Token) EhcacheUtil.getInstance().get(EhcacheUtil.TOKEN, appid + secrect);
		log.debug("缓存中的Token：" + token);
		if (token != null && System.currentTimeMillis() - token.getTimestamp() < token.getExpires_in() * 1000) {
			return token;
		}
		Long ts = System.currentTimeMillis();
		token = HttpClientUtil.doGet(MessageFormat.format(path, appid, secrect), Token.class);
		if (token.getAccess_token() == null) {
			log.error("获取Token错误：<" + token.getErrcode() + ">" + token.getErrmsg());
			throw new RuntimeException("<" + token.getErrcode() + ">" + token.getErrmsg());
		}
		log.debug("微信获取的Token：" + token);
		token.setTimestamp(ts);
		EhcacheUtil.getInstance().put(EhcacheUtil.TOKEN, secrect, token);
		return token;
	}
}
