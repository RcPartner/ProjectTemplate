package com.rc.projecttemplate.app.announce;

import com.rc.projecttemplate.common.http.YiniuCallback;
import com.rc.projecttemplate.databinding.AnnouncePageFragmentBinding;
import com.rc.projecttemplate.model.resopnse.AnnouncedGoodsActivityResponse;
import com.rc.projecttemplate.service.ServiceManager;

/**
 * Description:
 * Author: Caizemingg
 * Email:caizemingg@163.com
 * Date: 2016-07-22 17:43
 */
public class AnnouncePageFragmentVM {

    AnnouncePageFragmentBinding binding;

    private AnnouncePageAdapter announcePageAdapter;

    public AnnouncePageFragmentVM(AnnouncePageFragmentBinding binding) {
        this.binding = binding;
        announcePageAdapter = new AnnouncePageAdapter(binding.ptrlvAnnounce.getContext());
        binding.ptrlvAnnounce.setAdapter(announcePageAdapter);
        ServiceManager.getGoodsService().getAnnounceGoodsList(1, 16, new YiniuCallback<AnnouncedGoodsActivityResponse>() {
            @Override
            public void onSuccess(final AnnouncedGoodsActivityResponse data, int code, String mes) {
                if (data != null) {
                    announcePageAdapter.setArray(data.data.list);
                    announcePageAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
