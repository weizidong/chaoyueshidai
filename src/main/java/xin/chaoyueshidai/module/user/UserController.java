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

	// 修改我的资料
	@RequestMapping("/dyh/update/{openId}")
	public String updateDyh(HttpSession session) {
		return "user/update";
	}

	// 获取当前登录
	@RequestMapping("/mine")
	@ResponseBody
	public Object mine(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return WebException.error("用户未登录！");
		}
		user = userService.getById(user.getId());
		session.setAttribute("user", user);
		return user;
	}

	// // 登录
	// @RequestMapping("/login")
	// @ResponseBody
	// public Object login(@BeanParam User u, HttpSession session) {
	// User user = userService.login(u.getUsername(), u.getPwd());
	// user.setPwd(null);
	// session.setAttribute("user", user);
	// return user;
	// }
	//
	// // 登录二维码
	// @RequestMapping("/login_qrcode")
	// @ResponseBody
	// public Object login() {
	// User user = userService.login(u.getUsername(), u.getPwd());
	// user.setPwd(null);
	// session.setAttribute("user", user);
	// return user;
	// }

	// 登出
	@RequestMapping("/logout")
	@ResponseBody
	public void logout(HttpSession session) {
		session.removeAttribute("user");
	}

	// 修改密码
	@RequestMapping("/changePwd")
	@ResponseBody
	public WebException changePwd(@FormParam("pwd") String pwd, @FormParam("old") String old, HttpSession session) {
		User u = (User) session.getAttribute("user");
		userService.changePwd(u.getId(), old, pwd);
		session.removeAttribute("user");
		return WebException.success("密码修改成功，请重新登录！");
	}

	// 列表
	@RequestMapping("/list")
	@ResponseBody
	public PageInfo list(@BeanParam PageParam param) {
		PageInfo info = userService.find(param);
		return info;
	}

	// 根据id获取
	@RequestMapping("/get/{id}")
	@ResponseBody
	public User get(@PathVariable Integer id) {
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
