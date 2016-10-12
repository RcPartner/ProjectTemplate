package com.rc.projecttemplate.app.user;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rc.projecttemplate.R;
import com.rc.projecttemplate.app.shoppingcart.ShoppingCartFragmentVM;
import com.rc.projecttemplate.databinding.UserFBinding;

/**
 * Description:
 * Author: Caizemingg
 * Email:caizemingg@163.com
 * Date: 2016-08-24 12:28
 */
public class UserFragment extends Fragment{

    private UserFragmentVM userFragmentVM;
    private UserFBinding userFBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_f, null);
        userFBinding = DataBindingUtil.getBinding(view);
        userFragmentVM= new UserFragmentVM(userFBinding);
        return view;
    }
}
