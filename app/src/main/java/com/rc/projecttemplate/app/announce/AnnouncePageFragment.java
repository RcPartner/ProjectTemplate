package com.rc.projecttemplate.app.announce;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.rc.projecttemplate.R;
import com.rc.projecttemplate.databinding.AnnouncePageFragmentBinding;

/**
 * @author caizemingg
 * @date 2016-06-20
 * @Des 最新揭晓
 */
public class AnnouncePageFragment extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AnnouncePageFragmentBinding binding = DataBindingUtil.setContentView(this, R.layout.announce_page_fragment);
        AnnouncePageFragmentVM pageFragmentVM = new AnnouncePageFragmentVM(binding);
    }
}