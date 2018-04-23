package com.kaishengit.tms.entity.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketOfficeInfermationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public TicketOfficeInfermationExample() {
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

        public Criteria andOfficeNameIsNull() {
            addCriterion("office_name is null");
            return (Criteria) this;
        }

        public Criteria andOfficeNameIsNotNull() {
            addCriterion("office_name is not null");
            return (Criteria) this;
        }

        public Criteria andOfficeNameEqualTo(String value) {
            addCriterion("office_name =", value, "officeName");
            return (Criteria) this;
        }

        public Criteria andOfficeNameNotEqualTo(String value) {
            addCriterion("office_name <>", value, "officeName");
            return (Criteria) this;
        }

        public Criteria andOfficeNameGreaterThan(String value) {
            addCriterion("office_name >", value, "officeName");
            return (Criteria) this;
        }

        public Criteria andOfficeNameGreaterThanOrEqualTo(String value) {
            addCriterion("office_name >=", value, "officeName");
            return (Criteria) this;
        }

        public Criteria andOfficeNameLessThan(String value) {
            addCriterion("office_name <", value, "officeName");
            return (Criteria) this;
        }

        public Criteria andOfficeNameLessThanOrEqualTo(String value) {
            addCriterion("office_name <=", value, "officeName");
            return (Criteria) this;
        }

        public Criteria andOfficeNameLike(String value) {
            addCriterion("office_name like", value, "officeName");
            return (Criteria) this;
        }

        public Criteria andOfficeNameNotLike(String value) {
            addCriterion("office_name not like", value, "officeName");
            return (Criteria) this;
        }

        public Criteria andOfficeNameIn(List<String> values) {
            addCriterion("office_name in", values, "officeName");
            return (Criteria) this;
        }

        public Criteria andOfficeNameNotIn(List<String> values) {
            addCriterion("office_name not in", values, "officeName");
            return (Criteria) this;
        }

        public Criteria andOfficeNameBetween(String value1, String value2) {
            addCriterion("office_name between", value1, value2, "officeName");
            return (Criteria) this;
        }

        public Criteria andOfficeNameNotBetween(String value1, String value2) {
            addCriterion("office_name not between", value1, value2, "officeName");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressIsNull() {
            addCriterion("office_address is null");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressIsNotNull() {
            addCriterion("office_address is not null");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressEqualTo(String value) {
            addCriterion("office_address =", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressNotEqualTo(String value) {
            addCriterion("office_address <>", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressGreaterThan(String value) {
            addCriterion("office_address >", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressGreaterThanOrEqualTo(String value) {
            addCriterion("office_address >=", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressLessThan(String value) {
            addCriterion("office_address <", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressLessThanOrEqualTo(String value) {
            addCriterion("office_address <=", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressLike(String value) {
            addCriterion("office_address like", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressNotLike(String value) {
            addCriterion("office_address not like", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressIn(List<String> values) {
            addCriterion("office_address in", values, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressNotIn(List<String> values) {
            addCriterion("office_address not in", values, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressBetween(String value1, String value2) {
            addCriterion("office_address between", value1, value2, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressNotBetween(String value1, String value2) {
            addCriterion("office_address not between", value1, value2, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameIsNull() {
            addCriterion("legal_person_name is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameIsNotNull() {
            addCriterion("legal_person_name is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameEqualTo(String value) {
            addCriterion("legal_person_name =", value, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameNotEqualTo(String value) {
            addCriterion("legal_person_name <>", value, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameGreaterThan(String value) {
            addCriterion("legal_person_name >", value, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person_name >=", value, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameLessThan(String value) {
            addCriterion("legal_person_name <", value, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameLessThanOrEqualTo(String value) {
            addCriterion("legal_person_name <=", value, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameLike(String value) {
            addCriterion("legal_person_name like", value, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameNotLike(String value) {
            addCriterion("legal_person_name not like", value, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameIn(List<String> values) {
            addCriterion("legal_person_name in", values, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameNotIn(List<String> values) {
            addCriterion("legal_person_name not in", values, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameBetween(String value1, String value2) {
            addCriterion("legal_person_name between", value1, value2, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameNotBetween(String value1, String value2) {
            addCriterion("legal_person_name not between", value1, value2, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonMobileIsNull() {
            addCriterion("legal_person_mobile is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonMobileIsNotNull() {
            addCriterion("legal_person_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonMobileEqualTo(String value) {
            addCriterion("legal_person_mobile =", value, "legalPersonMobile");
            return (Criteria) this;
        }

        public Criteria andLegalPersonMobileNotEqualTo(String value) {
            addCriterion("legal_person_mobile <>", value, "legalPersonMobile");
            return (Criteria) this;
        }

        public Criteria andLegalPersonMobileGreaterThan(String value) {
            addCriterion("legal_person_mobile >", value, "legalPersonMobile");
            return (Criteria) this;
        }

        public Criteria andLegalPersonMobileGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person_mobile >=", value, "legalPersonMobile");
            return (Criteria) this;
        }

        public Criteria andLegalPersonMobileLessThan(String value) {
            addCriterion("legal_person_mobile <", value, "legalPersonMobile");
            return (Criteria) this;
        }

        public Criteria andLegalPersonMobileLessThanOrEqualTo(String value) {
            addCriterion("legal_person_mobile <=", value, "legalPersonMobile");
            return (Criteria) this;
        }

        public Criteria andLegalPersonMobileLike(String value) {
            addCriterion("legal_person_mobile like", value, "legalPersonMobile");
            return (Criteria) this;
        }

        public Criteria andLegalPersonMobileNotLike(String value) {
            addCriterion("legal_person_mobile not like", value, "legalPersonMobile");
            return (Criteria) this;
        }

        public Criteria andLegalPersonMobileIn(List<String> values) {
            addCriterion("legal_person_mobile in", values, "legalPersonMobile");
            return (Criteria) this;
        }

        public Criteria andLegalPersonMobileNotIn(List<String> values) {
            addCriterion("legal_person_mobile not in", values, "legalPersonMobile");
            return (Criteria) this;
        }

        public Criteria andLegalPersonMobileBetween(String value1, String value2) {
            addCriterion("legal_person_mobile between", value1, value2, "legalPersonMobile");
            return (Criteria) this;
        }

        public Criteria andLegalPersonMobileNotBetween(String value1, String value2) {
            addCriterion("legal_person_mobile not between", value1, value2, "legalPersonMobile");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLicenseIsNull() {
            addCriterion("ticket_office_license is null");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLicenseIsNotNull() {
            addCriterion("ticket_office_license is not null");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLicenseEqualTo(String value) {
            addCriterion("ticket_office_license =", value, "ticketOfficeLicense");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLicenseNotEqualTo(String value) {
            addCriterion("ticket_office_license <>", value, "ticketOfficeLicense");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLicenseGreaterThan(String value) {
            addCriterion("ticket_office_license >", value, "ticketOfficeLicense");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_office_license >=", value, "ticketOfficeLicense");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLicenseLessThan(String value) {
            addCriterion("ticket_office_license <", value, "ticketOfficeLicense");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLicenseLessThanOrEqualTo(String value) {
            addCriterion("ticket_office_license <=", value, "ticketOfficeLicense");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLicenseLike(String value) {
            addCriterion("ticket_office_license like", value, "ticketOfficeLicense");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLicenseNotLike(String value) {
            addCriterion("ticket_office_license not like", value, "ticketOfficeLicense");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLicenseIn(List<String> values) {
            addCriterion("ticket_office_license in", values, "ticketOfficeLicense");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLicenseNotIn(List<String> values) {
            addCriterion("ticket_office_license not in", values, "ticketOfficeLicense");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLicenseBetween(String value1, String value2) {
            addCriterion("ticket_office_license between", value1, value2, "ticketOfficeLicense");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLicenseNotBetween(String value1, String value2) {
            addCriterion("ticket_office_license not between", value1, value2, "ticketOfficeLicense");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardUpIsNull() {
            addCriterion("legal_person_card_up is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardUpIsNotNull() {
            addCriterion("legal_person_card_up is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardUpEqualTo(String value) {
            addCriterion("legal_person_card_up =", value, "legalPersonCardUp");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardUpNotEqualTo(String value) {
            addCriterion("legal_person_card_up <>", value, "legalPersonCardUp");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardUpGreaterThan(String value) {
            addCriterion("legal_person_card_up >", value, "legalPersonCardUp");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardUpGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person_card_up >=", value, "legalPersonCardUp");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardUpLessThan(String value) {
            addCriterion("legal_person_card_up <", value, "legalPersonCardUp");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardUpLessThanOrEqualTo(String value) {
            addCriterion("legal_person_card_up <=", value, "legalPersonCardUp");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardUpLike(String value) {
            addCriterion("legal_person_card_up like", value, "legalPersonCardUp");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardUpNotLike(String value) {
            addCriterion("legal_person_card_up not like", value, "legalPersonCardUp");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardUpIn(List<String> values) {
            addCriterion("legal_person_card_up in", values, "legalPersonCardUp");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardUpNotIn(List<String> values) {
            addCriterion("legal_person_card_up not in", values, "legalPersonCardUp");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardUpBetween(String value1, String value2) {
            addCriterion("legal_person_card_up between", value1, value2, "legalPersonCardUp");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardUpNotBetween(String value1, String value2) {
            addCriterion("legal_person_card_up not between", value1, value2, "legalPersonCardUp");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardDownIsNull() {
            addCriterion("legal_person_card_down is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardDownIsNotNull() {
            addCriterion("legal_person_card_down is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardDownEqualTo(String value) {
            addCriterion("legal_person_card_down =", value, "legalPersonCardDown");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardDownNotEqualTo(String value) {
            addCriterion("legal_person_card_down <>", value, "legalPersonCardDown");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardDownGreaterThan(String value) {
            addCriterion("legal_person_card_down >", value, "legalPersonCardDown");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardDownGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person_card_down >=", value, "legalPersonCardDown");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardDownLessThan(String value) {
            addCriterion("legal_person_card_down <", value, "legalPersonCardDown");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardDownLessThanOrEqualTo(String value) {
            addCriterion("legal_person_card_down <=", value, "legalPersonCardDown");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardDownLike(String value) {
            addCriterion("legal_person_card_down like", value, "legalPersonCardDown");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardDownNotLike(String value) {
            addCriterion("legal_person_card_down not like", value, "legalPersonCardDown");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardDownIn(List<String> values) {
            addCriterion("legal_person_card_down in", values, "legalPersonCardDown");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardDownNotIn(List<String> values) {
            addCriterion("legal_person_card_down not in", values, "legalPersonCardDown");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardDownBetween(String value1, String value2) {
            addCriterion("legal_person_card_down between", value1, value2, "legalPersonCardDown");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardDownNotBetween(String value1, String value2) {
            addCriterion("legal_person_card_down not between", value1, value2, "legalPersonCardDown");
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

        public Criteria andTicketOfficeLongitudeIsNull() {
            addCriterion("ticket_office_longitude is null");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLongitudeIsNotNull() {
            addCriterion("ticket_office_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLongitudeEqualTo(String value) {
            addCriterion("ticket_office_longitude =", value, "ticketOfficeLongitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLongitudeNotEqualTo(String value) {
            addCriterion("ticket_office_longitude <>", value, "ticketOfficeLongitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLongitudeGreaterThan(String value) {
            addCriterion("ticket_office_longitude >", value, "ticketOfficeLongitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_office_longitude >=", value, "ticketOfficeLongitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLongitudeLessThan(String value) {
            addCriterion("ticket_office_longitude <", value, "ticketOfficeLongitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLongitudeLessThanOrEqualTo(String value) {
            addCriterion("ticket_office_longitude <=", value, "ticketOfficeLongitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLongitudeLike(String value) {
            addCriterion("ticket_office_longitude like", value, "ticketOfficeLongitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLongitudeNotLike(String value) {
            addCriterion("ticket_office_longitude not like", value, "ticketOfficeLongitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLongitudeIn(List<String> values) {
            addCriterion("ticket_office_longitude in", values, "ticketOfficeLongitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLongitudeNotIn(List<String> values) {
            addCriterion("ticket_office_longitude not in", values, "ticketOfficeLongitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLongitudeBetween(String value1, String value2) {
            addCriterion("ticket_office_longitude between", value1, value2, "ticketOfficeLongitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLongitudeNotBetween(String value1, String value2) {
            addCriterion("ticket_office_longitude not between", value1, value2, "ticketOfficeLongitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLatitudeIsNull() {
            addCriterion("ticket_office_latitude is null");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLatitudeIsNotNull() {
            addCriterion("ticket_office_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLatitudeEqualTo(String value) {
            addCriterion("ticket_office_latitude =", value, "ticketOfficeLatitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLatitudeNotEqualTo(String value) {
            addCriterion("ticket_office_latitude <>", value, "ticketOfficeLatitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLatitudeGreaterThan(String value) {
            addCriterion("ticket_office_latitude >", value, "ticketOfficeLatitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_office_latitude >=", value, "ticketOfficeLatitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLatitudeLessThan(String value) {
            addCriterion("ticket_office_latitude <", value, "ticketOfficeLatitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLatitudeLessThanOrEqualTo(String value) {
            addCriterion("ticket_office_latitude <=", value, "ticketOfficeLatitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLatitudeLike(String value) {
            addCriterion("ticket_office_latitude like", value, "ticketOfficeLatitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLatitudeNotLike(String value) {
            addCriterion("ticket_office_latitude not like", value, "ticketOfficeLatitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLatitudeIn(List<String> values) {
            addCriterion("ticket_office_latitude in", values, "ticketOfficeLatitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLatitudeNotIn(List<String> values) {
            addCriterion("ticket_office_latitude not in", values, "ticketOfficeLatitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLatitudeBetween(String value1, String value2) {
            addCriterion("ticket_office_latitude between", value1, value2, "ticketOfficeLatitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeLatitudeNotBetween(String value1, String value2) {
            addCriterion("ticket_office_latitude not between", value1, value2, "ticketOfficeLatitude");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeStatusIsNull() {
            addCriterion("ticket_office_status is null");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeStatusIsNotNull() {
            addCriterion("ticket_office_status is not null");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeStatusEqualTo(String value) {
            addCriterion("ticket_office_status =", value, "ticketOfficeStatus");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeStatusNotEqualTo(String value) {
            addCriterion("ticket_office_status <>", value, "ticketOfficeStatus");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeStatusGreaterThan(String value) {
            addCriterion("ticket_office_status >", value, "ticketOfficeStatus");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_office_status >=", value, "ticketOfficeStatus");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeStatusLessThan(String value) {
            addCriterion("ticket_office_status <", value, "ticketOfficeStatus");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeStatusLessThanOrEqualTo(String value) {
            addCriterion("ticket_office_status <=", value, "ticketOfficeStatus");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeStatusLike(String value) {
            addCriterion("ticket_office_status like", value, "ticketOfficeStatus");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeStatusNotLike(String value) {
            addCriterion("ticket_office_status not like", value, "ticketOfficeStatus");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeStatusIn(List<String> values) {
            addCriterion("ticket_office_status in", values, "ticketOfficeStatus");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeStatusNotIn(List<String> values) {
            addCriterion("ticket_office_status not in", values, "ticketOfficeStatus");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeStatusBetween(String value1, String value2) {
            addCriterion("ticket_office_status between", value1, value2, "ticketOfficeStatus");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeStatusNotBetween(String value1, String value2) {
            addCriterion("ticket_office_status not between", value1, value2, "ticketOfficeStatus");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeCommentIsNull() {
            addCriterion("ticket_office_comment is null");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeCommentIsNotNull() {
            addCriterion("ticket_office_comment is not null");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeCommentEqualTo(String value) {
            addCriterion("ticket_office_comment =", value, "ticketOfficeComment");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeCommentNotEqualTo(String value) {
            addCriterion("ticket_office_comment <>", value, "ticketOfficeComment");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeCommentGreaterThan(String value) {
            addCriterion("ticket_office_comment >", value, "ticketOfficeComment");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeCommentGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_office_comment >=", value, "ticketOfficeComment");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeCommentLessThan(String value) {
            addCriterion("ticket_office_comment <", value, "ticketOfficeComment");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeCommentLessThanOrEqualTo(String value) {
            addCriterion("ticket_office_comment <=", value, "ticketOfficeComment");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeCommentLike(String value) {
            addCriterion("ticket_office_comment like", value, "ticketOfficeComment");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeCommentNotLike(String value) {
            addCriterion("ticket_office_comment not like", value, "ticketOfficeComment");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeCommentIn(List<String> values) {
            addCriterion("ticket_office_comment in", values, "ticketOfficeComment");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeCommentNotIn(List<String> values) {
            addCriterion("ticket_office_comment not in", values, "ticketOfficeComment");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeCommentBetween(String value1, String value2) {
            addCriterion("ticket_office_comment between", value1, value2, "ticketOfficeComment");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeCommentNotBetween(String value1, String value2) {
            addCriterion("ticket_office_comment not between", value1, value2, "ticketOfficeComment");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeAccountIdIsNull() {
            addCriterion("ticket_office_account_id is null");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeAccountIdIsNotNull() {
            addCriterion("ticket_office_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeAccountIdEqualTo(Integer value) {
            addCriterion("ticket_office_account_id =", value, "ticketOfficeAccountId");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeAccountIdNotEqualTo(Integer value) {
            addCriterion("ticket_office_account_id <>", value, "ticketOfficeAccountId");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeAccountIdGreaterThan(Integer value) {
            addCriterion("ticket_office_account_id >", value, "ticketOfficeAccountId");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ticket_office_account_id >=", value, "ticketOfficeAccountId");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeAccountIdLessThan(Integer value) {
            addCriterion("ticket_office_account_id <", value, "ticketOfficeAccountId");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("ticket_office_account_id <=", value, "ticketOfficeAccountId");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeAccountIdIn(List<Integer> values) {
            addCriterion("ticket_office_account_id in", values, "ticketOfficeAccountId");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeAccountIdNotIn(List<Integer> values) {
            addCriterion("ticket_office_account_id not in", values, "ticketOfficeAccountId");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("ticket_office_account_id between", value1, value2, "ticketOfficeAccountId");
            return (Criteria) this;
        }

        public Criteria andTicketOfficeAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ticket_office_account_id not between", value1, value2, "ticketOfficeAccountId");
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