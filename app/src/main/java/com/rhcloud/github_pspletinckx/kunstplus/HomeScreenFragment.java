package com.rhcloud.github_pspletinckx.kunstplus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
    private ContentFragmentCallbacks mCallback;

    String[] titles = {
            "In My Head-Carll Cneut \n"+
            "ma-vr, 16u - 20u -  | Afstand: 1Km",

            "Joris Ghekiere - S.M.A.K. \n"+
             "Vandaag, 16u - 20u | Afstand: 200m ",

            "Christian Falsnaes - Kiosk\n" +
            "",

            "Joris Ghekiere - S.M.A.K. \n"+
            "Vandaag, 16u - 20u | Afstand: 200m ",

            "Jef Geys - S.M.A.K.",

            "Larry Sultan - S.M.A.K.",

            "Tabula Rasa - Museum Dr. Guislain"

    } ;
    Integer[] imageId = {
            R.drawable.carllcneut480,
            R.drawable.jorisghekiere480,
            R.drawable.christian_falsnaes_thumbnail_eartnow,
            R.drawable.img_ghekiere_12,
            R.drawable.img_jefgeys_affiche_datum,
            R.drawable.img_larry_sultan_serie_pictures_from_home_empty_pool_1991,
            R.drawable.ronny_delrue_lost_memory_2006_fotoprint

    };

    String[] urls = {
            "http://sintpietersabdij.stad.gent/nl/content/carll-cneut-my-head#content",//content to skip header
            "http://www.smak.be/tentoonstelling.php?la=nl&y=&tid=&t=&id=627", //non responive web
            "One",
            "http://www.smak.be/tentoonstelling.php?la=nl&y=&tid=&t=&id=627",
            "Three",
            "Four",
            "Five"
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
                //mCallback.openContentWindow(urls[(int)id]); //Heb ik nog niet kunnen doen werken, ga ik vervangen door intent
                displayUrl(urls[(int)id]);
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
    private void displayUrl(String url){
        if(url!=null) {
            Intent intent = new Intent(getActivity(), QRObjectActivity.class);
            intent.putExtra("LoadResource", url);
            startActivity(intent);
        }
    }
    private void toonqrscan(){
        Intent intent = new Intent(getActivity(),QRScanActivity.class);
        startActivity(intent);
    }
    public void voorbeeldContentFragment(){
    }

}


