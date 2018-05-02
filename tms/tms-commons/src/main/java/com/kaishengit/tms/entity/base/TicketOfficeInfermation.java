package com.kaishengit.tms.entity.base;

import java.io.Serializable;
import java.util.Date;

/**
 *@Description:售票点信息对象
 *@Author: 邱志辉
 *@Date 2016/4/20 0020下午 2:31
 */
public class TicketOfficeInfermation implements Serializable {

    public static final String OFFICE_NOMAL_STATUS="正常";
    public static final String OFFICE_FORBIDDEN_STATUS="禁用";
    public  static final Integer PAGE_SIZE=5;



    public TicketOfficeAccount getAccount() {
        return account;
    }

    public void setAccount(TicketOfficeAccount account) {
        this.account = account;
    }

    /**
     * 售票点关联的帐号
     */
    private  TicketOfficeAccount account ;


    /**
     * 售票点信息表的主键
     */
    private Integer id;

    /**
     * 售票点名称
     */
    private String officeName;

    /**
     * 售票点地址
     */
    private String officeAddress;

    /**
     * 售票点法人姓名
     */
    private String legalPersonName;

    /**
     * 售票点法人电话
     */
    private String legalPersonMobile;

    /**
     * 销售点营业执照
     */
    private String ticketOfficeLicense;

    /**
     * 法人身份证正面照片地址
     */
    private String legalPersonCardUp;

    private String legalPersonCardDown;

    /**
     * 销售点创建时间
     */
    private Date createTime;

    /**
     * 售票点信息更新时间
     */
    private Date updateTime;

    /**
     * 销售点经度
     */
    private String ticketOfficeLongitude;

    /**
     * 销售点纬度
     */
    private String ticketOfficeLatitude;

    /**
     * 营业点的状态
     */
    private String ticketOfficeStatus;

    /**
     * 售票点其他信息
     */
    private String ticketOfficeComment;

