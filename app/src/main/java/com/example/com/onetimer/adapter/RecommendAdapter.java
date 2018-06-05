package com.example.com.onetimer.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.com.onetimer.R;
import com.example.com.onetimer.bean.RecommendBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;
import java.util.zip.Inflater;

import okhttp3.internal.http.HttpMethod;

public class RecommendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final LayoutInflater inflater;
    private List<RecommendBean.DataBean> list;
    private Context context;
    private boolean like_pd=false;
    private boolean seek_pd=false;

    public RecommendAdapter(List<RecommendBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
         inflater= LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.recommend_layout,null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            final MyViewHolder holder1= (MyViewHolder) holder;
            //赋值
            holder1.tx.setImageURI(list.get(position).getUser().getIcon());
            holder1.name.setText(list.get(position).getUser().getNickname());
            holder1.time.setText(list.get(position).getCreateTime());
            holder1.title.setText(list.get(position).getWorkDesc());
        //设置视频控制器
        holder1.voideo.setMediaController(new MediaController(context));

        //播放完成回调
        holder1.voideo.setOnCompletionListener( new MyPlayerOnCompletionListener());

        //设置视频路径"
        holder1.voideo.setVideoURI(Uri.parse(list.get(position).getVideoUrl()));
        holder1.voideo.requestFocus();
        if(list.get(position).getComments()!=null){
            return;
        }else{
            for (int i=0;i<list.get(position).getComments().size();i++){
                TextView view=new TextView(context);
                view.setText(list.get(position).getComments().get(i).getNickname()+" : "+list.get(position).getComments().get(i).getContent());
                view.setPadding(5,5,5,5);
                holder1.comment_qu.addView(view);
            }
        }
        holder1.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(like_pd){
                    Toast.makeText(context,"喜欢",Toast.LENGTH_SHORT).show();

                    like_pd=false;
                    Uri uri=Uri.parse(""+R.drawable.raw1499933215);
                    holder1.like.setImageURI(uri);
                }else {
                    like_pd=true;
                    Toast.makeText(context,"不喜欢",Toast.LENGTH_SHORT).show();

                    Uri uri=Uri.parse(""+R.drawable.raw_1499933216);
                    holder1.like.setImageURI(uri);

                }
            }
        });
        holder1.seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(seek_pd==false){
                    Toast.makeText(context,"不收藏",Toast.LENGTH_SHORT).show();
                    seek_pd=true;
                    Uri uri=Uri.parse(""+R.drawable.raw_1499947358);
                    holder1.seek.setImageURI(uri);
                }else {
                    seek_pd=false;
                    Toast.makeText(context,"收藏",Toast.LENGTH_SHORT).show();
                    Uri uri=Uri.parse(""+R.drawable.raw_1500022686);
                    holder1.seek.setImageURI(uri);
                }
            }
        });
    }
    class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            Toast.makeText( context, "播放完成了", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView tx;
        private final TextView name;
        private final TextView time;
        private final TextView title;
        private final VideoView voideo;
        private final LinearLayout comment_qu;
        private final ImageView like;
        private final ImageView seek;

        public MyViewHolder(View itemView) {
            super(itemView);
            tx=itemView.findViewById(R.id.recomend_tx);
            name=itemView.findViewById(R.id.recomend_name);
            time=itemView.findViewById(R.id.recomend_time);
            title=itemView.findViewById(R.id.recomend_title);
            voideo=itemView.findViewById(R.id.recomend_video);
            comment_qu=itemView.findViewById(R.id.comment_qu);
            like=itemView.findViewById(R.id.like_img);
            seek=itemView.findViewById(R.id.seek_img);
        }
    }
}
