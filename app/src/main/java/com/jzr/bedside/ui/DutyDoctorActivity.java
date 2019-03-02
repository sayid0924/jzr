package com.jzr.bedside.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.bean.DoctorBean;
import com.jzr.bedside.bean.NurseInfoBean;
import com.jzr.bedside.presenter.contract.activity.DutyDoctorContract;
import com.jzr.bedside.presenter.impl.activity.DutyDoctorActivityPresenter;
import com.jzr.bedside.utils.GlideUtils;
import com.jzr.bedside.utils.PreferUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class DutyDoctorActivity extends BaseActivity implements DutyDoctorContract.View {

    DutyDoctorActivityPresenter mPresenter = new DutyDoctorActivityPresenter(this);

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.left_title)
    TextView leftTitle;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.iv_right_back)
    ImageView ivRightBack;

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_code)
    TextView tvCode;
    @BindView(R.id.tv_dept)
    TextView tvDept;
    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;
    @BindView(R.id.tv_specialty)
    TextView tvSpecialty;
    @BindView(R.id.tv_intro)
    TextView tvIntro;

    @BindView(R.id.iv_logo)
    ImageView tvLogo;

    @BindView(R.id.tv_type)
    TextView tvType;

    @Override
    public int getLayoutId() {
        return R.layout.activity_duty_doctor;
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
        ivRightBack.setVisibility(View.GONE);
        ivRight.setVisibility(View.VISIBLE);
        ivBack.setVisibility(View.GONE);
        leftTitle.setText(PreferUtil.getInstance().getLocationInfo());

//        if (getIntent().getIntExtra("TYPE", 0) == 0) {
//            actionbarTitle.setText("医生详情");
//            tvType.setText("主治医生");
//            if (MainActivity.mainActivity.data != null && MainActivity.mainActivity.data.getData().getTpatientVo().getTdoctorBrieflyVoList()!=null &&
//                    MainActivity.mainActivity.data.getData().getTpatientVo().getTdoctorBrieflyVoList().size() != 0) {
//                mPresenter.selectByDoctorId("doctorId",
//                        String.valueOf(MainActivity.mainActivity.data.getData().getTpatientVo().getTdoctorBrieflyVoList().get(0).getId()));
//            }
//        } else {
//            if (MainActivity.mainActivity.data != null &&  MainActivity.mainActivity.data.getData().getTpatientVo().getTnurseBrieflyVoList()!=null &&
//                    MainActivity.mainActivity.data.getData().getTpatientVo().getTnurseBrieflyVoList().size() != 0) {
//                actionbarTitle.setText("护士详情");
//                tvType.setText("主治护士");
//                mPresenter.selectByNurseId("nurseId",
//                        String.valueOf(MainActivity.mainActivity.data.getData().getTpatientVo().getTnurseBrieflyVoList().get(0).getId())
//                );
//            }
//        }

    }


    @OnClick({R.id.iv_right_back, R.id.iv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_right_back:
                finish();
                break;
            case R.id.iv_right:
                finish();
                break;
        }
    }

    @Override
    public void selectByDoctorIdSuccess(DoctorBean doctorBean) {
        GlideUtils.load(this,doctorBean.getData().getImageUrl(),tvLogo,R.drawable.yiyuanglogo);
        tvName.setText(doctorBean.getData().getDoctorName());
        tvTitle.setText(doctorBean.getData().getTitle());
        tvCode.setText(doctorBean.getData().getCode());
        tvDept.setText("");
        tvSpecialty.setText(doctorBean.getData().getSpecialty());
        tvIntro.setText(doctorBean.getData().getIntro());
    }

    @Override
    public void selectByNurseIdSuccess(NurseInfoBean nurseInfoBean) {
        tvName.setText(nurseInfoBean.getData().getName());
        tvTitle.setText(nurseInfoBean.getData().getTitle());
        tvCode.setText(nurseInfoBean.getData().getCode());
        tvDept.setText("");
        tvSpecialty.setText(nurseInfoBean.getData().getSpecialty());
        tvIntro.setText(nurseInfoBean.getData().getIntro());
    }

    @Override
    public void showError(String message) {

    }
}
