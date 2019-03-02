package com.jzr.bedside.ui.apadter;

import android.content.Context;
import android.graphics.Color;

import com.jzr.bedside.R;
import com.jzr.bedside.bean.BedInfoBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class DoctorAdviceApadter extends BaseQuickAdapter<BedInfoBean.DataBean.TpatientVoBean.TcareLableVoListBean, BaseViewHolder> {

    private Context mContext;
    private List<BedInfoBean.DataBean.TpatientVoBean.TcareLableVoListBean> data;

    public DoctorAdviceApadter(List<BedInfoBean.DataBean.TpatientVoBean.TcareLableVoListBean> data, Context mContext) {
        super(R.layout.item_doctor_advice, data);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final BedInfoBean.DataBean.TpatientVoBean.TcareLableVoListBean item) {

        if(item.getStatus()==1){
            helper.setText(R.id.tv_carelable,item.getLableName());
            helper.getView(R.id.item_doctor_advice).setBackgroundColor(Color.parseColor(item.getViewColor()) );
        }

    }
}
