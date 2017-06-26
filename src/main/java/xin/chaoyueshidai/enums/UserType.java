package xin.chaoyueshidai.enums;

public enum UserType {
	普通用户(0), 管理员(1), 超级管理员(2);
	private Integer value;

	private UserType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static UserType parse(Integer type) {
		for (UserType item : UserType.values()) {
			if (type != null && type == item.getValue()) {
				return item;
			}
		}
		throw new RuntimeException("值【" + type + "】不是" + UserType.class + "的有效值。");
	}
}
