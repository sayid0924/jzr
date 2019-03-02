package com.jzr.bedside.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.bean.BedInfoBean;
import com.jzr.bedside.bean.EvenBusColos;
import com.jzr.bedside.bean.MedicationRecordBean;
import com.jzr.bedside.db.database.BedInfoBeanDbDao;
import com.jzr.bedside.presenter.contract.activity.RecordContract;
import com.jzr.bedside.presenter.impl.activity.RecordActivityPresenter;
import com.jzr.bedside.ui.apadter.RecordApadter;
import com.jzr.bedside.utils.PreferUtil;
import com.blankj.utilcode.utils.EmptyUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class RecordActivity extends BaseActivity implements RecordContract.View, OnLoadmoreListener {

    private RecordActivityPresenter mPresenter = new RecordActivityPresenter(this);
    String[] doc = {"奥美拉唑肠溶颗粒", "盐酸阿来替尼胶囊", "糠酸氟替卡松维兰特罗吸入粉雾剂",
            "盐酸安罗替尼胶囊", "参芪五味子胶囊"};
    private RecordApadter recordApadter;
    private MedicationRecordBean.DataBean.ListBean listBean ;
    private List<MedicationRecordBean.DataBean.ListBean> recordBeans = new ArrayList<>();
    private List<MedicationRecordBean.DataBean.ListBean.TdrugsDoseVoListBean> tdrugsDoseVoListBeans;
    private MedicationRecordBean.DataBean.ListBean.TdrugsDoseVoListBean tdrugsDoseVoListBean ;
    private BedInfoBeanDbDao collectionInfoDao;
    public BedInfoBean bedInfoBean;
    private int pageNum = 1;
    private int pageSize = 10;
    private int pages;

    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.iv_right_back)
    ImageView ivRightBack;
    @BindView(R.id.left_title)
    TextView leftTitle;
    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;
    @BindView(R.id.rv_record)
    RecyclerView rvRecord;
    @BindView(R.id.srl)
    SmartRefreshLayout srl;

    @Override
    public int getLayoutId() {
        return R.layout.activity_record;
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
        actionbarTitle.setText("用药记录");

        srl.setEnableRefresh(false);
        srl.setOnLoadmoreListener(this);
        initDate();

        recordApadter = new RecordApadter(recordBeans, this);
        rvRecord.setLayoutManager(new LinearLayoutManager(this));
        rvRecord.setAdapter(recordApadter);

//        collectionInfoDao = GreenDaoUtil.getDaoSession().getBedInfoBeanDbDao();
//        BedInfoBeanDb infoBeanDb = collectionInfoDao.queryBuilder().where(BedInfoBeanDbDao.Properties.Id.eq(0)).unique();
//        if (infoBeanDb != null) {
//            bedInfoBean = infoBeanDb.getBedInfoBean();
//            mPresenter.selectByMedicationRecordid(
//                    "pageNum", String.valueOf(pageNum), "pageSize", String.valueOf(pageSize));
//        }

    }

    public void initDate() {
        for (int i = 0; i < 10; i++) {
            listBean = new MedicationRecordBean.DataBean.ListBean();
            listBean.setId(i + 1);
            listBean.setCureNo(String.valueOf((int) (Math.random() * 100)));
            listBean.setPatientId(i + 1);
            listBean.setDrugDeliveryNurseId((int) (Math.random() * 100));
            listBean.setDrugDeliveryNurseName("何聪");
            listBean.setDateOfHospitalization("2018-11-" + String.valueOf(i));
            tdrugsDoseVoListBeans = new ArrayList<>();
            for (int n = 0; n < 10; n++) {

                tdrugsDoseVoListBean = new MedicationRecordBean.DataBean.ListBean.TdrugsDoseVoListBean();
                tdrugsDoseVoListBean.setId(i + 1);
                tdrugsDoseVoListBean.setMedicationRecordId(i + 1);
                tdrugsDoseVoListBean.setDrugName(doc[(int) (Math.random() * doc.length)]);
                tdrugsDoseVoListBean.setBeforeSleepConsumption("1#");
                if(i%2 == 1){
                    tdrugsDoseVoListBean.setLunchConsumption("1#");
                    tdrugsDoseVoListBean.setBreakfastConsumption("1#");
                }
                tdrugsDoseVoListBeans.add(tdrugsDoseVoListBean);
            }
            listBean.setTdrugsDoseVoList(tdrugsDoseVoListBeans);
            recordBeans.add(listBean);
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

    @Override
    public void selectByMedicationRecordidSuccess(MedicationRecordBean medicationRecordBean) {

        if (EmptyUtils.isNotEmpty(medicationRecordBean.getData().getList())) {
            for (int i = 0; i < medicationRecordBean.getData().getList().size(); i++) {
                if (medicationRecordBean.getData().getList().get(i).getTdrugsDoseVoList() == null) {
                    medicationRecordBean.getData().getList().remove(i);
                }
            }
            pages = medicationRecordBean.getData().getPages();
            if (srl.isLoading()) {
                recordApadter.addData(medicationRecordBean.getData().getList());
                srl.finishLoadmore();
            } else {
                if (recordBeans.size() != 0) recordBeans.clear();
                recordBeans = medicationRecordBean.getData().getList();
                recordApadter.setNewData(recordBeans);
            }
        }

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        if (pageNum < pages) {
            pageNum++;
            if (EmptyUtils.isNotEmpty(bedInfoBean))
                mPresenter.selectByMedicationRecordid("patientId", String.valueOf(bedInfoBean.getData().getTpatientVo().getId()),
                        "pageNum", String.valueOf(pageNum), "pageSize", String.valueOf(pageSize));
        } else {
            srl.setEnableLoadmore(false);
        }
    }
}
