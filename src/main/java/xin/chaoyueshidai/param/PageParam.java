package xin.chaoyueshidai.param;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSON;

/**
 * 分页查询参数
 * 
 * @author weizidong
 *
 */
@SuppressWarnings("serial")
public class PageParam implements Serializable {
	private Integer page; // 当前页
	private Integer pageSize;// 每页条数
	private String[] sort;// 排序字段
	private String[] order; // 排序顺序
	private String filed;// 筛选字段
	private Object keyWord;// 筛选关键词
	private Date start; // 开始时间
	private Date end; // 结束时间

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

	public String[] getSort() {
		return sort;
	}

	public void setSort(String[] sort) {
		this.sort = sort;
	}

	public String[] getOrder() {
		return order;
	}

	public void setOrder(String[] order) {
		this.order = order;
	}

	public String getFiled() {
		return filed;
	}

	public void setFiled(String filed) {
		this.filed = filed;
	}

	public Object getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(Object keyWord) {
		this.keyWord = keyWord;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
