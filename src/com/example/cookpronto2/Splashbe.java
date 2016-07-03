package com.example.cookpronto2;

import com.example.cookpronto2.Task.TaskFinishedListener;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Splashbe extends Activity implements TaskFinishedListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Show the splash screen
        setContentView(R.layout.splashbe);
        // Find the progress bar
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.activity_splash_progress_bar);
        // Start your loading
        new Task(progressBar, this).execute("www.google.co.uk"); // Pass in whatever you need a url is just an example we don't use it in this tutorial
    }

    // This is the callback for when your async task has finished
    @Override
	public void onTaskFinished() {
		completeSplash();
	}

    private void completeSplash(){
		startApp();
		finish(); // Don't forget to finish this Splash Activity so the user can't return to it!
    }

    private void startApp() {
		Intent intent = new Intent(Splashbe.this, Home.class);
		startActivity(intent);
	}
}