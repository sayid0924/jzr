package com.jzr.bedside.ui.apadter;

import android.content.Context;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.inuker.bluetooth.library.search.SearchResult;
import com.jzr.bedside.R;
import com.orhanobut.logger.Logger;

import java.util.List;

public class BlueDeviceApadter extends BaseQuickAdapter<SearchResult, BaseViewHolder> {

    private Context mContext;
    private List<SearchResult> data;
    private onItemClick onItemClick;

    public BlueDeviceApadter(List<SearchResult> data, Context mContext) {
        super(R.layout.item_bule_device, data);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final SearchResult item) {
        if(item.getName().equals(mContext.getString(R.string.string_device_spo2))){
            helper.setText(R.id.tv_name, "脉搏血氧仪");
        }
        if(item.getName().equals(mContext.getString(R.string.string_device_nibp))){
            helper.setText(R.id.tv_name, "血压仪");
        }
        if(item.getName().equals(mContext.getString(R.string.string_device_irt))){
            helper.setText(R.id.tv_name, "体温计");
        }
        helper.setText(R.id.tv_mac, item.getAddress() + "    " +item.getName());
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
        void onItemClick(SearchResult  bleDevices);

    }
    public  void  onItemClick(onItemClick onItemClick){
        this.onItemClick = onItemClick;
    }

}
