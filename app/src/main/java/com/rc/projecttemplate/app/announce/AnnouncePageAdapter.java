package com.rc.projecttemplate.app.announce;


import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rc.framework.adapter.RcAdapter;
import com.rc.projecttemplate.R;
import com.rc.projecttemplate.databinding.AnnouncePageItem1Binding;
import com.rc.projecttemplate.model.entity.AnnouncedGoodsActivityEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Author: Caizemingg
 * Email:caizemingg@163.com
 * Date: 2016-06-20 10:47
 */
public class AnnouncePageAdapter extends RcAdapter<AnnouncedGoodsActivityEntity> {
    //揭晓中
    private static final String STATUS_ANNOUNCING = "1";
    //已揭晓
    private static final String STATUS_ANNOUNCED = "2";
    //倒计时时间间隔
    private static final int COUNT_DOWN_INTERVAL = 30;
    //列数
    private static final int COLUMN_COUNT = 2;

    //    private GoodsActivityResultProtocol protocol;
    private CountDownTimer countDownTimer;

    private long countDownMills;


    public AnnouncePageAdapter(Context context) {
        super(context);
        countDown();
    }

    @Override
    public void setArray(List<AnnouncedGoodsActivityEntity> list) {
        for (AnnouncedGoodsActivityEntity temp : list) {
            temp.startCountDownTime = countDownMills;
        }
        super.setArray(list);
    }

    @Override
    public void addArray(List<AnnouncedGoodsActivityEntity> list) {
        for (AnnouncedGoodsActivityEntity temp : list) {
            temp.startCountDownTime = countDownMills;
        }
        super.addArray(list);
    }

    @Override
    public void add(AnnouncedGoodsActivityEntity data) {
        data.startCountDownTime = countDownMills;
        super.add(data);
    }

    private void countDown() {
        countDownTimer = new CountDownTimer(Long.MAX_VALUE, COUNT_DOWN_INTERVAL) {
            @Override
            public void onTick(long millisUntilFinished) {
                countDownMills = Long.MAX_VALUE - millisUntilFinished;
                ViewHolder viewHolder;
                if (visibleViewHolders == null) {
                    return;
                }
                for (int i = 0; i < visibleViewHolders.size(); i++) {
                    viewHolder = (ViewHolder) visibleViewHolders.get(i).getTag();
                    updateCountDownTimeView(viewHolder.viewHolder1);
                    updateCountDownTimeView(viewHolder.viewHolder2);
                }
            }

            @Override
            public void onFinish() {
                countDown();
            }
        };
        countDownTimer.start();
    }

    public void stopCountDown() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /**
     * 获取已经倒计时了多少秒
     *
     * @param startCountDownTime 开始倒计时时，countDownTimer已经过了多少秒
     * @return 已经倒计时了多少秒
     */
    private long getCountDownMills(long startCountDownTime) {
        if (countDownMills - startCountDownTime <= 0) {//下一轮倒计时
            return Long.MAX_VALUE - startCountDownTime + countDownMills;
        }
        return countDownMills - startCountDownTime;
    }

    private void updateCountDownTimeView(final ViewHolder.ViewHolder1 viewHolder) {
        final int currentPosition = viewHolder.position;
        final AnnouncedGoodsActivityEntity goodsActivity = getItem(currentPosition);
        if (goodsActivity != null) {
            long remainMills = goodsActivity.getRemainMills() - getCountDownMills(goodsActivity.startCountDownTime);
            if (remainMills <= 0) {
                if (STATUS_ANNOUNCING.equals(goodsActivity.status) && !goodsActivity.isRequestAnnouncedResult) {
                    //viewHolder.tvCountDownTime.setText("等待揭晓");
                    goodsActivity.isRequestAnnouncedResult = true;
//                    requestAnnouncedResult(goodsActivity.actId, new OnSuccessListener<BuyerResponse>() {
//                        @Override
//                        public void onSuccessResponse(BuyerResponse response) {
//                            if (response != null && response.isSuccess()) {
//                                Buyer data = response.data;
//                                goodsActivity.userName = data.userName;
//                                goodsActivity.luckNumber = data.luckNumber;
//                                goodsActivity.buyNum = data.buyNum;
//                                goodsActivity.status = data.status;
//                                goodsActivity.updateTime = data.addTime;
//                                if (viewHolder.position == currentPosition) {
//                                    if (viewHolder == null) {
//                                        return;
//                                    }
//                                    updateViewHolder(viewHolder);
//                                }
//                            }
//                        }
//                    });
                }
            } else {
                String strTime1 = toCountDownTime(remainMills);
                if (viewHolder == null) {
                    return;
                }
                viewHolder.announceViewModel.setCountDownTime(strTime1);
            }
        }
    }

    public String toCountDownTime(long time) {
        String timeStr = "";
        int min = (int) (time % 3600000) / 60000;
        int sec = (int) (time % 60000) / 1000;
        int mills100 = (int) (time % 60000) % 1000 / 10;
        if (min < 10) {
            timeStr += "0" + min;
        } else {
            timeStr += min;
        }
        timeStr += ":";
        if (sec < 10) {
            timeStr += "0" + sec;
        } else {
            timeStr += sec;
        }
        timeStr += ":";
        if (mills100 < 10) {
            timeStr += "0" + mills100;
        } else {
            timeStr += mills100;
        }
        return timeStr;
    }

//    private void requestAnnouncedResult(String actId, OnSuccessListener<BuyerResponse> response) {
//        protocol = new GoodsActivityResultProtocol();
//        HashMap<String, String> requestParams = new HashMap<String, String>();
//        requestParams.put("upActId", actId);
//        protocol.execute(getContext(), requestParams, response, null);
//    }

    private List<View> visibleViewHolders = new ArrayList<View>();

    @Override
    public int getCount() {
        if (getList() == null) {
            return 0;
        }
        return (getList().size() % COLUMN_COUNT == 0) ? (getList().size() / COLUMN_COUNT) : (getList().size() / COLUMN_COUNT + 1);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.announce_page_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        position = position * COLUMN_COUNT;
        viewHolder.setPosition(position);
        viewHolder.bind(getItem(position), getItem(position + 1));

        if (!visibleViewHolders.contains(convertView)) {
            visibleViewHolders.add(convertView);
        }
        return convertView;
    }

    static class ViewHolder {
        ViewHolder1 viewHolder1;
        ViewHolder1 viewHolder2;

        static class ViewHolder1 {
            int position;
            AnnouncePageItem1Binding item1Binding;
            AnnounceViewModel announceViewModel;

            ViewHolder1(View root) {
                item1Binding = AnnouncePageItem1Binding.bind(root);
                this.announceViewModel = new AnnounceViewModel(item1Binding);
                item1Binding.setAnnounceViewModel(announceViewModel);
            }
        }

        ViewHolder(View view) {
            viewHolder1 = new ViewHolder1(view.findViewById(R.id.l_item));
            viewHolder2 = new ViewHolder1(view.findViewById(R.id.l_item2));
        }

        public void bind(AnnouncedGoodsActivityEntity entity1, AnnouncedGoodsActivityEntity entity2) {
            viewHolder1.announceViewModel.setEntity(entity1);
            viewHolder2.announceViewModel.setEntity(entity2);
        }

        void setPosition(int position) {
            if (viewHolder1 != null) {
                viewHolder1.position = position;
            }
            if (viewHolder2 != null) {
                viewHolder2.position = position + 1;
            }
        }
    }
}
