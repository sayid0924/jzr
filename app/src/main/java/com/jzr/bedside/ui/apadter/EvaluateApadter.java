package com.jzr.bedside.ui.apadter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jzr.bedside.R;
import com.jzr.bedside.bean.CheckedListBean;
import com.jzr.bedside.bean.TQuestionBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class EvaluateApadter extends BaseQuickAdapter<TQuestionBean.DataBean.ListBean,BaseViewHolder> {

    private Context mContext;
    private List<TQuestionBean.DataBean.ListBean> data;
    private EvaluateChildrenApadter evaluateChildrenApadter;

    private List<CheckedListBean> checkedList = new ArrayList<>();

    public EvaluateApadter(List<TQuestionBean.DataBean.ListBean> data, Context mContext) {
        super(R.layout.item_evaluate, data);
        this.mContext = mContext;
        this.data = data;
    }

    public List<CheckedListBean> getCheckedList() {
        return checkedList;
    }

    void addCheckedList(CheckedListBean.Answer item, int postion) {
        checkedList.get(postion).getAnswers().add(item);
    }

     void removeCheckedList(CheckedListBean.Answer item,int postion) {
            for(int n =0;n<checkedList.get(postion).getAnswers().size();n++){
                if(checkedList.get(postion).getAnswers().get(n).getId()==item.getId()){
                    checkedList.get(postion).getAnswers().remove(n);
                }
            }
    }

    @Override
    protected void convert(final BaseViewHolder helper, final TQuestionBean.DataBean.ListBean item) {

        helper.setText(R.id.tv_name, item.getName());
        CheckedListBean checkedListBean = new CheckedListBean();
        List<CheckedListBean.Answer> answerList = new ArrayList<>();
        checkedListBean.setTitle(item.getName());
        checkedListBean.setTitleId(item.getId());
        checkedListBean.setAnswers(answerList);
        checkedList.add(checkedListBean);

        evaluateChildrenApadter = new EvaluateChildrenApadter(item.getTquestionAnswerVoList(), mContext,
                this,helper.getLayoutPosition(),item.getControlType());

        RecyclerView childrenRv = helper.getView(R.id.rv_children);
        childrenRv.setLayoutManager(new GridLayoutManager(mContext, 5));
        childrenRv.setAdapter(evaluateChildrenApadter);

    }

}
