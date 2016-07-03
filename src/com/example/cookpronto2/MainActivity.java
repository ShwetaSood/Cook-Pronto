package com.example.cookpronto2;



import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends ActionBarActivity {
	protected ListView lv;
	protected ListAdapter adapter;
	SQLiteDatabase db;
	Cursor cursor;
	EditText et_db;
	Intent intent;
	String cat;
	TextView path;
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		ActionBar actionBar =getSupportActionBar();
		getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
	    getSupportActionBar().setLogo(R.drawable.logo);
	    getSupportActionBar().setDisplayUseLogoEnabled(true);

		db = (new DB_Recipe(this)).getWritableDatabase();
		lv = (ListView) findViewById(R.id.lv);
		path = (TextView) findViewById(R.id.path5);
		intent = getIntent();
		if (intent.getExtras()!=null)
		{
			cat=intent.getExtras().getString("cat");
		}
		path.setText("Home>"+cat);

		try {
			cursor = db.rawQuery("SELECT * FROM recipe WHERE cat = '"+cat+"' ORDER BY time ASC", null);
			adapter = new SimpleCursorAdapter(this, R.layout.searchingre, cursor,
					new String[] { "name","time",  "img" }, new int[] {
							R.id.tv_nama,R.id.tv_time,  R.id.imV });
			lv.setAdapter(adapter);
			lv.setTextFilterEnabled(true);
			lv.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View v,
						int position, long id) {
					detail(position);

				}
			});		} catch (Exception e) {
			e.printStackTrace();
			
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
        	Intent helpIntent = new Intent(this, Help_searchingre.class);
            helpIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(helpIntent);
            Toast.makeText(getBaseContext(), "Click on help button", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
	 

	 
	 
	 
	 
	
	public void calltosearch(View v)
	{
		String cate=(String) path.getText();
		//Log.v("Here",cate);
		Intent i = new Intent(this, Searchbyingredients.class);
		i.putExtra("paths", cate);
		startActivity(i);
	}

	public void detail(int position) {
		int im = 0;
		String _id = "";
		String name = "";
		String quant = "";
		String prep = "";
		String time = "";
		
		if (cursor.moveToFirst()) {
			cursor.moveToPosition(position);
			im = cursor.getInt(cursor.getColumnIndex("img"));
			name = cursor.getString(cursor.getColumnIndex("name"));
			quant = cursor.getString(cursor.getColumnIndex("quant"));
			prep = cursor.getString(cursor.getColumnIndex("prep"));
			time = cursor.getString(cursor.getColumnIndex("time"));

		}
		String path="Home>"+cat;
		Intent iIntent = new Intent(this, DB_Parse.class);
		iIntent.putExtra("dataIM", im);
		iIntent.putExtra("dataName", name);
		iIntent.putExtra("dataQuant", quant);
		iIntent.putExtra("dataMethod", prep);
		iIntent.putExtra("dataTime", time);
		setResult(RESULT_OK, iIntent);
		startActivityForResult(iIntent, 99);
	}

}