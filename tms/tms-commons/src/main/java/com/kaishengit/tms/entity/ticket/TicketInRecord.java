package com.kaishengit.tms.entity.ticket;

import java.io.Serializable;
import java.util.Date;

/**
 * ticket_in_record
 * @author 
 */
public class TicketInRecord implements Serializable {

    public static final Integer PAGE_SIZE = 15;

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
     * 入库人姓名
     */
    private String accountName;

    /**
     * 入库内容
     */
    private String content;

    /**
     * 入库帐号id
     */
    private Integer accountId;

    /**
     * 入库起始票号
     */
    private String startTicketNum;

    /**
     * 入库结束票号
     */
    private String endTicketNum;

    /**
     * 入库总数量
     */
    private Integer totalNum;

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

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
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
        TicketInRecord other = (TicketInRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getAccountName() == null ? other.getAccountName() == null : this.getAccountName().equals(other.getAccountName()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getStartTicketNum() == null ? other.getStartTicketNum() == null : this.getStartTicketNum().equals(other.getStartTicketNum()))
            && (this.getEndTicketNum() == null ? other.getEndTicketNum() == null : this.getEndTicketNum().equals(other.getEndTicketNum()))
            && (this.getTotalNum() == null ? other.getTotalNum() == null : this.getTotalNum().equals(other.getTotalNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getAccountName() == null) ? 0 : getAccountName().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getStartTicketNum() == null) ? 0 : getStartTicketNum().hashCode());
        result = prime * result + ((getEndTicketNum() == null) ? 0 : getEndTicketNum().hashCode());
        result = prime * result + ((getTotalNum() == null) ? 0 : getTotalNum().hashCode());
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
        sb.append(", accountName=").append(accountName);
        sb.append(", content=").append(content);
        sb.append(", accountId=").append(accountId);
        sb.append(", startTicketNum=").append(startTicketNum);
        sb.append(", endTicketNum=").append(endTicketNum);
        sb.append(", totalNum=").append(totalNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}