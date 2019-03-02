package com.jzr.bedside.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseFragment;
import com.jzr.bedside.base.Constant;
import com.jzr.bedside.bean.HospitalBean;
import com.jzr.bedside.ui.apadter.HospitalApadter;
import com.blankj.utilcode.utils.EmptyUtils;

import butterknife.BindView;

/**
 * Created by Bben on 2018/11/6.
 */

public class HospitalListFragment extends BaseFragment {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.rv_hospital)
    RecyclerView rvHospital;

    private HospitalBean hospitalBean;
    private HospitalApadter hospitalApadterApadter;

    public static HospitalListFragment getInstance(HospitalBean hospitalBean) {
        HospitalListFragment sf = new HospitalListFragment();
        sf.hospitalBean = hospitalBean;
        return sf;
    }

    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_hospital_list;
    }

    @Override
    protected void initView(Bundle bundle) {
        tvName.setText(hospitalBean.getData().getName());
        if(EmptyUtils.isNotEmpty(hospitalBean.getData().getTparentDeptVoList())){
            hospitalApadterApadter = new HospitalApadter(hospitalBean.getData().getTparentDeptVoList(), getActivity());
            rvHospital.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
            rvHospital.setLayoutManager(new LinearLayoutManager(getActivity()));
            rvHospital.setAdapter(hospitalApadterApadter);
        }
    }

    @Override
    public void attachView() {

    }

}
