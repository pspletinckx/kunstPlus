package com.rhcloud.github_pspletinckx.kunstplus;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class AboutFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER ="section_number";

    public AboutFragment() {
    }

    public static AboutFragment newInstance(int sectionNumber) { //factory??
        AboutFragment fragment = new AboutFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);
        return rootView;

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((AppMainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
