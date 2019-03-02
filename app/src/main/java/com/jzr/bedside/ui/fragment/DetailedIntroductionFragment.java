package com.jzr.bedside.ui.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseFragment;
import com.jzr.bedside.base.Constant;
import com.jzr.bedside.bean.HospitalBean;

import butterknife.BindView;

/**
 * Created by Bben on 2018/11/6.
 */

public class DetailedIntroductionFragment extends BaseFragment {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_intro)
    TextView tvIntro;


    private HospitalBean hospitalBean;

    public static DetailedIntroductionFragment getInstance(HospitalBean hospitalBean) {
        DetailedIntroductionFragment sf = new DetailedIntroductionFragment();
        sf.hospitalBean = hospitalBean;
        return sf;
    }

    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_detailed_introduction;
    }

    @Override
    protected void initView(Bundle bundle) {
//        tvIntro.setText(getActivity().getResources().getString(R.string.doc));
//        tvName.setText(hospitalBean.getData().getName());
    }

    @Override
    public void attachView() {

    }

}
