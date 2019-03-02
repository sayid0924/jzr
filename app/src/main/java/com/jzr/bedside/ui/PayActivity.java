package com.jzr.bedside.ui;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.base.PayInfoBean;
import com.jzr.bedside.bean.BedInfoBean;
import com.jzr.bedside.bean.EvenBusColos;
import com.jzr.bedside.db.database.BedInfoBeanDbDao;
import com.jzr.bedside.db.entity.BedInfoBeanDb;
import com.jzr.bedside.presenter.contract.activity.PayContract;
import com.jzr.bedside.presenter.impl.activity.PayActivityPresenter;
import com.jzr.bedside.utils.GreenDaoUtil;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

public class PayActivity extends BaseActivity implements PayContract.View {

    private PayActivityPresenter mPresenter = new PayActivityPresenter(this);
    private BedInfoBeanDbDao collectionInfoDao;
    public BedInfoBean bedInfoBean;

    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.iv_right_back)
    ImageView ivRightBack;
    @BindView(R.id.left_title)
    TextView leftTitle;
    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;
    @BindView(R.id.tv_alreadypaid)
    TextView tvAlreadypaid;
    @BindView(R.id.tv_balance)
    TextView tvBalance;

    @Override
    public int getLayoutId() {
        return R.layout.activity_pay;
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
        leftTitle.setVisibility(View.GONE);
        ivRightBack.setVisibility(View.VISIBLE);
        ivRight.setVisibility(View.VISIBLE);
        actionbarTitle.setText("床旁支付");

        collectionInfoDao = GreenDaoUtil.getDaoSession().getBedInfoBeanDbDao();
        BedInfoBeanDb infoBeanDb = collectionInfoDao.queryBuilder().where(BedInfoBeanDbDao.Properties.Id.eq(0)).unique();
        if (infoBeanDb != null) {
            bedInfoBean = infoBeanDb.getBedInfoBean();
            mPresenter.getTHospitalizationExpensesVoAllByCondition("patientId", String.valueOf(bedInfoBean.getData().getTpatientVo().getId()));
        }
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

    @SuppressLint("SetTextI18n")
    @Override
    public void getTHospitalizationExpensesVoAllByConditionSuccess(PayInfoBean payInfoBean) {
        tvAlreadypaid.setText(String.valueOf(payInfoBean.getData().get(0).getAlreadyPaid())  +" ￥");
        tvBalance.setText(String.valueOf(payInfoBean.getData().get(0).getBalance()) +" ￥");
    }

    @Override
    public void showError(String message) {

    }
}
