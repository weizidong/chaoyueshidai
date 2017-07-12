package xin.chaoyueshidai.module.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import xin.chaoyueshidai.dto.RestResponse;
import xin.chaoyueshidai.dto.WebException;

// 用户请求
@Controller
@RequestMapping("/rest/user")
public class UserController {
	private static final Logger log = LogManager.getLogger(UserController.class);
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
	public User mine(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			throw WebException.error("用户未登录！");
		}
		user = userService.getById(user.getId());
		session.setAttribute("user", user);
		return user;
	}

	// 登录
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse login(@RequestBody String data, HttpSession session) {
		User user = JSON.parseObject(data, User.class);
		log.debug("参数：" + user);
		RestResponse res = userService.login(user.getTel(), user.getPwd());
		session.setAttribute("user", res.getData());
		return res;
	}

	// 注册
	@RequestMapping("/register")
	@ResponseBody
	public void register(@BeanParam User u, HttpSession session) {
		userService.save(u);
	}

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

}
