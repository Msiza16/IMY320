package com.project.imy320.spaceboy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.net.ParseException;

import com.parse.Parse;
import com.parse.ParseObject;


public class MainActivity extends AppCompatActivity {
    Fragment fragment;
    private int endState;
    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayView(3);
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "8B2ErhBcnMGnilCANwXWYoMcj1WQQmd6BKqseKIU", "X47E2mI8YSLslBq415JO64WGzI9Sws5xNxoMYv7t");
    }

    public void onBackPressed()
    {
        FragmentManager fm = getSupportFragmentManager();
        if(fragment instanceof TaskListFrag )
        {
            ViewFlipper vf= (ViewFlipper) findViewById(R.id.TaskV);
            if(SpaceBoy_Globals.TaskFragState==0) {
                fm.popBackStack();
                try {
                    if (counter == 0) {
                        Toast.makeText(this, "out", Toast.LENGTH_SHORT).show();
                    } else {
                        counter--;
                    }

                } catch (Exception e) {
                    Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
                }
            }
            else if(SpaceBoy_Globals.TaskFragState==1)
            {
                vf.showPrevious();
                SpaceBoy_Globals.TaskFragState=0;
            }
            else if(SpaceBoy_Globals.TaskFragState==2)
            {
                vf.showPrevious();
                SpaceBoy_Globals.TaskFragState=1;
            }
            else if(SpaceBoy_Globals.TaskFragState==4)
            {
                vf.showPrevious();
                vf.showPrevious();
                SpaceBoy_Globals.TaskFragState=0;
            }
            else if(SpaceBoy_Globals.TaskFragState==5)
            {
                vf.showPrevious();
                SpaceBoy_Globals.TaskFragState=4;
            }
            else if(SpaceBoy_Globals.TaskFragState==6)
            {
                vf.showPrevious();
                vf.showPrevious();
                SpaceBoy_Globals.TaskFragState=1;
            }
            counter=2;

        }
        else{
        fm.popBackStack();
        try {
            if (counter==0) {
                Toast.makeText(this, "out", Toast.LENGTH_SHORT).show();
            }
            else
            {
                counter--;
            }
        }
        catch(Exception e)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
 ;  }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void Cal(View v)
    {
        displayView(1);
    }
    public void TimeT(View v) {
        displayView(2);
    }
    public void NewTask(View v)
    {
        displayView(0);
    }
    private void displayView(int position) {
        fragment= null;
        String title = getString(R.string.app_name);
        counter++;
        endState=position;
        switch (position) {
            case 0:
                fragment = new TaskListFrag();
                break;
            case 1:
                fragment = new CalendarViewFragment();
                break;
            case 2:
                fragment = new TimeTableFrag();
               // title = getString(R.string.title_fingureprinting);
                break;
            case 3:
                fragment = new buttonFragClass();
                //title = getString(R.string.title_images);
                break;
            case 4:/*
                fragment = new TakePictureFragment();
                title = getString(R.string.title_take_pictures);
                break;
            case 5:
                fragment = new SettingFragment();
                title = getString(R.string.title_settings);
                break;*/
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.Container, fragment);
           if(position!=3)
            fragmentTransaction.addToBackStack(null).commit();
            else
            fragmentTransaction.commit();
            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
