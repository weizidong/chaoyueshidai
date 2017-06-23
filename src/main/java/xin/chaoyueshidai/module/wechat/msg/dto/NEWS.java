package xin.chaoyueshidai.module.wechat.msg.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * news消息体
 * 
 * @author WeiZiDong
 *
 */
@SuppressWarnings("serial")
public class NEWS implements Serializable {
	private List<ARTICLE> articles;

	public NEWS() {
		super();
	}

	public NEWS(List<ARTICLE> articles) {
		this.articles = articles;
	}

	public NEWS(ARTICLE article) {
		this.articles = Arrays.asList(article);
	}

	public List<ARTICLE> getArticles() {
		return articles;
	}

	public void setArticles(List<ARTICLE> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
