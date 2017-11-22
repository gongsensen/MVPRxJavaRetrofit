package com.powersen.project_client_test.model;

import com.powersen.project_client_test.model.bean.MyBean;

import io.reactivex.Observable;

/**
 * Created by lenovo on 2017/11/21.
 */

public interface UserModel {

    Observable<MyBean> getMovie();

}
