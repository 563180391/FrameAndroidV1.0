package com.epoint.app.basecore.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者： 张健
 * 创建时间： 2018/7/30 19:03
 * 版权： 江苏国泰新点软件有限公司
 * 版本： [1.0 2018/7/30 ]
 * 描述： 页面控制器接口。 可以理解为页面代理。统一由该控制器处理逻辑
 */
public interface IPageControl {

    void setOrientation();

    View initBaseView(LayoutInflater var1, ViewGroup var2);

    void showLoading();

    void showLoading(String var1);

    void hideLoading();

    void toast(String var1);

    void setLayout(int var1);

    void setLayout(View var1);

    void setTitle(String var1);

    void setTitle(String[] var1);

    Context getContext();

    Activity getActivity();

    Object getFragment();

    View getRootView();

    View getBaseContent();

    View findViewById(int var1);

    IErrorControl getStatusPage();

    void setStatusPage(IErrorControl var1);

    void onDestroy();

    void onResume();

    void onStop();

    void finish();

    void startActivity();

}
