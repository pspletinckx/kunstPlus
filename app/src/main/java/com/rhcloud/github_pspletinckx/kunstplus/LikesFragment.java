package com.rhcloud.github_pspletinckx.kunstplus;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class LikesFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER ="section_number";
    private ListView likesList;

    String[] web = {
            "Mausoleums der Galla Placidia in Ravenna",
            "Mosaîc Lillebonne Orphée ",
            "Mozaiek uit woonhuis Pompei"

    } ;
    Integer[] imageId = {
            R.drawable.mausoleums,
            R.drawable.mosaic_lillebonne,
            R.drawable.pompei
    };

    public LikesFragment() {
    }

    public static LikesFragment newInstance(int sectionNumber) { //factory??
        LikesFragment fragment = new LikesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_likes, container, false);
        LikesListAdaptor adaptor = new LikesListAdaptor(getActivity(),web,imageId);
        likesList=(ListView)rootView.findViewById(R.id.likesListView);
        likesList.setAdapter(adaptor);
        return rootView;

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((AppMainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
