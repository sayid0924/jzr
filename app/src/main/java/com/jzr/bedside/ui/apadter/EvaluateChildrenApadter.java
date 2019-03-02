package com.jzr.bedside.ui.apadter;

import android.content.Context;
import android.view.View;

import com.jzr.bedside.R;
import com.jzr.bedside.bean.CheckedListBean;
import com.jzr.bedside.bean.TQuestionBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;


public class EvaluateChildrenApadter extends BaseQuickAdapter<TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean, BaseViewHolder> {

    private Context mContext;
    private List<TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean> data;
    private EvaluateApadter evaluateApadter;
    private int postion;
    private  String controlType;

    public EvaluateChildrenApadter(List<TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean> data, Context mContext, EvaluateApadter evaluateApadter, int postion,String controlType) {
        super(R.layout.item_evaluate_children, data);
        this.mContext = mContext;
        this.data = data;
        this.evaluateApadter = evaluateApadter;
        this.postion = postion;
        this.controlType = controlType;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean item) {
        helper.setText(R.id.tv_name, item.getAnswerName());


        if (item.isIschoose()) {
            CheckedListBean.Answer answer = new CheckedListBean.Answer();
            answer.setAnswer(item.getAnswerName());
            answer.setId(item.getId());
            helper.getView(R.id.iv_check).setBackgroundResource(R.drawable.checkboxp);
            evaluateApadter.addCheckedList(answer, postion);
        } else {
            helper.getView(R.id.iv_check).setBackgroundResource(R.drawable.checkboxn);
        }

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item.isIschoose()) {

                        CheckedListBean.Answer answer = new CheckedListBean.Answer();
                        answer.setAnswer(item.getAnswerName());
                        answer.setId(item.getId());

                        item.setIschoose(false);
                        helper.getView(R.id.iv_check).setBackgroundResource(R.drawable.checkboxn);
                        evaluateApadter.removeCheckedList(answer, postion);

                } else {
                    if(controlType.equals("radio")){   // 单选
                        for(int i=0;i<data.size();i++){
                            CheckedListBean.Answer answer = new CheckedListBean.Answer();
                            answer.setAnswer(data.get(i).getAnswerName());
                            answer.setId(data.get(i).getId());
                            data.get(i).setIschoose(false);
                            evaluateApadter.removeCheckedList(answer, postion);
                        }
                        item.setIschoose(true);
                    }else {
                        CheckedListBean.Answer answer = new CheckedListBean.Answer();
                        answer.setAnswer(item.getAnswerName());
                        answer.setId(item.getId());
                        item.setIschoose(true);
                        evaluateApadter.addCheckedList(answer, postion);
                        helper.getView(R.id.iv_check).setBackgroundResource(R.drawable.checkboxp);
                    }
                }
                notifyDataSetChanged();
            }
        });
    }
}
