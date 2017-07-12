package xin.chaoyueshidai.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * UrlFilter
 * 
 * @author WeiZiDong
 *
 */
public class UrlFilter implements Filter {
	private static final Logger log = LogManager.getLogger(UrlFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		// 请求
		String requestUrl = httpRequest.getRequestURI().substring(1);
		// 加载静态文件
		log.debug("加载静态页面：" + requestUrl);
		request.getRequestDispatcher("/index.html?v=" + System.currentTimeMillis()).forward(request, response);
		return;
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
