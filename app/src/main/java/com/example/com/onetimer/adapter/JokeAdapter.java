package com.example.com.onetimer.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.com.onetimer.R;
import com.example.com.onetimer.bean.JokeBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class JokeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<JokeBean.DataBean> list;
    private LayoutInflater inflater;

    public JokeAdapter(Context context, List<JokeBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.joke_item, parent, false);
        JokeViewHolder jokeViewHolder =new JokeViewHolder(view);
        return jokeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        JokeViewHolder jokeViewHolder = (JokeViewHolder) holder;
        JokeBean.DataBean dataBean = list.get(position);
        jokeViewHolder.content.setText(list.get(position).getContent());
        jokeViewHolder.username.setText(list.get(position).getUser().getNickname()+"");
        Glide.with(context).load(list.get(position).getImgUrls()).into(jokeViewHolder.img);
        String imgto = list.get(position).getUser().getIcon();
        jokeViewHolder.imgtou.setImageURI(imgto);
        jokeViewHolder.creatTime.setText(list.get(position).getCreateTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class JokeViewHolder extends RecyclerView.ViewHolder {
        private TextView username;
        private SimpleDraweeView imgtou;
        private TextView content;
        private SimpleDraweeView img;
        private TextView creatTime;
        public JokeViewHolder(View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.content);
            imgtou = itemView.findViewById(R.id.imgtou1);
            username = itemView.findViewById(R.id.username);
            img = itemView.findViewById(R.id.img);
            creatTime = itemView.findViewById(R.id.creattime);
        }
    }
}
