package com.jzr.bedside.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.bean.EvenBusColos;
import com.jzr.bedside.utils.CommonUtil;
import com.jzr.bedside.utils.PreferUtil;

import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;

public class ContentsActivity extends BaseActivity {

    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.iv_right_back)
    ImageView ivRightBack;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.iv_hospital)
    ImageView ivHospital;
    @BindView(R.id.iv_record)
    ImageView ivRecord;
    @BindView(R.id.iv_Service)
    ImageView ivService;
    @BindView(R.id.iv_expense)
    ImageView ivExpense;
    @BindView(R.id.iv_video)
    ImageView ivVideo;
    @BindView(R.id.iv_pay)
    ImageView ivPay;
    @BindView(R.id.iv_cctv)
    ImageView ivCctv;
    @BindView(R.id.iv_mrdering_meals)
    ImageView ivMrderingMeals;
    @BindView(R.id.iv_temp)
    ImageView ivTemp;
    @BindView(R.id.iv_oximetry)
    ImageView ivOximetry;
    @BindView(R.id.iv_bloodpressur)
    ImageView ivBloodpressur;
    @BindView(R.id.left_title)
    TextView leftTitle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_contents;
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
        ivBack.setVisibility(View.GONE);
        leftTitle.setText(PreferUtil.getInstance().getLocationInfo());

    }

    @Subscribe
    public void getEventBus(EvenBusColos evenBusColos) {
        finish();
    }

    @OnClick({R.id.iv_right_back, R.id.iv_right, R.id.iv_hospital, R.id.iv_cctv,
            R.id.iv_record, R.id.iv_Service, R.id.iv_video,R.id.iv_expense,R.id.iv_pay,
            R.id.iv_mrdering_meals,R.id.iv_temp,R.id.iv_oximetry,R.id.iv_bloodpressur})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_right_back:
                finish();
                break;
            case R.id.iv_right:
                finish();
                break;
            case R.id.iv_hospital:
                startActivityIn(new Intent(ContentsActivity.this, HospitalActivity.class), ContentsActivity.this);
                break;
            case R.id.iv_record:
                startActivityIn(new Intent(ContentsActivity.this, RecordActivity.class), ContentsActivity.this);
                break;
            case R.id.iv_Service:
                startActivityIn(new Intent(ContentsActivity.this, EvaluateActivity.class), ContentsActivity.this);
                break;
            case R.id.iv_video:
                startActivityIn(new Intent(ContentsActivity.this, PlayVideoActivity.class), ContentsActivity.this);
                break;
            case R.id.iv_expense:
                startActivityIn(new Intent(ContentsActivity.this, ExpenseActivity.class), ContentsActivity.this);
                break;
            case R.id.iv_pay:
                startActivityIn(new Intent(ContentsActivity.this, PayActivity.class), ContentsActivity.this);
                break;
            case R.id.iv_cctv:
                CommonUtil.launchCctvAPK(this,"cn.cntvhd");
                break;
            case R.id.iv_mrdering_meals:
                startActivityIn(new Intent(ContentsActivity.this, MrdeingMealsActivity.class), ContentsActivity.this);
                break;
            case R.id.iv_temp:
                startActivityIn(new Intent(ContentsActivity.this, GaugeTempActivity.class), ContentsActivity.this);
                break;
            case R.id.iv_oximetry:
                startActivityIn(new Intent(ContentsActivity.this, OximetryActivity.class), ContentsActivity.this);
                break;
            case R.id.iv_bloodpressur:
                startActivityIn(new Intent(ContentsActivity.this, BloodPressureActivity.class), ContentsActivity.this);
                break;
        }
    }
}
