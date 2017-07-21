package xin.chaoyueshidai.module.system;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// 用户请求
@Controller
public class SystemController {
	@Resource
	private SystemService systemService;

	// 获取操作说明
	@RequestMapping("/rest/info/{openid}")
	public String info(@PathVariable String openid, Model model) {
		model.addAttribute("openid", openid);
		return "system/info";
	}

	// 获取操作说明
	@RequestMapping("/404")
	public String error404(Model model) {
		return "common/404";
	}

	// 获取操作说明
	@RequestMapping("/500")
	public String error500(Model model) {
		model.addAttribute("msg", "错误消息！500...");
		return "common/500";
	}

}
