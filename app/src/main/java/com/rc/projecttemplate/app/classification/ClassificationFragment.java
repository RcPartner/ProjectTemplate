package com.rc.projecttemplate.app.classification;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rc.projecttemplate.R;
import com.rc.projecttemplate.databinding.ClassificationFBinding;

/**
 * Description:
 * Author: Caizemingg
 * Email:caizemingg@163.com
 * Date: 2016-08-24 14:44
 */
public class ClassificationFragment extends Fragment {

    private ClassificationFragmentVM classificationFragmentVM;
    private ClassificationFBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.classification_f, null, false);
        classificationFragmentVM = new ClassificationFragmentVM(binding);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.srlDemo.setColorSchemeResources(R.color.app_theme,
                R.color.app_theme_pressed,
                R.color.app_theme_selected,
                R.color.app_theme_disable);
        binding.srlDemo.setSize(SwipeRefreshLayout.LARGE);
        binding.srlDemo.setProgressBackgroundColorSchemeResource(R.color.app_theme);
        //swipeRefreshLayout.setPadding(20, 20, 20, 20);
        //swipeRefreshLayout.setProgressViewOffset(true, 100, 200);
        //swipeRefreshLayout.setDistanceToTriggerSync(50);
        binding.srlDemo.setProgressViewEndTarget(true, 100);
        binding.srlDemo.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
    }
}
