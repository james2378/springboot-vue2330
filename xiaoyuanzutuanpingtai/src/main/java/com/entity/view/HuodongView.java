package com.entity.view;

import com.entity.HuodongEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 组团活动
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("huodong")
public class HuodongView extends HuodongEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 组团活动类型的值
		*/
		private String huodongValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



		//级联表 huodongguanliyuan
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

	public HuodongView() {

	}

	public HuodongView(HuodongEntity huodongEntity) {
		try {
			BeanUtils.copyProperties(this, huodongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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


















				//级联表的get和set huodongguanliyuan

					/**
					* 获取： 活动管理员编号
					*/
					public String getHuodongguanliyuanUuidNumber() {
						return huodongguanliyuanUuidNumber;
					}
					/**
					* 设置： 活动管理员编号
					*/
					public void setHuodongguanliyuanUuidNumber(String huodongguanliyuanUuidNumber) {
						this.huodongguanliyuanUuidNumber = huodongguanliyuanUuidNumber;
					}

					/**
					* 获取： 活动管理员姓名
					*/
					public String getHuodongguanliyuanName() {
						return huodongguanliyuanName;
					}
					/**
					* 设置： 活动管理员姓名
					*/
					public void setHuodongguanliyuanName(String huodongguanliyuanName) {
						this.huodongguanliyuanName = huodongguanliyuanName;
					}

					/**
					* 获取： 活动管理员手机号
					*/
					public String getHuodongguanliyuanPhone() {
						return huodongguanliyuanPhone;
					}
					/**
					* 设置： 活动管理员手机号
					*/
					public void setHuodongguanliyuanPhone(String huodongguanliyuanPhone) {
						this.huodongguanliyuanPhone = huodongguanliyuanPhone;
					}

					/**
					* 获取： 活动管理员身份证号
					*/
					public String getHuodongguanliyuanIdNumber() {
						return huodongguanliyuanIdNumber;
					}
					/**
					* 设置： 活动管理员身份证号
					*/
					public void setHuodongguanliyuanIdNumber(String huodongguanliyuanIdNumber) {
						this.huodongguanliyuanIdNumber = huodongguanliyuanIdNumber;
					}

					/**
					* 获取： 活动管理员头像
					*/
					public String getHuodongguanliyuanPhoto() {
						return huodongguanliyuanPhoto;
					}
					/**
					* 设置： 活动管理员头像
					*/
					public void setHuodongguanliyuanPhoto(String huodongguanliyuanPhoto) {
						this.huodongguanliyuanPhoto = huodongguanliyuanPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getHuodongguanliyuanEmail() {
						return huodongguanliyuanEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setHuodongguanliyuanEmail(String huodongguanliyuanEmail) {
						this.huodongguanliyuanEmail = huodongguanliyuanEmail;
					}


}
