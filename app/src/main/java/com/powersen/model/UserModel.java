package com.powersen.model;


import okhttp3.Request;

/**
 * Created by lenovo on 2017/11/22.
 */

public class UserModel implements IModel {
    /**
     * Model层实现IModel然后重写imodel的方法，
     * 实例化request
     * 注意返回值
     * @param url
     * @return
     */
    @Override
    public Request getData(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        return request;
    }
}
