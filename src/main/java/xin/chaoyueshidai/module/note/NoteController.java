package xin.chaoyueshidai.module.note;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xin.chaoyueshidai.dto.PageInfo;
import xin.chaoyueshidai.module.user.User;
import xin.chaoyueshidai.module.user.UserService;
import xin.chaoyueshidai.param.PageParam;

// 项目案例请求
@Controller
@RequestMapping("/rest/note")
public class NoteController {
	private static final Logger log = LogManager.getLogger(NoteController.class);
	@Resource
	private NoteService noteService;
	@Resource
	private UserService userService;

	// 获取列表
	@RequestMapping(value = "/find/{type}/{userid}", method = RequestMethod.POST)
	@ResponseBody
	public PageInfo<Note> find(@RequestBody PageParam param, @PathVariable String type, @PathVariable Integer userid,
			HttpSession session) {
		log.debug("参数：" + param + ",type=" + type + ",userid=" + userid);
		if (userid == -1) {
			User user = (User) session.getAttribute("user");
			userid = user.getId();
		}
		PageInfo<Note> info = noteService.find(userid, type, param);
		if (info.getList().size() > 0) {
			List<User> userList = userService
					.findList(info.getList().stream().map(Note::getUserid).collect(Collectors.toList()));
			info.getList().forEach((n) -> {
				List<User> users = userList.stream().filter((u) -> u.getId() == n.getUserid())
						.collect(Collectors.toList());
				if (users != null && users.size() > 0) {
					User u = users.get(0);
					n.setUserName(u.getName() == null ? u.getNickName() : u.getName());
					n.setAvatarUrl(u.getAvatarUrl());
				}
			});
		}
		return info;
	}

	// 根据id获取
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Note get(@PathVariable Integer id) {
		Note note = noteService.get(id);
		User u = userService.getById(note.getUserid());
		note.setUserName(u.getName() == null ? u.getNickName() : u.getName());
		note.setAvatarUrl(u.getAvatarUrl());
		return note;
	}

	// 根据id删除
	@RequestMapping(value = "/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable Integer id) {
		noteService.delete(id);
	}

	// 添加
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public void get(@RequestBody Note n, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null && user.getId() != null) {
			noteService.save(user.getId(), n);
		}
	}

	// 修改
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public void update(@RequestBody Note n) {
		noteService.update(n);
	}
}
