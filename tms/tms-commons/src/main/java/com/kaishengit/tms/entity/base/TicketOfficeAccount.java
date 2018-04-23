package com.kaishengit.tms.entity.base;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *@Description:售票点帐号对象
 *@Author: 邱志辉
 *@Date 2016/4/20 0020下午 2:32
 */
public class TicketOfficeAccount implements Serializable {

    public static final String ACCOUNT_NOMAL_STATUS="正常";
    public static final String ACCOUNT_FORBIDDEN_STATUS="禁用";
    //false表示未虚拟删除
    public static final boolean ACCOUNT_IS_DELETED=false;
    //true表示已经进行虚拟删除
    public static final boolean ACCOUNT_IS_NOT_DELETED=true;

    /**
     * 售票点帐号主键
     */
    private Integer id;

    private String ticketOfficeAccountName;

    private String ticketOfficeAccountPassword;

    /**
     * 创建时间
     */
    private Date createTime;

    private Date updateTime;

    /**
     * 帐号状态
     */
    private String status;


    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    /**
     * 判断帐号虚拟删除，如果为0表示为未删除，如果为1，表示为已删除
     */
    private boolean isDeleted;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTicketOfficeAccountName() {
        return ticketOfficeAccountName;
    }

    public void setTicketOfficeAccountName(String ticketOfficeAccountName) {
        this.ticketOfficeAccountName = ticketOfficeAccountName;
    }

    public String getTicketOfficeAccountPassword() {
        return ticketOfficeAccountPassword;
    }

    public void setTicketOfficeAccountPassword(String ticketOfficeAccountPassword) {
        this.ticketOfficeAccountPassword = ticketOfficeAccountPassword;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TicketOfficeAccount)) {
            return false;
        }
        TicketOfficeAccount that = (TicketOfficeAccount) o;
        return isDeleted() == that.isDeleted() &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getTicketOfficeAccountName(), that.getTicketOfficeAccountName()) &&
                Objects.equals(getTicketOfficeAccountPassword(), that.getTicketOfficeAccountPassword()) &&
                Objects.equals(getCreateTime(), that.getCreateTime()) &&
                Objects.equals(getUpdateTime(), that.getUpdateTime()) &&
                Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getTicketOfficeAccountName(), getTicketOfficeAccountPassword(), getCreateTime(), getUpdateTime(), getStatus(), isDeleted());
    }

    @Override
    public String toString() {
        return "TicketOfficeAccount{" +
                "id=" + id +
                ", ticketOfficeAccountName='" + ticketOfficeAccountName + '\'' +
                ", ticketOfficeAccountPassword='" + ticketOfficeAccountPassword + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status='" + status + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}