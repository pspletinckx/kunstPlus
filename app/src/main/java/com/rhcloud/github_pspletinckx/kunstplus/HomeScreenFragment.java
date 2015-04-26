package com.rhcloud.github_pspletinckx.kunstplus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class HomeScreenFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private String QRresource;
    private ListView advList;

    String[] titles = {
            "In My Head-Carll Cneut - ma-vr, 16u - 20u - Naam Museum - 1Km",
            "Joris Ghekiere - Vandaag, 16u - 20u - Naam Museum - 200m ",
            "In My Head-Carll Cneut - ma-vr, 16u - 20u - Naam Museum - 1Km"

    } ;
    Integer[] imageId = {
            R.drawable.carllcneut480,
            R.drawable.jorisghekiere480,
            R.drawable.carllcneut480
    };

    String[] urls = {
            "http://sintpietersabdij.stad.gent/nl/content/carll-cneut-my-head",
            "http://www.smak.be/tentoonstelling.php?la=nl&y=&tid=&t=&id=627", //non responive web
            "http://sintpietersabdij.stad.gent/nl/content/carll-cneut-my-head"
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
        AdvListAdaptor adaptor = new AdvListAdaptor(getActivity(), titles,imageId);
        advList = (ListView)rootView.findViewById(R.id.advList);
        advList.setAdapter(adaptor);
        advList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Clicked",""+id);
            }
        });
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


