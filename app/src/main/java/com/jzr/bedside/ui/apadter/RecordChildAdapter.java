package com.jzr.bedside.ui.apadter;

import android.content.Context;

import com.jzr.bedside.R;
import com.jzr.bedside.bean.MedicationRecordBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;


public class RecordChildAdapter extends BaseQuickAdapter<MedicationRecordBean.DataBean.ListBean.TdrugsDoseVoListBean, BaseViewHolder> {

    private Context mContext;
    public RecordChildAdapter(List<MedicationRecordBean.DataBean.ListBean.TdrugsDoseVoListBean> data, Context context) {
        super(R.layout.item_record_child, data);
        this.mContext = context;
    }


    @Override
    protected void convert(BaseViewHolder helper, MedicationRecordBean.DataBean.ListBean.TdrugsDoseVoListBean item) {
        if(helper.getLayoutPosition()%2==0){
            helper.getView(R.id.item_doctor_advice).setBackgroundColor(mContext.getResources().getColor(R.color.color_F0F0F0));
        }
        helper.setText(R.id.tv_other, item.getOther());
        helper.setText(R.id.tv_beforeSleepConsumption, item.getBeforeSleepConsumption());
        helper.setText(R.id.tv_dinnerConsumption, item.getDinnerConsumption());
        helper.setText(R.id.tv_lunchConsumption, item.getLunchConsumption());
        helper.setText(R.id.tv_breakfastconsumption, item.getBreakfastConsumption());
        helper.setText(R.id.tv_drugname, item.getDrugName());
        helper.setText(R.id.tv_no, String.valueOf( helper.getLayoutPosition()+1));

    }
}
