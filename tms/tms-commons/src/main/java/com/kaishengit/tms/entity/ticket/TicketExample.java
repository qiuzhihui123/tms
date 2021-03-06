package com.kaishengit.tms.entity.ticket;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public TicketExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTicketNumIsNull() {
            addCriterion("ticket_num is null");
            return (Criteria) this;
        }

        public Criteria andTicketNumIsNotNull() {
            addCriterion("ticket_num is not null");
            return (Criteria) this;
        }

        public Criteria andTicketNumEqualTo(String value) {
            addCriterion("ticket_num =", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumNotEqualTo(String value) {
            addCriterion("ticket_num <>", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumGreaterThan(String value) {
            addCriterion("ticket_num >", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_num >=", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumLessThan(String value) {
            addCriterion("ticket_num <", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumLessThanOrEqualTo(String value) {
            addCriterion("ticket_num <=", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumLike(String value) {
            addCriterion("ticket_num like", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumNotLike(String value) {
            addCriterion("ticket_num not like", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumIn(List<String> values) {
            addCriterion("ticket_num in", values, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumNotIn(List<String> values) {
            addCriterion("ticket_num not in", values, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumBetween(String value1, String value2) {
            addCriterion("ticket_num between", value1, value2, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumNotBetween(String value1, String value2) {
            addCriterion("ticket_num not between", value1, value2, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeIsNull() {
            addCriterion("ticket_in_time is null");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeIsNotNull() {
            addCriterion("ticket_in_time is not null");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeEqualTo(Date value) {
            addCriterion("ticket_in_time =", value, "ticketInTime");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeNotEqualTo(Date value) {
            addCriterion("ticket_in_time <>", value, "ticketInTime");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeGreaterThan(Date value) {
            addCriterion("ticket_in_time >", value, "ticketInTime");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ticket_in_time >=", value, "ticketInTime");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeLessThan(Date value) {
            addCriterion("ticket_in_time <", value, "ticketInTime");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeLessThanOrEqualTo(Date value) {
            addCriterion("ticket_in_time <=", value, "ticketInTime");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeIn(List<Date> values) {
            addCriterion("ticket_in_time in", values, "ticketInTime");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeNotIn(List<Date> values) {
            addCriterion("ticket_in_time not in", values, "ticketInTime");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeBetween(Date value1, Date value2) {
            addCriterion("ticket_in_time between", value1, value2, "ticketInTime");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeNotBetween(Date value1, Date value2) {
            addCriterion("ticket_in_time not between", value1, value2, "ticketInTime");
            return (Criteria) this;
        }

        public Criteria andTicketOutTimeIsNull() {
            addCriterion("ticket_out_time is null");
            return (Criteria) this;
        }

        public Criteria andTicketOutTimeIsNotNull() {
            addCriterion("ticket_out_time is not null");
            return (Criteria) this;
        }

        public Criteria andTicketOutTimeEqualTo(Date value) {
            addCriterion("ticket_out_time =", value, "ticketOutTime");
            return (Criteria) this;
        }

        public Criteria andTicketOutTimeNotEqualTo(Date value) {
            addCriterion("ticket_out_time <>", value, "ticketOutTime");
            return (Criteria) this;
        }

        public Criteria andTicketOutTimeGreaterThan(Date value) {
            addCriterion("ticket_out_time >", value, "ticketOutTime");
            return (Criteria) this;
        }

        public Criteria andTicketOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ticket_out_time >=", value, "ticketOutTime");
            return (Criteria) this;
        }

        public Criteria andTicketOutTimeLessThan(Date value) {
            addCriterion("ticket_out_time <", value, "ticketOutTime");
            return (Criteria) this;
        }

        public Criteria andTicketOutTimeLessThanOrEqualTo(Date value) {
            addCriterion("ticket_out_time <=", value, "ticketOutTime");
            return (Criteria) this;
        }

        public Criteria andTicketOutTimeIn(List<Date> values) {
            addCriterion("ticket_out_time in", values, "ticketOutTime");
            return (Criteria) this;
        }

        public Criteria andTicketOutTimeNotIn(List<Date> values) {
            addCriterion("ticket_out_time not in", values, "ticketOutTime");
            return (Criteria) this;
        }

        public Criteria andTicketOutTimeBetween(Date value1, Date value2) {
            addCriterion("ticket_out_time between", value1, value2, "ticketOutTime");
            return (Criteria) this;
        }

        public Criteria andTicketOutTimeNotBetween(Date value1, Date value2) {
            addCriterion("ticket_out_time not between", value1, value2, "ticketOutTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andOfficeIdIsNull() {
            addCriterion("office_id is null");
            return (Criteria) this;
        }

        public Criteria andOfficeIdIsNotNull() {
            addCriterion("office_id is not null");
            return (Criteria) this;
        }

        public Criteria andOfficeIdEqualTo(Integer value) {
            addCriterion("office_id =", value, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdNotEqualTo(Integer value) {
            addCriterion("office_id <>", value, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdGreaterThan(Integer value) {
            addCriterion("office_id >", value, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("office_id >=", value, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdLessThan(Integer value) {
            addCriterion("office_id <", value, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdLessThanOrEqualTo(Integer value) {
            addCriterion("office_id <=", value, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdIn(List<Integer> values) {
            addCriterion("office_id in", values, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdNotIn(List<Integer> values) {
            addCriterion("office_id not in", values, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdBetween(Integer value1, Integer value2) {
            addCriterion("office_id between", value1, value2, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("office_id not between", value1, value2, "officeId");
            return (Criteria) this;
        }

        public Criteria andOpenCardTimeIsNull() {
            addCriterion("open_card_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenCardTimeIsNotNull() {
            addCriterion("open_card_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenCardTimeEqualTo(Date value) {
            addCriterion("open_card_time =", value, "openCardTime");
            return (Criteria) this;
        }

        public Criteria andOpenCardTimeNotEqualTo(Date value) {
            addCriterion("open_card_time <>", value, "openCardTime");
            return (Criteria) this;
        }

        public Criteria andOpenCardTimeGreaterThan(Date value) {
            addCriterion("open_card_time >", value, "openCardTime");
            return (Criteria) this;
        }

        public Criteria andOpenCardTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("open_card_time >=", value, "openCardTime");
            return (Criteria) this;
        }

        public Criteria andOpenCardTimeLessThan(Date value) {
            addCriterion("open_card_time <", value, "openCardTime");
            return (Criteria) this;
        }

        public Criteria andOpenCardTimeLessThanOrEqualTo(Date value) {
            addCriterion("open_card_time <=", value, "openCardTime");
            return (Criteria) this;
        }

        public Criteria andOpenCardTimeIn(List<Date> values) {
            addCriterion("open_card_time in", values, "openCardTime");
            return (Criteria) this;
        }

        public Criteria andOpenCardTimeNotIn(List<Date> values) {
            addCriterion("open_card_time not in", values, "openCardTime");
            return (Criteria) this;
        }

        public Criteria andOpenCardTimeBetween(Date value1, Date value2) {
            addCriterion("open_card_time between", value1, value2, "openCardTime");
            return (Criteria) this;
        }

        public Criteria andOpenCardTimeNotBetween(Date value1, Date value2) {
            addCriterion("open_card_time not between", value1, value2, "openCardTime");
            return (Criteria) this;
        }

        public Criteria andInvalidateTimeIsNull() {
            addCriterion("invalidate_time is null");
            return (Criteria) this;
        }

        public Criteria andInvalidateTimeIsNotNull() {
            addCriterion("invalidate_time is not null");
            return (Criteria) this;
        }

        public Criteria andInvalidateTimeEqualTo(Date value) {
            addCriterion("invalidate_time =", value, "invalidateTime");
            return (Criteria) this;
        }

        public Criteria andInvalidateTimeNotEqualTo(Date value) {
            addCriterion("invalidate_time <>", value, "invalidateTime");
            return (Criteria) this;
        }

        public Criteria andInvalidateTimeGreaterThan(Date value) {
            addCriterion("invalidate_time >", value, "invalidateTime");
            return (Criteria) this;
        }

        public Criteria andInvalidateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("invalidate_time >=", value, "invalidateTime");
            return (Criteria) this;
        }

        public Criteria andInvalidateTimeLessThan(Date value) {
            addCriterion("invalidate_time <", value, "invalidateTime");
            return (Criteria) this;
        }

        public Criteria andInvalidateTimeLessThanOrEqualTo(Date value) {
            addCriterion("invalidate_time <=", value, "invalidateTime");
            return (Criteria) this;
        }

        public Criteria andInvalidateTimeIn(List<Date> values) {
            addCriterion("invalidate_time in", values, "invalidateTime");
            return (Criteria) this;
        }

        public Criteria andInvalidateTimeNotIn(List<Date> values) {
            addCriterion("invalidate_time not in", values, "invalidateTime");
            return (Criteria) this;
        }

        public Criteria andInvalidateTimeBetween(Date value1, Date value2) {
            addCriterion("invalidate_time between", value1, value2, "invalidateTime");
            return (Criteria) this;
        }

        public Criteria andInvalidateTimeNotBetween(Date value1, Date value2) {
            addCriterion("invalidate_time not between", value1, value2, "invalidateTime");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Integer value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Integer value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Integer value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Integer value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Integer> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Integer> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }
    }

    /**
     */
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