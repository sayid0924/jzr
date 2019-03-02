package com.jzr.bedside.utils;

import android.view.View;

public class AreaClickListener implements View.OnLongClickListener, View.OnClickListener {

    private static final String TAG = AreaClickListener.class.getSimpleName();
    private final int COUNT_FOR_FIRE_EVENT;
    private final int VALID_TIME_INTERVAL;
    private final ClickEvent mClickEvent;

    public AreaClickListener(int count, int interval, ClickEvent event) {
        COUNT_FOR_FIRE_EVENT = count;
        VALID_TIME_INTERVAL = interval;
        mClickEvent = event;
    }

    private int mLongClickCount = 0;
    private long mLastLongClickTime = 0;
    private long mCurrentClickTime = 0;

    @Override
    public boolean onLongClick(View v) {
        mCurrentClickTime = System.currentTimeMillis();
        if ((mLongClickCount == 0) || (mCurrentClickTime - mLastLongClickTime) < VALID_TIME_INTERVAL) {
            mLongClickCount++;
            if (mLongClickCount == COUNT_FOR_FIRE_EVENT) {
                if (mClickEvent != null) {
                    mClickEvent.onEvent();
                }
            }
        } else {
            mLongClickCount = 1;
        }
        mLastLongClickTime = mCurrentClickTime;

        return true;
    }

    @Override
    public void onClick(View v) {
        mCurrentClickTime = System.currentTimeMillis();
        if ((mLongClickCount == 0) || (mCurrentClickTime - mLastLongClickTime) < VALID_TIME_INTERVAL) {
            mLongClickCount++;
            if (mLongClickCount == COUNT_FOR_FIRE_EVENT) {
                if (mClickEvent != null) {
                    mClickEvent.onEvent();
                }
            }
        } else {
            mLongClickCount = 1;
        }
        mLastLongClickTime = mCurrentClickTime;

    }


    public interface ClickEvent {
        void onEvent();
    }
}
