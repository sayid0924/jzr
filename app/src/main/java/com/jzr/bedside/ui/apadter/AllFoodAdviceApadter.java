package com.jzr.bedside.ui.apadter;

import android.content.Context;
import android.widget.ImageView;

import com.jzr.bedside.R;
import com.jzr.bedside.bean.FoodBean;
import com.jzr.bedside.utils.GlideUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class AllFoodAdviceApadter extends BaseQuickAdapter<FoodBean, BaseViewHolder> {

    private Context mContext;
    private List<FoodBean> data;

    public AllFoodAdviceApadter(List<FoodBean> data, Context mContext) {
        super(R.layout.item_all_food, data);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final FoodBean item) {
        helper.setText(R.id.tv_name, item.getName());
        helper.setText(R.id.tv_dec, item.getDoe());
        helper.setText(R.id.tv_price,item.getPrice());
        ImageView iv = helper.getView(R.id.iv_url);
        GlideUtils.load(mContext, item.getImgurl(), iv);
    }

}
