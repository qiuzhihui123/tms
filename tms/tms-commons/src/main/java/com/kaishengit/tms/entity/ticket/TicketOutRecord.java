package com.kaishengit.tms.entity.ticket;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ticket_out_record
 * @author 
 */
public class TicketOutRecord implements Serializable {

    public static final String NON_PAYMENT_STATUS="未支付";

    public static final String HAVE_PAID_STATUS="已支付";



    //单页显示的条数
    public static final Integer PAGE_SIZE = 15;

    /**
     * 下发记录的主键
     */
    private Integer id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 下发年票的人员，引用了account表
     */
    private Integer outAccountId;

    /**
     * 下发人姓名
     */
    private String outAccountName;

    /**
     * 下发的起始票号
     */
    private String startTicketNum;

    /**
     * 下发的结束票号
     */
    private String endTicketNum;

    /**
     * 下发的总数量
     */
    private Integer totalNum;

    /**
     * 下发单价
     */
    private BigDecimal price;

    /**
     * 总价
     */
    private BigDecimal totalPrice;

    /**
     * 状态，已支付或者未支付
     */
    private String status;

    /**
     * 下发该组年票给该字段引用的售票点id
     */
    private Integer officeId;

    /**
     * 售票点名称
     */
    private String officeName;

    /**
     * 收款人的id,引用accout表
     */
    private Integer financeAccountId;

    /**
     * 收款人姓名
     */
    private String financeAccountName;

    /**
     * 支付方式，现金或者刷卡
     */
    private String payType;

    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getOutAccountId() {
        return outAccountId;
    }

    public void setOutAccountId(Integer outAccountId) {
        this.outAccountId = outAccountId;
    }

    public String getOutAccountName() {
        return outAccountName;
    }

    public void setOutAccountName(String outAccountName) {
        this.outAccountName = outAccountName;
    }

    public String getStartTicketNum() {
        return startTicketNum;
    }

    public void setStartTicketNum(String startTicketNum) {
        this.startTicketNum = startTicketNum;
    }

    public String getEndTicketNum() {
        return endTicketNum;
    }

    public void setEndTicketNum(String endTicketNum) {
        this.endTicketNum = endTicketNum;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public Integer getFinanceAccountId() {
        return financeAccountId;
    }

    public void setFinanceAccountId(Integer financeAccountId) {
        this.financeAccountId = financeAccountId;
    }

    public String getFinanceAccountName() {
        return financeAccountName;
    }

    public void setFinanceAccountName(String financeAccountName) {
        this.financeAccountName = financeAccountName;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        TicketOutRecord other = (TicketOutRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getOutAccountId() == null ? other.getOutAccountId() == null : this.getOutAccountId().equals(other.getOutAccountId()))
            && (this.getOutAccountName() == null ? other.getOutAccountName() == null : this.getOutAccountName().equals(other.getOutAccountName()))
            && (this.getStartTicketNum() == null ? other.getStartTicketNum() == null : this.getStartTicketNum().equals(other.getStartTicketNum()))
            && (this.getEndTicketNum() == null ? other.getEndTicketNum() == null : this.getEndTicketNum().equals(other.getEndTicketNum()))
            && (this.getTotalNum() == null ? other.getTotalNum() == null : this.getTotalNum().equals(other.getTotalNum()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getTotalPrice() == null ? other.getTotalPrice() == null : this.getTotalPrice().equals(other.getTotalPrice()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getOfficeId() == null ? other.getOfficeId() == null : this.getOfficeId().equals(other.getOfficeId()))
            && (this.getOfficeName() == null ? other.getOfficeName() == null : this.getOfficeName().equals(other.getOfficeName()))
            && (this.getFinanceAccountId() == null ? other.getFinanceAccountId() == null : this.getFinanceAccountId().equals(other.getFinanceAccountId()))
            && (this.getFinanceAccountName() == null ? other.getFinanceAccountName() == null : this.getFinanceAccountName().equals(other.getFinanceAccountName()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getOutAccountId() == null) ? 0 : getOutAccountId().hashCode());
        result = prime * result + ((getOutAccountName() == null) ? 0 : getOutAccountName().hashCode());
        result = prime * result + ((getStartTicketNum() == null) ? 0 : getStartTicketNum().hashCode());
        result = prime * result + ((getEndTicketNum() == null) ? 0 : getEndTicketNum().hashCode());
        result = prime * result + ((getTotalNum() == null) ? 0 : getTotalNum().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getTotalPrice() == null) ? 0 : getTotalPrice().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getOfficeId() == null) ? 0 : getOfficeId().hashCode());
        result = prime * result + ((getOfficeName() == null) ? 0 : getOfficeName().hashCode());
        result = prime * result + ((getFinanceAccountId() == null) ? 0 : getFinanceAccountId().hashCode());
        result = prime * result + ((getFinanceAccountName() == null) ? 0 : getFinanceAccountName().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", outAccountId=").append(outAccountId);
        sb.append(", outAccountName=").append(outAccountName);
        sb.append(", startTicketNum=").append(startTicketNum);
        sb.append(", endTicketNum=").append(endTicketNum);
        sb.append(", totalNum=").append(totalNum);
        sb.append(", price=").append(price);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", status=").append(status);
        sb.append(", officeId=").append(officeId);
        sb.append(", officeName=").append(officeName);
        sb.append(", financeAccountId=").append(financeAccountId);
        sb.append(", financeAccountName=").append(financeAccountName);
        sb.append(", payType=").append(payType);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}