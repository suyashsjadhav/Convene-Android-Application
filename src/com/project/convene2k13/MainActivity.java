package com.project.convene2k13;



import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void go_to_map(View view){
		Intent go_to_map= new Intent(this,Show_on_map.class);
		startActivity(go_to_map);
	}
	public void go_to_schedule(View view){
		Intent go_to_schedule= new Intent(this,Show_schedule.class);
		startActivity(go_to_schedule);
	}
	public void open_cybage_website(View view){
		  Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://www.cybage.com/pages/index.aspx"));

          startActivity(intent);
	}

}
