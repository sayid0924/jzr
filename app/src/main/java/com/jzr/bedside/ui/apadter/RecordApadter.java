package com.jzr.bedside.ui.apadter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jzr.bedside.R;
import com.jzr.bedside.bean.MedicationRecordBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class RecordApadter extends BaseQuickAdapter<MedicationRecordBean.DataBean.ListBean, BaseViewHolder> {

    private Context mContext;
    private List<MedicationRecordBean.DataBean.ListBean> data;
    private  RecordChildAdapter recordChildAdapter ;

    public RecordApadter(List<MedicationRecordBean.DataBean.ListBean> data, Context mContext) {
        super(R.layout.item_record, data);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final MedicationRecordBean.DataBean.ListBean item) {
        if(item.getTdrugsDoseVoList()!=null) {
            recordChildAdapter = new RecordChildAdapter(item.getTdrugsDoseVoList(),mContext);
            RecyclerView rvData =helper.getView(R.id.rv_data);
            rvData.setLayoutManager(new LinearLayoutManager(mContext));
            rvData.setAdapter(recordChildAdapter);
            helper.setText(R.id.tv_date,item.getDateOfHospitalization());
            helper.setText(R.id.tv_name,item.getDrugDeliveryNurseName());
            helper.setText(R.id.tv_description,item.getDescription());
        }else {
            helper.itemView.setVisibility(View.GONE);
        }
    }
}
