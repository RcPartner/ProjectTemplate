package com.rc.projecttemplate;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rc.projecttemplate.app.classification.ClassificationFragment;
import com.rc.projecttemplate.app.home.HomeFragment;
import com.rc.projecttemplate.app.shoppingcart.ShoppingCartFragment;
import com.rc.projecttemplate.app.user.UserFragment;
import com.rc.projecttemplate.databinding.MainABinding;

import java.util.HashMap;

/**
 * Description:
 * Author: Caizemingg
 * Email:caizemingg@163.com
 * Date: 2016-08-17 11:15
 */
public class MainActivity extends FragmentActivity {

    FragmentManager fm;
    MainActivityVM mainActivityVM;
    private MainABinding binding;
    //双击退出
    private boolean backToExit = false;
    // 双击返回键的延时时间
    private static final int BACK_TO_EXIT_DELAY_TIME = 2000;

    private Class[] tabsFragment = {HomeFragment.class, ClassificationFragment.class,
            ShoppingCartFragment.class, UserFragment.class};
    private int[] tabsText = {R.string.ma_tab1, R.string.ma_tab2, R.string.ma_tab3, R.string.ma_tab4};
    private int[][] tabsDrawable = {{R.mipmap.ic_tab_home_normal, R.mipmap.ic_tab_home_selected},
            {R.mipmap.ic_tab_announced_normal, R.mipmap.ic_tab_announced_selected},
            {R.mipmap.ic_tab_discover_normal, R.mipmap.ic_tab_discover_selected},
            {R.mipmap.ic_tab_userinfo_normal, R.mipmap.ic_tab_userinfo_selected}};
    private int tabTextColorNormal = R.color.color_no_6_gray;
    private int tabTextColorSelected = R.color.color_no_1_red;

    private int currentTabIndex = -1;

    private HashMap<Class<? extends Fragment>, Fragment> singleFragments = new HashMap<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm = getSupportFragmentManager();

        binding = DataBindingUtil.setContentView(this, R.layout.main_a);
        mainActivityVM = new MainActivityVM(binding);
        for (int i = 0; i < tabsText.length; i++) {
            final int pos = i;
            TextView textView = getTabView(i);
            binding.llTabs.addView(textView);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startTabFragment(tabsFragment[pos]);
                }
            });
        }
        startTabFragment(HomeFragment.class);
    }

    private void setCurrentTab(Class cl) {
        for (int i = 0; i < tabsFragment.length; i++) {
            if (tabsFragment[i].equals(cl)) {
                setCurrentTab(i);
                return;
            }
        }
    }

    private void setCurrentTab(int pos) {
        if (currentTabIndex == pos || pos < 0 || pos >= tabsText.length) {
            return;
        }
        TextView currentTab;
        if (currentTabIndex != -1) {
            currentTab = (TextView) binding.llTabs.getChildAt(currentTabIndex);
            currentTab.setTextColor(getResources().getColor(tabTextColorNormal));
            currentTab.setCompoundDrawablesWithIntrinsicBounds(0, tabsDrawable[currentTabIndex][0], 0, 0);
        }
        currentTabIndex = pos;
        currentTab = (TextView) binding.llTabs.getChildAt(currentTabIndex);
        currentTab.setTextColor(getResources().getColor(tabTextColorSelected));
        currentTab.setCompoundDrawablesWithIntrinsicBounds(0, tabsDrawable[pos][1], 0, 0);
    }

    @NonNull
    private TextView getTabView(int pos) {
        TextView textView = new TextView(this);
        textView.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, tabsDrawable[pos][0], 0, 0);
        textView.setText(tabsText[pos]);
        textView.setTextColor(getResources().getColor(tabTextColorNormal));
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    /**
     * 切换到指定的fragment
     *
     * @param fClass
     */
    private void startFragment(Class<? extends Fragment> fClass) {
        startFragment(Fragment.instantiate(this, fClass.getName()));
    }

    /**
     * 切换到指定的fragment
     *
     * @param fragment
     */
    private void startFragment(Fragment fragment) {
        String tag = fragment.getClass().getSimpleName() + (getBackStackEntryCountOfFragment(fragment.getClass()) + 1);
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fContent, fragment, tag);
        ft.addToBackStack(tag);
        ft.commit();
    }


    @NonNull
    private String getFragmentTag(Class<? extends Fragment> fragment) {
        return fragment.getSimpleName() + getBackStackEntryCountOfFragment(fragment);
    }

    /**
     * 回退栈中是否存在指定fragment记录
     *
     * @param fragment
     * @return
     */
    private boolean isBackStackEntryOfFragmentInBackStack(Class<? extends Fragment> fragment) {
        String tag = fragment.getSimpleName();
        for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
            FragmentManager.BackStackEntry temp = fm.getBackStackEntryAt(i);
            if (!TextUtils.isEmpty(temp.getName()) && temp.getName().contains(tag)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 回退栈中有多少个指定fragment记录
     *
     * @param fragment
     * @return
     */
    private int getBackStackEntryCountOfFragment(Class<? extends Fragment> fragment) {
        String tag = fragment.getSimpleName();
        int count = 0;
        for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
            FragmentManager.BackStackEntry temp = fm.getBackStackEntryAt(i);
            if (!TextUtils.isEmpty(temp.getName()) && temp.getName().contains(tag)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 切换到指定fragment，并保证回退栈中只有一个该fragment的记录
     *
     * @param fragment
     */
    private void startTabFragment(Class<? extends Fragment> fragment) {
        startSingleFragment(fragment);
        setCurrentTab(fragment);
    }

    /**
     * 切换到指定fragment，并保证回退栈中只有一个该fragment的记录
     *
     * @param cl
     */
    private void startSingleFragment(Class<? extends Fragment> cl) {

        String tag = cl.getSimpleName() + "1";
        Fragment fragment = fm.findFragmentByTag(tag);
        if (fragment != null) {
            fm.popBackStackImmediate(tag, 0);
        }else{
            fragment = Fragment.instantiate(this, cl.getName());

            startFragment(fragment);
        }
        singleFragments.put(cl, fragment);
    }

    private Fragment getStackTopFragment() {
        int backStackEntryCount = fm.getBackStackEntryCount();
        if (backStackEntryCount < 1) {
            return null;
        }
        return fm.findFragmentByTag(fm.getBackStackEntryAt(backStackEntryCount - 1).getName());
    }

    @Override
    public void onBackPressed() {
        if (getStackTopFragment() instanceof HomeFragment) {
            if (backToExit) {
                finish();
            } else {
                Toast.makeText(this, "再按一次返回键退出", Toast.LENGTH_SHORT).show();
                backToExit = true;
            }
            getWindow().getDecorView().postDelayed(new Runnable() {
                @Override
                public void run() {
                    backToExit = false;
                }
            }, BACK_TO_EXIT_DELAY_TIME);
        } else {
            super.onBackPressed();
        }
        setCurrentTab(getStackTopFragment().getClass());
    }


//    public void finishFragment() {
//        fm.popBackStack();
//    }
//
//    public boolean finishFragmentImmediate() {
//        return fm.popBackStackImmediate();
//    }

    //    public void startFragmentAfterFinish(Class<Fragment> fClass) {
//        if (finishFragmentImmediate()) {
//            startFragmentAfterFinish(fClass);
//        }
//    }
}
