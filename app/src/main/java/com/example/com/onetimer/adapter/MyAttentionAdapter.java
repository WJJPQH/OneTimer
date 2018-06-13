package com.example.com.onetimer.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.com.onetimer.R;
import com.example.com.onetimer.bean.AttentionBean;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;

public class MyAttentionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final LayoutInflater inflater;
    private List<AttentionBean.DataBean> list;
    private Context context;

    public MyAttentionAdapter(List<AttentionBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater= LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.myattention_list,null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1= (MyViewHolder) holder;
        holder1.name.setText(list.get(position).getUsername());
        holder1.tx.setImageURI(list.get(position).getIcon());
        holder1.qm.setText(""+list.get(position).getNickname());
        holder1.time.setText(list.get(position).getCreatetime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView tx;
        private final TextView time;
        private final TextView name;
        private final TextView qm;

        public MyViewHolder(View itemView) {
            super(itemView);
            tx=itemView.findViewById(R.id.myattention_tx);
            name=itemView.findViewById(R.id.myattention_name);
            qm=itemView.findViewById(R.id.myattention_qm);
            time=itemView.findViewById(R.id.myattention_time);
        }
    }

}
