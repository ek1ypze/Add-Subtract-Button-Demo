package com.eklypze.android.addsub;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.eklypze.android.addsub.R;

public class Splash extends Activity {
	MediaPlayer bgSong;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);

		// play background song, continue until MainActivity
		bgSong = MediaPlayer.create(this, R.raw.ffmelodies_piano);
		bgSong.start();

		// create thread to load timed splash
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(5000); // 5000ms = 5seconds
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent openMainActivity = new Intent(
							"com.eklypze.android.addsub.MENU");
					startActivity(openMainActivity); // start MainActivity after splash finished
				}
			}
		};
		timer.start(); // start timer
	}

	@Override
	protected void onPause() {
		super.onPause();
		// bgSong.release(); // stop song after splash finishes
		finish();
	}

}
