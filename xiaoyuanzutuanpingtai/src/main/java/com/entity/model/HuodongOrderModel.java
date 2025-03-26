package com.entity.model;

import com.entity.HuodongOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 组团活动报名
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuodongOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 申请编号
     */
    private String huodongOrderUuidNumber;


    /**
     * 组团活动
     */
    private Integer huodongId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 联系人姓名
     */
    private String lianxirenName;


    /**
     * 联系人手机号
     */
    private String lianxirenPhone;


    /**
     * 加入活动的理由
     */
    private String huodongOrderContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 报名状态
     */
    private Integer huodongOrderYesnoTypes;


    /**
     * 审核意见
     */
    private String huodongOrderYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date huodongOrderShenheTime;


    /**
     * 创建时间 show3
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
	 * 获取：申请编号
	 */
    public String getHuodongOrderUuidNumber() {
        return huodongOrderUuidNumber;
    }


    /**
	 * 设置：申请编号
	 */
    public void setHuodongOrderUuidNumber(String huodongOrderUuidNumber) {
        this.huodongOrderUuidNumber = huodongOrderUuidNumber;
    }
    /**
	 * 获取：组团活动
	 */
    public Integer getHuodongId() {
        return huodongId;
    }


    /**
	 * 设置：组团活动
	 */
    public void setHuodongId(Integer huodongId) {
        this.huodongId = huodongId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：联系人姓名
	 */
    public String getLianxirenName() {
        return lianxirenName;
    }


    /**
	 * 设置：联系人姓名
	 */
    public void setLianxirenName(String lianxirenName) {
        this.lianxirenName = lianxirenName;
    }
    /**
	 * 获取：联系人手机号
	 */
    public String getLianxirenPhone() {
        return lianxirenPhone;
    }


    /**
	 * 设置：联系人手机号
	 */
    public void setLianxirenPhone(String lianxirenPhone) {
        this.lianxirenPhone = lianxirenPhone;
    }
    /**
	 * 获取：加入活动的理由
	 */
    public String getHuodongOrderContent() {
        return huodongOrderContent;
    }


    /**
	 * 设置：加入活动的理由
	 */
    public void setHuodongOrderContent(String huodongOrderContent) {
        this.huodongOrderContent = huodongOrderContent;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getHuodongOrderYesnoTypes() {
        return huodongOrderYesnoTypes;
    }


    /**
	 * 设置：报名状态
	 */
    public void setHuodongOrderYesnoTypes(Integer huodongOrderYesnoTypes) {
        this.huodongOrderYesnoTypes = huodongOrderYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getHuodongOrderYesnoText() {
        return huodongOrderYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setHuodongOrderYesnoText(String huodongOrderYesnoText) {
        this.huodongOrderYesnoText = huodongOrderYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getHuodongOrderShenheTime() {
        return huodongOrderShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setHuodongOrderShenheTime(Date huodongOrderShenheTime) {
        this.huodongOrderShenheTime = huodongOrderShenheTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
