package edu.birzeit.projectpart1.ui.search;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import edu.birzeit.projectpart1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {
    EditText city;
    EditText min_area;
    EditText max_area;
    EditText min_bedroom;
    EditText max_bedroom;
    EditText price;
    Spinner status;
    CheckBox garden;
    CheckBox balcony;
    ImageButton btn_search;




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        city=getActivity().findViewById(R.id.search_city);
        min_area=getActivity().findViewById(R.id.search_min_area);
        max_area=getActivity().findViewById(R.id.search_max_area);
        min_bedroom=getActivity().findViewById(R.id.search_min_bedroom);
        max_bedroom=getActivity().findViewById(R.id.search_max_bebroom);
        price=getActivity().findViewById(R.id.search_price);
        status=getActivity().findViewById(R.id.search_spinner);
        garden=getActivity().findViewById(R.id.search_garden);
        balcony=getActivity().findViewById(R.id.search_balcony);
        btn_search=getActivity().findViewById(R.id.search_picture_button);
        //خلاشيش



    }
}