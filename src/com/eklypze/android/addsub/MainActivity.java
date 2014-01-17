package com.eklypze.android.addsub;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eklypze.android.helloworld.R;

public class MainActivity extends Activity {

	int counter;
	Button add, sub;
	TextView display;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// initialize counter to 0
		counter = 0;
		// get button id from XML
		add = (Button) findViewById(R.id.bAdd);
		sub = (Button) findViewById(R.id.bSub);
		// get text id from XML
		display = (TextView) findViewById(R.id.tvDisplay);

		/* Assign Listener to Buttons */
		add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				counter++;
				display.setText("Your total is: " + counter + ".");
			}
		});
		sub.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				counter--;
				display.setText("Your total is: " + counter + ".");
			}
		});
	}

}
