package com.innovation.auto.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MotorInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MotorInfoExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdIsNull() {
            addCriterion("manufacturer_id is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdIsNotNull() {
            addCriterion("manufacturer_id is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdEqualTo(Integer value) {
            addCriterion("manufacturer_id =", value, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdNotEqualTo(Integer value) {
            addCriterion("manufacturer_id <>", value, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdGreaterThan(Integer value) {
            addCriterion("manufacturer_id >", value, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("manufacturer_id >=", value, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdLessThan(Integer value) {
            addCriterion("manufacturer_id <", value, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdLessThanOrEqualTo(Integer value) {
            addCriterion("manufacturer_id <=", value, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdIn(List<Integer> values) {
            addCriterion("manufacturer_id in", values, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdNotIn(List<Integer> values) {
            addCriterion("manufacturer_id not in", values, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdBetween(Integer value1, Integer value2) {
            addCriterion("manufacturer_id between", value1, value2, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("manufacturer_id not between", value1, value2, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andMadeCountryIsNull() {
            addCriterion("made_country is null");
            return (Criteria) this;
        }

        public Criteria andMadeCountryIsNotNull() {
            addCriterion("made_country is not null");
            return (Criteria) this;
        }

        public Criteria andMadeCountryEqualTo(String value) {
            addCriterion("made_country =", value, "madeCountry");
            return (Criteria) this;
        }

        public Criteria andMadeCountryNotEqualTo(String value) {
            addCriterion("made_country <>", value, "madeCountry");
            return (Criteria) this;
        }

        public Criteria andMadeCountryGreaterThan(String value) {
            addCriterion("made_country >", value, "madeCountry");
            return (Criteria) this;
        }

        public Criteria andMadeCountryGreaterThanOrEqualTo(String value) {
            addCriterion("made_country >=", value, "madeCountry");
            return (Criteria) this;
        }

        public Criteria andMadeCountryLessThan(String value) {
            addCriterion("made_country <", value, "madeCountry");
            return (Criteria) this;
        }

        public Criteria andMadeCountryLessThanOrEqualTo(String value) {
            addCriterion("made_country <=", value, "madeCountry");
            return (Criteria) this;
        }

        public Criteria andMadeCountryLike(String value) {
            addCriterion("made_country like", value, "madeCountry");
            return (Criteria) this;
        }

        public Criteria andMadeCountryNotLike(String value) {
            addCriterion("made_country not like", value, "madeCountry");
            return (Criteria) this;
        }

        public Criteria andMadeCountryIn(List<String> values) {
            addCriterion("made_country in", values, "madeCountry");
            return (Criteria) this;
        }

        public Criteria andMadeCountryNotIn(List<String> values) {
            addCriterion("made_country not in", values, "madeCountry");
            return (Criteria) this;
        }

        public Criteria andMadeCountryBetween(String value1, String value2) {
            addCriterion("made_country between", value1, value2, "madeCountry");
            return (Criteria) this;
        }

        public Criteria andMadeCountryNotBetween(String value1, String value2) {
            addCriterion("made_country not between", value1, value2, "madeCountry");
            return (Criteria) this;
        }

        public Criteria andMarketTimeIsNull() {
            addCriterion("market_time is null");
            return (Criteria) this;
        }

        public Criteria andMarketTimeIsNotNull() {
            addCriterion("market_time is not null");
            return (Criteria) this;
        }

        public Criteria andMarketTimeEqualTo(Date value) {
            addCriterion("market_time =", value, "marketTime");
            return (Criteria) this;
        }

        public Criteria andMarketTimeNotEqualTo(Date value) {
            addCriterion("market_time <>", value, "marketTime");
            return (Criteria) this;
        }

        public Criteria andMarketTimeGreaterThan(Date value) {
            addCriterion("market_time >", value, "marketTime");
            return (Criteria) this;
        }

        public Criteria andMarketTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("market_time >=", value, "marketTime");
            return (Criteria) this;
        }

        public Criteria andMarketTimeLessThan(Date value) {
            addCriterion("market_time <", value, "marketTime");
            return (Criteria) this;
        }

        public Criteria andMarketTimeLessThanOrEqualTo(Date value) {
            addCriterion("market_time <=", value, "marketTime");
            return (Criteria) this;
        }

        public Criteria andMarketTimeIn(List<Date> values) {
            addCriterion("market_time in", values, "marketTime");
            return (Criteria) this;
        }

        public Criteria andMarketTimeNotIn(List<Date> values) {
            addCriterion("market_time not in", values, "marketTime");
            return (Criteria) this;
        }

        public Criteria andMarketTimeBetween(Date value1, Date value2) {
            addCriterion("market_time between", value1, value2, "marketTime");
            return (Criteria) this;
        }

        public Criteria andMarketTimeNotBetween(Date value1, Date value2) {
            addCriterion("market_time not between", value1, value2, "marketTime");
            return (Criteria) this;
        }

        public Criteria andRetailPriceIsNull() {
            addCriterion("retail_price is null");
            return (Criteria) this;
        }

        public Criteria andRetailPriceIsNotNull() {
            addCriterion("retail_price is not null");
            return (Criteria) this;
        }

        public Criteria andRetailPriceEqualTo(Long value) {
            addCriterion("retail_price =", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceNotEqualTo(Long value) {
            addCriterion("retail_price <>", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceGreaterThan(Long value) {
            addCriterion("retail_price >", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("retail_price >=", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceLessThan(Long value) {
            addCriterion("retail_price <", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceLessThanOrEqualTo(Long value) {
            addCriterion("retail_price <=", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceIn(List<Long> values) {
            addCriterion("retail_price in", values, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceNotIn(List<Long> values) {
            addCriterion("retail_price not in", values, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceBetween(Long value1, Long value2) {
            addCriterion("retail_price between", value1, value2, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceNotBetween(Long value1, Long value2) {
            addCriterion("retail_price not between", value1, value2, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andDisplacementIsNull() {
            addCriterion("displacement is null");
            return (Criteria) this;
        }

        public Criteria andDisplacementIsNotNull() {
            addCriterion("displacement is not null");
            return (Criteria) this;
        }

        public Criteria andDisplacementEqualTo(String value) {
            addCriterion("displacement =", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementNotEqualTo(String value) {
            addCriterion("displacement <>", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementGreaterThan(String value) {
            addCriterion("displacement >", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementGreaterThanOrEqualTo(String value) {
            addCriterion("displacement >=", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementLessThan(String value) {
            addCriterion("displacement <", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementLessThanOrEqualTo(String value) {
            addCriterion("displacement <=", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementLike(String value) {
            addCriterion("displacement like", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementNotLike(String value) {
            addCriterion("displacement not like", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementIn(List<String> values) {
            addCriterion("displacement in", values, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementNotIn(List<String> values) {
            addCriterion("displacement not in", values, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementBetween(String value1, String value2) {
            addCriterion("displacement between", value1, value2, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementNotBetween(String value1, String value2) {
            addCriterion("displacement not between", value1, value2, "displacement");
            return (Criteria) this;
        }

        public Criteria andCylindersNumIsNull() {
            addCriterion("cylinders_num is null");
            return (Criteria) this;
        }

        public Criteria andCylindersNumIsNotNull() {
            addCriterion("cylinders_num is not null");
            return (Criteria) this;
        }

        public Criteria andCylindersNumEqualTo(String value) {
            addCriterion("cylinders_num =", value, "cylindersNum");
            return (Criteria) this;
        }

        public Criteria andCylindersNumNotEqualTo(String value) {
            addCriterion("cylinders_num <>", value, "cylindersNum");
            return (Criteria) this;
        }

        public Criteria andCylindersNumGreaterThan(String value) {
            addCriterion("cylinders_num >", value, "cylindersNum");
            return (Criteria) this;
        }

        public Criteria andCylindersNumGreaterThanOrEqualTo(String value) {
            addCriterion("cylinders_num >=", value, "cylindersNum");
            return (Criteria) this;
        }

        public Criteria andCylindersNumLessThan(String value) {
            addCriterion("cylinders_num <", value, "cylindersNum");
            return (Criteria) this;
        }

        public Criteria andCylindersNumLessThanOrEqualTo(String value) {
            addCriterion("cylinders_num <=", value, "cylindersNum");
            return (Criteria) this;
        }

        public Criteria andCylindersNumLike(String value) {
            addCriterion("cylinders_num like", value, "cylindersNum");
            return (Criteria) this;
        }

        public Criteria andCylindersNumNotLike(String value) {
            addCriterion("cylinders_num not like", value, "cylindersNum");
            return (Criteria) this;
        }

        public Criteria andCylindersNumIn(List<String> values) {
            addCriterion("cylinders_num in", values, "cylindersNum");
            return (Criteria) this;
        }

        public Criteria andCylindersNumNotIn(List<String> values) {
            addCriterion("cylinders_num not in", values, "cylindersNum");
            return (Criteria) this;
        }

        public Criteria andCylindersNumBetween(String value1, String value2) {
            addCriterion("cylinders_num between", value1, value2, "cylindersNum");
            return (Criteria) this;
        }

        public Criteria andCylindersNumNotBetween(String value1, String value2) {
            addCriterion("cylinders_num not between", value1, value2, "cylindersNum");
            return (Criteria) this;
        }

        public Criteria andStrokeIsNull() {
            addCriterion("stroke is null");
            return (Criteria) this;
        }

        public Criteria andStrokeIsNotNull() {
            addCriterion("stroke is not null");
            return (Criteria) this;
        }

        public Criteria andStrokeEqualTo(String value) {
            addCriterion("stroke =", value, "stroke");
            return (Criteria) this;
        }

        public Criteria andStrokeNotEqualTo(String value) {
            addCriterion("stroke <>", value, "stroke");
            return (Criteria) this;
        }

        public Criteria andStrokeGreaterThan(String value) {
            addCriterion("stroke >", value, "stroke");
            return (Criteria) this;
        }

        public Criteria andStrokeGreaterThanOrEqualTo(String value) {
            addCriterion("stroke >=", value, "stroke");
            return (Criteria) this;
        }

        public Criteria andStrokeLessThan(String value) {
            addCriterion("stroke <", value, "stroke");
            return (Criteria) this;
        }

        public Criteria andStrokeLessThanOrEqualTo(String value) {
            addCriterion("stroke <=", value, "stroke");
            return (Criteria) this;
        }

        public Criteria andStrokeLike(String value) {
            addCriterion("stroke like", value, "stroke");
            return (Criteria) this;
        }

        public Criteria andStrokeNotLike(String value) {
            addCriterion("stroke not like", value, "stroke");
            return (Criteria) this;
        }

        public Criteria andStrokeIn(List<String> values) {
            addCriterion("stroke in", values, "stroke");
            return (Criteria) this;
        }

        public Criteria andStrokeNotIn(List<String> values) {
            addCriterion("stroke not in", values, "stroke");
            return (Criteria) this;
        }

        public Criteria andStrokeBetween(String value1, String value2) {
            addCriterion("stroke between", value1, value2, "stroke");
            return (Criteria) this;
        }

        public Criteria andStrokeNotBetween(String value1, String value2) {
            addCriterion("stroke not between", value1, value2, "stroke");
            return (Criteria) this;
        }

        public Criteria andPerCylinderValveIsNull() {
            addCriterion("per_cylinder_valve is null");
            return (Criteria) this;
        }

        public Criteria andPerCylinderValveIsNotNull() {
            addCriterion("per_cylinder_valve is not null");
            return (Criteria) this;
        }

        public Criteria andPerCylinderValveEqualTo(String value) {
            addCriterion("per_cylinder_valve =", value, "perCylinderValve");
            return (Criteria) this;
        }

        public Criteria andPerCylinderValveNotEqualTo(String value) {
            addCriterion("per_cylinder_valve <>", value, "perCylinderValve");
            return (Criteria) this;
        }

        public Criteria andPerCylinderValveGreaterThan(String value) {
            addCriterion("per_cylinder_valve >", value, "perCylinderValve");
            return (Criteria) this;
        }

        public Criteria andPerCylinderValveGreaterThanOrEqualTo(String value) {
            addCriterion("per_cylinder_valve >=", value, "perCylinderValve");
            return (Criteria) this;
        }

        public Criteria andPerCylinderValveLessThan(String value) {
            addCriterion("per_cylinder_valve <", value, "perCylinderValve");
            return (Criteria) this;
        }

        public Criteria andPerCylinderValveLessThanOrEqualTo(String value) {
            addCriterion("per_cylinder_valve <=", value, "perCylinderValve");
            return (Criteria) this;
        }

        public Criteria andPerCylinderValveLike(String value) {
            addCriterion("per_cylinder_valve like", value, "perCylinderValve");
            return (Criteria) this;
        }

        public Criteria andPerCylinderValveNotLike(String value) {
            addCriterion("per_cylinder_valve not like", value, "perCylinderValve");
            return (Criteria) this;
        }

        public Criteria andPerCylinderValveIn(List<String> values) {
            addCriterion("per_cylinder_valve in", values, "perCylinderValve");
            return (Criteria) this;
        }

        public Criteria andPerCylinderValveNotIn(List<String> values) {
            addCriterion("per_cylinder_valve not in", values, "perCylinderValve");
            return (Criteria) this;
        }

        public Criteria andPerCylinderValveBetween(String value1, String value2) {
            addCriterion("per_cylinder_valve between", value1, value2, "perCylinderValve");
            return (Criteria) this;
        }

        public Criteria andPerCylinderValveNotBetween(String value1, String value2) {
            addCriterion("per_cylinder_valve not between", value1, value2, "perCylinderValve");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerIsNull() {
            addCriterion("maximum_power is null");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerIsNotNull() {
            addCriterion("maximum_power is not null");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerEqualTo(String value) {
            addCriterion("maximum_power =", value, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerNotEqualTo(String value) {
            addCriterion("maximum_power <>", value, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerGreaterThan(String value) {
            addCriterion("maximum_power >", value, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerGreaterThanOrEqualTo(String value) {
            addCriterion("maximum_power >=", value, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerLessThan(String value) {
            addCriterion("maximum_power <", value, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerLessThanOrEqualTo(String value) {
            addCriterion("maximum_power <=", value, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerLike(String value) {
            addCriterion("maximum_power like", value, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerNotLike(String value) {
            addCriterion("maximum_power not like", value, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerIn(List<String> values) {
            addCriterion("maximum_power in", values, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerNotIn(List<String> values) {
            addCriterion("maximum_power not in", values, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerBetween(String value1, String value2) {
            addCriterion("maximum_power between", value1, value2, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerNotBetween(String value1, String value2) {
            addCriterion("maximum_power not between", value1, value2, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueIsNull() {
            addCriterion("maximum_torque is null");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueIsNotNull() {
            addCriterion("maximum_torque is not null");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueEqualTo(String value) {
            addCriterion("maximum_torque =", value, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueNotEqualTo(String value) {
            addCriterion("maximum_torque <>", value, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueGreaterThan(String value) {
            addCriterion("maximum_torque >", value, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueGreaterThanOrEqualTo(String value) {
            addCriterion("maximum_torque >=", value, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueLessThan(String value) {
            addCriterion("maximum_torque <", value, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueLessThanOrEqualTo(String value) {
            addCriterion("maximum_torque <=", value, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueLike(String value) {
            addCriterion("maximum_torque like", value, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueNotLike(String value) {
            addCriterion("maximum_torque not like", value, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueIn(List<String> values) {
            addCriterion("maximum_torque in", values, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueNotIn(List<String> values) {
            addCriterion("maximum_torque not in", values, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueBetween(String value1, String value2) {
            addCriterion("maximum_torque between", value1, value2, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueNotBetween(String value1, String value2) {
            addCriterion("maximum_torque not between", value1, value2, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andFuelConsumptionIsNull() {
            addCriterion("fuel_consumption is null");
            return (Criteria) this;
        }

        public Criteria andFuelConsumptionIsNotNull() {
            addCriterion("fuel_consumption is not null");
            return (Criteria) this;
        }

        public Criteria andFuelConsumptionEqualTo(String value) {
            addCriterion("fuel_consumption =", value, "fuelConsumption");
            return (Criteria) this;
        }

        public Criteria andFuelConsumptionNotEqualTo(String value) {
            addCriterion("fuel_consumption <>", value, "fuelConsumption");
            return (Criteria) this;
        }

        public Criteria andFuelConsumptionGreaterThan(String value) {
            addCriterion("fuel_consumption >", value, "fuelConsumption");
            return (Criteria) this;
        }

        public Criteria andFuelConsumptionGreaterThanOrEqualTo(String value) {
            addCriterion("fuel_consumption >=", value, "fuelConsumption");
            return (Criteria) this;
        }

        public Criteria andFuelConsumptionLessThan(String value) {
            addCriterion("fuel_consumption <", value, "fuelConsumption");
            return (Criteria) this;
        }

        public Criteria andFuelConsumptionLessThanOrEqualTo(String value) {
            addCriterion("fuel_consumption <=", value, "fuelConsumption");
            return (Criteria) this;
        }

        public Criteria andFuelConsumptionLike(String value) {
            addCriterion("fuel_consumption like", value, "fuelConsumption");
            return (Criteria) this;
        }

        public Criteria andFuelConsumptionNotLike(String value) {
            addCriterion("fuel_consumption not like", value, "fuelConsumption");
            return (Criteria) this;
        }

        public Criteria andFuelConsumptionIn(List<String> values) {
            addCriterion("fuel_consumption in", values, "fuelConsumption");
            return (Criteria) this;
        }

        public Criteria andFuelConsumptionNotIn(List<String> values) {
            addCriterion("fuel_consumption not in", values, "fuelConsumption");
            return (Criteria) this;
        }

        public Criteria andFuelConsumptionBetween(String value1, String value2) {
            addCriterion("fuel_consumption between", value1, value2, "fuelConsumption");
            return (Criteria) this;
        }

        public Criteria andFuelConsumptionNotBetween(String value1, String value2) {
            addCriterion("fuel_consumption not between", value1, value2, "fuelConsumption");
            return (Criteria) this;
        }

        public Criteria andGearIsNull() {
            addCriterion("gear is null");
            return (Criteria) this;
        }

        public Criteria andGearIsNotNull() {
            addCriterion("gear is not null");
            return (Criteria) this;
        }

        public Criteria andGearEqualTo(String value) {
            addCriterion("gear =", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearNotEqualTo(String value) {
            addCriterion("gear <>", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearGreaterThan(String value) {
            addCriterion("gear >", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearGreaterThanOrEqualTo(String value) {
            addCriterion("gear >=", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearLessThan(String value) {
            addCriterion("gear <", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearLessThanOrEqualTo(String value) {
            addCriterion("gear <=", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearLike(String value) {
            addCriterion("gear like", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearNotLike(String value) {
            addCriterion("gear not like", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearIn(List<String> values) {
            addCriterion("gear in", values, "gear");
            return (Criteria) this;
        }

        public Criteria andGearNotIn(List<String> values) {
            addCriterion("gear not in", values, "gear");
            return (Criteria) this;
        }

        public Criteria andGearBetween(String value1, String value2) {
            addCriterion("gear between", value1, value2, "gear");
            return (Criteria) this;
        }

        public Criteria andGearNotBetween(String value1, String value2) {
            addCriterion("gear not between", value1, value2, "gear");
            return (Criteria) this;
        }

        public Criteria andTankCapacityIsNull() {
            addCriterion("tank_capacity is null");
            return (Criteria) this;
        }

        public Criteria andTankCapacityIsNotNull() {
            addCriterion("tank_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andTankCapacityEqualTo(String value) {
            addCriterion("tank_capacity =", value, "tankCapacity");
            return (Criteria) this;
        }

        public Criteria andTankCapacityNotEqualTo(String value) {
            addCriterion("tank_capacity <>", value, "tankCapacity");
            return (Criteria) this;
        }

        public Criteria andTankCapacityGreaterThan(String value) {
            addCriterion("tank_capacity >", value, "tankCapacity");
            return (Criteria) this;
        }

        public Criteria andTankCapacityGreaterThanOrEqualTo(String value) {
            addCriterion("tank_capacity >=", value, "tankCapacity");
            return (Criteria) this;
        }

        public Criteria andTankCapacityLessThan(String value) {
            addCriterion("tank_capacity <", value, "tankCapacity");
            return (Criteria) this;
        }

        public Criteria andTankCapacityLessThanOrEqualTo(String value) {
            addCriterion("tank_capacity <=", value, "tankCapacity");
            return (Criteria) this;
        }

        public Criteria andTankCapacityLike(String value) {
            addCriterion("tank_capacity like", value, "tankCapacity");
            return (Criteria) this;
        }

        public Criteria andTankCapacityNotLike(String value) {
            addCriterion("tank_capacity not like", value, "tankCapacity");
            return (Criteria) this;
        }

        public Criteria andTankCapacityIn(List<String> values) {
            addCriterion("tank_capacity in", values, "tankCapacity");
            return (Criteria) this;
        }

        public Criteria andTankCapacityNotIn(List<String> values) {
            addCriterion("tank_capacity not in", values, "tankCapacity");
            return (Criteria) this;
        }

        public Criteria andTankCapacityBetween(String value1, String value2) {
            addCriterion("tank_capacity between", value1, value2, "tankCapacity");
            return (Criteria) this;
        }

        public Criteria andTankCapacityNotBetween(String value1, String value2) {
            addCriterion("tank_capacity not between", value1, value2, "tankCapacity");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(String value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(String value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(String value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(String value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(String value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(String value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLike(String value) {
            addCriterion("weight like", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotLike(String value) {
            addCriterion("weight not like", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<String> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<String> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(String value1, String value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(String value1, String value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }


        public Criteria andBrakeSystemIsNull() {
            addCriterion("brake_system is null");
            return (Criteria) this;
        }

        public Criteria andBrakeSystemIsNotNull() {
            addCriterion("brake_system is not null");
            return (Criteria) this;
        }

        public Criteria andBrakeSystemEqualTo(String value) {
            addCriterion("brake_system =", value, "brakeSystem");
            return (Criteria) this;
        }

        public Criteria andBrakeSystemNotEqualTo(String value) {
            addCriterion("brake_system <>", value, "brakeSystem");
            return (Criteria) this;
        }

        public Criteria andBrakeSystemGreaterThan(String value) {
            addCriterion("brake_system >", value, "brakeSystem");
            return (Criteria) this;
        }

        public Criteria andBrakeSystemGreaterThanOrEqualTo(String value) {
            addCriterion("brake_system >=", value, "brakeSystem");
            return (Criteria) this;
        }

        public Criteria andBrakeSystemLessThan(String value) {
            addCriterion("brake_system <", value, "brakeSystem");
            return (Criteria) this;
        }

        public Criteria andBrakeSystemLessThanOrEqualTo(String value) {
            addCriterion("brake_system <=", value, "brakeSystem");
            return (Criteria) this;
        }

        public Criteria andBrakeSystemLike(String value) {
            addCriterion("brake_system like", value, "brakeSystem");
            return (Criteria) this;
        }

        public Criteria andBrakeSystemNotLike(String value) {
            addCriterion("brake_system not like", value, "brakeSystem");
            return (Criteria) this;
        }

        public Criteria andBrakeSystemIn(List<String> values) {
            addCriterion("brake_system in", values, "brakeSystem");
            return (Criteria) this;
        }

        public Criteria andBrakeSystemNotIn(List<String> values) {
            addCriterion("brake_system not in", values, "brakeSystem");
            return (Criteria) this;
        }

        public Criteria andBrakeSystemBetween(String value1, String value2) {
            addCriterion("brake_system between", value1, value2, "brakeSystem");
            return (Criteria) this;
        }

        public Criteria andBrakeSystemNotBetween(String value1, String value2) {
            addCriterion("brake_system not between", value1, value2, "brakeSystem");
            return (Criteria) this;
        }

        public Criteria andInstrumentIsNull() {
            addCriterion("instrument is null");
            return (Criteria) this;
        }

        public Criteria andInstrumentIsNotNull() {
            addCriterion("instrument is not null");
            return (Criteria) this;
        }

        public Criteria andInstrumentEqualTo(String value) {
            addCriterion("instrument =", value, "instrument");
            return (Criteria) this;
        }

        public Criteria andInstrumentNotEqualTo(String value) {
            addCriterion("instrument <>", value, "instrument");
            return (Criteria) this;
        }

        public Criteria andInstrumentGreaterThan(String value) {
            addCriterion("instrument >", value, "instrument");
            return (Criteria) this;
        }

        public Criteria andInstrumentGreaterThanOrEqualTo(String value) {
            addCriterion("instrument >=", value, "instrument");
            return (Criteria) this;
        }

        public Criteria andInstrumentLessThan(String value) {
            addCriterion("instrument <", value, "instrument");
            return (Criteria) this;
        }

        public Criteria andInstrumentLessThanOrEqualTo(String value) {
            addCriterion("instrument <=", value, "instrument");
            return (Criteria) this;
        }

        public Criteria andInstrumentLike(String value) {
            addCriterion("instrument like", value, "instrument");
            return (Criteria) this;
        }

        public Criteria andInstrumentNotLike(String value) {
            addCriterion("instrument not like", value, "instrument");
            return (Criteria) this;
        }

        public Criteria andInstrumentIn(List<String> values) {
            addCriterion("instrument in", values, "instrument");
            return (Criteria) this;
        }

        public Criteria andInstrumentNotIn(List<String> values) {
            addCriterion("instrument not in", values, "instrument");
            return (Criteria) this;
        }

        public Criteria andInstrumentBetween(String value1, String value2) {
            addCriterion("instrument between", value1, value2, "instrument");
            return (Criteria) this;
        }

        public Criteria andInstrumentNotBetween(String value1, String value2) {
            addCriterion("instrument not between", value1, value2, "instrument");
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