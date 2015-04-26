package com.rhcloud.github_pspletinckx.kunstplus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class HomeScreenFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
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

    public HomeScreenFragment() {
    }

    public static HomeScreenFragment newInstance(int sectionNumber) { //factory??
        HomeScreenFragment fragment = new HomeScreenFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_homescreen, container, false);
        AdvListAdaptor adaptor = new AdvListAdaptor(getActivity(),web,imageId);
        advList = (ListView)rootView.findViewById(R.id.advList);
        advList.setAdapter(adaptor);
        return rootView;

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((AppMainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }

    private void voorbeeldqrview(){
        //QRresource = "http://github-pspletinckx.rhcloud.com";
        QRresource = "http://github-pspletinckx.rhcloud.com/kunstPlus/QR/123456789ABCDEF/";
        Intent intent = new Intent(getActivity(),QRObjectActivity.class);
        intent.putExtra("LoadResource",QRresource);
        startActivity(intent);
    }
    private void toonqrscan(){
        Intent intent = new Intent(getActivity(),QRScanActivity.class);
        startActivity(intent);
    }

}


