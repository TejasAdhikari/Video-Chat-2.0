package com.quickblox.sample.videochat.java.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.quickblox.auth.session.QBSettings;
import com.quickblox.sample.videochat.java.BuildConfig;
import com.quickblox.sample.videochat.java.R;


public class AppInfoActivity extends BaseActivity {

    private TextView appVersionTextView;

    public static void start(Context context) {
        Intent intent = new Intent(context, AppInfoActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appinfo);

        initUI();
        fillUI();
    }

    private void initUI() {
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(R.string.appinfo_title);
        appVersionTextView = findViewById(R.id.text_app_version);
    }

    public void fillUI() {
        appVersionTextView.setText("2.0.0");

        if (BuildConfig.IS_QA) {
            String appVersion = BuildConfig.VERSION_NAME;
            String versionQACode = String.valueOf(BuildConfig.VERSION_QA_CODE);
            String qaVersion = appVersion + "." + versionQACode;
            Spannable spannable = new SpannableString(qaVersion);
            spannable.setSpan(new ForegroundColorSpan(Color.RED), appVersion.length() + 1,
                    qaVersion.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }
}