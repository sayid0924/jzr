package com.jzr.bedside.ui.fragment.food;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseFragment;
import com.jzr.bedside.base.Constant;
import com.jzr.bedside.bean.FoodBean;
import com.jzr.bedside.ui.apadter.AllFoodAdviceApadter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Bben on 2018/11/6.
 */

public class AllFoodFragment extends BaseFragment {

    @BindView(R.id.rv_food)
    RecyclerView rvFood;

    private AllFoodAdviceApadter apadter;
    private List<FoodBean> foodBeanList= new ArrayList<>();
    private FoodBean foodBean;

    public static AllFoodFragment getInstance() {
        AllFoodFragment sf = new AllFoodFragment();
        return sf;
    }

    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_all_food;
    }

    @Override
    protected void initView(Bundle bundle) {

        foodBeanList.add(new FoodBean("鸡蛋小炒肉饭","https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1549895172&di=132d3c1f20f8e7b9c40c0a6a523547d5&src=http://e.hiphotos.baidu.com/bainuo/crop=0,8,700,424;w=470;q=80/sign=12c0abb4f0dcd100d9d3a2614fbb6b28/5243fbf2b21193139979fe096d380cd791238d54.jpg","doc","36"));
        foodBeanList.add(new FoodBean("鸡蛋小炒肉饭","https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1549895172&di=132d3c1f20f8e7b9c40c0a6a523547d5&src=http://e.hiphotos.baidu.com/bainuo/crop=0,8,700,424;w=470;q=80/sign=12c0abb4f0dcd100d9d3a2614fbb6b28/5243fbf2b21193139979fe096d380cd791238d54.jpg","doc","36"));
        foodBeanList.add(new FoodBean("鸡蛋小炒肉饭","https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1549895172&di=132d3c1f20f8e7b9c40c0a6a523547d5&src=http://e.hiphotos.baidu.com/bainuo/crop=0,8,700,424;w=470;q=80/sign=12c0abb4f0dcd100d9d3a2614fbb6b28/5243fbf2b21193139979fe096d380cd791238d54.jpg","doc","36"));
        foodBeanList.add(new FoodBean("鸡蛋小炒肉饭","https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1549895172&di=132d3c1f20f8e7b9c40c0a6a523547d5&src=http://e.hiphotos.baidu.com/bainuo/crop=0,8,700,424;w=470;q=80/sign=12c0abb4f0dcd100d9d3a2614fbb6b28/5243fbf2b21193139979fe096d380cd791238d54.jpg","doc","36"));
        foodBeanList.add(new FoodBean("鸡蛋小炒肉饭","https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1549895172&di=132d3c1f20f8e7b9c40c0a6a523547d5&src=http://e.hiphotos.baidu.com/bainuo/crop=0,8,700,424;w=470;q=80/sign=12c0abb4f0dcd100d9d3a2614fbb6b28/5243fbf2b21193139979fe096d380cd791238d54.jpg","doc","36"));
        foodBeanList.add(new FoodBean("鸡蛋小炒肉饭","https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1549895172&di=132d3c1f20f8e7b9c40c0a6a523547d5&src=http://e.hiphotos.baidu.com/bainuo/crop=0,8,700,424;w=470;q=80/sign=12c0abb4f0dcd100d9d3a2614fbb6b28/5243fbf2b21193139979fe096d380cd791238d54.jpg","doc","36"));
        foodBeanList.add(new FoodBean("鸡蛋小炒肉饭","https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1549895172&di=132d3c1f20f8e7b9c40c0a6a523547d5&src=http://e.hiphotos.baidu.com/bainuo/crop=0,8,700,424;w=470;q=80/sign=12c0abb4f0dcd100d9d3a2614fbb6b28/5243fbf2b21193139979fe096d380cd791238d54.jpg","doc","36"));

        apadter = new AllFoodAdviceApadter(foodBeanList, getActivity());
        rvFood.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        rvFood.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvFood.setAdapter(apadter);


    }

    @Override
    public void attachView() {

    }

}
