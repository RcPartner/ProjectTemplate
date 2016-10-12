package com.rc.projecttemplate.service.goods;

import com.rc.framework.http.HttpClient;
import com.rc.framework.service.ServicesCallback;
import com.rc.projecttemplate.common.http.HttpUrlManager;
import com.rc.projecttemplate.common.http.params.GetAnnounceGoodsListParams;
import com.rc.projecttemplate.model.http.GoodsRequest;
import com.rc.projecttemplate.model.resopnse.AnnouncedGoodsActivityResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Description:
 * Author: Caizemingg
 * Email:caizemingg@163.com
 * Date: 2016-07-14 11:25
 */
public class GoodsServiceImpl implements GoodsService {

    //倒计时时间间隔
    private static final int COUNT_DOWN_INTERVAL = 30;

    @Override
    public void getAnnounceGoodsList(int page, int pageSize, final ServicesCallback callback) {
        GetAnnounceGoodsListParams params = new GetAnnounceGoodsListParams(page, pageSize);
        HttpClient.INSTANCE.get(params.getUrl(HttpUrlManager.GET_ANNOUNCE_GOODS_LIST), callback);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpUrlManager.HOST)
                .build();
        GoodsRequest goodsRequest = retrofit.create(GoodsRequest.class);
        goodsRequest.getAnnounceGoodsList(page, pageSize, new Callback<AnnouncedGoodsActivityResponse>() {
            @Override
            public void onResponse(Call<AnnouncedGoodsActivityResponse> call, Response<AnnouncedGoodsActivityResponse> response) {

            }

            @Override
            public void onFailure(Call<AnnouncedGoodsActivityResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void startCountDownAnnounceGoodsList() {
//        countDownTimer = new CountDownTimer(Long.MAX_VALUE, COUNT_DOWN_INTERVAL) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                countDownMills = Long.MAX_VALUE - millisUntilFinished;
//                ViewHolder viewHolder;
//                if (visibleViewHolders == null) {
//                    return;
//                }
//                for (int i = 0; i < visibleViewHolders.size(); i++) {
//                    viewHolder = (ViewHolder) visibleViewHolders.get(i).getTag();
//                    updateCountDownTimeView(viewHolder.viewHolder1);
//                    updateCountDownTimeView(viewHolder.viewHolder2);
//                }
//            }
//
//            @Override
//            public void onFinish() {
//                countDown();
//            }
//        };
//        countDownTimer.start();
    }
}
