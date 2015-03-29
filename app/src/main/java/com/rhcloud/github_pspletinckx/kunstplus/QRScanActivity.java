package com.rhcloud.github_pspletinckx.kunstplus;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class QRScanActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrscan);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_qrscan, menu);
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

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_qrscan, container, false);
            HandleClick hc = new HandleClick();
            rootView.findViewById(R.id.scanQR).setOnClickListener(hc);

            return rootView;
        }

        private class HandleClick implements View.OnClickListener {
            public void onClick(View arg0) {
                Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                intent.putExtra("SCANMODE", "QR_CODE_MODE");
                startActivityForResult(intent, 0);	//Barcode Scanner to scan for us
            }
        }
        public void onActivityResult(int requestCode, int resultCode, Intent intent) {
            if (requestCode == 0) {
                TextView tvStatus = (TextView) getActivity().findViewById(R.id.tvStatus); //this getActivity might be wrong
                TextView tvResult = (TextView) getActivity().findViewById(R.id.tvResult);
                if (resultCode == RESULT_OK) {
                    tvStatus.setText(intent.getStringExtra("SCAN_RESULT_FORMAT"));
                    tvResult.setText(intent.getStringExtra("SCAN_RESULT"));
                    openMatchingQRObject(intent.getStringExtra("SCAN_RESULT"));
                } else if (resultCode == RESULT_CANCELED) {
                    tvStatus.setText("Press a button to start a scan.");
                    tvResult.setText("Scan cancelled.");
                  }
            }
        }

        private void openMatchingQRObject(String id) {
            String QRresource = "http://github-pspletinckx.rhcloud.com/kunstPlus/QR/"+id;
            Intent intent = new Intent(getActivity(),QRObjectActivity.class);
            intent.putExtra("LoadResource",QRresource);
            startActivity(intent);
        }
    }
}
