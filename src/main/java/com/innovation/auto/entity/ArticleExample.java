package com.innovation.auto.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andAgreeNumIsNull() {
            addCriterion("agree_num is null");
            return (Criteria) this;
        }

        public Criteria andAgreeNumIsNotNull() {
            addCriterion("agree_num is not null");
            return (Criteria) this;
        }

        public Criteria andAgreeNumEqualTo(String value) {
            addCriterion("agree_num =", value, "agreeNum");
            return (Criteria) this;
        }

        public Criteria andAgreeNumNotEqualTo(String value) {
            addCriterion("agree_num <>", value, "agreeNum");
            return (Criteria) this;
        }

        public Criteria andAgreeNumGreaterThan(String value) {
            addCriterion("agree_num >", value, "agreeNum");
            return (Criteria) this;
        }

        public Criteria andAgreeNumGreaterThanOrEqualTo(String value) {
            addCriterion("agree_num >=", value, "agreeNum");
            return (Criteria) this;
        }

        public Criteria andAgreeNumLessThan(String value) {
            addCriterion("agree_num <", value, "agreeNum");
            return (Criteria) this;
        }

        public Criteria andAgreeNumLessThanOrEqualTo(String value) {
            addCriterion("agree_num <=", value, "agreeNum");
            return (Criteria) this;
        }

        public Criteria andAgreeNumLike(String value) {
            addCriterion("agree_num like", value, "agreeNum");
            return (Criteria) this;
        }

        public Criteria andAgreeNumNotLike(String value) {
            addCriterion("agree_num not like", value, "agreeNum");
            return (Criteria) this;
        }

        public Criteria andAgreeNumIn(List<String> values) {
            addCriterion("agree_num in", values, "agreeNum");
            return (Criteria) this;
        }

        public Criteria andAgreeNumNotIn(List<String> values) {
            addCriterion("agree_num not in", values, "agreeNum");
            return (Criteria) this;
        }

        public Criteria andAgreeNumBetween(String value1, String value2) {
            addCriterion("agree_num between", value1, value2, "agreeNum");
            return (Criteria) this;
        }

        public Criteria andAgreeNumNotBetween(String value1, String value2) {
            addCriterion("agree_num not between", value1, value2, "agreeNum");
            return (Criteria) this;
        }

        public Criteria andDisagreeNumIsNull() {
            addCriterion("disagree_num is null");
            return (Criteria) this;
        }

        public Criteria andDisagreeNumIsNotNull() {
            addCriterion("disagree_num is not null");
            return (Criteria) this;
        }

        public Criteria andDisagreeNumEqualTo(String value) {
            addCriterion("disagree_num =", value, "disagreeNum");
            return (Criteria) this;
        }

        public Criteria andDisagreeNumNotEqualTo(String value) {
            addCriterion("disagree_num <>", value, "disagreeNum");
            return (Criteria) this;
        }

        public Criteria andDisagreeNumGreaterThan(String value) {
            addCriterion("disagree_num >", value, "disagreeNum");
            return (Criteria) this;
        }

        public Criteria andDisagreeNumGreaterThanOrEqualTo(String value) {
            addCriterion("disagree_num >=", value, "disagreeNum");
            return (Criteria) this;
        }

        public Criteria andDisagreeNumLessThan(String value) {
            addCriterion("disagree_num <", value, "disagreeNum");
            return (Criteria) this;
        }

        public Criteria andDisagreeNumLessThanOrEqualTo(String value) {
            addCriterion("disagree_num <=", value, "disagreeNum");
            return (Criteria) this;
        }

        public Criteria andDisagreeNumLike(String value) {
            addCriterion("disagree_num like", value, "disagreeNum");
            return (Criteria) this;
        }

        public Criteria andDisagreeNumNotLike(String value) {
            addCriterion("disagree_num not like", value, "disagreeNum");
            return (Criteria) this;
        }

        public Criteria andDisagreeNumIn(List<String> values) {
            addCriterion("disagree_num in", values, "disagreeNum");
            return (Criteria) this;
        }

        public Criteria andDisagreeNumNotIn(List<String> values) {
            addCriterion("disagree_num not in", values, "disagreeNum");
            return (Criteria) this;
        }

        public Criteria andDisagreeNumBetween(String value1, String value2) {
            addCriterion("disagree_num between", value1, value2, "disagreeNum");
            return (Criteria) this;
        }

        public Criteria andDisagreeNumNotBetween(String value1, String value2) {
            addCriterion("disagree_num not between", value1, value2, "disagreeNum");
            return (Criteria) this;
        }

        public Criteria andClicksIsNull() {
            addCriterion("clicks is null");
            return (Criteria) this;
        }

        public Criteria andClicksIsNotNull() {
            addCriterion("clicks is not null");
            return (Criteria) this;
        }

        public Criteria andClicksEqualTo(String value) {
            addCriterion("clicks =", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksNotEqualTo(String value) {
            addCriterion("clicks <>", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksGreaterThan(String value) {
            addCriterion("clicks >", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksGreaterThanOrEqualTo(String value) {
            addCriterion("clicks >=", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksLessThan(String value) {
            addCriterion("clicks <", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksLessThanOrEqualTo(String value) {
            addCriterion("clicks <=", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksLike(String value) {
            addCriterion("clicks like", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksNotLike(String value) {
            addCriterion("clicks not like", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksIn(List<String> values) {
            addCriterion("clicks in", values, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksNotIn(List<String> values) {
            addCriterion("clicks not in", values, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksBetween(String value1, String value2) {
            addCriterion("clicks between", value1, value2, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksNotBetween(String value1, String value2) {
            addCriterion("clicks not between", value1, value2, "clicks");
            return (Criteria) this;
        }

        public Criteria andCustomTagsIsNull() {
            addCriterion("custom_tags is null");
            return (Criteria) this;
        }

        public Criteria andCustomTagsIsNotNull() {
            addCriterion("custom_tags is not null");
            return (Criteria) this;
        }

        public Criteria andCustomTagsEqualTo(String value) {
            addCriterion("custom_tags =", value, "customTags");
            return (Criteria) this;
        }

        public Criteria andCustomTagsNotEqualTo(String value) {
            addCriterion("custom_tags <>", value, "customTags");
            return (Criteria) this;
        }

        public Criteria andCustomTagsGreaterThan(String value) {
            addCriterion("custom_tags >", value, "customTags");
            return (Criteria) this;
        }

        public Criteria andCustomTagsGreaterThanOrEqualTo(String value) {
            addCriterion("custom_tags >=", value, "customTags");
            return (Criteria) this;
        }

        public Criteria andCustomTagsLessThan(String value) {
            addCriterion("custom_tags <", value, "customTags");
            return (Criteria) this;
        }

        public Criteria andCustomTagsLessThanOrEqualTo(String value) {
            addCriterion("custom_tags <=", value, "customTags");
            return (Criteria) this;
        }

        public Criteria andCustomTagsLike(String value) {
            addCriterion("custom_tags like", value, "customTags");
            return (Criteria) this;
        }

        public Criteria andCustomTagsNotLike(String value) {
            addCriterion("custom_tags not like", value, "customTags");
            return (Criteria) this;
        }

        public Criteria andCustomTagsIn(List<String> values) {
            addCriterion("custom_tags in", values, "customTags");
            return (Criteria) this;
        }

        public Criteria andCustomTagsNotIn(List<String> values) {
            addCriterion("custom_tags not in", values, "customTags");
            return (Criteria) this;
        }

        public Criteria andCustomTagsBetween(String value1, String value2) {
            addCriterion("custom_tags between", value1, value2, "customTags");
            return (Criteria) this;
        }

        public Criteria andCustomTagsNotBetween(String value1, String value2) {
            addCriterion("custom_tags not between", value1, value2, "customTags");
            return (Criteria) this;
        }

        public Criteria andClassificationIdIsNull() {
            addCriterion("classification_id is null");
            return (Criteria) this;
        }

        public Criteria andClassificationIdIsNotNull() {
            addCriterion("classification_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassificationIdEqualTo(Integer value) {
            addCriterion("classification_id =", value, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdNotEqualTo(Integer value) {
            addCriterion("classification_id <>", value, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdGreaterThan(Integer value) {
            addCriterion("classification_id >", value, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("classification_id >=", value, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdLessThan(Integer value) {
            addCriterion("classification_id <", value, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdLessThanOrEqualTo(Integer value) {
            addCriterion("classification_id <=", value, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdIn(List<Integer> values) {
            addCriterion("classification_id in", values, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdNotIn(List<Integer> values) {
            addCriterion("classification_id not in", values, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdBetween(Integer value1, Integer value2) {
            addCriterion("classification_id between", value1, value2, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("classification_id not between", value1, value2, "classificationId");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
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