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


    public ContentFragment() {
    }

    public static ContentFragment newInstance(int sectionNumber) { //factory??
        ContentFragment fragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_content, container, false);
        WebView webView = (WebView)rootView.findViewById(R.id.qr_render);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://github-pspletinckx.rhcloud.com/kunstPlus/QR/APPPRESENTATION/");
        return rootView;

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((AppMainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
