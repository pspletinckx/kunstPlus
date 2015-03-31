package com.rhcloud.github_pspletinckx.kunstplus;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {
    private String QRresource;
    private ListView advList;

    String[] web = {
            "In My Head-Carll Cneut - ma-vr, 16u - 20u - Naam Museum - 1Km",
            "Joris Ghekiere - Vandaag, 16u - 20u - Naam Museum - 200m ",
            "In My Head-Carll Cneut - ma-vr, 16u - 20u - Naam Museum - 1Km"

    } ;
    Integer[] imageId = {
            R.drawable.carllcneut480,
            R.drawable.jorisghekiere480,
            R.drawable.carllcneut480
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdvListAdaptor adaptor = new AdvListAdaptor(this,web,imageId);
        advList = (ListView)findViewById(R.id.advList);
        advList.setAdapter(adaptor);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
        switch (id){
            case R.id.qr_object:
                voorbeeldqrview();
                return true;
            case R.id.qr_scan:
                toonqrscan();
                return true;
            default:
        }

        return super.onOptionsItemSelected(item);
    }
    private void voorbeeldqrview(){
        //QRresource = "http://github-pspletinckx.rhcloud.com";
        QRresource = "http://github-pspletinckx.rhcloud.com/kunstPlus/QR/123456789ABCDEF/";
        Intent intent = new Intent(this,QRObjectActivity.class);
        intent.putExtra("LoadResource",QRresource);
        startActivity(intent);
    }
    private void toonqrscan(){
        Intent intent = new Intent(this,QRScanActivity.class);
        startActivity(intent);
    }

}
