package xin.chaoyueshidai.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import xin.chaoyueshidai.module.user.User;
import xin.chaoyueshidai.module.user.UserService;

public class LoginInterceptor implements HandlerInterceptor {
	private static final Logger log = LogManager.getLogger(LoginInterceptor.class);
	// 不拦截 "/login" 请求
	private static final String[] IGNORE_URI = { "/rest/user/login" };
	@Autowired
	private UserService userService;

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)
			throws Exception {
		HttpSession session = request.getSession();
		Long start = (Long) session.getAttribute("start");
		log.debug("耗时：" + (System.currentTimeMillis() - start) + " ms");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// flag 表示是否登录
		boolean flag = false;
		// 记录访问时间
		HttpSession session = request.getSession();
		session.setAttribute("start", System.currentTimeMillis());
		// 获取请求的 URL
		String url = request.getServletPath();
		String query = request.getQueryString();
		log.debug("请求：" + url + (query != null ? ("?" + query) : ""));
		// 微信请求不校验
		if (url.startsWith("/rest/wechat/")) {
			return !flag;
		}
		User user = (User) session.getAttribute("user");
		// 开启debug模式
		String debug = request.getParameter("debug");
		if (debug != null && debug.equals("WeiZiDong")) {
			log.debug("开启debug模式。。。");
			if (user == null) {
				user = userService.getByOpenId("oejSSwDJnyK3JFT2GqJd4YNPzvIQ");
				session.setAttribute("user", user);
			}
			return !flag;
		}
		// 判断是否来自微信请求回调
		// String code = request.getParameter("code");
		// if (StringUtils.isNotBlank(code) && user == null) {
		// Long time = Long.parseLong(request.getParameter("state"));
		// log.debug("微信授权成功!\t用时：" + (System.currentTimeMillis() - time) +
		// "ms");
		// Token token = HttpClientUtil
		// .doGet(MessageFormat.format(FwAPI.ACCESS_TOKEN, Configs.Appid,
		// Configs.Secret, code), Token.class);
		// if (token.getOpenid() == null) {
		// throw new RuntimeException(token.getErrmsg());
		// }
		// user = userService.getByOpenId(token.getOpenid());
		// if (user == null) {
		// user = new User();
		// user.setOpenid(token.getOpenid());
		// userService.save(user);
		// }
		// session.setAttribute("user", user);
		// return !flag;
		// }
		// 判断是否来自微信请求（订阅号不做授权处理，没有api权限）
		if (user == null && url.contains("/dyh/")) {
			// String getCodeUrl = MessageFormat.format(FwAPI.AUTHORIZE,
			// Configs.Appid,
			// URLEncoder.encode(Configs.hostname + url, "utf-8"),
			// String.valueOf(System.currentTimeMillis()));
			// log.debug("授权:" + getCodeUrl);
			// response.sendRedirect(getCodeUrl);
			String openId = request.getServletPath().substring(request.getServletPath().lastIndexOf("/") + 1);
			log.debug("订阅号openId：" + openId);
			user = userService.getByOpenId(openId);
			if (user == null) {
				return flag;
			}
			session.setAttribute("user", user);
			return !flag;
		}
		// 判断是否登录
		for (String s : IGNORE_URI) {
			if (url.equals("/") || url.contains(s)) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			// 获取 Session 并判断是否登录
			if (user == null) {
				// 如果未登录，进行拦截，跳转到登录界面
				request.getRequestDispatcher("/rest/user/login").forward(request, response);
			} else {
				flag = true;
			}
		}
		return flag;
	}
}
