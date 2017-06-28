package xin.chaoyueshidai.module.config;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xin.chaoyueshidai.module.user.User;

// 配置请求
@Controller
@RequestMapping("/rest/config")
public class ConfigController {
	@Resource
	private ConfigService configService;

	// 保存配置
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public void save(@RequestBody Config c, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null && user.getId() != null) {
			configService.save(user.getId(), c.getValue());
		}
	}

	// 获取我的配置
	@RequestMapping(value = "/mine")
	@ResponseBody
	public Config mine(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null && user.getId() != null) {
			return configService.get(user.getId());
		}
		return null;
	}
}
