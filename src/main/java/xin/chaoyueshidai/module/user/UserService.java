package xin.chaoyueshidai.module.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xin.chaoyueshidai.dto.PageInfo;
import xin.chaoyueshidai.dto.WebException;
import xin.chaoyueshidai.param.PageParam;

// 用户业务
@Service
public class UserService {
	@Resource
	private UserMapper mapper;

	// 登录
	public User login(String username, String pwd) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	// 修改密码
	public void changePwd(Integer id, String old, String pwd) throws WebException {
		// TODO Auto-generated method stub

	}

	// 查询列表
	public PageInfo find(PageParam param) {
		// TODO Auto-generated method stub
		return null;
	}

	// 根据Id获取
	public User getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	// 重置密码
	public void reset(Integer id) {
		// TODO Auto-generated method stub

	}

	// 修改权限
	public void changeType(Integer id, Integer type) {
		// TODO Auto-generated method stub

	}
}
