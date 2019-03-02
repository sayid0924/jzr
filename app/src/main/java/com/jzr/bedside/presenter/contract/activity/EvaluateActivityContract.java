
package com.jzr.bedside.presenter.contract.activity;


import com.jzr.bedside.base.BaseContract;
import com.jzr.bedside.bean.TQuestionBean;

public interface EvaluateActivityContract {

    interface View extends BaseContract.BaseView {

        // 根据Id查询问卷调查信息
        void  questionGettQuestionvoBypageSuccess(TQuestionBean tQuestionBean);

        // 提交用户调查问卷
        void  addTUserQuestionnaireSuccess(TQuestionBean tQuestionBean);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        // 根据Id查询问卷调查信息
        void  questionGettQuestionvoBypage(String... s);

        // 提交用户调查问卷
        void  addTUserQuestionnaire(String... s);

    }
}
