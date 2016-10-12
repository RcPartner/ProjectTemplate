package com.rc.projecttemplate.app.announce;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.SpannableString;

import com.rc.framework.imageloader.ImageLoader;
import com.rc.framework.util.SpanStrUtil;
import com.rc.projecttemplate.BR;
import com.rc.projecttemplate.R;
import com.rc.projecttemplate.databinding.AnnouncePageItem1Binding;
import com.rc.projecttemplate.model.entity.AnnouncedGoodsActivityEntity;

/**
 * Description:
 * Author: Caizemingg
 * Email:caizemingg@163.com
 * Date: 2016-07-20 14:49
 */
public class AnnounceViewModel extends BaseObservable {

    //揭晓中
    private static final String STATUS_ANNOUNCING = "1";
    //已揭晓
    private static final String STATUS_ANNOUNCED = "2";

    private AnnouncePageItem1Binding item1Binding;

    private AnnouncedGoodsActivityEntity entity;

    public AnnounceViewModel(AnnouncePageItem1Binding item1Binding) {
        this.item1Binding = item1Binding;
    }

    @Bindable
    public boolean isAnnouncing() {
        if (STATUS_ANNOUNCING.equals(entity.status)) {
            return true;
        }
        return false;
    }

    @Bindable
    public boolean isAnnounced() {
        if (STATUS_ANNOUNCED.equals(entity.status)) {
            return true;
        }
        return false;
    }

    @Bindable
    public AnnouncedGoodsActivityEntity getEntity() {
        return entity;
    }

    public void setEntity(AnnouncedGoodsActivityEntity entity) {
        this.entity = entity;
        if (entity != null) {
            ImageLoader.INSTANCE.displayImage(entity.squarePic, item1Binding.ivImage);
        }
//        notifyPropertyChanged(BR.entity);
    }

    public String getGoodsTitle() {
        return entity.goodsTitle;
    }

    public SpannableString getActId() {
        return SpanStrUtil.makeColorSpanStr(R.color.color_no_6_gray, R.string.apf_act_id, entity.actId);
    }

    public SpannableString getLuckUser() {
        return SpanStrUtil.makeColorSpanStr(R.color.color_no_17_blue, R.string.apf_lucky_user, entity.userName);
    }

    public SpannableString getBuyNum() {
        return SpanStrUtil.makeColorSpanStr(R.color.color_no_17_blue, R.string.apf_lucky_user, entity.buyNum);
    }

    public SpannableString getLuckNumber() {
        return SpanStrUtil.makeColorSpanStr(R.color.color_no_1_red, R.string.apf_lucky_num, entity.luckNumber);
    }

    public SpannableString getUpdateTime() {
        return SpanStrUtil.makeColorSpanStr(R.color.color_no_6_gray, R.string.apf_announce_time, entity.updateTime);
    }

    private String countDownTime;

    @Bindable
    public String getCountDownTime() {
        return countDownTime;
    }

    public void setCountDownTime(String countDownTime) {
        this.countDownTime = countDownTime;
        notifyPropertyChanged(BR.countDownTime);
    }
}
