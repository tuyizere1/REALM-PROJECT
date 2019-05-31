/* package com.paccy.realmloginvideoplayer.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.paccy.realmloginvideoplayer.Model.VideoModel;
import com.paccy.realmloginvideoplayer.R;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    Context context;
    ArrayList<VideoModel> arrayListVideos;
    public VideoAdapter(Context context, ArrayList<VideoModel> arrayListVideos) {
        this.context = context;
        this.arrayListVideos = arrayListVideos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_video,parent,false);

        //ViewHolder viewHolder= new ViewHolder(view);
        //return viewHolder;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load("file://" + arrayListVideos.get(position).getStr_thumb())
                .skipMemoryCache(false)
                .into(holder.imageView);

        holder.r1_select.setBackgroundColor(Color.parseColor("#ffffff"));
        holder.r1_select.setAlpha(0);

        holder.r1_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"you Clicked the video",Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayListVideos.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        RelativeLayout r1_select;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.iv_image);
            r1_select = (RelativeLayout)itemView.findViewById(R.id.r1_select);



        }
    }
}
 //*/