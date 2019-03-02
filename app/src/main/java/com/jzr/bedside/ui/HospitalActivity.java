package com.jzr.bedside.ui;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.base.BaseFragmentPageAdapter;
import com.jzr.bedside.bean.EvenBusColos;
import com.jzr.bedside.bean.HospitalBean;
import com.jzr.bedside.bean.TabEntity;
import com.jzr.bedside.db.database.BedInfoBeanDbDao;
import com.jzr.bedside.db.entity.BedInfoBeanDb;
import com.jzr.bedside.presenter.contract.activity.HospitalActivityContract;
import com.jzr.bedside.presenter.impl.activity.HospitalActivityPresenter;
import com.jzr.bedside.ui.fragment.DetailedIntroductionFragment;
import com.jzr.bedside.ui.fragment.FamousDoctorsFragment;
import com.jzr.bedside.ui.fragment.HospitalListFragment;
import com.jzr.bedside.ui.fragment.TelephoneAddressFragment;
import com.jzr.bedside.utils.GlideUtils;
import com.jzr.bedside.utils.GreenDaoUtil;
import com.jzr.bedside.utils.PreferUtil;
import com.jzr.bedside.view.NoScrollViewPager;
import com.jzr.bedside.view.verticaltablayout.VerticalTabLayout;
import com.blankj.utilcode.utils.EmptyUtils;
import com.flyco.tablayout.listener.CustomTabEntity;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class HospitalActivity extends BaseActivity implements HospitalActivityContract.View,  VerticalTabLayout.OnTabSelectedListener {

    private HospitalActivityPresenter mPresenter =new HospitalActivityPresenter(this);
    private ArrayList<String> mTitleList = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private   BedInfoBeanDbDao collectionInfoDao;
    private  BaseFragmentPageAdapter myAdapter;
    public  static HospitalActivity hospitalActivity;

    private int[] mIconUnselectIds = {
            R.drawable.dialog_waiting, R.drawable.dialog_waiting,
            R.drawable.dialog_waiting, R.drawable.dialog_waiting};
    private int[] mIconSelectIds = {
            R.drawable.dialog_waiting, R.drawable.dialog_waiting,
            R.drawable.dialog_waiting, R.drawable.dialog_waiting};

    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.iv_right_back)
    ImageView ivRightBack;
    @BindView(R.id.left_title)
    TextView leftTitle;
    @BindView(R.id.tab_layout)
    VerticalTabLayout tabLayout;
    @BindView(R.id.vp)
    NoScrollViewPager vp;
    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;

    @Override
    public int getLayoutId() {
        return R.layout.activity_hospital;
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
        actionbarTitle.setText("医院介绍");

        mTitleList.add("详细介绍");
//        mTitleList.add("科室列表");
//        mTitleList.add("名医推荐");
        mTitleList.add("电话地址");


        for (int i = 0; i < mTitleList.size(); i++) {
            mTabEntities.add(new TabEntity(mTitleList.get(i), mIconSelectIds[i], mIconUnselectIds[i]));
        }

        for(int i=0;i<mTitleList.size();i++){
            tabLayout.addTab(tabLayout.newTab().setText(mTitleList.get(i)));
        }
        tabLayout.setOnTabSelectedListener(this);
        vp.setNoScroll(true);

         myAdapter = new BaseFragmentPageAdapter(getSupportFragmentManager(), mFragments, mTitleList);
        vp.setAdapter(myAdapter);

        collectionInfoDao = GreenDaoUtil.getDaoSession().getBedInfoBeanDbDao();
        BedInfoBeanDb infoBeanDb = collectionInfoDao.queryBuilder().where(
                BedInfoBeanDbDao.Properties.Id.eq(0)).unique();
        if (infoBeanDb != null) {
            if (EmptyUtils.isNotEmpty(infoBeanDb.getBedInfoBean().getData().getTpatientVo().getHospitalId())) {
                mPresenter.selectByHospitalId("hospitalId", String.valueOf(infoBeanDb.getBedInfoBean().getData().getTpatientVo().getHospitalId()));
            }
        }

        hospitalActivity= this;

        mFragments.add(DetailedIntroductionFragment.getInstance(null));
//        mFragments.add(HospitalListFragment.getInstance(null));
//        mFragments.add(FamousDoctorsFragment.getInstance(null));
        mFragments.add(TelephoneAddressFragment.getInstance(null));
        myAdapter.notifyDataSetChanged();
        tabLayout.setSelectedTab(0);
        vp.setCurrentItem(0);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hospitalActivity = null;
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
    public void onTabSelected(VerticalTabLayout.Tab tab, int position) {
        vp.setCurrentItem(position);
    }

    @Override
    public void onTabReleased(VerticalTabLayout.Tab tab, int position) {

    }

    @Override
    public void selectByHospitalIdSuccess(HospitalBean hospitalBean) {
        GlideUtils.load(this,hospitalBean.getData().getLogoUrl(),ivLogo,R.drawable.yiyuanglogo);
        mFragments.add(DetailedIntroductionFragment.getInstance(hospitalBean));
        mFragments.add(HospitalListFragment.getInstance(hospitalBean));
        mFragments.add(FamousDoctorsFragment.getInstance(hospitalBean));
        mFragments.add(TelephoneAddressFragment.getInstance(hospitalBean));
        myAdapter.notifyDataSetChanged();
        tabLayout.setSelectedTab(0);
        vp.setCurrentItem(0);
    }

    @Override
    public void showError(String message) {

    }
}
