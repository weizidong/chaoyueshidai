package xin.chaoyueshidai.utils;

import java.util.UUID;

/**
 * 获取UUID工具类
 * 
 * @author WeiZiDong
 *
 */
public class UUIDUtil {
	/**
	 * 获取UUID
	 * 
	 * @return
	 */
	public static String get() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}

}
