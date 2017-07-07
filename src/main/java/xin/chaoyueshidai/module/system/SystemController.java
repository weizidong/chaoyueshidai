package xin.chaoyueshidai.module.system;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 用户请求
@Controller
public class SystemController {
	@Resource
	private SystemService systemService;

	// 获取当前登录
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "/";
	}

}
