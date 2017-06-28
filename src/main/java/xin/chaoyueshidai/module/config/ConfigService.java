package xin.chaoyueshidai.module.config;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

// 配置业务
@Service
public class ConfigService {
	@Resource
	private ConfigMapper mapper;

	/**
	 * 获取指定用户属性
	 */
	public Config get(Integer userid) {
		Config c = mapper.selectByPrimaryKey(userid);
		return c;
	}

	/**
	 * 保存配置
	 */
	public void save(Integer userid, String value) {
		Config c = mapper.selectByPrimaryKey(userid);
		if (c == null) {
			c = new Config();
			c.setUserid(userid);
			c.setValue(value);
			c.setTime(new Date());
			mapper.insertSelective(c);
		} else {
			c.setLastValue(c.getValue());
			c.setValue(value);
			c.setTime(new Date());
			mapper.updateByPrimaryKeySelective(c);
		}
	}

}
