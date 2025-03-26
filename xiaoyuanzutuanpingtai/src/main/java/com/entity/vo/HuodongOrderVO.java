package com.entity.vo;

import com.entity.HuodongOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 组团活动报名
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("huodong_order")
public class HuodongOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 申请编号
     */

    @TableField(value = "huodong_order_uuid_number")
    private String huodongOrderUuidNumber;


    /**
     * 组团活动
     */

    @TableField(value = "huodong_id")
    private Integer huodongId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 联系人姓名
     */

    @TableField(value = "lianxiren_name")
    private String lianxirenName;


    /**
     * 联系人手机号
     */

    @TableField(value = "lianxiren_phone")
    private String lianxirenPhone;


    /**
     * 加入活动的理由
     */

    @TableField(value = "huodong_order_content")
    private String huodongOrderContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 报名状态
     */

    @TableField(value = "huodong_order_yesno_types")
    private Integer huodongOrderYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "huodong_order_yesno_text")
    private String huodongOrderYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "huodong_order_shenhe_time")
    private Date huodongOrderShenheTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：申请编号
	 */
    public String getHuodongOrderUuidNumber() {
        return huodongOrderUuidNumber;
    }


    /**
	 * 获取：申请编号
	 */

    public void setHuodongOrderUuidNumber(String huodongOrderUuidNumber) {
        this.huodongOrderUuidNumber = huodongOrderUuidNumber;
    }
    /**
	 * 设置：组团活动
	 */
    public Integer getHuodongId() {
        return huodongId;
    }


    /**
	 * 获取：组团活动
	 */

    public void setHuodongId(Integer huodongId) {
        this.huodongId = huodongId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：联系人姓名
	 */
    public String getLianxirenName() {
        return lianxirenName;
    }


    /**
	 * 获取：联系人姓名
	 */

    public void setLianxirenName(String lianxirenName) {
        this.lianxirenName = lianxirenName;
    }
    /**
	 * 设置：联系人手机号
	 */
    public String getLianxirenPhone() {
        return lianxirenPhone;
    }


    /**
	 * 获取：联系人手机号
	 */

    public void setLianxirenPhone(String lianxirenPhone) {
        this.lianxirenPhone = lianxirenPhone;
    }
    /**
	 * 设置：加入活动的理由
	 */
    public String getHuodongOrderContent() {
        return huodongOrderContent;
    }


    /**
	 * 获取：加入活动的理由
	 */

    public void setHuodongOrderContent(String huodongOrderContent) {
        this.huodongOrderContent = huodongOrderContent;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getHuodongOrderYesnoTypes() {
        return huodongOrderYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setHuodongOrderYesnoTypes(Integer huodongOrderYesnoTypes) {
        this.huodongOrderYesnoTypes = huodongOrderYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getHuodongOrderYesnoText() {
        return huodongOrderYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setHuodongOrderYesnoText(String huodongOrderYesnoText) {
        this.huodongOrderYesnoText = huodongOrderYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getHuodongOrderShenheTime() {
        return huodongOrderShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setHuodongOrderShenheTime(Date huodongOrderShenheTime) {
        this.huodongOrderShenheTime = huodongOrderShenheTime;
    }
    /**
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
