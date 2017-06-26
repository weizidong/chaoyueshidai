package xin.chaoyueshidai.module.example;

import java.util.Date;

import com.alibaba.fastjson.JSON;

// 案例
public class Example {
	private Integer id;
	// 标题
	private String topic;
	// 案例网址
	private String url;
	// 配图
	private String pic;
	// 时间
	private Date created;
	// 说明
	private String legend;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic == null ? null : topic.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic == null ? null : pic.trim();
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getLegend() {
		return legend;
	}

	public void setLegend(String legend) {
		this.legend = legend == null ? null : legend.trim();
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}