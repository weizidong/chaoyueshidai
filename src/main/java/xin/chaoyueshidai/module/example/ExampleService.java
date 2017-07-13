package xin.chaoyueshidai.module.example;

import java.util.Date;
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
	public PageInfo<Example> find(Integer userid, String type, PageParam param) {
		ExampleExample e = new ExampleExample();
		Criteria c = e.createCriteria();
		c.andUseridEqualTo(userid);
		c.andTypeEqualTo(type);
		if ("title".equals(param.getFiled())) {
			c.andTitleLike("%" + param.getKeyWord().toString() + "%");
		}
		e.setOrderByClause("id ASC");
		PageInfo<Example> info = new PageInfo<Example>();
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

	/**
	 * 根据Id获取
	 */
	public Example get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	/**
	 * 保存
	 */
	public void save(Integer userid, String type, Example e) {
		e.setUserid(userid);
		e.setType(type);
		e.setCreated(new Date());
		mapper.insertSelective(e);
	}

	/**
	 * 删除
	 */
	public void delete(Integer id) {
		mapper.deleteByPrimaryKey(id);
	}

	/**
	 * 修改
	 */
	public void update(Example e) {
		mapper.updateByPrimaryKeyWithBLOBs(e);
	}

}
