package com.jzr.bedside.ui.apadter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jzr.bedside.R;
import com.jzr.bedside.base.ExpenseDetailBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class ExpenseApadter extends BaseQuickAdapter<ExpenseDetailBean.DataBean,BaseViewHolder> {

    private Context mContext;
    private List<ExpenseDetailBean.DataBean> data;
    private ExpenseChildrenApadter expenseChildrenApadter;


    public ExpenseApadter(List<ExpenseDetailBean.DataBean> data, Context mContext) {
        super(R.layout.item_expense, data);
        this.mContext = mContext;
        this.data = data;
    }



    @Override
    protected void convert(final BaseViewHolder helper, final ExpenseDetailBean.DataBean item) {

        helper.setText(R.id.tv_date, item.getThospitalizationExpensesDayVoList().get(helper.getPosition()).getDateOfHospitalization());
        helper.setText(R.id.tv_totalCostOfDay,String.valueOf(item.getThospitalizationExpensesDayVoList().get(helper.getLayoutPosition()).getTotalCostOfDay()));
        helper.setText(R.id.tv_balance,String.valueOf(item.getBalance()));
        helper.setText(R.id.tv_alreadypaid,String.valueOf(item.getAlreadyPaid()));

        expenseChildrenApadter = new ExpenseChildrenApadter(item.getThospitalizationExpensesDayVoList().get(helper.getLayoutPosition()).getThospitalizationExpensesDetailVoList(), mContext);
        RecyclerView childrenRv = helper.getView(R.id.rv_data);
        childrenRv.setLayoutManager(new LinearLayoutManager(mContext));
        childrenRv.setAdapter(expenseChildrenApadter);

    }

}
