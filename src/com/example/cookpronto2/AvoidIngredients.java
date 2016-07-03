package com.example.cookpronto2;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class AvoidIngredients extends ActionBarActivity {

	CheckBox c1;
	CheckBox c2;
	CheckBox c3;
	CheckBox c4;
	CheckBox c5;
	CheckBox c6;
	CheckBox c7;
	Button text;
	String path;
	Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.avoid_ingredients);

		ActionBar actionBar =getSupportActionBar();
		getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
	    getSupportActionBar().setLogo(R.drawable.logo);
	    getSupportActionBar().setDisplayUseLogoEnabled(true);


		c1=(CheckBox)findViewById(R.id.egg);
		c2=(CheckBox)findViewById(R.id.poultry);
		c3=(CheckBox)findViewById(R.id.sugar);
		c4=(CheckBox)findViewById(R.id.shellfish);
		c5=(CheckBox)findViewById(R.id.nut);
		c6=(CheckBox)findViewById(R.id.soy);
		c7=(CheckBox)findViewById(R.id.wheat);
		text = (Button) findViewById(R.id.path3);
		intent = getIntent();
		
		if (intent.getExtras()!=null)
		{
				path=intent.getExtras().getString("paths");
				text.setText(path+">\nAvoid Ingredients");
		}

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
    	  Intent homeIntent = new Intent(this, Home.class);
          homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
          startActivity(homeIntent);
          Toast.makeText(getBaseContext(), "Click on home button", Toast.LENGTH_LONG).show();
      }
      if (id == R.id.help_icon) {
    	  Intent helpIntent = new Intent(this, Help_Avoid.class);
          helpIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
          startActivity(helpIntent);
          Toast.makeText(getBaseContext(), "Click on help button", Toast.LENGTH_LONG).show();
      }
      return super.onOptionsItemSelected(item);
  }
	
	
	public void savestate(View v)
	{
		Toast.makeText(this,"Save", Toast.LENGTH_SHORT).show();
		 String avoid="";
		 int f=0;
         if(c1.isChecked())
         {
        	 avoid+=c1.getText().toString().toLowerCase();
          	 f=1;
         }
         if(c2.isChecked())
         {
        	 if(f==1)
        	 	avoid+=",";
             avoid+=c2.getText().toString().toLowerCase();
             f=1;
         }
         if(c3.isChecked())
         {
        	 if(f==1)
        		 avoid+=",";
        	 avoid+=c3.getText().toString().toLowerCase();
        	 f=1;
         }
         if(c4.isChecked())
         {
        	 if(f==1)
        		 avoid+=",";
        	 avoid+=c4.getText().toString().toLowerCase();
        	 f=1;
         }
         if(c5.isChecked())
         {
        	 if(f==1)
        		 avoid+=",";
        	 avoid+=c5.getText().toString().toLowerCase();
        	 f=1;
         }
         if(c6.isChecked())
         {
        	 if(f==1)
        		 avoid+=",";
             avoid+=c6.getText().toString().toLowerCase();
             f=1;
         }
         if(c7.isChecked())
         {
        	 if(f==1)
        		 avoid+=",";
             avoid+=c7.getText().toString().toLowerCase();
             f=1;
         }
         Intent intent=getIntent();
         String savedtext=intent.getExtras().getString("savedtext");
         String prefer=intent.getExtras().getString("prefer");
         Intent i = new Intent(this, Searchbyingredients.class);
         i.putExtra("avoid", avoid);
         i.putExtra("savedtext",savedtext);
         i.putExtra("prefer", prefer);
         path=intent.getExtras().getString("paths");
         i.putExtra("paths", path);
         
 		 startActivity(i);
	}
	public void cancelstate(View v)
	{
		Toast.makeText(this,"Cancel", Toast.LENGTH_SHORT).show();
		c1.setChecked(false);
		c2.setChecked(false);
		c3.setChecked(false);
		c4.setChecked(false);
		c5.setChecked(false);
		c6.setChecked(false);
		c7.setChecked(false);
	}

}
