package com.powersen.project_client_test.api;


import com.powersen.project_client_test.model.bean.MyBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2017/11/21.
 */

public interface ApiService {
//    https://api.douban.com/v2/movie/top250
    @GET("v2/movie/top250")
    Observable<MyBean> getMovieData();
}
