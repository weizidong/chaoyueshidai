package xin.chaoyueshidai.dto;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/**
 * 分页列表数据返回
 * 
 * @author weizidong
 *
 */
@SuppressWarnings("serial")
public class PageInfo implements Serializable {
	private Integer all;
	private Integer page;
	private Integer pageSize;
	private Object list;

	public Integer getAll() {
		return all;
	}

	public void setAll(Integer all) {
		this.all = all;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Object getList() {
		return list;
	}

	public void setList(Object list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
