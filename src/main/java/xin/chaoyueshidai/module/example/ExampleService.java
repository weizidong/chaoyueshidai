package xin.chaoyueshidai.module.example;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xin.chaoyueshidai.dto.PageInfo;
import xin.chaoyueshidai.module.example.ExampleExample.Criteria;
import xin.chaoyueshidai.param.PageParam;

// 项目案例业务
@Service
public class ExampleService {
	@Resource
	private ExampleMapper mapper;

	/**
	 * 获取列表
	 */
	public PageInfo find(Integer userid, String type, PageParam param) {
		ExampleExample e = new ExampleExample();
		Criteria c = e.createCriteria();
		c.andUseridEqualTo(userid);
		c.andTypeEqualTo(type);
		if ("topic".equals(param.getFiled())) {
			c.andTopicLike(param.getKeyWord().toString());
		}
		e.setOrderByClause("id ASC");
		PageInfo info = new PageInfo();
		if (param.getPageSize() != null && param.getPageSize() > 0) {
			int all = mapper.countByExample(e);
			info.setPageSize(param.getPageSize());
			info.setPage(param.getPage());
			info.setAll(all);
			e.setOrderByClause("id ASC limit " + info.getStart() + "," + info.getEnd());
		}
		List<Example> list = mapper.selectByExample(e);
		info.setList(list);
		return info;
	}

}
