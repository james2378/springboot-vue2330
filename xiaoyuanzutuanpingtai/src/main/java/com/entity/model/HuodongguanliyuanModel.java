package com.entity.model;

import com.entity.HuodongguanliyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 活动管理员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuodongguanliyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 活动管理员编号
     */
    private String huodongguanliyuanUuidNumber;


    /**
     * 活动管理员姓名
     */
    private String huodongguanliyuanName;


    /**
     * 活动管理员手机号
     */
    private String huodongguanliyuanPhone;


    /**
     * 活动管理员身份证号
     */
    private String huodongguanliyuanIdNumber;


    /**
     * 活动管理员头像
     */
    private String huodongguanliyuanPhoto;


    /**
     * 电子邮箱
     */
    private String huodongguanliyuanEmail;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：活动管理员编号
	 */
    public String getHuodongguanliyuanUuidNumber() {
        return huodongguanliyuanUuidNumber;
    }


    /**
	 * 设置：活动管理员编号
	 */
    public void setHuodongguanliyuanUuidNumber(String huodongguanliyuanUuidNumber) {
        this.huodongguanliyuanUuidNumber = huodongguanliyuanUuidNumber;
    }
    /**
	 * 获取：活动管理员姓名
	 */
    public String getHuodongguanliyuanName() {
        return huodongguanliyuanName;
    }


    /**
	 * 设置：活动管理员姓名
	 */
    public void setHuodongguanliyuanName(String huodongguanliyuanName) {
        this.huodongguanliyuanName = huodongguanliyuanName;
    }
    /**
	 * 获取：活动管理员手机号
	 */
    public String getHuodongguanliyuanPhone() {
        return huodongguanliyuanPhone;
    }


    /**
	 * 设置：活动管理员手机号
	 */
    public void setHuodongguanliyuanPhone(String huodongguanliyuanPhone) {
        this.huodongguanliyuanPhone = huodongguanliyuanPhone;
    }
    /**
	 * 获取：活动管理员身份证号
	 */
    public String getHuodongguanliyuanIdNumber() {
        return huodongguanliyuanIdNumber;
    }


    /**
	 * 设置：活动管理员身份证号
	 */
    public void setHuodongguanliyuanIdNumber(String huodongguanliyuanIdNumber) {
        this.huodongguanliyuanIdNumber = huodongguanliyuanIdNumber;
    }
    /**
	 * 获取：活动管理员头像
	 */
    public String getHuodongguanliyuanPhoto() {
        return huodongguanliyuanPhoto;
    }


    /**
	 * 设置：活动管理员头像
	 */
    public void setHuodongguanliyuanPhoto(String huodongguanliyuanPhoto) {
        this.huodongguanliyuanPhoto = huodongguanliyuanPhoto;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getHuodongguanliyuanEmail() {
        return huodongguanliyuanEmail;
    }


    /**
	 * 设置：电子邮箱
	 */
    public void setHuodongguanliyuanEmail(String huodongguanliyuanEmail) {
        this.huodongguanliyuanEmail = huodongguanliyuanEmail;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
