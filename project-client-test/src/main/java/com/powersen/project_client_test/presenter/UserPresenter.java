package com.powersen.project_client_test.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.powersen.project_client_test.adapter.MyAdapter;
import com.powersen.project_client_test.model.IModel;
import com.powersen.project_client_test.model.UserModel;
import com.powersen.project_client_test.model.bean.MyBean;
import com.powersen.project_client_test.view.UserView;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/11/21.
 */

public class UserPresenter {
    private final UserView userView;
    private final IModel iModel;

    public UserPresenter(UserView userView) {
        this.userView = userView;
        this.iModel = new IModel();
    }

    /**
     * presenter利用model返回的被观察者 ，用rxjava的形式处理请求结果
     */
    public void getData() {
        Observable<MyBean> observable = iModel.getMovie();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull MyBean myBean) {
                        if (myBean != null) {
                            userView.getDataSeccess();
                            userView.showAdapter(myBean.getSubjects());
                            Log.d("-----", "onNext: " + myBean.toString());
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        userView.getDataSeccess();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
