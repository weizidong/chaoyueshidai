package xin.chaoyueshidai.module.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xin.chaoyueshidai.dto.PageInfo;
import xin.chaoyueshidai.dto.WebException;
import xin.chaoyueshidai.param.PageParam;

// 用户请求
@Controller
@RequestMapping("/rest/user")
public class UserController {
	@Resource
	private UserService userService;

	// 登录
	@RequestMapping("/login")
	public @ResponseBody Object login(@BeanParam User u, HttpSession session) {
		try {
			User user = userService.login(u.getUsername(), u.getPwd());
			user.setPwd(null);
			session.setAttribute("user", user);
			return user;
		} catch (WebException e) {
			return e;
		}
	}

	// 修改密码
	@RequestMapping("/changePwd")
	public @ResponseBody WebException changePwd(@FormParam("pwd") String pwd, @FormParam("old") String old,
			HttpSession session) {
		try {
			User u = (User) session.getAttribute("user");
			userService.changePwd(u.getId(), old, pwd);
			session.removeAttribute("user");
			return WebException.success("密码修改成功，请重新登录！");
		} catch (WebException e) {
			return e;
		}
	}

	// 列表
	@RequestMapping("/list")
	public @ResponseBody PageInfo list(@BeanParam PageParam param) {
		PageInfo info = userService.find(param);
		return info;
	}

	// 根据id获取
	@RequestMapping("/get/{id}")
	public @ResponseBody User get(@PathVariable Integer id) {
		User user = userService.getById(id);
		return user;
	}

	// 重置密码
	@RequestMapping("/reset/{id}")
	public void reset(@PathVariable Integer id) {
		userService.reset(id);
	}

	// 修改权限
	@RequestMapping("/changeType/{id}/{type}")
	public void changeType(@PathVariable Integer id, @PathVariable Integer type) {
		userService.changeType(id, type);
	}
}
