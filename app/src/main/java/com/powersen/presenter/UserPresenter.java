package com.powersen.presenter;

import com.powersen.url.BaseURL;
import com.powersen.bean.MyBean;
import com.powersen.app.AppOk;
import com.powersen.model.UserModel;
import com.powersen.view.UserView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lenovo on 2017/11/22.
 * 在Presenter层里做的是View层与Model的交互
 */

public class UserPresenter {
    private final UserModel userModel;
    private final UserView userView;

    public UserPresenter(UserView userView) {
        this.userModel = new UserModel();
        this.userView = userView;
    }

    //请求数据方法
    public void getData() {
        /**
         * 这个request就是Model层里方法的返回值，并且参数里赋上Url也就是接口
         */
        Request request = userModel.getData(BaseURL.BASE_URL);
        //调用初始化过的OKHTTP通过call来请求数据
        AppOk.okHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                userView.onFailed();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                userView.onSeccess();
                if (response.body() != null) {
                    String json = response.body().string();
                    MyBean bean = MyBean.objectFromData(json);
                    if (bean != null) {
                        //这是配置适配器的方法，注意里面参数
                        userView.showAdapter(bean.getSubjects());
                    }
                }
            }
        });
    }

}
