package xin.chaoyueshidai.module.config;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

// 配置业务
@Service
public class ConfigService {
	@Resource
	private ConfigMapper mapper;
}
