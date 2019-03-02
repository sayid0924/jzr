package com.jzr.bedside.ui.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseFragment;
import com.jzr.bedside.base.Constant;
import com.jzr.bedside.bean.HospitalBean;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Bben on 2018/11/6.
 */

public class TelephoneAddressFragment extends BaseFragment {


    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    Unbinder unbinder;
    private HospitalBean hospitalBean;

    public static TelephoneAddressFragment getInstance(HospitalBean hospitalBean) {
        TelephoneAddressFragment sf = new TelephoneAddressFragment();
        sf.hospitalBean = hospitalBean;
        return sf;
    }

    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_telephone_address;
    }

    @Override
    protected void initView(Bundle bundle) {
//        tvName.setText(hospitalBean.getData().getName());
//        tvPhone.setText(hospitalBean.getData().getPhone());
    }

    @Override
    public void attachView() {

    }
}
