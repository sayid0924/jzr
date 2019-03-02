package com.jzr.bedside.ui.apadter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.jzr.bedside.R;
import com.jzr.bedside.bean.VideoBean;
import com.jzr.bedside.ui.VideoActivity;
import com.jzr.bedside.utils.GlideUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dou361.ijkplayer.widget.IjkVideoView;

import java.util.List;

public class PlayVideoApadter extends BaseQuickAdapter<VideoBean.DataBean.ListBean,BaseViewHolder> {

    private Activity mContext;
    private List<VideoBean.DataBean.ListBean> data;
    private IjkVideoView playerView;

    public PlayVideoApadter(List<VideoBean.DataBean.ListBean> data, Activity mContext) {
        super(R.layout.item_playvideo, data);
        this.mContext = mContext;
        this.data = data;
    }



    @Override
    protected void convert(final BaseViewHolder helper, final VideoBean.DataBean.ListBean item) {
           helper.setText(R.id.tv_name,item.getDescription());
            ImageView iv= helper.getView(R.id.iv_url);

        GlideUtils.load(mContext,item.getImageUrl(),iv,R.drawable.yiyuanglogo);
           helper.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent i = new Intent(mContext, VideoActivity.class);
                   i.putExtra("TITLE",item.getDescription());
                   i.putExtra("URL",item.getVideoUrl());
                   mContext.startActivity(i);
               }
           });


    }

}
