package com.softwaree.softwaree.backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.ObjectInputStream;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.softwaree.softwaree.backend.utils.OrderInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * <p>
 *
 * </p>
 *
 * @author fetter
 * @since 2019-11-29
 */
@ApiModel(value = "Order", description = "订单类")
@NoArgsConstructor
@AllArgsConstructor
@TableName("orders")
public class Order implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("orderID")
    private Long id;

    @TableField("createTime")
    private LocalDateTime createTime;

    @TableField("acceptTime")
    private LocalDateTime acceptTime;

    @TableField("tallyTime")
    private LocalDateTime tallyTime;

    @TableField("chipType")
    private String chipType;

    @TableField("chipAmount")
    private Long chipAmount;

    @TableField("EDAFileLocation")
    private String EDAFileLocation;

    @TableField("attachedInfo")
    private String attachedInfo;

    @TableField("produceProgress")
    private String produceProgress;

    @TableField("customerID")
    private Long customerID;

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(LocalDateTime acceptTime) {
        this.acceptTime = acceptTime;
    }

    public LocalDateTime getTallyTime() {
        return tallyTime;
    }

    public void setTallyTime(LocalDateTime tallyTime) {
        this.tallyTime = tallyTime;
    }

    public String getChipType() {
        return chipType;
    }

    public void setChipType(String chipType) {
        this.chipType = chipType;
    }

    public Long getChipAmount() {
        return chipAmount;
    }

    public void setChipAmount(Long chipAmount) {
        this.chipAmount = chipAmount;
    }

    public String getEDAFileLocation() {
        return EDAFileLocation;
    }

    public void setEDAFileLocation(String EDAFileLocation) {
        this.EDAFileLocation = EDAFileLocation;
    }

    public String getAttachedInfo() {
        return attachedInfo;
    }

    public void setAttachedInfo(String attachedInfo) {
        this.attachedInfo = attachedInfo;
    }

    public String getProduceProgress() {
        return produceProgress;
    }

    public void setProduceProgress(String produceProgress) {
        this.produceProgress = produceProgress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", acceptTime=" + acceptTime +
                ", tallyTime=" + tallyTime +
                ", chipType='" + chipType + '\'' +
                ", chipAmount=" + chipAmount +
                ", EDAFileLocation='" + EDAFileLocation + '\'' +
                ", attachedInfo='" + attachedInfo + '\'' +
                ", produceProgress='" + produceProgress + '\'' +
                ", customerID=" + customerID +
                '}';
    }
}
