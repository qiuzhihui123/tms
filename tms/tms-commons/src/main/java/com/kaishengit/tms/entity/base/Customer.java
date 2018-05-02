package com.kaishengit.tms.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * customer
 * @author 
 */
public class Customer implements Serializable {
    /**
     * id
     */
    private Long id;

    private BigDecimal ticketPrice;

    /**
     * 顾客姓名
     */
    private String customerName;

    /**
     * 身份证号
     */
    private String identityNum;

    /**
     * 身份证正面照片地址
     */
    private String identityUp;

    /**
     * 身份证背面地址
     */
    private String identityDown;

    /**
     * 2寸照片地址
     */
    private String customerPhoto;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 联系电话
     */
    private String customerMobile;

    /**
     * 顾客住址
     */
    private String customerAddress;

    /**
     * 年票id
     */
    private Long ticketId;

    private Integer customerAge;

    private String customerSex;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIdentityNum() {
        return identityNum;
    }

    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum;
    }

    public String getIdentityUp() {
        return identityUp;
    }

    public void setIdentityUp(String identityUp) {
        this.identityUp = identityUp;
    }

    public String getIdentityDown() {
        return identityDown;
    }

    public void setIdentityDown(String identityDown) {
        this.identityDown = identityDown;
    }

    public String getCustomerPhoto() {
        return customerPhoto;
    }

    public void setCustomerPhoto(String customerPhoto) {
        this.customerPhoto = customerPhoto;
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

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(Integer customerAge) {
        this.customerAge = customerAge;
    }

    public String getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(String customerSex) {
        this.customerSex = customerSex;
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
        Customer other = (Customer) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTicketPrice() == null ? other.getTicketPrice() == null : this.getTicketPrice().equals(other.getTicketPrice()))
            && (this.getCustomerName() == null ? other.getCustomerName() == null : this.getCustomerName().equals(other.getCustomerName()))
            && (this.getIdentityNum() == null ? other.getIdentityNum() == null : this.getIdentityNum().equals(other.getIdentityNum()))
            && (this.getIdentityUp() == null ? other.getIdentityUp() == null : this.getIdentityUp().equals(other.getIdentityUp()))
            && (this.getIdentityDown() == null ? other.getIdentityDown() == null : this.getIdentityDown().equals(other.getIdentityDown()))
            && (this.getCustomerPhoto() == null ? other.getCustomerPhoto() == null : this.getCustomerPhoto().equals(other.getCustomerPhoto()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCustomerMobile() == null ? other.getCustomerMobile() == null : this.getCustomerMobile().equals(other.getCustomerMobile()))
            && (this.getCustomerAddress() == null ? other.getCustomerAddress() == null : this.getCustomerAddress().equals(other.getCustomerAddress()))
            && (this.getTicketId() == null ? other.getTicketId() == null : this.getTicketId().equals(other.getTicketId()))
            && (this.getCustomerAge() == null ? other.getCustomerAge() == null : this.getCustomerAge().equals(other.getCustomerAge()))
            && (this.getCustomerSex() == null ? other.getCustomerSex() == null : this.getCustomerSex().equals(other.getCustomerSex()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTicketPrice() == null) ? 0 : getTicketPrice().hashCode());
        result = prime * result + ((getCustomerName() == null) ? 0 : getCustomerName().hashCode());
        result = prime * result + ((getIdentityNum() == null) ? 0 : getIdentityNum().hashCode());
        result = prime * result + ((getIdentityUp() == null) ? 0 : getIdentityUp().hashCode());
        result = prime * result + ((getIdentityDown() == null) ? 0 : getIdentityDown().hashCode());
        result = prime * result + ((getCustomerPhoto() == null) ? 0 : getCustomerPhoto().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCustomerMobile() == null) ? 0 : getCustomerMobile().hashCode());
        result = prime * result + ((getCustomerAddress() == null) ? 0 : getCustomerAddress().hashCode());
        result = prime * result + ((getTicketId() == null) ? 0 : getTicketId().hashCode());
        result = prime * result + ((getCustomerAge() == null) ? 0 : getCustomerAge().hashCode());
        result = prime * result + ((getCustomerSex() == null) ? 0 : getCustomerSex().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ticketPrice=").append(ticketPrice);
        sb.append(", customerName=").append(customerName);
        sb.append(", identityNum=").append(identityNum);
        sb.append(", identityUp=").append(identityUp);
        sb.append(", identityDown=").append(identityDown);
        sb.append(", customerPhoto=").append(customerPhoto);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", customerMobile=").append(customerMobile);
        sb.append(", customerAddress=").append(customerAddress);
        sb.append(", ticketId=").append(ticketId);
        sb.append(", customerAge=").append(customerAge);
        sb.append(", customerSex=").append(customerSex);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}