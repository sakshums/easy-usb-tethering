package com.marcellomessori.easyusbtethering;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class IntroductionActivity extends Activity {


    private AdView mAdView;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_intro);
        MobileAds.initialize(this,
                "ca-app-pub-2413724092372090~4639103575");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mButton = (Button) findViewById(R.id.dummy_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tetherSettings = new Intent();
                tetherSettings.setClassName("com.android.settings", "com.android.settings.TetherSettings");
                tetherSettings.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(tetherSettings);
            }
        });
    }

}
