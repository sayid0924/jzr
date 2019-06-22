package com.jzr.bedside.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.bean.BedInfoBean;
import com.jzr.bedside.bean.CheckedListBean;
import com.jzr.bedside.bean.EvenBusColos;
import com.jzr.bedside.bean.TQuestionBean;
import com.jzr.bedside.db.database.BedInfoBeanDbDao;
import com.jzr.bedside.db.entity.BedInfoBeanDb;
import com.jzr.bedside.presenter.contract.activity.EvaluateActivityContract;
import com.jzr.bedside.presenter.impl.activity.EvaluateActivityPresenter;
import com.jzr.bedside.ui.apadter.EvaluateApadter;
import com.jzr.bedside.utils.GreenDaoUtil;
import com.jzr.bedside.utils.PreferUtil;
import com.blankj.utilcode.utils.EmptyUtils;
import com.blankj.utilcode.utils.ToastUtils;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class EvaluateActivity extends BaseActivity implements EvaluateActivityContract.View, OnLoadmoreListener {

    private EvaluateActivityPresenter mPresenter = new EvaluateActivityPresenter();
    private EvaluateApadter evaluateApadter;
    private List<TQuestionBean.DataBean.ListBean> tQuestionBeanList = new ArrayList<>();
    private int pageNum = 1;
    private int pageSize = 10;
    private int pages;
    private boolean isLastPage = false;
    private List<Integer> checks = new ArrayList<>();
    private BedInfoBeanDbDao collectionInfoDao;
    public BedInfoBean bedInfoBean;

    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.iv_right_back)
    ImageView ivRightBack;
    @BindView(R.id.left_title)
    TextView leftTitle;
    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;
    @BindView(R.id.rv_evaluate)
    RecyclerView rvEvaluate;
    @BindView(R.id.srl)
    SmartRefreshLayout srl;
    @BindView(R.id.ll_post)
    LinearLayout llPost;
    @BindView(R.id.btn_post)
    Button btnPost;


    @Override
    public int getLayoutId() {
        return R.layout.activity_service_evaluate;
    }

    @Override
    public void attachView() {
        mPresenter.attachView(this);
    }

    @Override
    public void detachView() {
        mPresenter.detachView();
    }

    @Override
    public void initView() {

        leftTitle.setVisibility(View.VISIBLE);
        ivRightBack.setVisibility(View.VISIBLE);
        ivRight.setVisibility(View.VISIBLE);
        leftTitle.setText(PreferUtil.getInstance().getLocationInfo());
        actionbarTitle.setText("服务评价");

        srl.setEnableRefresh(false);
        srl.setOnLoadmoreListener(this);

        initData();

        evaluateApadter = new EvaluateApadter(tQuestionBeanList, this);
        rvEvaluate.setLayoutManager(new LinearLayoutManager(this));
        rvEvaluate.setAdapter(evaluateApadter);

        collectionInfoDao = GreenDaoUtil.getDaoSession().getBedInfoBeanDbDao();
        BedInfoBeanDb infoBeanDb = collectionInfoDao.queryBuilder().where(BedInfoBeanDbDao.Properties.Id.eq(0)).unique();
        if (infoBeanDb != null) {
//            bedInfoBean = infoBeanDb.getBedInfoBean();
//            mPresenter.questionGettQuestionvoBypage("userId", String.valueOf(bedInfoBean.getData().getTpatientVo().getId()), "pageNum", String.valueOf(pageNum), "pageSize", String.valueOf(pageSize));
        }
    }

    private void  initData(){
        TQuestionBean.DataBean.ListBean listBean = new TQuestionBean.DataBean.ListBean();
        listBean.setId(0);
        listBean.setName("您是通过什么渠道了解到我们医院的？");
        listBean.setControlType("radio");
        List<TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean>  answerVoListBeans= new ArrayList<>();
        answerVoListBeans.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(1,"电视报道",true));
        answerVoListBeans.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(2,"路牌广告",false));
        answerVoListBeans.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(3,"杂志",false));
        answerVoListBeans.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(4,"网络媒体",false));
        answerVoListBeans.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(5,"朋友介绍",false));
        listBean.setTquestionAnswerVoList(answerVoListBeans);
        tQuestionBeanList.add(listBean);

        TQuestionBean.DataBean.ListBean listBean1 = new TQuestionBean.DataBean.ListBean();
        listBean1.setId(1);
        listBean1.setName("对护士操作技术的满意程度。");
        listBean1.setControlType("radio");
        List<TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean>  answerVoListBeans1= new ArrayList<>();
        answerVoListBeans1.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(1,"满意",true));
        answerVoListBeans1.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(2,"基本满意",false));
        answerVoListBeans1.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(3,"不满意",false));
        listBean1.setTquestionAnswerVoList(answerVoListBeans1);
        tQuestionBeanList.add(listBean1);

        TQuestionBean.DataBean.ListBean listBean2 = new TQuestionBean.DataBean.ListBean();
        listBean2.setId(2);
        listBean2.setName("对办理入、出院手续是否方便的满意程度。");
        listBean2.setControlType("radio");
        List<TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean>  answerVoListBeans2= new ArrayList<>();
        answerVoListBeans2.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(1,"满意",true));
        answerVoListBeans2.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(2,"基本满意",false));
        answerVoListBeans2.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(3,"不满意",false));
        listBean2.setTquestionAnswerVoList(answerVoListBeans2);
        tQuestionBeanList.add(listBean2);

        TQuestionBean.DataBean.ListBean listBean3 = new TQuestionBean.DataBean.ListBean();
        listBean3.setId(3);
        listBean3.setName("对办理入、出院手续是否方便的满意程度。");
        listBean3.setControlType("radio");
        List<TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean>  answerVoListBeans3= new ArrayList<>();
        answerVoListBeans3.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(1,"满意",true));
        answerVoListBeans3.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(2,"基本满意",false));
        answerVoListBeans3.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(3,"不满意",false));
        listBean3.setTquestionAnswerVoList(answerVoListBeans3);
        tQuestionBeanList.add(listBean3);

        TQuestionBean.DataBean.ListBean listBean4 = new TQuestionBean.DataBean.ListBean();
        listBean4.setId(4);
        listBean4.setName("对初入病房时医务人员接待您的满意程度。");
        listBean4.setControlType("radio");
        List<TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean>  answerVoListBeans4= new ArrayList<>();
        answerVoListBeans4.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(1,"满意",true));
        answerVoListBeans4.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(2,"基本满意",false));
        answerVoListBeans4.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(3,"不满意",false));
        listBean4.setTquestionAnswerVoList(answerVoListBeans4);
        tQuestionBeanList.add(listBean4);

        TQuestionBean.DataBean.ListBean listBean5 = new TQuestionBean.DataBean.ListBean();
        listBean5.setId(5);
        listBean5.setName("对病房整洁程度的满意程度。");
        listBean5.setControlType("radio");
        List<TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean>  answerVoListBeans5= new ArrayList<>();
        answerVoListBeans5.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(1,"满意",true));
        answerVoListBeans5.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(2,"基本满意",false));
        answerVoListBeans5.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(3,"不满意",false));
        listBean5.setTquestionAnswerVoList(answerVoListBeans5);
        tQuestionBeanList.add(listBean5);

        TQuestionBean.DataBean.ListBean listBean6 = new TQuestionBean.DataBean.ListBean();
        listBean6.setId(6);
        listBean6.setName("对医院收费的满意程度。");
        listBean6.setControlType("radio");
        List<TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean>  answerVoListBeans6= new ArrayList<>();
        answerVoListBeans6.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(1,"满意",true));
        answerVoListBeans6.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(2,"基本满意",false));
        answerVoListBeans6.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(3,"不满意",false));
        listBean6.setTquestionAnswerVoList(answerVoListBeans6);
        tQuestionBeanList.add(listBean6);

        TQuestionBean.DataBean.ListBean listBean7 = new TQuestionBean.DataBean.ListBean();
        listBean7.setId(7);
        listBean7.setName("对医务人员回答问题的满意程度。");
        listBean7.setControlType("radio");
        List<TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean>  answerVoListBeans7= new ArrayList<>();
        answerVoListBeans7.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(1,"满意",true));
        answerVoListBeans7.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(2,"基本满意",false));
        answerVoListBeans7.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(3,"不满意",false));
        listBean7.setTquestionAnswerVoList(answerVoListBeans7);
        tQuestionBeanList.add(listBean7);

        TQuestionBean.DataBean.ListBean listBean8 = new TQuestionBean.DataBean.ListBean();
        listBean8.setId(8);
        listBean8.setName("对药房人员服务态度的满意程度。");
        listBean8.setControlType("radio");
        List<TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean>  answerVoListBeans8= new ArrayList<>();
        answerVoListBeans8.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(1,"满意",true));
        answerVoListBeans8.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(2,"基本满意",false));
        answerVoListBeans8.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(3,"不满意",false));
        listBean8.setTquestionAnswerVoList(answerVoListBeans8);
        tQuestionBeanList.add(listBean8);

        TQuestionBean.DataBean.ListBean listBean9 = new TQuestionBean.DataBean.ListBean();
        listBean9.setId(9);
        listBean9.setName("对医院保安工作的满意程度。");
        listBean9.setControlType("radio");
        List<TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean>  answerVoListBeans9= new ArrayList<>();
        answerVoListBeans9.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(1,"满意",true));
        answerVoListBeans9.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(2,"基本满意",false));
        answerVoListBeans9.add(new TQuestionBean.DataBean.ListBean.TquestionAnswerVoListBean(3,"不满意",false));
        listBean9.setTquestionAnswerVoList(answerVoListBeans9);
        tQuestionBeanList.add(listBean9);

    }

    @OnClick({R.id.iv_right_back, R.id.iv_right, R.id.btn_post})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_right_back:
                finish();
                break;
            case R.id.iv_right:
                EventBus.getDefault().post(new EvenBusColos());
                finish();
                break;
            case R.id.btn_post:
                boolean isbeak = false;
                List<CheckedListBean> checkedList = evaluateApadter.getCheckedList();
                for (int i = 0; i < checkedList.size(); i++) {
                    if (checkedList.get(i).getAnswers() == null || checkedList.get(i).getAnswers().size() == 0) {
                        ToastUtils.showLongToast("请在  " + checkedList.get(i).getTitle() + "  中选择答案");
                        isbeak = true;
                        break;
                    }
                }
                if(!isbeak){
                    StringBuilder stringBuffer = new StringBuilder();
                    for (int i = 0; i < checkedList.size(); i++) {
                        for(int n =0;n<checkedList.get(i).getAnswers().size();n++){
                            stringBuffer.append(String.valueOf(checkedList.get(i).getAnswers().get(n).getId())).append(",");
                        }
                    }
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                    if(EmptyUtils.isNotEmpty(bedInfoBean)){
//                        mPresenter.addTUserQuestionnaire("userId",String.valueOf(bedInfoBean.getData().getTpatientVo().getId()),
//                                "questionAnswerIds", stringBuffer.toString());
                    }
                    Logger.e(stringBuffer.toString());
                }

                break;
        }
    }

    @Override
    public void questionGettQuestionvoBypageSuccess(TQuestionBean tQuestionBean) {
        pages = tQuestionBean.getData().getPages();
        if (pageNum < pages) {
            isLastPage = false;
            llPost.setVisibility(View.GONE);
        } else {
            isLastPage = true;
            llPost.setVisibility(View.VISIBLE);
        }
        if (srl.isLoading()) {
            evaluateApadter.addData(tQuestionBean.getData().getList());
            srl.finishLoadmore();
        } else {
            if (tQuestionBeanList.size() != 0) tQuestionBeanList.clear();
            tQuestionBeanList = tQuestionBean.getData().getList();
            evaluateApadter.setNewData(tQuestionBeanList);
        }
    }

    @Override
    public void addTUserQuestionnaireSuccess(TQuestionBean tQuestionBean) {
        ToastUtils.showLongToast("谢谢您的评价  提交成功");
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        if (pageNum < pages) {
            pageNum++;
            if (EmptyUtils.isNotEmpty(bedInfoBean)){

            }
//                mPresenter.questionGettQuestionvoBypage("userId", String.valueOf(bedInfoBean.getData().getTpatientVo().getId()), "pageNum", String.valueOf(pageNum), "pageSize", String.valueOf(pageSize));
        } else {
            isLastPage = true;
            srl.setEnableLoadmore(false);
        }
    }

}
