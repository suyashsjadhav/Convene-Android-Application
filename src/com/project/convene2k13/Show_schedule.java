package com.project.convene2k13;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class Show_schedule extends Activity {
	
		@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		WebView webview = new WebView(this);
		 setContentView(webview);
	
		 webview.getSettings().setBuiltInZoomControls(true);
		 webview.loadUrl("file:///android_asset/scheduleconvene2k13.html");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_schedule, menu);
		return true;
	}

}
