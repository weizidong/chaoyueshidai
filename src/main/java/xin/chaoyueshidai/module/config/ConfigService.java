package xin.chaoyueshidai.module.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

// 配置业务
@Service
public class ConfigService {
	@Resource
	private ConfigMapper mapper;

	/**
	 * 获取指定属性
	 */
	public String get(String filed) {
		Config c = mapper.selectByPrimaryKey(filed);
		return c != null ? c.getValue() : null;
	}

	/**
	 * 获取所有属性
	 */
	public Map<String, String> getAll() {
		ConfigExample e = new ConfigExample();
		e.setOrderByClause("filed");
		List<Config> list = mapper.selectByExample(e);
		Map<String, String> result = new HashMap<>();
		list.forEach((config) -> result.put(config.getFiled(), config.getValue()));
		return result;
	}
}
