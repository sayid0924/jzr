package com.jzr.bedside.view.tv;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Utils {
    /**
     * 格式化
     */
    private static DecimalFormat dfs = null;
    public static DecimalFormat format(String pattern) {
        if (dfs == null) {
            dfs = new DecimalFormat();
        }
        dfs.setRoundingMode(RoundingMode.FLOOR);
        dfs.applyPattern(pattern);
        return dfs;
    }
}