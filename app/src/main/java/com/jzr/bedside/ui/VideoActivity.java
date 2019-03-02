package com.jzr.bedside.ui;

import android.view.View;
import android.widget.ImageView;

import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseActivity;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;

public class VideoActivity extends BaseActivity {
    PlayerView playerView;
    ImageView ivVideoFinish;

    @Override
    public int getLayoutId() {
        return R.layout.activity_video;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void initView() {

        View rootView = getLayoutInflater().from(this).inflate(R.layout.simple_player_view_player, null);
        setContentView(rootView);
        ivVideoFinish =(ImageView)rootView.findViewById(R.id.app_video_finish);
        String url = getIntent().getStringExtra("URL");
        String title =  getIntent().getStringExtra("TITLE");
        playerView = new PlayerView(this)
                .setScaleType(PlayStateParams.fitparent)
                .setPlaySource(url)
                .setTitle(title)
                .startPlay();

        ivVideoFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerView.stopPlay();
                playerView.onDestroy();
                finish();
            }
        });
    }
}