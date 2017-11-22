package com.powersen.project_client_test.view;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.powersen.project_client_test.R;
import com.powersen.project_client_test.adapter.MyAdapter;
import com.powersen.project_client_test.model.bean.MyBean;
import com.powersen.project_client_test.presenter.UserPresenter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity implements UserView {

    private UserPresenter presenter;
    private List<MyBean.SubjectsBean> list = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        presenter = new UserPresenter(this);
        presenter.getData();
    }


    @Override
    public void getDataSeccess() {
        Toast.makeText(MainActivity.this, "请求成功！", Toast.LENGTH_LONG).show();
    }

    @Override
    public void getDataFailed() {
        Toast.makeText(MainActivity.this, "请求失败！", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showAdapter(List<MyBean.SubjectsBean> list) {
        recyclerView.setAdapter(new MyAdapter(MainActivity.this, list));
    }
}
