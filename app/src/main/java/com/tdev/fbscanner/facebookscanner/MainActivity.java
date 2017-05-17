package com.tdev.fbscanner.facebookscanner;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	Button btn;
	private AdView mAdView;
	private InterstitialAd mInterstitialAd;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.asd);
        fab.setOnClickListener(this);

		btn = (Button) findViewById(R.id.button);
		btn.setOnClickListener(this);

		MobileAds.initialize(this, "ca-app-pub-3744234328305963~3454873330");
		mAdView = (AdView) findViewById(R.id.adView);
		//mAdView.setAdSize(AdSize.BANNER);
		//mAdView.setAdUnitId();
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);
		mInterstitialAd = new InterstitialAd(this);
		mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
		mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

	public void func(View v) {
		Snackbar.make(v, "Snackbar clicked!", Snackbar.LENGTH_LONG)
				.setAction("Action", this).show();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId())
		{
			case R.id.asd:
				func(v);
				break;
			case R.id.button:
				btn.setText("you clicke md!!");
				break;
			default:
				Toast.makeText(this, "asdasd", Toast.LENGTH_SHORT).show();
				if (mInterstitialAd.isLoaded()) {
					mInterstitialAd.show();
				} else {
					Log.d("TAG", "The interstitial wasn't loaded yet.");
				}
		}

	}
}
