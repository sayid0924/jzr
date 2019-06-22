package com.jzr.bedside.ui;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.bean.EvenBusColos;
import com.jzr.bedside.bean.VideoBean;
import com.jzr.bedside.presenter.contract.activity.PlayVideoContract;
import com.jzr.bedside.presenter.impl.activity.PlayVideoPresenter;
import com.jzr.bedside.ui.apadter.PlayVideoApadter;
import com.jzr.bedside.utils.PreferUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class PlayVideoActivity extends BaseActivity  implements PlayVideoContract.View, OnLoadmoreListener {

    private PlayVideoPresenter mPresenter = new PlayVideoPresenter();

    private List<VideoBean.DataBean.ListBean>  videoBeans = new ArrayList<>();
    private PlayVideoApadter playVideoApadter;
    private  int pageNum=1;
    private  int pageSize=10;
    private int pages;

    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.iv_right_back)
    ImageView ivRightBack;
    @BindView(R.id.left_title)
    TextView leftTitle;
    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;

    @BindView(R.id.rv_video)
    RecyclerView rvVideo;
    @BindView(R.id.srl)
    SmartRefreshLayout srl;

    @Override
    public int getLayoutId() {
        return R.layout.activity_play_video;
    }

    @Override
    public void attachView() {
        mPresenter.attachView(this);
    }

    @Override
    public void detachView() {
      mPresenter.detachView();
    }

    @Override
    public void initView() {

        leftTitle.setVisibility(View.VISIBLE);
        ivRightBack.setVisibility(View.VISIBLE);
        ivRight.setVisibility(View.VISIBLE);
        leftTitle.setText(PreferUtil.getInstance().getLocationInfo());
        actionbarTitle.setText("视频播放");

        srl.setOnLoadmoreListener(this);
        playVideoApadter = new PlayVideoApadter(videoBeans, this);
        rvVideo.setLayoutManager(new GridLayoutManager(this,4));
        rvVideo.setAdapter(playVideoApadter);
        mPresenter.gettVideovoByCondition("videoType","1","pageNum",String.valueOf(pageNum),"pageSize",String.valueOf(pageSize));

    }

    @OnClick({R.id.iv_right_back, R.id.iv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_right_back:
                finish();
                break;
            case R.id.iv_right:
                EventBus.getDefault().post(new EvenBusColos());
                finish();
                break;
        }
    }


    @Override
    public void gettVideovoByConditionSuccess(VideoBean data) {
        pages = data.getData().getPages();
        if (srl.isLoading()) {
            playVideoApadter.addData(data.getData().getList());
            srl.finishLoadmore();
        } else {
            if (videoBeans.size() != 0) videoBeans.clear();
            videoBeans = data.getData().getList();
            playVideoApadter.setNewData(videoBeans);
        }
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        if (pageNum < pages) {
            pageNum++;
            mPresenter.gettVideovoByCondition("videoType","1","pageNum",String.valueOf(pageNum),"pageSize",String.valueOf(pageSize));
        } else {
            srl.setEnableLoadmore(false);
        }
    }
}
