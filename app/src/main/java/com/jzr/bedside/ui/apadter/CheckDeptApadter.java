package com.jzr.bedside.ui.apadter;

import android.content.Context;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.inuker.bluetooth.library.search.SearchResult;
import com.jzr.bedside.R;
import com.jzr.bedside.bean.CheckDeptBean;

import java.util.List;

public class CheckDeptApadter extends BaseQuickAdapter<CheckDeptBean.DataBean, BaseViewHolder> {

    private Context mContext;
    private List<CheckDeptBean.DataBean> data;
    private onItemClick onItemClick;

    public CheckDeptApadter(List<CheckDeptBean.DataBean> data, Context mContext) {
        super(R.layout.item_dept, data);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final CheckDeptBean.DataBean item) {

        helper.setText(R.id.tv_name,item.getName());

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClick!=null){
                    onItemClick.onItemClick(item);
                }
            }
        });
    }



    public  interface onItemClick {
        void onItemClick(CheckDeptBean.DataBean c);

    }
    public  void  onItemClick(onItemClick onItemClick){
        this.onItemClick = onItemClick;
    }

}
