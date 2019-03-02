package com.jzr.bedside.ui.apadter;

import android.content.Context;

import com.jzr.bedside.R;
import com.jzr.bedside.bean.HospitalBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;


public class HospitalChildrenApadter extends BaseQuickAdapter<HospitalBean.DataBean.TparentDeptVoListBean.TsonDeptVoListBean, BaseViewHolder> {

    private Context mContext;
    private List<HospitalBean.DataBean.TparentDeptVoListBean.TsonDeptVoListBean> data;

    public HospitalChildrenApadter(List<HospitalBean.DataBean.TparentDeptVoListBean.TsonDeptVoListBean> data, Context mContext) {
        super(R.layout.item_hospital_children, data);
        this.mContext = mContext;
        this.data = data;

    }

    @Override
    protected void convert(final BaseViewHolder helper, final HospitalBean.DataBean.TparentDeptVoListBean.TsonDeptVoListBean item) {
        helper.setText(R.id.tv_name,item.getName());
    }
}
