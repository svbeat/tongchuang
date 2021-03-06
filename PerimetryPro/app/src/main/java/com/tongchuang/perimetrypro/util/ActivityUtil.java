package com.tongchuang.perimetrypro.util;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.WindowManager;

import com.tongchuang.perimetrypro.perimetry.common.Intensity;
import com.tongchuang.perimetrypro.perimetry.settings.ExamSettings;
import com.tongchuang.perimetrypro.perimetry.settings.SettingService;

import java.util.UUID;

/**
 * Created by qingdi on 3/10/16.
 */
public class ActivityUtil {
    public static void hideStatusBar(AppCompatActivity activity) {
        View decorView = activity.getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        android.support.v7.app.ActionBar actionBar = activity.getSupportActionBar();
        actionBar.hide();
    }

    public static String getDeviceID(Context context) {
        final TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        String deviceId = tm.getDeviceId();
        if (deviceId == null || deviceId.isEmpty()) {
            // load deviceSettings
            SharedPreferences sharedPref = context.getSharedPreferences(SettingService.SHARED_PREF_NAME, Context.MODE_PRIVATE);
            deviceId = sharedPref.getString(SettingService.PROP_NAME_DEVICE_ID, "");
            if (deviceId.isEmpty()) {
                deviceId = UUID.randomUUID().toString();
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString(SettingService.PROP_NAME_DEVICE_ID, deviceId);
                editor.commit();
            }
        }
/*
        final String tmDevice, tmSerial, tmPhone, androidId;
        tmDevice = "" + tm.getDeviceId();
        tmSerial = "" + tm.getSimSerialNumber();
        androidId = "" + android.provider.Settings.Secure.getString(context.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);

        UUID deviceUuid = new UUID(androidId.hashCode(), ((long)tmDevice.hashCode() << 32) | tmSerial.hashCode());
        String deviceId = deviceUuid.toString();
        return deviceId;
        */
        return deviceId;
    }

    public static void setScreenBrightness(AppCompatActivity activity, ExamSettings examSettings) {
        Intensity defaultIntensity = examSettings.getDefaultIntensity();
        WindowManager.LayoutParams layout = activity.getWindow().getAttributes();
        layout.screenBrightness = defaultIntensity.getScreenBrightness();
        activity.getWindow().setAttributes(layout);
    }
}
