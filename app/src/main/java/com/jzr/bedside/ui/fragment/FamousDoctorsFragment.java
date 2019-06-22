package com.jzr.bedside.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseFragment;
import com.jzr.bedside.base.Constant;
import com.jzr.bedside.bean.DoctorByConditionBean;
import com.jzr.bedside.bean.HospitalBean;
import com.jzr.bedside.presenter.contract.fragment.DoctorConditionContract;
import com.jzr.bedside.presenter.impl.fragment.DoctorConditionPresenter;
import com.jzr.bedside.ui.HospitalActivity;
import com.jzr.bedside.ui.apadter.FamousDoctorApadter;
import com.blankj.utilcode.utils.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Bben on 2018/11/6.
 */

public class FamousDoctorsFragment extends BaseFragment implements DoctorConditionContract.View, OnLoadmoreListener {

    private DoctorConditionPresenter mPresenter= new DoctorConditionPresenter();

    private HospitalBean hospitalBean;
    private  int pageNum =1;

    private FamousDoctorApadter famousDoctorApadter;

    private List<DoctorByConditionBean.DataBean.ListBean> famousDoctorsBeans = new ArrayList<>();

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.rv_doctor)
    RecyclerView rvDoctor;
    @BindView(R.id.srl)
    SmartRefreshLayout srl;
    private int pages;

    public static FamousDoctorsFragment getInstance(HospitalBean hospitalBean) {
        FamousDoctorsFragment sf = new FamousDoctorsFragment();
        sf.hospitalBean = hospitalBean;
        return sf;
    }

    @Override
    protected void initView(Bundle bundle) {
        tvName.setText(hospitalBean.getData().getName());
        famousDoctorApadter = new FamousDoctorApadter(famousDoctorsBeans, getActivity());
        rvDoctor.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        rvDoctor.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvDoctor.setAdapter(famousDoctorApadter);

        srl.setEnableRefresh(false);
        srl.setOnLoadmoreListener(this);
        mPresenter.findDoctorByCondition("isExpert","true","pageNum",String.valueOf(pageNum),"pageSize","10");

    }


    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_famous_doctors;
    }

    @Override
    public void attachView() {
        mPresenter.attachView(this);
    }

    @Override
    public void findDoctorByConditionSuccess(DoctorByConditionBean doctorByConditionBean) {
        pages = doctorByConditionBean.getData().getPages();
        if (srl.isLoading()) {
            famousDoctorApadter.addData(doctorByConditionBean.getData().getList());
            srl.finishLoadmore();

        }else {
            if (famousDoctorsBeans.size() != 0) famousDoctorsBeans.clear();
            if (srl.isRefreshing()) srl.finishRefresh();
            famousDoctorsBeans =doctorByConditionBean.getData().getList();
            famousDoctorApadter.setNewData(famousDoctorsBeans);

        }
    }

    @Override
    public void showError(String message) {

        if (srl.isRefreshing()) srl.finishRefresh();
        if (srl.isLoading()) srl.finishLoadmore();

    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {

        if (pageNum < pages) {
            pageNum++;
            mPresenter.findDoctorByCondition("isExpert","true","pageNum",String.valueOf(pageNum),"pageSize","10");
        } else {
            srl.setEnableLoadmore(false);
            ToastUtils.showLongToast("暂无更多数据");
        }

    }
}
