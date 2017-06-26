package xin.chaoyueshidai.module.config;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	// 初始化配置
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String login(HttpSession session, Model model) {
		Config c = (Config) session.getAttribute("config");
		if (c == null) {
			return "";
		}
		return "";
	}

	// 获取我的配置
	@RequestMapping(value = "/mine", method = RequestMethod.GET)
	public @ResponseBody Config mine(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null && user.getId() != null) {
			return configService.get(user.getId());
		}
		return null;
	}
}
