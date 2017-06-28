package xin.chaoyueshidai.module.example;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xin.chaoyueshidai.dto.PageInfo;
import xin.chaoyueshidai.module.user.User;
import xin.chaoyueshidai.param.PageParam;

// 项目案例请求
@Controller
@RequestMapping("/rest/example")
public class ExampleController {
	@Resource
	private ExampleService exampleService;

	// 获取列表
	@RequestMapping(value = "/find/{type}", method = RequestMethod.POST)
	@ResponseBody
	public PageInfo save(@RequestBody PageParam param, @PathVariable String type, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null && user.getId() != null) {
			return exampleService.find(user.getId(), type, param);
		}
		return null;
	}
}
