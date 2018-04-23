package com.kaishengit.tms.entity.ticket;

import java.io.Serializable;
import java.util.Date;

/**
 * ticket
 * @author 
 */
public class Ticket implements Serializable {

    public static final String TICKET_STATE_IN_STORE = "已入库";
    public static final String TICKET_STATE_OUT_STORE = "已下发";
    public static final String TICKET_STATE_SALE = "已销售";
    public static final String TICKET_STATE_LOST = "已挂失";
    public static final String TICKET_STATE_OUT_DATE = "已过期";

    /**
     * 年票id
     */
    private Long id;

    /**
     * 票号
     */
    private String ticketNum;

    /**
     * 入库时间
     */
    private Date ticketInTime;

    /**
     * 出库时间
     */
    private Date ticketOutTime;

    /**
     * 年票状态
     */
    private String status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 销售点id
     */
    private Integer officeId;

    /**
     * 开卡时间
     */
    private Date openCardTime;

    /**
     * 截至时间
     */
    private Date invalidateTime;

    /**
     * 办卡顾客id
     */
    private Integer customerId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(String ticketNum) {
        this.ticketNum = ticketNum;
    }

    public Date getTicketInTime() {
        return ticketInTime;
    }

    public void setTicketInTime(Date ticketInTime) {
        this.ticketInTime = ticketInTime;
    }

    public Date getTicketOutTime() {
        return ticketOutTime;
    }

    public void setTicketOutTime(Date ticketOutTime) {
        this.ticketOutTime = ticketOutTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public Date getOpenCardTime() {
        return openCardTime;
    }

    public void setOpenCardTime(Date openCardTime) {
        this.openCardTime = openCardTime;
    }

    public Date getInvalidateTime() {
        return invalidateTime;
    }

    public void setInvalidateTime(Date invalidateTime) {
        this.invalidateTime = invalidateTime;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Ticket other = (Ticket) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTicketNum() == null ? other.getTicketNum() == null : this.getTicketNum().equals(other.getTicketNum()))
            && (this.getTicketInTime() == null ? other.getTicketInTime() == null : this.getTicketInTime().equals(other.getTicketInTime()))
            && (this.getTicketOutTime() == null ? other.getTicketOutTime() == null : this.getTicketOutTime().equals(other.getTicketOutTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getOfficeId() == null ? other.getOfficeId() == null : this.getOfficeId().equals(other.getOfficeId()))
            && (this.getOpenCardTime() == null ? other.getOpenCardTime() == null : this.getOpenCardTime().equals(other.getOpenCardTime()))
            && (this.getInvalidateTime() == null ? other.getInvalidateTime() == null : this.getInvalidateTime().equals(other.getInvalidateTime()))
            && (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTicketNum() == null) ? 0 : getTicketNum().hashCode());
        result = prime * result + ((getTicketInTime() == null) ? 0 : getTicketInTime().hashCode());
        result = prime * result + ((getTicketOutTime() == null) ? 0 : getTicketOutTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getOfficeId() == null) ? 0 : getOfficeId().hashCode());
        result = prime * result + ((getOpenCardTime() == null) ? 0 : getOpenCardTime().hashCode());
        result = prime * result + ((getInvalidateTime() == null) ? 0 : getInvalidateTime().hashCode());
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ticketNum=").append(ticketNum);
        sb.append(", ticketInTime=").append(ticketInTime);
        sb.append(", ticketOutTime=").append(ticketOutTime);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", officeId=").append(officeId);
        sb.append(", openCardTime=").append(openCardTime);
        sb.append(", invalidateTime=").append(invalidateTime);
        sb.append(", customerId=").append(customerId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}