    /**
     * 售票点帐号的id,此列为外键，引用了ticket_office_account的id
     */
    private Integer ticketOfficeAccountId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getLegalPersonName() {
        return legalPersonName;
    }

    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
    }

    public String getLegalPersonMobile() {
        return legalPersonMobile;
    }

    public void setLegalPersonMobile(String legalPersonMobile) {
        this.legalPersonMobile = legalPersonMobile;
    }

    public String getTicketOfficeLicense() {
        return ticketOfficeLicense;
    }

    public void setTicketOfficeLicense(String ticketOfficeLicense) {
        this.ticketOfficeLicense = ticketOfficeLicense;
    }

    public String getLegalPersonCardUp() {
        return legalPersonCardUp;
    }

    public void setLegalPersonCardUp(String legalPersonCardUp) {
        this.legalPersonCardUp = legalPersonCardUp;
    }

    public String getLegalPersonCardDown() {
        return legalPersonCardDown;
    }

    public void setLegalPersonCardDown(String legalPersonCardDown) {
        this.legalPersonCardDown = legalPersonCardDown;
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

    public String getTicketOfficeLongitude() {
        return ticketOfficeLongitude;
    }

    public void setTicketOfficeLongitude(String ticketOfficeLongitude) {
        this.ticketOfficeLongitude = ticketOfficeLongitude;
    }

    public String getTicketOfficeLatitude() {
        return ticketOfficeLatitude;
    }

    public void setTicketOfficeLatitude(String ticketOfficeLatitude) {
        this.ticketOfficeLatitude = ticketOfficeLatitude;
    }

    public String getTicketOfficeStatus() {
        return ticketOfficeStatus;
    }

    public void setTicketOfficeStatus(String ticketOfficeStatus) {
        this.ticketOfficeStatus = ticketOfficeStatus;
    }

    public String getTicketOfficeComment() {
        return ticketOfficeComment;
    }

    public void setTicketOfficeComment(String ticketOfficeComment) {
        this.ticketOfficeComment = ticketOfficeComment;
    }

    public Integer getTicketOfficeAccountId() {
        return ticketOfficeAccountId;
    }

    public void setTicketOfficeAccountId(Integer ticketOfficeAccountId) {
        this.ticketOfficeAccountId = ticketOfficeAccountId;
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
        TicketOfficeInfermation other = (TicketOfficeInfermation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOfficeName() == null ? other.getOfficeName() == null : this.getOfficeName().equals(other.getOfficeName()))
            && (this.getOfficeAddress() == null ? other.getOfficeAddress() == null : this.getOfficeAddress().equals(other.getOfficeAddress()))
            && (this.getLegalPersonName() == null ? other.getLegalPersonName() == null : this.getLegalPersonName().equals(other.getLegalPersonName()))
            && (this.getLegalPersonMobile() == null ? other.getLegalPersonMobile() == null : this.getLegalPersonMobile().equals(other.getLegalPersonMobile()))
            && (this.getTicketOfficeLicense() == null ? other.getTicketOfficeLicense() == null : this.getTicketOfficeLicense().equals(other.getTicketOfficeLicense()))
            && (this.getLegalPersonCardUp() == null ? other.getLegalPersonCardUp() == null : this.getLegalPersonCardUp().equals(other.getLegalPersonCardUp()))
            && (this.getLegalPersonCardDown() == null ? other.getLegalPersonCardDown() == null : this.getLegalPersonCardDown().equals(other.getLegalPersonCardDown()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getTicketOfficeLongitude() == null ? other.getTicketOfficeLongitude() == null : this.getTicketOfficeLongitude().equals(other.getTicketOfficeLongitude()))
            && (this.getTicketOfficeLatitude() == null ? other.getTicketOfficeLatitude() == null : this.getTicketOfficeLatitude().equals(other.getTicketOfficeLatitude()))
            && (this.getTicketOfficeStatus() == null ? other.getTicketOfficeStatus() == null : this.getTicketOfficeStatus().equals(other.getTicketOfficeStatus()))
            && (this.getTicketOfficeComment() == null ? other.getTicketOfficeComment() == null : this.getTicketOfficeComment().equals(other.getTicketOfficeComment()))
            && (this.getTicketOfficeAccountId() == null ? other.getTicketOfficeAccountId() == null : this.getTicketOfficeAccountId().equals(other.getTicketOfficeAccountId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOfficeName() == null) ? 0 : getOfficeName().hashCode());
        result = prime * result + ((getOfficeAddress() == null) ? 0 : getOfficeAddress().hashCode());
        result = prime * result + ((getLegalPersonName() == null) ? 0 : getLegalPersonName().hashCode());
        result = prime * result + ((getLegalPersonMobile() == null) ? 0 : getLegalPersonMobile().hashCode());
        result = prime * result + ((getTicketOfficeLicense() == null) ? 0 : getTicketOfficeLicense().hashCode());
        result = prime * result + ((getLegalPersonCardUp() == null) ? 0 : getLegalPersonCardUp().hashCode());
        result = prime * result + ((getLegalPersonCardDown() == null) ? 0 : getLegalPersonCardDown().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getTicketOfficeLongitude() == null) ? 0 : getTicketOfficeLongitude().hashCode());
        result = prime * result + ((getTicketOfficeLatitude() == null) ? 0 : getTicketOfficeLatitude().hashCode());
        result = prime * result + ((getTicketOfficeStatus() == null) ? 0 : getTicketOfficeStatus().hashCode());
        result = prime * result + ((getTicketOfficeComment() == null) ? 0 : getTicketOfficeComment().hashCode());
        result = prime * result + ((getTicketOfficeAccountId() == null) ? 0 : getTicketOfficeAccountId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", officeName=").append(officeName);
        sb.append(", officeAddress=").append(officeAddress);
        sb.append(", legalPersonName=").append(legalPersonName);
        sb.append(", legalPersonMobile=").append(legalPersonMobile);
        sb.append(", ticketOfficeLicense=").append(ticketOfficeLicense);
        sb.append(", legalPersonCardUp=").append(legalPersonCardUp);
        sb.append(", legalPersonCardDown=").append(legalPersonCardDown);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", ticketOfficeLongitude=").append(ticketOfficeLongitude);
        sb.append(", ticketOfficeLatitude=").append(ticketOfficeLatitude);
        sb.append(", ticketOfficeStatus=").append(ticketOfficeStatus);
        sb.append(", ticketOfficeComment=").append(ticketOfficeComment);
        sb.append(", ticketOfficeAccountId=").append(ticketOfficeAccountId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}