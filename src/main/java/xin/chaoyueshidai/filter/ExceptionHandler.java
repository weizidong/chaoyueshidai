package xin.chaoyueshidai.filter;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import xin.chaoyueshidai.dto.WebException;

/**
 * 全局异常处理类.对后台直接抛往前台页面的异常进行封装处理.
 * 
 * @author WeiZhiDong
 *
 */
public class ExceptionHandler extends SimpleMappingExceptionResolver {
	private static final Logger log = LogManager.getLogger(ExceptionHandler.class);

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView modelAndView = super.doResolveException(request, response, handler, ex);
		try {
			log.error("参数：" + StreamUtils.copyToString(request.getInputStream(), Charset.defaultCharset()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		WebException e = null;
		if (ex instanceof WebException) {
			e = (WebException) ex;
		} else {
			e = WebException.error(ex.getMessage());
		}
		log.error("异常：" + e.getMsg());
		ex.printStackTrace();
		if (modelAndView == null) {
			modelAndView = new ModelAndView("common/500");
			modelAndView.addObject("msg", e.getMsg());
		}
		return modelAndView;
	}
}
