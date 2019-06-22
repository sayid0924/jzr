package com.jzr.bedside.ui.apadter;

import android.content.Context;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jzr.bedside.R;
import com.jzr.bedside.bean.CheckDeptBean;
import com.jzr.netty.common.base.DeviceLive;
import com.jzr.netty.common.protocol.GetDeviceListResponse;

import java.util.List;

public class CheckDeviceApadter extends BaseQuickAdapter<DeviceLive, BaseViewHolder> {

    private Context mContext;
    private List<DeviceLive> data;
    private onItemClick onItemClick;

    public CheckDeviceApadter(List<DeviceLive> data, Context mContext) {
        super(R.layout.item_device, data);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final DeviceLive item) {

        helper.setText(R.id.tv_name,item.getNurseName());
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
        void onItemClick(DeviceLive c);

    }
    public  void  onItemClick(onItemClick onItemClick){
        this.onItemClick = onItemClick;
    }

}
