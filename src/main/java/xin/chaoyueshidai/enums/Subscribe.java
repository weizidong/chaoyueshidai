package xin.chaoyueshidai.enums;

public enum Subscribe {
	未关注(0), 已关注(1);
	private Integer value;

	private Subscribe(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static Subscribe parse(Integer type) {
		for (Subscribe item : Subscribe.values()) {
			if (type != null && type == item.getValue()) {
				return item;
			}
		}
		throw new RuntimeException("值【" + type + "】不是" + Subscribe.class + "的有效值。");
	}
}
