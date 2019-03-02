package com.jzr.bedside.ui.apadter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jzr.bedside.R;
import com.jzr.bedside.bean.HospitalBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;


public class HospitalApadter extends BaseQuickAdapter<HospitalBean.DataBean.TparentDeptVoListBean, BaseViewHolder> {

    private Context mContext;
    private List<HospitalBean.DataBean.TparentDeptVoListBean> data;
    private HospitalChildrenApadter childrenApadterApadter;

    public HospitalApadter(List<HospitalBean.DataBean.TparentDeptVoListBean> data, Context mContext) {
        super(R.layout.item_hospital, data);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final HospitalBean.DataBean.TparentDeptVoListBean item) {
        if(helper.getLayoutPosition()%2==0){
             helper.getView(R.id.item_hospital).setBackgroundColor(mContext.getResources().getColor(R.color.color_F0F0F0));
        }
        childrenApadterApadter = new HospitalChildrenApadter(item.getTsonDeptVoList(),mContext);
        helper.setText(R.id.tv_name,item.getName());
        RecyclerView  childrenRv = helper.getView(R.id.rv_children);
        childrenRv.setLayoutManager(new GridLayoutManager(mContext,5));
        childrenRv.setAdapter(childrenApadterApadter);

    }
}
