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
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.com.onetimer.R;
import com.example.com.onetimer.bean.RecommendBean;
import com.example.com.onetimer.onlick.OnItreamClickListener;
import com.example.com.onetimer.recommend.contract.UserVideosContract;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class UserVoidersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final LayoutInflater inflater;
    private RecommendBean.DataBean list;
    private Context context;
    private boolean like_pd=false;
    private boolean seek_pd=false;
    List<UserVideosBean.DataBean> userlist;
    private OnItreamClickListener onItreamClickListener;
    public UserVoidersAdapter(RecommendBean.DataBean list, Context context, List<UserVideosBean.DataBean> userlist) {
        this.list = list;
        this.context = context;
        this.userlist=userlist;
         inflater= LayoutInflater.from(context);
    }
    public void setOnItemClickListener(OnItreamClickListener onItemClickListener){
        this.onItreamClickListener=onItemClickListener;

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.recommend_layout,null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
            final MyViewHolder holder1= (MyViewHolder) holder;
            //赋值
            holder1.tx.setImageURI(list.getUser().getIcon());
        holder1.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItreamClickListener!=null){
                    onItreamClickListener.onItemClick(position);
                }
            }
        });


        holder1.name.setText(list.getUser().getNickname());
            holder1.time.setText(userlist.get(position).getCreateTime());
            holder1.title.setText(list.getWorkDesc());
        holder1.voideo.TOOL_BAR_EXIST = false;
        holder1.voideo.setUp(userlist.get(position).getVideoUrl()
                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "看什么没有标题啦!");
//        jcVideoPlayerStandard.loop  = true;//是否循环播放
        Glide.with(context).load("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640")
                .into( holder1.voideo.thumbImageView);

//        JCVideoPlayerStandard.startFullscreen(this, JCVideoPlayerStandard.class, "http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4", "嫂子辛苦了");
        //直接进入全屏

        if(list.getComments()!=null){
            return;
        }else{
            for (int i=0;i<list.getComments().size();i++){
                TextView view=new TextView(context);
                view.setText(list.getComments().get(i).getNickname()+" : "+list.getComments().get(i).getContent());
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
        return userlist.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView tx;
        private final TextView name;
        private final TextView time;
        private final TextView title;
        private final JCVideoPlayerStandard voideo;
        private final LinearLayout comment_qu;
        private final ImageView like;
        private final ImageView seek;
        private final LinearLayout ll;

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
            ll=itemView.findViewById(R.id.recommend_click);
        }
    }
    //刷新
    public  void refresh(List<UserVideosBean.DataBean> temlist){
        this.userlist.clear();
        this.userlist.addAll(temlist);
    }
    //加载更多
    public  void loadMore(List<UserVideosBean.DataBean> list){
        this.userlist.addAll(list);
        notifyDataSetChanged();
    }
}
