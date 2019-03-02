package com.jzr.bedside.view.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.jzr.bedside.R;

/**
 * Created by Bben on 2018/11/14.
 */

public class DialogActivity extends Activity implements View.OnClickListener {
    private LinearLayout ll_root,ll_dialog;
    private Button bt_confirm,bt_dismiss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_connect_fail);
        getWindow().setLayout(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        initView();
    }

    private void initView() {
//        ll_root= (LinearLayout) findViewById(R.id.ll_root);
//        ll_dialog= (LinearLayout) findViewById(R.id.ll_dialog);
//        bt_confirm= (Button) findViewById(R.id.bt_confirm);
//        bt_dismiss= (Button) findViewById(R.id.bt_dismiss);
//        ll_root.setOnClickListener(this);
//        ll_dialog.setOnClickListener(this);
//        bt_dismiss.setOnClickListener(this);
//        bt_confirm.setOnClickListener(this);

    }

    public void confirm(View v){

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.bt_dismiss:
//            case R.id.ll_root:
//                finish();
//                break;
//            case R.id.bt_confirm:
//                Toast.makeText(this, "确认充值", Toast.LENGTH_SHORT).show();
//                finish();
//                break;
        }
    }
}