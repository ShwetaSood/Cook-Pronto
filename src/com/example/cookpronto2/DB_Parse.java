package com.example.cookpronto2;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DB_Parse extends ActionBarActivity {
	ImageView Im;
	TextView name, quantity, prepare, id,time;
	Gallery gallery;
	ImageSwitcher imageSwitcher;
	Integer[] imageIDs = new Integer[3];
	int msg_im;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recipe);

		ActionBar actionBar =getSupportActionBar();
		getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
	    getSupportActionBar().setLogo(R.drawable.logo);
	    getSupportActionBar().setDisplayUseLogoEnabled(true);


		Intent i = getIntent();
		msg_im = i.getIntExtra("dataIM", 0);
		String msg_name = i.getStringExtra("dataName");
		String msg_quantity = i.getStringExtra("dataQuant");
		String msg_prepare = i.getStringExtra("dataMethod");
		String msg_time = i.getStringExtra("dataTime");
		
		Im = (ImageView) findViewById(R.id.picture);
		name = (TextView) findViewById(R.id.recipename);
		quantity = (TextView) findViewById(R.id.quantity);
		prepare = (TextView) findViewById(R.id.prepare);
		time = (TextView) findViewById(R.id.time);
		
		Im.setImageResource(msg_im);
		name.setText(msg_name);
		quantity.setText(msg_quantity);
		prepare.setText(msg_prepare);
		time.setText(msg_time);
	}
	@Override
	  public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.action_bar, menu);
	    return super.onCreateOptionsMenu(menu);
	  } 
	
	@Override
  public boolean onOptionsItemSelected(MenuItem item) {
      // Handle action bar item clicks here. The action bar will
      // automatically handle clicks on the Home/Up button, so long
      // as you specify a parent activity in AndroidManifest.xml.
      int id = item.getItemId();
      
      if (id==android.R.id.home){
          // app icon in action bar clicked; goto parent activity.
          this.finish();
          return true;
      }
      if (id == R.id.home_icon) {
          Toast.makeText(getBaseContext(), "Click on home button", Toast.LENGTH_LONG).show();
      
          Intent homeIntent = new Intent(this, Home.class);
          homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
          startActivity(homeIntent);
      }
      if (id == R.id.help_icon) {
    	  Intent helpIntent = new Intent(this, Help_search.class);
          helpIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
          startActivity(helpIntent);
          Toast.makeText(getBaseContext(), "Click on help button", Toast.LENGTH_LONG).show();
      }
      return super.onOptionsItemSelected(item);
  }
	
}