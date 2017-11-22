package com.powersen.project_client_test.model;

import com.powersen.project_client_test.api.API;
import com.powersen.project_client_test.api.ApiService;
import com.powersen.project_client_test.model.bean.MyBean;
import com.powersen.project_client_test.model.utils.ClientUtils;

import io.reactivex.Observable;

/**
 * Created by lenovo on 2017/11/21.
 */

public class IModel implements UserModel {
    @Override
    public Observable<MyBean> getMovie() {
        return ClientUtils.getclientData(API.DOUBAN_URl).create(ApiService.class).getMovieData();
    }
}
