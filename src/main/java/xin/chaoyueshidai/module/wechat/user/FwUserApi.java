package xin.chaoyueshidai.module.wechat.user;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import xin.chaoyueshidai.module.user.User;
import xin.chaoyueshidai.module.wechat.Token;
import xin.chaoyueshidai.module.wechat.base.BaseResp;
import xin.chaoyueshidai.module.wechat.base.FwAPI;
import xin.chaoyueshidai.utils.Configs;
import xin.chaoyueshidai.utils.HttpClientUtil;

/**
 * 微信服务号用户API
 * 
 * @author WeiZiDong
 *
 */
public class FwUserApi {
	// 获取AccessToken
	private static String getAccessToken() {
		Token t = Token.get(FwAPI.TOKEN, Configs.Appid, Configs.Secret);
		if (t == null) {
			throw new RuntimeException("AccessToken获取失败!");
		}
		return t.getAccess_token();
	}

	/**
	 * 获取用户详情
	 */
	public static User get(String openid) {
		String path = MessageFormat.format(FwAPI.USER_INFO, getAccessToken(), openid);
		User resp = HttpClientUtil.doGet(path, User.class);
		if (resp.getErrcode() != null) {
			throw new RuntimeException("<" + resp.getErrcode() + ">" + resp.getErrmsg());
		}
		return resp;
	}

	/**
	 * 获取用户(根据临时授权码拉取用户信息)
	 */
	public static User get(String access_token, String openid) {
		String path = MessageFormat.format(FwAPI.USERINFO, access_token, openid);
		User resp = HttpClientUtil.doGet(path, User.class);
		if (resp.getErrcode() != null) {
			throw new RuntimeException("<" + resp.getErrcode() + ">" + resp.getErrmsg());
		}
		return resp;
	}

	/**
	 * 获取用户列表(仅openId)
	 */
	public static FwUserList getList(String next_openid) {
		String path = MessageFormat.format(FwAPI.GET_USER, getAccessToken(), next_openid);
		FwUserList resp = HttpClientUtil.doGet(path, FwUserList.class);
		if (resp.getErrcode() != null) {
			throw new RuntimeException("<" + resp.getErrcode() + ">" + resp.getErrmsg());
		}
		return resp;
	}

	/**
	 * 批量获取用户信息
	 */
	public static List<User> batchGet(List<String> openids) {
		String path = MessageFormat.format(FwAPI.BATCHGET_INFO, getAccessToken());
		Map<String, List<Map<String, String>>> param = new HashMap<>();
		List<Map<String, String>> userList = openids.stream().map(openid -> {
			Map<String, String> user = new HashMap<>();
			user.put("openid", openid);
			user.put("lang", "zh-CN");
			return user;
		}).collect(Collectors.toList());
		param.put("user_list", userList);
		FwUserList resp = HttpClientUtil.doPostJson(path, param, FwUserList.class);
		if (resp.getErrcode() != null) {
			throw new RuntimeException("<" + resp.getErrcode() + ">" + resp.getErrmsg());
		}
		return resp.getUser_info_list();
	}

	/**
	 * 设置用户备注名
	 */
	public static void updateRemark(String openid, String remark) {
		String path = MessageFormat.format(FwAPI.UPDATEREMARK, getAccessToken());
		Map<String, String> param = new HashMap<>();
		param.put("openid", openid);
		param.put("remark", remark);
		BaseResp resp = HttpClientUtil.doPostJson(path, param, BaseResp.class);
		if (resp.getErrcode() != 0) {
			throw new RuntimeException("<" + resp.getErrcode() + ">" + resp.getErrmsg());
		}
	}
}
