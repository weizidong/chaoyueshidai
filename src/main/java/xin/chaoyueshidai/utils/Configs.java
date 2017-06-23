package xin.chaoyueshidai.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 加载系统配置
 * 
 * @author WeiZiDong
 *
 */
public class Configs {
	private static final Logger log = LogManager.getLogger(Configs.class);
	// 配置路径
	private static String PROPERTIES = "system.properties";
	// 所有配置
	private static PropertiesUtil prop = null;
	/**
	 * 版本号
	 */
	public static String version = "1.0.0";
	/**
	 * 本机域名
	 */
	public static String hostname = "127.0.0.1";
	/**
	 * 服务号原始ID
	 */
	public static String wechat_Id = "";
	/**
	 * 服务号唯一凭证
	 */
	public static String Appid = "";
	/**
	 * 服务号唯一凭证密钥
	 */
	public static String Secret = "";
	/**
	 * 服务号EncodingAESKey用于消息体的加密，是AES密钥的Base64编码。
	 */
	public static String EncodingAESKey = "";
	/**
	 * 服务号Token可由企业任意填写，用于生成签名。
	 */
	public static String Token = "";

	static {
		prop = new PropertiesUtil(PROPERTIES);
		version = prop.getProperty("version");
		hostname = prop.getProperty("hostname");
		wechat_Id = prop.getProperty("wechat_Id");
		Appid = prop.getProperty("Appid");
		Secret = prop.getProperty("Secret");
		EncodingAESKey = prop.getProperty("EncodingAESKey");
		Token = prop.getProperty("Token");
		log.info("启动成功！版本：" + version);
	}

	/**
	 * 获取相关配置
	 */
	public static String get(String key) {
		return prop.getProperty(key);
	}

	/**
	 * 设置相关配置
	 */
	public static void set(String key, String value) {
		prop.writeProperties(key, value);
	}

}
