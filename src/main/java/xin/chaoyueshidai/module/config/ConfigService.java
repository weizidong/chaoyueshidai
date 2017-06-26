package xin.chaoyueshidai.module.config;

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

}
