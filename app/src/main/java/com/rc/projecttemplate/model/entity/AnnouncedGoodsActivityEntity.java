package com.rc.projecttemplate.model.entity;

/**
 * Description:
 * Author: Caizemingg
 * Email:caizemingg@163.com
 * Date: 2016-06-22 10:56
 */
public class AnnouncedGoodsActivityEntity {

    /**
     * 活动id（期id）
     */
    public String actId;
    /**
     * 商品id
     */
    public String goodsId;
    /**
     * 开奖状态：
     * 1为待揭奖
     * 2为已揭奖
     */
    public String status;
    /**
     * 状态文本
     */
    public String statusTxt;
    /**
     * 用户ID
     */
    public String userId;
    /**
     * 用户名称
     */
    public String userName;
    /**
     * 本期购买份数
     */
    public String buyNum;
    /**
     * 老时时彩开奖时间【status=1时使用】
     */
    public String phaseTime;
    /**
     * 幸运号码
     */
    public String luckNumber;
    /**
     * 商品标题
     */
    public String goodsTitle;
    /**
     * 开奖时间【需status=2】
     */
    public String updateTime;
    /**
     *
     */
    public String picUrl;
    /**
     *
     */
    public String thumbPath;
    /**
     * 正方形封面图
     */
    public String squarePic;
    /**
     * 长方形封面图
     */
    public String squareThumb;
    /**
     * 剩余秒数
     */
    public Long remainSeconds;

    /**
     * 剩余毫秒（php的精度只到秒，从服务端获取后，需要进行一次转换）
     */
//    public Long remainMills = -99L;
    public Long getRemainMills() {
        if (remainSeconds <= 0) {
            return 0L;
        }
        return remainSeconds * 1000;
    }

    public boolean isRequestAnnouncedResult = false;

    public Long startCountDownTime;

}
