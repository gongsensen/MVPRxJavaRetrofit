package com.powersen.view;

import com.powersen.bean.MyBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/22.
 */

public interface UserView {
    /**
     * View层只需要写一些显示界面的东西，比如说一个Toast，给RecyclerView配置适配器，弹出Dialog等
     */
    void onSeccess();

    void onFailed();

    void showAdapter(List<MyBean.SubjectsBean> list);
}
