package com.example.cookpronto2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Home extends ActionBarActivity {
	protected ListView lv;
	protected ListAdapter adapter;
	SQLiteDatabase db;
	Cursor cursor;
	private AutoCompleteTextView et_db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		ActionBar actionBar =getSupportActionBar();
		getSupportActionBar().setDisplayShowHomeEnabled(true);
	    getSupportActionBar().setLogo(R.drawable.logo);
	    getSupportActionBar().setDisplayUseLogoEnabled(true);
		
		

		db = (new DB_Recipe(this)).getWritableDatabase();
		lv = (ListView) findViewById(R.id.lv2);
		
		String[] recipes = getResources().
				   getStringArray(R.array.list_of_recipes);
				   ArrayAdapter adapter2 = new ArrayAdapter
				   (this,android.R.layout.simple_list_item_1,recipes);
		et_db = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		et_db.setAdapter(adapter2);
		try {
			String[] cats = new String[] {
			        "Busy Bee", "Healthy Pick","Dinner Delight","Snacky Eve"
			    };
			// Array of integers points to images stored in /res/drawable-hdpi/
		    int[] flags = new int[]{
		    		
		        R.drawable.busybee,
		        R.drawable.healthypick,
		        R.drawable.dinnerdelight,
		        R.drawable.snackeve

		    };
			 List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

		        for(int i=0;i<4;i++){
		            HashMap<String, String> hm = new HashMap<String,String>();
		            hm.put("category",cats[i]);
		            hm.put("flag", Integer.toString(flags[i]) );
		            aList.add(hm);
		        }

		        // Keys used in Hashmap
		        String[] from = { "flag","category"};

		        // Ids of views in listview_layout
		        int[] to = { R.id.imV2,R.id.tv_nama2};

		        // Instantiating an adapter to store each items
		        // R.layout.listview_layout defines the layout of each item
		        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList,R.layout.category, from, to);


		        // Setting the adapter to the listView
		        lv.setAdapter(adapter);
		        lv.setTextFilterEnabled(true);
				lv.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View v,
							int position, long id) {
						detail(position);

					}
				});	
			}
			catch (Exception e) {
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
	        
	        if (id == R.id.home_icon) {
	      	  Intent homeIntent = new Intent(this, Home.class);
	            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(homeIntent);
	            Toast.makeText(getBaseContext(), "Click on home button", Toast.LENGTH_LONG).show();
	        }

	       
	        if (id == R.id.help_icon) {
	        	Intent helpIntent = new Intent(this, Help_Home.class);
	            helpIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(helpIntent);
	            Toast.makeText(getBaseContext(), "Click on help button", Toast.LENGTH_LONG).show();
	        }
	        return super.onOptionsItemSelected(item);
	    }
	 

	public void detail(int position) {
		String cat;
		if(position==0)
		{
			cat="Busy Bee";
		}
		else if(position==1)
		{
			cat="Healthy Pick";
		}
		else if(position==2)
		{
			cat="Dinner Delight";
		}
		else
		{
			cat="Snacky Eve";
		}	
		Intent iIntent = new Intent(this, MainActivity.class);
		iIntent.putExtra("cat", cat);
		startActivity(iIntent);
	}
	
	public void search_db(View v) {
		String edit_db = et_db.getText().toString();
		if (!edit_db.equals("")) {
			try {
				cursor = db.rawQuery("SELECT * FROM recipe WHERE name LIKE ?",
						new String[] { "%" + edit_db + "%" });
				adapter = new SimpleCursorAdapter(
						this,
						R.layout.searchingre,
						cursor,
						new String[] { "name","time","img" },
						new int[] { R.id.tv_nama, R.id.tv_time, R.id.imV });
				if (adapter.getCount() == 0) {
					Toast.makeText(
							this,
							"No recipe with name " + edit_db
									+ " exists", Toast.LENGTH_SHORT).show();
				} else {
					lv.setAdapter(adapter);
					lv.setTextFilterEnabled(true);
					lv.setOnItemClickListener(new OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> parent, View v,
								int position, long id) {
							detail2(position);

						}
					});		
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
	}
	
	public void detail2(int position) {
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
