package com.innovation.auto.entity;

import java.util.ArrayList;
import java.util.List;

public class DicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DicExample() {
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

        public Criteria andDicIdIsNull() {
            addCriterion("dic_id is null");
            return (Criteria) this;
        }

        public Criteria andDicIdIsNotNull() {
            addCriterion("dic_id is not null");
            return (Criteria) this;
        }

        public Criteria andDicIdEqualTo(Integer value) {
            addCriterion("dic_id =", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdNotEqualTo(Integer value) {
            addCriterion("dic_id <>", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdGreaterThan(Integer value) {
            addCriterion("dic_id >", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dic_id >=", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdLessThan(Integer value) {
            addCriterion("dic_id <", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdLessThanOrEqualTo(Integer value) {
            addCriterion("dic_id <=", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdIn(List<Integer> values) {
            addCriterion("dic_id in", values, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdNotIn(List<Integer> values) {
            addCriterion("dic_id not in", values, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdBetween(Integer value1, Integer value2) {
            addCriterion("dic_id between", value1, value2, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dic_id not between", value1, value2, "dicId");
            return (Criteria) this;
        }

        public Criteria andPartitionIdIsNull() {
            addCriterion("partition_id is null");
            return (Criteria) this;
        }

        public Criteria andPartitionIdIsNotNull() {
            addCriterion("partition_id is not null");
            return (Criteria) this;
        }

        public Criteria andPartitionIdEqualTo(String value) {
            addCriterion("partition_id =", value, "partitionId");
            return (Criteria) this;
        }

        public Criteria andPartitionIdNotEqualTo(String value) {
            addCriterion("partition_id <>", value, "partitionId");
            return (Criteria) this;
        }

        public Criteria andPartitionIdGreaterThan(String value) {
            addCriterion("partition_id >", value, "partitionId");
            return (Criteria) this;
        }

        public Criteria andPartitionIdGreaterThanOrEqualTo(String value) {
            addCriterion("partition_id >=", value, "partitionId");
            return (Criteria) this;
        }

        public Criteria andPartitionIdLessThan(String value) {
            addCriterion("partition_id <", value, "partitionId");
            return (Criteria) this;
        }

        public Criteria andPartitionIdLessThanOrEqualTo(String value) {
            addCriterion("partition_id <=", value, "partitionId");
            return (Criteria) this;
        }

        public Criteria andPartitionIdLike(String value) {
            addCriterion("partition_id like", value, "partitionId");
            return (Criteria) this;
        }

        public Criteria andPartitionIdNotLike(String value) {
            addCriterion("partition_id not like", value, "partitionId");
            return (Criteria) this;
        }

        public Criteria andPartitionIdIn(List<String> values) {
            addCriterion("partition_id in", values, "partitionId");
            return (Criteria) this;
        }

        public Criteria andPartitionIdNotIn(List<String> values) {
            addCriterion("partition_id not in", values, "partitionId");
            return (Criteria) this;
        }

        public Criteria andPartitionIdBetween(String value1, String value2) {
            addCriterion("partition_id between", value1, value2, "partitionId");
            return (Criteria) this;
        }

        public Criteria andPartitionIdNotBetween(String value1, String value2) {
            addCriterion("partition_id not between", value1, value2, "partitionId");
            return (Criteria) this;
        }

        public Criteria andPartitionDescIsNull() {
            addCriterion("partition_desc is null");
            return (Criteria) this;
        }

        public Criteria andPartitionDescIsNotNull() {
            addCriterion("partition_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPartitionDescEqualTo(String value) {
            addCriterion("partition_desc =", value, "partitionDesc");
            return (Criteria) this;
        }

        public Criteria andPartitionDescNotEqualTo(String value) {
            addCriterion("partition_desc <>", value, "partitionDesc");
            return (Criteria) this;
        }

        public Criteria andPartitionDescGreaterThan(String value) {
            addCriterion("partition_desc >", value, "partitionDesc");
            return (Criteria) this;
        }

        public Criteria andPartitionDescGreaterThanOrEqualTo(String value) {
            addCriterion("partition_desc >=", value, "partitionDesc");
            return (Criteria) this;
        }

        public Criteria andPartitionDescLessThan(String value) {
            addCriterion("partition_desc <", value, "partitionDesc");
            return (Criteria) this;
        }

        public Criteria andPartitionDescLessThanOrEqualTo(String value) {
            addCriterion("partition_desc <=", value, "partitionDesc");
            return (Criteria) this;
        }

        public Criteria andPartitionDescLike(String value) {
            addCriterion("partition_desc like", value, "partitionDesc");
            return (Criteria) this;
        }

        public Criteria andPartitionDescNotLike(String value) {
            addCriterion("partition_desc not like", value, "partitionDesc");
            return (Criteria) this;
        }

        public Criteria andPartitionDescIn(List<String> values) {
            addCriterion("partition_desc in", values, "partitionDesc");
            return (Criteria) this;
        }

        public Criteria andPartitionDescNotIn(List<String> values) {
            addCriterion("partition_desc not in", values, "partitionDesc");
            return (Criteria) this;
        }

        public Criteria andPartitionDescBetween(String value1, String value2) {
            addCriterion("partition_desc between", value1, value2, "partitionDesc");
            return (Criteria) this;
        }

        public Criteria andPartitionDescNotBetween(String value1, String value2) {
            addCriterion("partition_desc not between", value1, value2, "partitionDesc");
            return (Criteria) this;
        }

        public Criteria andDicCodeIsNull() {
            addCriterion("dic_code is null");
            return (Criteria) this;
        }

        public Criteria andDicCodeIsNotNull() {
            addCriterion("dic_code is not null");
            return (Criteria) this;
        }

        public Criteria andDicCodeEqualTo(String value) {
            addCriterion("dic_code =", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeNotEqualTo(String value) {
            addCriterion("dic_code <>", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeGreaterThan(String value) {
            addCriterion("dic_code >", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dic_code >=", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeLessThan(String value) {
            addCriterion("dic_code <", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeLessThanOrEqualTo(String value) {
            addCriterion("dic_code <=", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeLike(String value) {
            addCriterion("dic_code like", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeNotLike(String value) {
            addCriterion("dic_code not like", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeIn(List<String> values) {
            addCriterion("dic_code in", values, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeNotIn(List<String> values) {
            addCriterion("dic_code not in", values, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeBetween(String value1, String value2) {
            addCriterion("dic_code between", value1, value2, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeNotBetween(String value1, String value2) {
            addCriterion("dic_code not between", value1, value2, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicLabelIsNull() {
            addCriterion("dic_label is null");
            return (Criteria) this;
        }

        public Criteria andDicLabelIsNotNull() {
            addCriterion("dic_label is not null");
            return (Criteria) this;
        }

        public Criteria andDicLabelEqualTo(String value) {
            addCriterion("dic_label =", value, "dicLabel");
            return (Criteria) this;
        }

        public Criteria andDicLabelNotEqualTo(String value) {
            addCriterion("dic_label <>", value, "dicLabel");
            return (Criteria) this;
        }

        public Criteria andDicLabelGreaterThan(String value) {
            addCriterion("dic_label >", value, "dicLabel");
            return (Criteria) this;
        }

        public Criteria andDicLabelGreaterThanOrEqualTo(String value) {
            addCriterion("dic_label >=", value, "dicLabel");
            return (Criteria) this;
        }

        public Criteria andDicLabelLessThan(String value) {
            addCriterion("dic_label <", value, "dicLabel");
            return (Criteria) this;
        }

        public Criteria andDicLabelLessThanOrEqualTo(String value) {
            addCriterion("dic_label <=", value, "dicLabel");
            return (Criteria) this;
        }

        public Criteria andDicLabelLike(String value) {
            addCriterion("dic_label like", value, "dicLabel");
            return (Criteria) this;
        }

        public Criteria andDicLabelNotLike(String value) {
            addCriterion("dic_label not like", value, "dicLabel");
            return (Criteria) this;
        }

        public Criteria andDicLabelIn(List<String> values) {
            addCriterion("dic_label in", values, "dicLabel");
            return (Criteria) this;
        }

        public Criteria andDicLabelNotIn(List<String> values) {
            addCriterion("dic_label not in", values, "dicLabel");
            return (Criteria) this;
        }

        public Criteria andDicLabelBetween(String value1, String value2) {
            addCriterion("dic_label between", value1, value2, "dicLabel");
            return (Criteria) this;
        }

        public Criteria andDicLabelNotBetween(String value1, String value2) {
            addCriterion("dic_label not between", value1, value2, "dicLabel");
            return (Criteria) this;
        }

        public Criteria andDelFlgIsNull() {
            addCriterion("del_flg is null");
            return (Criteria) this;
        }

        public Criteria andDelFlgIsNotNull() {
            addCriterion("del_flg is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlgEqualTo(String value) {
            addCriterion("del_flg =", value, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgNotEqualTo(String value) {
            addCriterion("del_flg <>", value, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgGreaterThan(String value) {
            addCriterion("del_flg >", value, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgGreaterThanOrEqualTo(String value) {
            addCriterion("del_flg >=", value, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgLessThan(String value) {
            addCriterion("del_flg <", value, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgLessThanOrEqualTo(String value) {
            addCriterion("del_flg <=", value, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgLike(String value) {
            addCriterion("del_flg like", value, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgNotLike(String value) {
            addCriterion("del_flg not like", value, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgIn(List<String> values) {
            addCriterion("del_flg in", values, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgNotIn(List<String> values) {
            addCriterion("del_flg not in", values, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgBetween(String value1, String value2) {
            addCriterion("del_flg between", value1, value2, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgNotBetween(String value1, String value2) {
            addCriterion("del_flg not between", value1, value2, "delFlg");
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