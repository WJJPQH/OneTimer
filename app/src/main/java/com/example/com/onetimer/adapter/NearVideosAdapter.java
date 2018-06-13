package com.example.com.onetimer.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.com.onetimer.R;
import com.example.com.onetimer.bean.HotVideosBean;
import com.example.com.onetimer.bean.NearVideosBean;

import java.util.List;

public class NearVideosAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<NearVideosBean.DataBean> list;
    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;
    public NearVideosAdapter(Context context, List<NearVideosBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }



    public interface OnItemClickListener{
        void onItemClick(NearVideosBean.DataBean dataBean);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.nearvideo_item, parent, false);
        NearVideosViewHolder nearVideosViewHolder = new NearVideosViewHolder(view);
        return nearVideosViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final NearVideosViewHolder nearVideosViewHolder = (NearVideosViewHolder) holder;
//        hotVideosViewHolder.video_img.setImageURI(Uri.parse(list.get(position).getUser().getIcon()));
        final NearVideosBean.DataBean dataBean = list.get(position);
        Glide.with(context).load(list.get(position).getCover()).into(nearVideosViewHolder.video_img);
        nearVideosViewHolder.text_comment.setText(list.get(position).getCommentNum()+"");
        nearVideosViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(dataBean);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class NearVideosViewHolder extends RecyclerView.ViewHolder {
        private ImageView video_img;
        private TextView text_comment;
        private RelativeLayout ll;
        public NearVideosViewHolder(View itemView) {
            super(itemView);
            ll = itemView.findViewById(R.id.ll);
            video_img = itemView.findViewById(R.id.videoimg);
            text_comment = itemView.findViewById(R.id.text_comment);
        }
    }

}
