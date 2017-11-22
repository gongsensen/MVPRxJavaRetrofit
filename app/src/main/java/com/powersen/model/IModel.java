package com.powersen.model;

import okhttp3.Request;

/**
 * Created by lenovo on 2017/11/22.
 */

public interface IModel {
//    初始化OKHTTP之后，这个方法是用来请求数据的
    Request getData(String url);
}
