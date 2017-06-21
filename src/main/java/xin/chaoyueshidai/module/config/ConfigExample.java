package xin.chaoyueshidai.module.config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConfigExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ConfigExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andFiledIsNull() {
			addCriterion("filed is null");
			return (Criteria) this;
		}

		public Criteria andFiledIsNotNull() {
			addCriterion("filed is not null");
			return (Criteria) this;
		}

		public Criteria andFiledEqualTo(String value) {
			addCriterion("filed =", value, "filed");
			return (Criteria) this;
		}

		public Criteria andFiledNotEqualTo(String value) {
			addCriterion("filed <>", value, "filed");
			return (Criteria) this;
		}

		public Criteria andFiledGreaterThan(String value) {
			addCriterion("filed >", value, "filed");
			return (Criteria) this;
		}

		public Criteria andFiledGreaterThanOrEqualTo(String value) {
			addCriterion("filed >=", value, "filed");
			return (Criteria) this;
		}

		public Criteria andFiledLessThan(String value) {
			addCriterion("filed <", value, "filed");
			return (Criteria) this;
		}

		public Criteria andFiledLessThanOrEqualTo(String value) {
			addCriterion("filed <=", value, "filed");
			return (Criteria) this;
		}

		public Criteria andFiledLike(String value) {
			addCriterion("filed like", value, "filed");
			return (Criteria) this;
		}

		public Criteria andFiledNotLike(String value) {
			addCriterion("filed not like", value, "filed");
			return (Criteria) this;
		}

		public Criteria andFiledIn(List<String> values) {
			addCriterion("filed in", values, "filed");
			return (Criteria) this;
		}

		public Criteria andFiledNotIn(List<String> values) {
			addCriterion("filed not in", values, "filed");
			return (Criteria) this;
		}

		public Criteria andFiledBetween(String value1, String value2) {
			addCriterion("filed between", value1, value2, "filed");
			return (Criteria) this;
		}

		public Criteria andFiledNotBetween(String value1, String value2) {
			addCriterion("filed not between", value1, value2, "filed");
			return (Criteria) this;
		}

		public Criteria andValueIsNull() {
			addCriterion("value is null");
			return (Criteria) this;
		}

		public Criteria andValueIsNotNull() {
			addCriterion("value is not null");
			return (Criteria) this;
		}

		public Criteria andValueEqualTo(String value) {
			addCriterion("value =", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotEqualTo(String value) {
			addCriterion("value <>", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueGreaterThan(String value) {
			addCriterion("value >", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueGreaterThanOrEqualTo(String value) {
			addCriterion("value >=", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueLessThan(String value) {
			addCriterion("value <", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueLessThanOrEqualTo(String value) {
			addCriterion("value <=", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueLike(String value) {
			addCriterion("value like", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotLike(String value) {
			addCriterion("value not like", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueIn(List<String> values) {
			addCriterion("value in", values, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotIn(List<String> values) {
			addCriterion("value not in", values, "value");
			return (Criteria) this;
		}

		public Criteria andValueBetween(String value1, String value2) {
			addCriterion("value between", value1, value2, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotBetween(String value1, String value2) {
			addCriterion("value not between", value1, value2, "value");
			return (Criteria) this;
		}

		public Criteria andLastValueIsNull() {
			addCriterion("last_value is null");
			return (Criteria) this;
		}

		public Criteria andLastValueIsNotNull() {
			addCriterion("last_value is not null");
			return (Criteria) this;
		}

		public Criteria andLastValueEqualTo(String value) {
			addCriterion("last_value =", value, "lastValue");
			return (Criteria) this;
		}

		public Criteria andLastValueNotEqualTo(String value) {
			addCriterion("last_value <>", value, "lastValue");
			return (Criteria) this;
		}

		public Criteria andLastValueGreaterThan(String value) {
			addCriterion("last_value >", value, "lastValue");
			return (Criteria) this;
		}

		public Criteria andLastValueGreaterThanOrEqualTo(String value) {
			addCriterion("last_value >=", value, "lastValue");
			return (Criteria) this;
		}

		public Criteria andLastValueLessThan(String value) {
			addCriterion("last_value <", value, "lastValue");
			return (Criteria) this;
		}

		public Criteria andLastValueLessThanOrEqualTo(String value) {
			addCriterion("last_value <=", value, "lastValue");
			return (Criteria) this;
		}

		public Criteria andLastValueLike(String value) {
			addCriterion("last_value like", value, "lastValue");
			return (Criteria) this;
		}

		public Criteria andLastValueNotLike(String value) {
			addCriterion("last_value not like", value, "lastValue");
			return (Criteria) this;
		}

		public Criteria andLastValueIn(List<String> values) {
			addCriterion("last_value in", values, "lastValue");
			return (Criteria) this;
		}

		public Criteria andLastValueNotIn(List<String> values) {
			addCriterion("last_value not in", values, "lastValue");
			return (Criteria) this;
		}

		public Criteria andLastValueBetween(String value1, String value2) {
			addCriterion("last_value between", value1, value2, "lastValue");
			return (Criteria) this;
		}

		public Criteria andLastValueNotBetween(String value1, String value2) {
			addCriterion("last_value not between", value1, value2, "lastValue");
			return (Criteria) this;
		}

		public Criteria andTimeIsNull() {
			addCriterion("time is null");
			return (Criteria) this;
		}

		public Criteria andTimeIsNotNull() {
			addCriterion("time is not null");
			return (Criteria) this;
		}

		public Criteria andTimeEqualTo(Date value) {
			addCriterion("time =", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeNotEqualTo(Date value) {
			addCriterion("time <>", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeGreaterThan(Date value) {
			addCriterion("time >", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("time >=", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeLessThan(Date value) {
			addCriterion("time <", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeLessThanOrEqualTo(Date value) {
			addCriterion("time <=", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeIn(List<Date> values) {
			addCriterion("time in", values, "time");
			return (Criteria) this;
		}

		public Criteria andTimeNotIn(List<Date> values) {
			addCriterion("time not in", values, "time");
			return (Criteria) this;
		}

		public Criteria andTimeBetween(Date value1, Date value2) {
			addCriterion("time between", value1, value2, "time");
			return (Criteria) this;
		}

		public Criteria andTimeNotBetween(Date value1, Date value2) {
			addCriterion("time not between", value1, value2, "time");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}