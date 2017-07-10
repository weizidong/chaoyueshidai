package xin.chaoyueshidai.module.user;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xin.chaoyueshidai.dto.PageInfo;
import xin.chaoyueshidai.param.PageParam;

// 用户业务
@Service
public class UserService {
	@Resource
	private UserMapper mapper;

	// 登录
	public User login(String username, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	// 修改密码
	public void changePwd(Integer id, String old, String pwd) {
		// TODO Auto-generated method stub

	}

	// 查询列表
	public PageInfo find(PageParam param) {
		// TODO Auto-generated method stub
		return null;
	}

	// 根据Id获取
	public User getById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	// 重置密码
	public void reset(Integer id) {
		// TODO Auto-generated method stub

	}

	// 修改权限
	public void changeType(Integer id, Integer type) {
		// TODO Auto-generated method stub

	}

	// 根据openId查找
	public User getByOpenId(String openId) {
		UserExample e = new UserExample();
		e.createCriteria().andOpenidEqualTo(openId);
		List<User> list = mapper.selectByExample(e);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// 保存
	public void save(User u) {
		u.setCreated(new Date());
		mapper.insertSelective(u);
	}

	// 更新
	public void update(User u) {
		mapper.updateByPrimaryKeySelective(u);
	}
}
