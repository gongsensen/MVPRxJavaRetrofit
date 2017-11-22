package com.powersen.project_client_test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.powersen.project_client_test.R;
import com.powersen.project_client_test.model.bean.MyBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/21.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<MyBean.SubjectsBean> list = new ArrayList<>();

    public MyAdapter(Context context, List<MyBean.SubjectsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.fresco.setImageURI(list.get(position).getImages().getLarge());
        holder.title.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }else{
            return 0;
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
//        private SimpleDraweeView fresco;

        public ViewHolder(View itemView) {
            super(itemView);

            this.title = itemView.findViewById(R.id.item_title);
//            this.fresco = itemView.findViewById(R.id.item_fresco);

        }
    }
}
