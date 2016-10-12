package com.rc.projecttemplate.app.shoppingcart;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rc.projecttemplate.R;
import com.rc.projecttemplate.databinding.ShoppingCartFBinding;

/**
 * Description:
 * Author: Caizemingg
 * Email:caizemingg@163.com
 * Date: 2016-08-24 14:45
 */
public class ShoppingCartFragment extends Fragment{

    private ShoppingCartFragmentVM shoppingCartFragmentVM;
    private ShoppingCartFBinding shoppingCartFBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shopping_cart_f, null);
        shoppingCartFBinding = DataBindingUtil.getBinding(view);
        shoppingCartFragmentVM= new ShoppingCartFragmentVM(shoppingCartFBinding);
        return view;
    }
}
