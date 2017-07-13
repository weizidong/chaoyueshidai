package xin.chaoyueshidai.dto;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * 分页列表数据返回
 * 
 * @author weizidong
 *
 */
@SuppressWarnings("serial")
public class PageInfo<T> implements Serializable {
	private Integer all;// 总记录
	private Integer page;// 当前页数
	private Integer pageSize;// 每页记录数
	private Integer start;// 开始记录
	private Integer end;// 结束记录
	private List<T> list;// 数据

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Integer getAll() {
		return all;
	}

	public void setAll(Integer all) {
		this.all = all;
		if (Math.ceil(all * 1.0 / this.pageSize) < this.page) {
			this.page = (int) Math.ceil(all / this.pageSize);
		}
		this.start = this.page == 0 ? 0 : (this.page - 1) * this.pageSize;
		this.end = this.page == 0 ? this.pageSize : this.page * this.pageSize;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page != null && page > 0 ? page : 1;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
