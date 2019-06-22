package com.jzr.bedside.ui.apadter;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;

import com.jzr.bedside.R;
import com.jzr.bedside.bean.BedInfoBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class DoctorAdviceApadter extends BaseQuickAdapter<BedInfoBean.DataBean.CareLabelListBean, BaseViewHolder> {

    private Context mContext;
    private List<BedInfoBean.DataBean.CareLabelListBean> data;

    public DoctorAdviceApadter(List<BedInfoBean.DataBean.CareLabelListBean> data, Context mContext) {
        super(R.layout.item_doctor_advice, data);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final BedInfoBean.DataBean.CareLabelListBean item) {

        helper.setText(R.id.tv_carelable, item.getLabelName());
        TextView tvName = helper.getView(R.id.tv_carelable);
        tvName.setTextColor(Color.parseColor(item.getFontColor()));
        helper.getView(R.id.item_doctor_advice).setBackgroundColor(Color.parseColor(item.getBgColor()));


    }
}
