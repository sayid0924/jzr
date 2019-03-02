package com.jzr.bedside.ui;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.base.BaseFragmentPageAdapter;
import com.jzr.bedside.bean.EvenBusColos;
import com.jzr.bedside.bean.TabEntity;
import com.jzr.bedside.ui.fragment.food.AllFoodFragment;
import com.jzr.bedside.utils.PreferUtil;
import com.jzr.bedside.view.NoScrollViewPager;
import com.jzr.bedside.view.verticaltablayout.VerticalTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class MrdeingMealsActivity extends BaseActivity implements VerticalTabLayout.OnTabSelectedListener {

    private ArrayList<String> mTitleList = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private int[] mIconUnselectIds = {
            R.drawable.dialog_waiting, R.drawable.dialog_waiting,
            R.drawable.dialog_waiting, R.drawable.dialog_waiting,
            R.drawable.dialog_waiting, R.drawable.dialog_waiting};
    private int[] mIconSelectIds = {
            R.drawable.dialog_waiting, R.drawable.dialog_waiting,
            R.drawable.dialog_waiting, R.drawable.dialog_waiting,
            R.drawable.dialog_waiting, R.drawable.dialog_waiting};

    private  BaseFragmentPageAdapter myAdapter;

    @BindView(R.id.tab_layout)
    VerticalTabLayout tabLayout;
    @BindView(R.id.vp)
    NoScrollViewPager vp;

    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.iv_right_back)
    ImageView ivRightBack;
    @BindView(R.id.left_title)
    TextView leftTitle;
    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mrdeing_meals;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void initView() {

        leftTitle.setVisibility(View.VISIBLE);
        ivRightBack.setVisibility(View.VISIBLE);
        ivRight.setVisibility(View.VISIBLE);
        leftTitle.setText(PreferUtil.getInstance().getLocationInfo());
        actionbarTitle.setText("院内点餐");

        mTitleList.add("全部");
        mTitleList.add("精美小炒");
        mTitleList.add("主食");
        mTitleList.add("零食");
        mTitleList.add("夜宵");
        mTitleList.add("营养套餐");

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

        mFragments.add(AllFoodFragment.getInstance());
        mFragments.add(AllFoodFragment.getInstance());
        mFragments.add(AllFoodFragment.getInstance());

        mFragments.add(AllFoodFragment.getInstance());
        mFragments.add(AllFoodFragment.getInstance());
        mFragments.add(AllFoodFragment.getInstance());

        myAdapter.notifyDataSetChanged();
        tabLayout.setSelectedTab(0);
        vp.setCurrentItem(0);

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
}