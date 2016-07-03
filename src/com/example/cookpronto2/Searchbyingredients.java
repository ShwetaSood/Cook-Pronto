package com.example.cookpronto2;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.Arrays;
import java.util.List;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Searchbyingredients extends ActionBarActivity {
	SQLiteDatabase db;
	private MultiAutoCompleteTextView et;
	Cursor cursor;
	Cursor cursor1;
	Cursor cursor2;
	String avoid;
	Intent intent;
	RadioButton veg;
	RadioButton nonveg;
	Button text;
	String path;
	protected ListAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.searchbyingredients);

		ActionBar actionBar =getSupportActionBar();
		getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
	    getSupportActionBar().setLogo(R.drawable.logo);
	    getSupportActionBar().setDisplayUseLogoEnabled(true);

		
		db = (new DB_Recipe(this)).getWritableDatabase();
		et = (MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView1);
		String[] ingredients = getResources().
				   getStringArray(R.array.list_of_ingre);
				   ArrayAdapter adapter2 = new ArrayAdapter
				   (this,android.R.layout.simple_list_item_1,ingredients);
				   et.setAdapter(adapter2);

				   et.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
		veg=(RadioButton)findViewById(R.id.veg);
		nonveg=(RadioButton)findViewById(R.id.nonveg);
		intent = getIntent();
		text = (Button) findViewById(R.id.path2);
		avoid="";
		if (intent.getExtras()!=null)
		{
			if(intent.getExtras().size()==1)
			{
				path=intent.getExtras().getString("paths");
				text.setText(path+">Add Ingredients");
			}
			else
			{
				String savedtext=intent.getExtras().getString("savedtext");
				avoid=intent.getExtras().getString("avoid");
				et.setText(savedtext);
				String prefer=intent.getExtras().getString("prefer");
				if(prefer.equals("veg"))
				{
					veg.setChecked(true);
					nonveg.setChecked(false);
				}
				else
				{
					nonveg.setChecked(true);
					veg.setChecked(false);
				}
				path=intent.getExtras().getString("paths");
				text.setText(path);
			}
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
        	Intent helpIntent = new Intent(this, Help_Searchingre_Main.class);
            helpIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(helpIntent);
            Toast.makeText(getBaseContext(), "Click on help button", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
	
	public void search_db(View v) {
	        	String edit_db = et.getText().toString();
	        	String[] values=edit_db.split(",");
	        	String name = "";
	        	List list2 = null;
				String name2="";
	    		if (!edit_db.equals("")) {
	    			try {

	    				cursor1=db.rawQuery("SELECT ingre,name,_id FROM recipe",null);
	    				int k=0,cnt=0,f=0;
	    				if (cursor1.moveToFirst()) {
	    				    do {
	    				    	cnt++;
	    				    	String ingre=cursor1.getString(0);
	    	    				String[] matches=ingre.split(",");
	    	    				int i;
	    	    				
	    	    				for(i=0;i<values.length;i++)
	    	    				{
	    	    					if(Arrays.asList(matches).contains(values[i].replace(" ","").toLowerCase()))
	    	    					{
	    	    						if(f!=0)
	    	    				    		name=name.concat(",");
	    	    						name=name.concat("'");
	    	    						name=name.concat(cursor1.getString(1)).concat("'");
	    	    						f++;
	    	    						break;
	    	    					}
	    	    				}
	    	    				
	    				    } while (cursor1.moveToNext());
	    				}
	    				
	    				if(avoid!="")
	    				{
	    					int g=0,j=0;
	    					String[] names2=avoid.split(",");
		    				cursor2=db.rawQuery("SELECT ingre,name FROM recipe",null);
		    				
		    				if (cursor2.moveToFirst()) {
		    					do{
		    						String ingre=cursor2.getString(0);
		    	    				String[] matches=ingre.split(",");
		    	    				int i=0;
		    	    				Log.d("Length",""+names2.length);
		    						for(j=0;j<names2.length;j++)
		    						{
		    							
		    							if(Arrays.asList(matches).contains(names2[j]))
		    							{
		    								if(g!=0)
		    	    				    		name2=name2.concat(",");
		    	    						name2=name2.concat("'");
		    	    						name2=name2.concat(cursor2.getString(1)).concat("'");
		    	    						g++;
		    	    						break;
		    								
		    							}
		    						}
		    					}while (cursor2.moveToNext());
		    				}
		    				
		    				names2=name2.split(",");
		    				list2=Arrays.asList(names2);
		    				name2=list2.toString();
		    				name2=name2.replace("[","(");
		    				name2=name2.replace("]", ")");
		    				
	    				}
	    				
	    				int i,j;
	    				
	    				String[] names=name.split(",");
	    				List list=Arrays.asList(names);
	    				if(!(list2==null))
	    				{
	    					for(i=0;i<list2.size();i++)
	    					{
	    						for(j=0;j<list.size();j++)
	    						{
	    							if(list2.get(i).equals(list.get(j)))
	    							{
	    								list.set(j, "'NotApplicable'");
	    							}
	    						}
	    					}
	    				}
	    				if(!(list.isEmpty()))
	    					name=list.toString();
	    				//Log.v("Name",name);
	    				//Log.v("List",list.toString());
	    				//Log.v("List2",list2.toString());
	    				name=name.replace("[","(");
	    				name=name.replace("]", ")");	
	    				String prefer="veg";
	    				if(nonveg.isChecked())
	    					prefer="nonveg";
	    				
	    				Intent toresults = new Intent(this, Ingreresults.class);
	    				toresults.putExtra("name",name);
	    				toresults.putExtra("prefer",prefer);
	    				toresults.putExtra("paths", text.getText().toString());
	    				startActivity(toresults);
	    			    
	    			} catch (Exception e) {
	    				e.printStackTrace();
	    			}
	        }
	        }
	
	public void launch(View v)
	{

		Intent i = new Intent(this, AvoidIngredients.class);
		String savedtext=et.getText().toString();
		String prefer;
		if(veg.isChecked())
			prefer="veg";
		else
			prefer="nonveg";
		i.putExtra("savedtext",savedtext);
		i.putExtra("prefer",prefer);
		i.putExtra("paths", text.getText().toString());
		startActivity(i);
	}
	
	
	public void onRadioButtonClicked(View view) {
	    // Is the button now checked?
	    boolean checked = ((RadioButton) view).isChecked();
	    
	    // Check which radio button was clicked
	    switch(view.getId()) {
	        case R.id.veg:
	            if (checked)
	            	view.setSelected(false);
	            else
	            	view.setSelected(true);
	            break;
	        case R.id.nonveg:
	            if (checked)
	            	view.setSelected(false);
	            else
	            	view.setSelected(true);
	            break;
	    }
	}
}
