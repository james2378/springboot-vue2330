package com.entity.view;

import com.entity.HuodongLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 组团活动留言
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("huodong_liuyan")
public class HuodongLiuyanView extends HuodongLiuyanEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 huodong
			/**
			* 组团活动 的 活动管理员
			*/
			private Integer huodongHuodongguanliyuanId;
			/**
			* 组团活动名称
			*/
			private String huodongName;
			/**
			* 组团活动编号
			*/
			private String huodongUuidNumber;
			/**
			* 组团活动照片
			*/
			private String huodongPhoto;
			/**
			* 活动开始时间
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			private Date kaishiTime;
			/**
			* 活动结束时间
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			private Date jieshuTime;
			/**
			* 活动地点
			*/
			private String huodongAddress;
			/**
			* 组团活动类型
			*/
			private Integer huodongTypes;
				/**
				* 组团活动类型的值
				*/
				private String huodongValue;
			/**
			* 最大参与人数
			*/
			private Integer huodongZuidaNumber;
			/**
			* 活动热度
			*/
			private Integer huodongClicknum;
			/**
			* 赞数量
			*/
			private Integer zanNumber;
			/**
			* 踩数量
			*/
			private Integer caiNumber;
			/**
			* 组团活动详细介绍
			*/
			private String huodongContent;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer huodongDelete;

		//级联表 yonghu
			/**
			* 用户编号
			*/
			private String yonghuUuidNumber;
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;
			/**
			* 学院
			*/
			private Integer xueyuanTypes;
				/**
				* 学院的值
				*/
				private String xueyuanValue;
			/**
			* 专业
			*/
			private Integer zhuanyeTypes;
				/**
				* 专业的值
				*/
				private String zhuanyeValue;
			/**
			* 班级
			*/
			private Integer banjiTypes;
				/**
				* 班级的值
				*/
				private String banjiValue;

	public HuodongLiuyanView() {

	}

	public HuodongLiuyanView(HuodongLiuyanEntity huodongLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, huodongLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}













				//级联表的get和set huodong

					/**
					* 获取：组团活动 的 活动管理员
					*/
					public Integer getHuodongHuodongguanliyuanId() {
						return huodongHuodongguanliyuanId;
					}
					/**
					* 设置：组团活动 的 活动管理员
					*/
					public void setHuodongHuodongguanliyuanId(Integer huodongHuodongguanliyuanId) {
						this.huodongHuodongguanliyuanId = huodongHuodongguanliyuanId;
					}


					/**
					* 获取： 组团活动名称
					*/
					public String getHuodongName() {
						return huodongName;
					}
					/**
					* 设置： 组团活动名称
					*/
					public void setHuodongName(String huodongName) {
						this.huodongName = huodongName;
					}

					/**
					* 获取： 组团活动编号
					*/
					public String getHuodongUuidNumber() {
						return huodongUuidNumber;
					}
					/**
					* 设置： 组团活动编号
					*/
					public void setHuodongUuidNumber(String huodongUuidNumber) {
						this.huodongUuidNumber = huodongUuidNumber;
					}

					/**
					* 获取： 组团活动照片
					*/
					public String getHuodongPhoto() {
						return huodongPhoto;
					}
					/**
					* 设置： 组团活动照片
					*/
					public void setHuodongPhoto(String huodongPhoto) {
						this.huodongPhoto = huodongPhoto;
					}

					/**
					* 获取： 活动开始时间
					*/
					public Date getKaishiTime() {
						return kaishiTime;
					}
					/**
					* 设置： 活动开始时间
					*/
					public void setKaishiTime(Date kaishiTime) {
						this.kaishiTime = kaishiTime;
					}

					/**
					* 获取： 活动结束时间
					*/
					public Date getJieshuTime() {
						return jieshuTime;
					}
					/**
					* 设置： 活动结束时间
					*/
					public void setJieshuTime(Date jieshuTime) {
						this.jieshuTime = jieshuTime;
					}

					/**
					* 获取： 活动地点
					*/
					public String getHuodongAddress() {
						return huodongAddress;
					}
					/**
					* 设置： 活动地点
					*/
					public void setHuodongAddress(String huodongAddress) {
						this.huodongAddress = huodongAddress;
					}

					/**
					* 获取： 组团活动类型
					*/
					public Integer getHuodongTypes() {
						return huodongTypes;
					}
					/**
					* 设置： 组团活动类型
					*/
					public void setHuodongTypes(Integer huodongTypes) {
						this.huodongTypes = huodongTypes;
					}


						/**
						* 获取： 组团活动类型的值
						*/
						public String getHuodongValue() {
							return huodongValue;
						}
						/**
						* 设置： 组团活动类型的值
						*/
						public void setHuodongValue(String huodongValue) {
							this.huodongValue = huodongValue;
						}

					/**
					* 获取： 最大参与人数
					*/
					public Integer getHuodongZuidaNumber() {
						return huodongZuidaNumber;
					}
					/**
					* 设置： 最大参与人数
					*/
					public void setHuodongZuidaNumber(Integer huodongZuidaNumber) {
						this.huodongZuidaNumber = huodongZuidaNumber;
					}

					/**
					* 获取： 活动热度
					*/
					public Integer getHuodongClicknum() {
						return huodongClicknum;
					}
					/**
					* 设置： 活动热度
					*/
					public void setHuodongClicknum(Integer huodongClicknum) {
						this.huodongClicknum = huodongClicknum;
					}

					/**
					* 获取： 赞数量
					*/
					public Integer getZanNumber() {
						return zanNumber;
					}
					/**
					* 设置： 赞数量
					*/
					public void setZanNumber(Integer zanNumber) {
						this.zanNumber = zanNumber;
					}

					/**
					* 获取： 踩数量
					*/
					public Integer getCaiNumber() {
						return caiNumber;
					}
					/**
					* 设置： 踩数量
					*/
					public void setCaiNumber(Integer caiNumber) {
						this.caiNumber = caiNumber;
					}

					/**
					* 获取： 组团活动详细介绍
					*/
					public String getHuodongContent() {
						return huodongContent;
					}
					/**
					* 设置： 组团活动详细介绍
					*/
					public void setHuodongContent(String huodongContent) {
						this.huodongContent = huodongContent;
					}

					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getHuodongDelete() {
						return huodongDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setHuodongDelete(Integer huodongDelete) {
						this.huodongDelete = huodongDelete;
					}













				//级联表的get和set yonghu

					/**
					* 获取： 用户编号
					*/
					public String getYonghuUuidNumber() {
						return yonghuUuidNumber;
					}
					/**
					* 设置： 用户编号
					*/
					public void setYonghuUuidNumber(String yonghuUuidNumber) {
						this.yonghuUuidNumber = yonghuUuidNumber;
					}

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 学院
					*/
					public Integer getXueyuanTypes() {
						return xueyuanTypes;
					}
					/**
					* 设置： 学院
					*/
					public void setXueyuanTypes(Integer xueyuanTypes) {
						this.xueyuanTypes = xueyuanTypes;
					}


						/**
						* 获取： 学院的值
						*/
						public String getXueyuanValue() {
							return xueyuanValue;
						}
						/**
						* 设置： 学院的值
						*/
						public void setXueyuanValue(String xueyuanValue) {
							this.xueyuanValue = xueyuanValue;
						}

					/**
					* 获取： 专业
					*/
					public Integer getZhuanyeTypes() {
						return zhuanyeTypes;
					}
					/**
					* 设置： 专业
					*/
					public void setZhuanyeTypes(Integer zhuanyeTypes) {
						this.zhuanyeTypes = zhuanyeTypes;
					}


						/**
						* 获取： 专业的值
						*/
						public String getZhuanyeValue() {
							return zhuanyeValue;
						}
						/**
						* 设置： 专业的值
						*/
						public void setZhuanyeValue(String zhuanyeValue) {
							this.zhuanyeValue = zhuanyeValue;
						}

					/**
					* 获取： 班级
					*/
					public Integer getBanjiTypes() {
						return banjiTypes;
					}
					/**
					* 设置： 班级
					*/
					public void setBanjiTypes(Integer banjiTypes) {
						this.banjiTypes = banjiTypes;
					}


						/**
						* 获取： 班级的值
						*/
						public String getBanjiValue() {
							return banjiValue;
						}
						/**
						* 设置： 班级的值
						*/
						public void setBanjiValue(String banjiValue) {
							this.banjiValue = banjiValue;
						}






}
