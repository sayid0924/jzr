package com.jzr.bedside.utils;

import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

import static android.content.Context.WIFI_SERVICE;

/**
 * Created by Bben on 2018/11/5.
 */

public class CommonUtil {


    public static String getBaseUrl() {
        return "http://"+PreferUtil.getInstance().getBaseUrl()+":"+PreferUtil.getInstance().getServerPort();
    }

    public static String getDownFileUrl(String path) {
        return getBaseUrl()+"/"+path;
    }

    public static String getWifiInfo(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        return wifiInfo.getSSID();
    }

    public static int getWifiLevel(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int ressi = wifiInfo.getRssi();

        if (ressi < 0 && ressi > -50) {
            return 0;
        } else if (ressi < -50 && ressi > -70) {
            return 1;
        } else if (ressi < -70) {
            return 2;
        }
        return 3;
    }


    /***
     * 获取本机IP地址
     */
    public static String getIP() {

        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    /**
     * 设置系统时间自动确定日期时间
     * @param checked
     * @param mContext
     */
    public static void setAutoDateTime(int checked,Context mContext){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            Settings.Global.putInt(mContext.getContentResolver(),
                    Settings.Global.AUTO_TIME, checked);
        }
    }

    /***
     * 设置系统时间
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param mContext
     */
    public static void setSysDate(int year, int month, int day, int hour,int minute, int second ,Context mContext){

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);

        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, second);
        c.set(Calendar.MILLISECOND, 0);

        long when = c.getTimeInMillis();

        if(when / 1000 < Integer.MAX_VALUE){
            ((AlarmManager)mContext.getSystemService(Context.ALARM_SERVICE)).setTime(when);
        }
    }

    /**
     * 根据生日计算年龄工具类
     * @param birthday
     * @return
     */
    public static int getAgeByBirth(Date birthday , Date nowTime) {
        int age = 0;
        try {

            Calendar now = Calendar.getInstance();
            now.setTime(nowTime);// 当前时间

            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);

            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (Exception e) {//兼容性更强,异常后返回数据
            return 0;
        }
    }

    /**
     * 获取设备唯一标识
     */
    public static String getDeviceId(Context context){
        TelephonyManager telephonyManager=(TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String  deviceCode=telephonyManager.getDeviceId();

        if(deviceCode==null){
            WifiManager wifi = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = wifi.getConnectionInfo();
            deviceCode=info.getMacAddress();
        }
        if(deviceCode==null){
            deviceCode= System.currentTimeMillis()+"";
        }
//        Logger.e("=============    DeviceId:   =========== " +deviceCode);
        return  deviceCode;
    }

//    public static UDPMessage getUdpMessage(String msg, int type){
//        UDPMessage message=new UDPMessage();
//        message.setType(type);
//        message.setIp(CommonUtil.getIP());
//        message.setSenderName(PreferUtil.getInstance().getDeviceName());
//        message.setMsg(msg);
//        message.setDeviceCode(getDeviceId(BaseApplication.getContext()));
//        message.setOwn(true);
//        return message;
//    }

    public  static int   getWidth(Context context){
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(dm);
        // 获得屏幕的高宽（用来适配分辨率）
      return dm.widthPixels;
    }

    public static int   getHeight(Context context){
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(dm);
        // 获得屏幕的高宽（用来适配分辨率）
        return dm.heightPixels;
    }

    /**
     * 启动第三方apk
     * 直接打开  每次都会启动到启动界面，每次都会干掉之前的，从新启动
     * XXXXX ： 包名
     */
    public static void launchCctvAPK(Context context,String pkgname) {

        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            PackageManager pm = context.getPackageManager();
            intent = pm.getLaunchIntentForPackage(pkgname);
            context.startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 对字符加星号处理：除前面几位和后面几位外，其他的字符以星号代替
     *
     * @param content
     *            传入的字符串
     * @param frontNum
     *            保留前面字符的位数
     * @param endNum
     *            保留后面字符的位数
     * @return 带星号的字符串
     */
    public static String replaceString2Star(String content, int frontNum, int endNum) {
        if (content == null || content.trim().isEmpty())
            return content;

        int len = content.length();

        if (frontNum >= len || frontNum < 0 || endNum >= len || endNum < 0)
            return content;

        if (frontNum + endNum >= len)
            return content;

        int beginIndex = frontNum;
        int endIndex = len - endNum;
        char[] cardChar = content.toCharArray();

        for (int j = beginIndex; j < endIndex; j++) {
            cardChar[j] = '*';
        }

        return new String(cardChar);
    }

}
