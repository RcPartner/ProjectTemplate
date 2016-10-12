package com.rc.projecttemplate.app.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rc.projecttemplate.R;
import com.rc.projecttemplate.common.fragment.BaseFragment;
import com.rc.projecttemplate.databinding.HomeFBinding;

/**
 * Description:
 * Author: Caizemingg
 * Email:caizemingg@163.com
 * Date: 2016-08-24 12:28
 */
public class HomeFragment extends BaseFragment {

    private HomeFragmentVM homeFragmentVM;
    private HomeFBinding homeFBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeFBinding = DataBindingUtil.inflate(inflater, R.layout.home_f, null, false);
        homeFragmentVM = new HomeFragmentVM(homeFBinding);
        homeFBinding.tvSelected.setSelected(true);
        return homeFBinding.getRoot();
    }


}
