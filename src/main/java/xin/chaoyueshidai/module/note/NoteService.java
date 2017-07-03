package xin.chaoyueshidai.module.note;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xin.chaoyueshidai.dto.PageInfo;
import xin.chaoyueshidai.module.note.NoteExample.Criteria;
import xin.chaoyueshidai.param.PageParam;

// 项目案例业务
@Service
public class NoteService {
	@Resource
	private NoteMapper mapper;

	/**
	 * 获取列表
	 */
	public PageInfo find(Integer userid, String type, PageParam param) {
		NoteExample e = new NoteExample();
		Criteria c = e.createCriteria();
		c.andUseridEqualTo(userid);
		c.andTypeEqualTo(type);
		if ("title".equals(param.getFiled())) {
			c.andTitleLike(param.getKeyWord().toString());
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
		List<Note> list = mapper.selectByExample(e);
		info.setList(list);
		return info;
	}

	/**
	 * 根据Id获取
	 */
	public Note get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	/**
	 * 保存
	 */
	public void save(Integer userid, String type, Note e) {
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
	public void update(Note e) {
		mapper.updateByPrimaryKeySelective(e);
	}

}
