package com.powersen.view;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.powersen.adapter.MyAdapter;
import com.powersen.bean.MyBean;
import com.powersen.R;
import com.powersen.presenter.UserPresenter;

import java.util.List;

/**
 * 实现userView
 * 重写三个方法
 */
public class MainActivity extends AppCompatActivity implements UserView {

    private UserPresenter presenter;
    private RecyclerView recyclerView;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        //实例化Presenter
        presenter = new UserPresenter(this);
        //调用P层请求数据方法
        presenter.getData();
    }

    @Override
    public void onSeccess() {
        //注意必须在线程里面做操作，以下方法都是
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "请求数据成功！", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onFailed() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "请求数据失败！", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void showAdapter(final List<MyBean.SubjectsBean> list) {
        /**
         * 创建了handler然后使用post方法在线程里配置适配器
         */
        handler.post(new Runnable() {
            @Override
            public void run() {
                recyclerView.setAdapter(new MyAdapter(MainActivity.this, list));
            }
        });

    }
}
