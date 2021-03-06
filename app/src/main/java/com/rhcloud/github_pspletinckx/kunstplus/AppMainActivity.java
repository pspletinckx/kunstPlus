package com.rhcloud.github_pspletinckx.kunstplus;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class AppMainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks,ContentFragmentCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        //Pieter: Implement different Fragments here
        switch (position){
            case 0:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, HomeScreenFragment.newInstance(position + 1))
                        .commit();
                break;
            case 1:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, LikesFragment.newInstance(position + 1))
                        .commit();
                break;
            case 2:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, FeedbackFragment.newInstance(position + 1))
                        .commit();
                break;
            case 3:
                fragmentManager.beginTransaction()
                        .replace(R.id.container,AboutFragment.newInstance(position + 1) )
                        .commit();
                break;
            default:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                        .commit();
                break;

        }

        if(position ==0){

            fragmentManager.beginTransaction()
                    .replace(R.id.container, HomeScreenFragment.newInstance(position + 1))
                    .commit();
        }
        else {

        }
    }

    public void meldingSaved(View view){
        Context context = getApplicationContext();
        CharSequence text = "Opgeslagen als favoriet";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section3);
                break;
            case 3:
                mTitle = getString(R.string.title_section4);
                break;
            case 4:
                mTitle = getString(R.string.title_section5);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.app_main, menu);
            restoreActionBar();
            //startScanning();///temp
            return true;
        }
        return super.onCreateOptionsMenu(menu);
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

    @Override
    public void openContentWindow(String url) {
        onNavigationDrawerItemSelected(1);
        /*
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, ContentFragment.newInstance(2,url))
                .commit();
                */
    }

    public void startScanning (){
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("SCANMODE", "QR_CODE_MODE");
        startActivityForResult(intent, 0);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Log.d("requestcode", requestCode+"");

        if (requestCode == 0) {

            if (resultCode == RESULT_OK) {
                //use Toast

                openMatchingQRObject(intent.getStringExtra("SCAN_RESULT"));
                //openMatchingFragment("");
            } else if (resultCode == RESULT_CANCELED) {
                //use Toast
            }
        }
    }
    private void openMatchingQRObject(String id) {
        String QRresource = "https://dl.dropboxusercontent.com/u/33161611/HoGent/kunstPlus/"+id+".htm";
        Intent intent = new Intent(this,QRObjectActivity.class);
        intent.putExtra("LoadResource",QRresource);
        startActivity(intent);
    }

    private void openMatchingFragment(String id){
        FragmentManager fragmentManager = getSupportFragmentManager();
        String url ="https://dl.dropboxusercontent.com/u/33161611/HoGent/kunstPlus/Duiven%20in%20Mausoleum%20van%20Galla%20Placidia.htm";
        fragmentManager.beginTransaction()
                .replace(R.id.container, ContentFragment.newInstance(2,
                        url))
                .commit();
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment { //Using this as a 404 fragment
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number"; //private static arg

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) { //factory??
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() { //constructor??
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_app_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((AppMainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }
}