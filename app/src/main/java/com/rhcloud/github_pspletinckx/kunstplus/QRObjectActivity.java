package com.rhcloud.github_pspletinckx.kunstplus;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.zip.Inflater;


public class QRObjectActivity extends ActionBarActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //View root = getWindow().getDecorView().findViewById(R.layout.activity_qrobject);
        setContentView(R.layout.fragment_content);
        View rootView =getWindow().getDecorView().getRootView();
        WebView webView = (WebView)rootView.findViewById(R.id.qr_render);
        //webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());

        //WebView webView = (WebView)this.findViewById(R.id.qr_render);
        //webView.loadUrl("http://github-pspletinckx.rhcloud.com");
        //webView.loadUrl("http://users.hogent.be/pspletinckx");
        //webView.loadUrl("http://github-pspletinckx.rhcloud.com/kazouAalst");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String QRResource = extras.getString("LoadResource");
            webView.loadUrl(QRResource);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_qrobject, menu);
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
            case R.id.like:
                //setResult url like to be added to local db
                return true;
            default:
        }

        return super.onOptionsItemSelected(item);
    }
}
