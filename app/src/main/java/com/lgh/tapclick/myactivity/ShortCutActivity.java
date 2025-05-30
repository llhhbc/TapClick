package com.lgh.tapclick.myactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

import com.lgh.tapclick.myfunction.MyUtils;

public class ShortCutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = getApplicationContext();
        if (getIntent().getAction().equals("com.lgh.action.addData")) {
            if (MyUtils.isServiceRunning()) {
                MyUtils.requestShowAddDataWindow();
            } else {
                Intent intentAccessibility = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                intentAccessibility.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentAccessibility);
                Toast.makeText(context, "请先开启无障碍服务", Toast.LENGTH_SHORT).show();
            }
        }
        finishAndRemoveTask();
    }
}
