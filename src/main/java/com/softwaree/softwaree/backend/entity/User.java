package com.softwaree.softwaree.backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

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
@ApiModel(value = "User", description = "用户类")
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("ID")
    private Long id;

    @TableField("companyName")
    private String companyName;

    @TableField("phone")
    private String phone;

    @TableField("address")
    private String address;

    @TableField("password")
    private String password;

    @TableField("userName")
    private String userName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", companyName=" + companyName +
                ", phone=" + phone +
                ", address=" + address +
                ", password=" + password +
                ", userName=" + userName +
                "}";
    }
}
