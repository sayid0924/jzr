package com.jzr.bedside.ui.apadter;

import android.content.Context;

import com.jzr.bedside.R;
import com.jzr.bedside.base.ExpenseDetailBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;


public class ExpenseChildrenApadter extends BaseQuickAdapter<ExpenseDetailBean.DataBean.ThospitalizationExpensesDayVoListBean.ThospitalizationExpensesDetailVoListBean, BaseViewHolder> {

    private Context mContext;
    private List<ExpenseDetailBean.DataBean.ThospitalizationExpensesDayVoListBean.ThospitalizationExpensesDetailVoListBean> data;


    public ExpenseChildrenApadter(List<ExpenseDetailBean.DataBean.ThospitalizationExpensesDayVoListBean.ThospitalizationExpensesDetailVoListBean> data, Context mContext) {
        super(R.layout.item_expense_child, data);
        this.mContext = mContext;
        this.data = data;

    }

    @Override
    protected void convert(final BaseViewHolder helper, final ExpenseDetailBean.DataBean.ThospitalizationExpensesDayVoListBean.ThospitalizationExpensesDetailVoListBean item) {
        if(helper.getLayoutPosition()%2==0){
            helper.getView(R.id.item_doctor_advice).setBackgroundColor(mContext.getResources().getColor(R.color.color_F0F0F0));
        }
        helper.setText(R.id.tv_no, String.valueOf(helper.getLayoutPosition()+1));
        helper.setText(R.id.tv_expensesname,item.getExpensesName());
        helper.setText(R.id.tv_unit,item.getUnit());
        helper.setText(R.id.tv_unitprice,String.valueOf(item.getUnitPrice()));
        helper.setText(R.id.tv_number,String.valueOf(item.getNumber()));
        helper.setText(R.id.tv_amountofmoney,String.valueOf(item.getAmountOfMoney()));

    }
}
