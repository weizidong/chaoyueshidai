package xin.chaoyueshidai.module.note;

import java.util.Date;

import com.alibaba.fastjson.JSON;

// 笔记
public class Note {
	private Integer id;
	// 题目
	private String title;
	// 内容
	private Date created;
	// 创建时间
	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}