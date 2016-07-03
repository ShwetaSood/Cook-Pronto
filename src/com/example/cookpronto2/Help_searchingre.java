package com.example.cookpronto2;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Help_searchingre extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help_searchingre);
		
		ActionBar actionBar =getSupportActionBar();
		getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
	    getSupportActionBar().setLogo(R.drawable.logo);
	    getSupportActionBar().setDisplayUseLogoEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.help_searchingre, menu);
		return true;
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
        	 Intent homeIntent = new Intent(this, Home.class);
             homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
             startActivity(homeIntent);
            Toast.makeText(getBaseContext(), "Click on home button", Toast.LENGTH_LONG).show();
        }
       
        return super.onOptionsItemSelected(item);
    }
}
