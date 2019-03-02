package com.jzr.bedside.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.base.ExpenseDetailBean;
import com.jzr.bedside.bean.BedInfoBean;
import com.jzr.bedside.bean.EvenBusColos;
import com.jzr.bedside.db.database.BedInfoBeanDbDao;
import com.jzr.bedside.db.entity.BedInfoBeanDb;
import com.jzr.bedside.presenter.contract.activity.ExpenseContract;
import com.jzr.bedside.presenter.impl.activity.ExpenseActivityPresenter;
import com.jzr.bedside.ui.apadter.ExpenseApadter;
import com.jzr.bedside.utils.GreenDaoUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ExpenseActivity extends BaseActivity implements ExpenseContract.View {

    private ExpenseActivityPresenter mPresenter = new ExpenseActivityPresenter(this);
    private ExpenseApadter apadter;
    public BedInfoBean bedInfoBean;
    private List<ExpenseDetailBean.DataBean> dataBeans = new ArrayList<>();


    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.iv_right_back)
    ImageView ivRightBack;
    @BindView(R.id.left_title)
    TextView leftTitle;
    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;

    @BindView(R.id.rv_expense)
    RecyclerView rvExpense;

    @Override
    public int getLayoutId() {
        return R.layout.activity_expense;
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
        actionbarTitle.setText("收费记录");

        initData();
        apadter = new ExpenseApadter(dataBeans, this);
        rvExpense.setLayoutManager(new LinearLayoutManager(this));
        rvExpense.setAdapter(apadter);

//        BedInfoBeanDbDao collectionInfoDao = GreenDaoUtil.getDaoSession().getBedInfoBeanDbDao();
//        BedInfoBeanDb infoBeanDb = collectionInfoDao.queryBuilder().where(BedInfoBeanDbDao.Properties.Id.eq(0)).unique();
//        if (infoBeanDb != null) {
//            bedInfoBean = infoBeanDb.getBedInfoBean();
//            mPresenter.getThisAndDetailAllByCondition("patientId", String.valueOf(bedInfoBean.getData().getTpatientVo().getId()));
//        }
    }


    private void initData() {

        ExpenseDetailBean.DataBean dataBean = new ExpenseDetailBean.DataBean();

        List<ExpenseDetailBean.DataBean.ThospitalizationExpensesDayVoListBean> voListBeanList = new ArrayList<>();
        ExpenseDetailBean.DataBean.ThospitalizationExpensesDayVoListBean voListBean = new ExpenseDetailBean.DataBean.ThospitalizationExpensesDayVoListBean();

        voListBean.setId(1);
        voListBean.setDateOfHospitalization("2019-2-28");
        voListBean.setTotalCostOfDay(2260);

        List<ExpenseDetailBean.DataBean.ThospitalizationExpensesDayVoListBean.ThospitalizationExpensesDetailVoListBean> detailVoListBean = new ArrayList<>();
        detailVoListBean.add(new ExpenseDetailBean.DataBean.ThospitalizationExpensesDayVoListBean.ThospitalizationExpensesDetailVoListBean(1, 1, "住院费", "元", 560, 1, 560, null));
        detailVoListBean.add(new ExpenseDetailBean.DataBean.ThospitalizationExpensesDayVoListBean.ThospitalizationExpensesDetailVoListBean(2, 1, "西药费", "元", 260, 1, 260, null));
        detailVoListBean.add(new ExpenseDetailBean.DataBean.ThospitalizationExpensesDayVoListBean.ThospitalizationExpensesDetailVoListBean(3, 1, "护理费", "元", 360, 1, 360, null));
        detailVoListBean.add(new ExpenseDetailBean.DataBean.ThospitalizationExpensesDayVoListBean.ThospitalizationExpensesDetailVoListBean(4, 1, "血费", "元", 160, 1, 160, null));
        detailVoListBean.add(new ExpenseDetailBean.DataBean.ThospitalizationExpensesDayVoListBean.ThospitalizationExpensesDetailVoListBean(5, 1, "床位费", "元", 260, 1, 260, null));
        detailVoListBean.add(new ExpenseDetailBean.DataBean.ThospitalizationExpensesDayVoListBean.ThospitalizationExpensesDetailVoListBean(6, 1, "其他费", "元", 660, 1, 660, null));

        voListBean.setThospitalizationExpensesDetailVoList(detailVoListBean);

        voListBeanList.add(voListBean);

        dataBean.setThospitalizationExpensesDayVoList(voListBeanList);

        dataBeans.add(dataBean);


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
    public void showError(String message) {

    }

    @Override
    public void getThisAndDetailAllByConditionSuccess(ExpenseDetailBean expenseDetailBean) {
        apadter.setNewData(expenseDetailBean.getData());
    }
}
