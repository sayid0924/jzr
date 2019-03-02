package com.jzr.bedside.ui.apadter;

import android.content.Context;
import android.widget.ImageView;

import com.jzr.bedside.R;
import com.jzr.bedside.bean.DoctorByConditionBean;
import com.jzr.bedside.utils.GlideUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;


public class FamousDoctorApadter extends BaseQuickAdapter<DoctorByConditionBean.DataBean.ListBean, BaseViewHolder> {

    private Context mContext;
    private List<DoctorByConditionBean.DataBean.ListBean> data;

    public FamousDoctorApadter(List<DoctorByConditionBean.DataBean.ListBean> data, Context mContext) {
        super(R.layout.item_famous_doctor, data);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final DoctorByConditionBean.DataBean.ListBean item) {
        helper.setText(R.id.tv_name, item.getDoctorName());
        helper.setText(R.id.tv_title, item.getTitle());
        helper.setText(R.id.tv_intro, item.getIntro());
        ImageView ivLogo = helper.getView(R.id.iv_logo);
        GlideUtils.load(mContext, item.getImageUrl(), ivLogo, R.drawable.yiyuanglogo);
    }
}
