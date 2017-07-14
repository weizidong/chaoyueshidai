package xin.chaoyueshidai.module.note;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;

import com.alibaba.fastjson.JSON;

import xin.chaoyueshidai.utils.Configs;

@SuppressWarnings("serial")
public class Note implements Serializable {
	private Integer id;

	private String title;

	private String pic;

	private Date created;

	private Integer userid;
	@Transient
	private String userName;
	@Transient
	private String avatarUrl;

	private String type;

	private Integer share;

	private String content;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAvatarUrl() {
		if (avatarUrl == null) {
			return null;
		}
		if (avatarUrl.startsWith("http://") || avatarUrl.startsWith("https://")) {
			return avatarUrl;
		}
		return Configs.hostname + avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getPic() {
		if (pic == null) {
			return null;
		}
		if (pic.startsWith("http://") || pic.startsWith("https://")) {
			return pic;
		}
		return Configs.hostname + pic;
	}

	public void setPic(String pic) {
		this.pic = pic == null ? null : pic.trim();
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public Integer getShare() {
		return share;
	}

	public void setShare(Integer share) {
		this.share = share;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}