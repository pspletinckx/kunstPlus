package com.rhcloud.github_pspletinckx.kunstplus;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class ContentFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER ="section_number";
    private static final String ARG_TARGET_URL="target_url";


    public ContentFragment() {
    }

    public static ContentFragment newInstance(int sectionNumber,String url) { //factory??
        ContentFragment fragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        args.putString(ARG_TARGET_URL,url);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_content, container, false);
        WebView webView = (WebView)rootView.findViewById(R.id.qr_render);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(getTargetUrl());
        //webView.loadUrl("http://github-pspletinckx.rhcloud.com/kunstPlus/QR/APPPRESENTATION/");
        //webView.loadUrl("http://sintpietersabdij.stad.gent/nl/content/carll-cneut-my-head");
        //http://sintpietersabdij.stad.gent/nl/content/carll-cneut-my-head
        return rootView;

    }

    public String getTargetUrl(){
        return getArguments().getString("target_url","404 url");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((AppMainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
