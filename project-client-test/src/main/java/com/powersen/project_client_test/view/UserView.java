package com.powersen.project_client_test.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.powersen.project_client_test.model.bean.MyBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/21.
 */

public interface UserView {
    /**
     * 在V层有请求成功或失败的方法
     * 给RecyclerView配置适配器的方法也在V层
     */
    void getDataSeccess();

    void getDataFailed();

    void showAdapter(List<MyBean.SubjectsBean> list);
}
