package xin.chaoyueshidai.module.file;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xin.chaoyueshidai.dto.PageInfo;
import xin.chaoyueshidai.module.file.FilesExample.Criteria;
import xin.chaoyueshidai.param.PageParam;

// 项目案例业务
@Service
public class FileService {
	@Resource
	private FilesMapper mapper;

	/**
	 * 获取列表
	 */
	public PageInfo find(PageParam param) {
		FilesExample e = new FilesExample();
		Criteria c = e.createCriteria();
		if ("name".equals(param.getFiled())) {
			c.andNameLike(param.getKeyWord().toString());
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
		List<Files> list = mapper.selectByExample(e);
		info.setList(list);
		return info;
	}

	/**
	 * 根据Id获取
	 */
	public Files get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	/**
	 * 保存
	 */
	public void save(Files f) {
		f.setCreated(new Date());
		mapper.insertSelective(f);
	}

	/**
	 * 删除
	 */
	public void delete(Integer id) {
		mapper.deleteByPrimaryKey(id);
	}

}
